(ns ring.middleware.http-response-test
  (:require [midje.sweet :refer :all]
            [ring.middleware.http-response :refer :all]
            [ring.util.http-response :refer :all]))

(defmacro always [& body] `(fn [_#] ~@body))

(def bad (always (bad-request "BAD")))
(def bad! (always (bad-request! "BAD")))
(def bad-result (bad-request "BAD"))

(fact "wrap-http-response"

  (facts "without middleware exception is thrown"
    (bad ..request..) => bad-result
    (bad! ..request..) => (throws Exception))

  (facts "with middleware exceptions are converted into responses"
    ((wrap-http-response bad) ..request..) => bad-result
    ((wrap-http-response bad!) ..request..) => bad-result)

  (fact "only response-exceptions are caugh"
    ((wrap-http-response (always (throw (RuntimeException.)))) ..request..) => (throws Exception)))
