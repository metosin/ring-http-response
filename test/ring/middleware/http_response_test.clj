(ns ring.middleware.http-response-test
  (:require [clojure.test :refer :all]
            [ring.middleware.http-response :refer :all]
            [ring.util.http-response :refer :all]))

(def bad (fn [_] (bad-request "BAD")))
(def bad! (fn [_] (bad-request! "BAD")))
(def bad-result (bad-request "BAD"))

(deftest wrap-http-response-test

  (testing "without middleware exception is thrown"
    (is (= bad-result (bad nil)))
    (is (thrown? Exception (bad! nil))))

  (testing "with middleware exceptions are converted into responses"
    (is (= bad-result ((wrap-http-response bad) nil)))
    (is (= bad-result ((wrap-http-response bad!) nil))))

  (testing "only response-exceptions are caugh"
    (is (thrown? Exception ((wrap-http-response (fn [_] (throw (RuntimeException.)))) nil)))))
