(ns ring.middleware.http-response-test
  (:require [clojure.test :refer :all]
            [ring.middleware.http-response :refer :all]
            [ring.util.http-response :refer :all]))

(def request {})
(defn failing [_] (throw (RuntimeException.)))

(def bad (fn [_] (bad-request "BAD")))
(def bad! (fn [_] (bad-request! "BAD")))
(def bad-result (bad-request "BAD"))

(deftest wrap-http-response-sync-test

  (testing "without middleware exception is thrown"
    (is (= bad-result (bad request)))
    (is (thrown? Exception (bad! request))))

  (testing "with middleware exceptions are converted into responses"
    (is (= bad-result ((wrap-http-response bad) request)))
    (is (= bad-result ((wrap-http-response bad!) request))))

  (testing "only response-exceptions are caugh"
    (is (thrown? Exception ((wrap-http-response failing) request)))))

(def bad-async (fn [_ respond _] (respond (bad-request "BAD"))))
(def bad-async! (fn [_ respond _] (respond (bad-request! "BAD"))))

(deftest wrap-http-response-async-test

  (testing "without middleware exception is thrown"
    (let [respond (promise), raise (promise)]
      (bad-async request respond raise)
      (is (= bad-result @respond)))
    (let [respond (promise), raise (promise)]
      (is (thrown? Exception (bad-async! request respond raise)))))

  (testing "with middleware exceptions are converted into responses"
    (let [respond (promise), raise (promise)]
      ((wrap-http-response bad-async) request respond raise)
      (is (= bad-result @respond)))
    (let [respond (promise), raise (promise)]
      ((wrap-http-response bad-async!) request respond raise)
      (is (= bad-result @respond))))

  (testing "only response-exceptions are caugh"
    (let [respond (promise), raise (promise)]
      (is (thrown? Exception ((wrap-http-response failing) request respond raise))))))
