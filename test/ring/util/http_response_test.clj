(ns ring.util.http-response-test
  (:require [clojure.test :refer :all]
            [ring.util.http-response :refer :all]))

(deftest http-responses-test

  (testing "Informational"
    (is (= {:status 100 :headers {} :body ""} (continue)))
    (is (= {:status 101 :headers {} :body ""} (switching-protocols)))
    (is (= {:status 102 :headers {} :body ""} (processing))))

  (testing "Success"
    (is (= {:status 200 :headers {} :body "body"} (ok "body")))
    (is (= {:status 201 :headers {"Location" "/url"} :body nil} (created "/url")))
    (is (= {:status 201 :headers {"Location" "/url"} :body "body"} (created "/url" "body")))
    (is (= {:status 202 :headers {} :body "body"} (accepted "body")))
    (is (= {:status 203 :headers {} :body "body"} (non-authoritative-information "body")))
    (is (= {:status 204 :headers {} :body ""} (no-content)))
    (is (= {:status 205 :headers {} :body ""} (reset-content)))
    (is (= {:status 206 :headers {} :body "body"} (partial-content "body")))
    (is (= {:status 207 :headers {} :body "body"} (multi-status "body")))
    (is (= {:status 208 :headers {} :body "body"} (already-reported "body")))
    (is (= {:status 226 :headers {} :body "body"} (im-used "body")))
    (testing "Must reject invalid inputs"
      (is (thrown? AssertionError (created 1) "Non-nil URL must be a URL-like type"))
      (is (thrown? AssertionError (created {}) "Non-nil URL must be a URL-like type"))))

  (testing "Redirection"
    (is (= {:status 300 :headers {"Location" "/url"} :body ""} (multiple-choices "/url")))
    (is (= {:status 301 :headers {"Location" "/url"} :body ""} (moved-permanently "/url")))
    (is (= {:status 302 :headers {"Location" "/url"} :body ""} (found "/url")))
    (is (= {:status 303 :headers {"Location" "/url"} :body ""} (see-other "/url")))
    (is (= {:status 304 :headers {} :body ""} (not-modified)))
    (is (= {:status 305 :headers {"Location" "/url"} :body ""} (use-proxy "/url")))
    (is (= {:status 307 :headers {"Location" "/url"} :body ""} (temporary-redirect "/url")))
    (is (= {:status 308 :headers {"Location" "/url"} :body ""} (permanent-redirect "/url")))
    (testing "Must reject invalid inputs"
      (is (thrown? AssertionError (multiple-choices nil) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (multiple-choices 1) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (moved-permanently nil) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (moved-permanently {}) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (found nil) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (found ::not-a-url) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (use-proxy nil) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (use-proxy ::not-a-url) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (temporary-redirect nil) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (temporary-redirect ::not-a-url) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (permanent-redirect nil) "URL must be a non-nil URL-like type"))
      (is (thrown? AssertionError (permanent-redirect ::not-a-url) "URL must be a non-nil URL-like type"))))

    (testing "ClientError"
      (is (= {:status 400 :headers {} :body "body"} (bad-request "body")))
      (is (= {:status 401 :headers {} :body "body"} (unauthorized "body")))
      (is (= {:status 402 :headers {} :body "body"} (payment-required "body")))
      (is (= {:status 403 :headers {} :body "body"} (forbidden "body")))
      (is (= {:status 404 :headers {} :body "body"} (not-found "body")))
      (is (= {:status 405 :headers {} :body "body"} (method-not-allowed "body")))
      (is (= {:status 406 :headers {} :body "body"} (not-acceptable "body")))
      (is (= {:status 407 :headers {} :body "body"} (proxy-authentication-required "body")))
      (is (= {:status 408 :headers {} :body "body"} (request-timeout "body")))
      (is (= {:status 409 :headers {} :body "body"} (conflict "body")))
      (is (= {:status 410 :headers {} :body "body"} (gone "body")))
      (is (= {:status 411 :headers {} :body "body"} (length-required "body")))
      (is (= {:status 412 :headers {} :body "body"} (precondition-failed "body")))
      (is (= {:status 413 :headers {} :body "body"} (request-entity-too-large "body")))
      (is (= {:status 414 :headers {} :body "body"} (request-uri-too-long "body")))
      (is (= {:status 415 :headers {} :body "body"} (unsupported-media-type "body")))
      (is (= {:status 416 :headers {} :body "body"} (requested-range-not-satisfiable "body")))
      (is (= {:status 417 :headers {} :body "body"} (expectation-failed "body")))
      (is (= {:status 420 :headers {} :body "body"} (enhance-your-calm "body")))
      (is (= {:status 422 :headers {} :body "body"} (unprocessable-entity "body")))
      (is (= {:status 423 :headers {} :body "body"} (locked "body")))
      (is (= {:status 424 :headers {} :body "body"} (failed-dependency "body")))
      (is (= {:status 425 :headers {} :body "body"} (unordered-collection "body")))
      (is (= {:status 426 :headers {} :body "body"} (upgrade-required "body")))
      (is (= {:status 428 :headers {} :body "body"} (precondition-required "body")))
      (is (= {:status 429 :headers {} :body "body"} (too-many-requests "body")))
      (is (= {:status 431 :headers {} :body "body"} (request-header-fields-too-large "body")))
      (is (= {:status 449 :headers {} :body "body"} (retry-with "body")))
      (is (= {:status 450 :headers {} :body "body"} (blocked-by-windows-parental-controls "body")))
      (is (= {:status 451 :headers {} :body "body"} (unavailable-for-legal-reasons "body"))))

    (testing "ServerError"
      (is (= {:status 500 :headers {} :body "body"} (internal-server-error "body")))
      (is (= {:status 501 :headers {} :body "body"} (not-implemented "body")))
      (is (= {:status 502 :headers {} :body "body"} (bad-gateway "body")))
      (is (= {:status 503 :headers {} :body "body"} (service-unavailable "body")))
      (is (= {:status 504 :headers {} :body "body"} (gateway-timeout "body")))
      (is (= {:status 505 :headers {} :body "body"} (http-version-not-supported "body")))
      (is (= {:status 506 :headers {} :body "body"} (variant-also-negotiates "body")))
      (is (= {:status 507 :headers {} :body "body"} (insufficient-storage "body")))
      (is (= {:status 508 :headers {} :body "body"} (loop-detected "body")))
      (is (= {:status 509 :headers {} :body "body"} (bandwidth-limit-exceeded "body")))
      (is (= {:status 510 :headers {} :body "body"} (not-extended "body")))
      (is (= {:status 511 :headers {} :body "body"} (network-authentication-required "body")))
      (is (= {:status 598 :headers {} :body "body"} (network-read-timeout "body")))
      (is (= {:status 599 :headers {} :body "body"} (network-connect-timeout "body")))))

(declare slingshots?)
(defmethod assert-expr 'slingshots? [msg form]
  (let [expected (second form)
        body (nthnext form 2)]
    `(try
       ~@body
       (do-report {:type :fail, :message ~msg,
                   :expected ~expected, :actual nil})
       (catch Exception e#
         (let [data# (ex-data e#)]
           (if (= :ring.util.http-response/response (:type data#))
             (if (= ~expected (:response data#))
               (do-report {:type :pass, :message ~msg,
                           :expected (:response data#) :actual (:response data#)})
               (do-report {:type :fail, :message ~msg,
                           :expected ~expected, :actual (:response data#)}))
             (do-report {:type :fail, :message ~msg,
                         :expected ~expected, :actual nil})))))))

(deftest slingshot-error-responses-test

  (testing "ClientError"
    (is (slingshots? {:status 400 :headers {} :body "body"} (bad-request! "body")))
    (is (slingshots? {:status 401 :headers {} :body "body"} (unauthorized! "body")))
    (is (slingshots? {:status 402 :headers {} :body "body"} (payment-required! "body")))
    (is (slingshots? {:status 403 :headers {} :body "body"} (forbidden! "body")))
    (is (slingshots? {:status 404 :headers {} :body "body"} (not-found! "body")))
    (is (slingshots? {:status 405 :headers {} :body "body"} (method-not-allowed! "body")))
    (is (slingshots? {:status 406 :headers {} :body "body"} (not-acceptable! "body")))
    (is (slingshots? {:status 407 :headers {} :body "body"} (proxy-authentication-required! "body")))
    (is (slingshots? {:status 408 :headers {} :body "body"} (request-timeout! "body")))
    (is (slingshots? {:status 409 :headers {} :body "body"} (conflict! "body")))
    (is (slingshots? {:status 410 :headers {} :body "body"} (gone! "body")))
    (is (slingshots? {:status 411 :headers {} :body "body"} (length-required! "body")))
    (is (slingshots? {:status 412 :headers {} :body "body"} (precondition-failed! "body")))
    (is (slingshots? {:status 413 :headers {} :body "body"} (request-entity-too-large! "body")))
    (is (slingshots? {:status 414 :headers {} :body "body"} (request-uri-too-long! "body")))
    (is (slingshots? {:status 415 :headers {} :body "body"} (unsupported-media-type! "body")))
    (is (slingshots? {:status 416 :headers {} :body "body"} (requested-range-not-satisfiable! "body")))
    (is (slingshots? {:status 417 :headers {} :body "body"} (expectation-failed! "body")))
    (is (slingshots? {:status 420 :headers {} :body "body"} (enhance-your-calm! "body")))
    (is (slingshots? {:status 422 :headers {} :body "body"} (unprocessable-entity! "body")))
    (is (slingshots? {:status 423 :headers {} :body "body"} (locked! "body")))
    (is (slingshots? {:status 424 :headers {} :body "body"} (failed-dependency! "body")))
    (is (slingshots? {:status 425 :headers {} :body "body"} (unordered-collection! "body")))
    (is (slingshots? {:status 426 :headers {} :body "body"} (upgrade-required! "body")))
    (is (slingshots? {:status 428 :headers {} :body "body"} (precondition-required! "body")))
    (is (slingshots? {:status 429 :headers {} :body "body"} (too-many-requests! "body")))
    (is (slingshots? {:status 431 :headers {} :body "body"} (request-header-fields-too-large! "body")))
    (is (slingshots? {:status 449 :headers {} :body "body"} (retry-with! "body")))
    (is (slingshots? {:status 450 :headers {} :body "body"} (blocked-by-windows-parental-controls! "body")))
    (is (slingshots? {:status 451 :headers {} :body "body"} (unavailable-for-legal-reasons! "body"))))

  (testing "ServerError"
    (is (slingshots? {:status 500 :headers {} :body "body"} (internal-server-error! "body")))
    (is (slingshots? {:status 501 :headers {} :body "body"} (not-implemented! "body")))
    (is (slingshots? {:status 502 :headers {} :body "body"} (bad-gateway! "body")))
    (is (slingshots? {:status 503 :headers {} :body "body"} (service-unavailable! "body")))
    (is (slingshots? {:status 504 :headers {} :body "body"} (gateway-timeout! "body")))
    (is (slingshots? {:status 505 :headers {} :body "body"} (http-version-not-supported! "body")))
    (is (slingshots? {:status 506 :headers {} :body "body"} (variant-also-negotiates! "body")))
    (is (slingshots? {:status 507 :headers {} :body "body"} (insufficient-storage! "body")))
    (is (slingshots? {:status 508 :headers {} :body "body"} (loop-detected! "body")))
    (is (slingshots? {:status 509 :headers {} :body "body"} (bandwidth-limit-exceeded! "body")))
    (is (slingshots? {:status 510 :headers {} :body "body"} (not-extended! "body")))
    (is (slingshots? {:status 511 :headers {} :body "body"} (network-authentication-required! "body")))
    (is (slingshots? {:status 598 :headers {} :body "body"} (network-read-timeout! "body")))
    (is (slingshots? {:status 599 :headers {} :body "body"} (network-connect-timeout! "body")))))

(deftest throw!-test
  (is (slingshots? {:status 400 :headers {} :body "body"} (throw! (bad-request "body"))))
  (is (slingshots? {:status 400 :headers {"a" "1"} :body "body"} (throw! (header (bad-request "body") "a" "1")))))

(deftest imported-vars-test
  (doseq [v [#'status
             #'header
             #'file-response
             #'content-type
             #'charset
             #'set-cookie
             #'response?
             #'url-response
             #'resource-response
             #'get-header]]
    (is (= 'ring.util.response (-> v meta :ns ns-name)) v)))
