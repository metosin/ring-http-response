(ns ring.util.http-status-test
  (:require [clojure.test :refer :all]
            [ring.util.http-status :refer :all]))


(deftest http-status-codes-test

  (testing "Informational"
    (is (= 100 continue))
    (is (= 101 switching-protocols))
    (is (= 102 processing)))

  (testing "Success"
    (is (= 200 ok))
    (is (= 201 created))
    (is (= 202 accepted))
    (is (= 203 non-authoritative-information))
    (is (= 204 no-content))
    (is (= 205 reset-content))
    (is (= 206 partial-content))
    (is (= 207 multi-status))
    (is (= 208 already-reported))
    (is (= 226 im-used)))

  (testing "Redirection"
    (is (= 300 multiple-choices))
    (is (= 301 moved-permanently))
    (is (= 302 found))
    (is (= 303 see-other))
    (is (= 304 not-modified))
    (is (= 305 use-proxy))
    (is (= 307 temporary-redirect))
    (is (= 308 permanent-redirect)))

  (testing "ClientError"
    (is (= 400 bad-request))
    (is (= 401 unauthorized))
    (is (= 402 payment-required))
    (is (= 403 forbidden))
    (is (= 404 not-found))
    (is (= 405 method-not-allowed))
    (is (= 406 not-acceptable))
    (is (= 407 proxy-authentication-required))
    (is (= 408 request-timeout))
    (is (= 409 conflict))
    (is (= 410 gone))
    (is (= 411 length-required))
    (is (= 412 precondition-failed))
    (is (= 413 request-entity-too-large))
    (is (= 414 request-uri-too-long))
    (is (= 415 unsupported-media-type))
    (is (= 416 requested-range-not-satisfiable))
    (is (= 417 expectation-failed))
    (is (= 420 enhance-your-calm))
    (is (= 422 unprocessable-entity))
    (is (= 423 locked))
    (is (= 424 failed-dependency))
    (is (= 425 unordered-collection))
    (is (= 426 upgrade-required))
    (is (= 428 precondition-required))
    (is (= 429 too-many-requests))
    (is (= 431 request-header-fields-too-large))
    (is (= 449 retry-with))
    (is (= 450 blocked-by-windows-parental-controls))
    (is (= 451 unavailable-for-legal-reasons)))

  (testing "ServerError"
    (is (= 500 internal-server-error))
    (is (= 501 not-implemented))
    (is (= 502 bad-gateway))
    (is (= 503 service-unavailable))
    (is (= 504 gateway-timeout))
    (is (= 505 http-version-not-supported))
    (is (= 506 variant-also-negotiates))
    (is (= 507 insufficient-storage))
    (is (= 508 loop-detected))
    (is (= 509 bandwidth-limit-exceeded))
    (is (= 510 not-extended))
    (is (= 511 network-authentication-required))
    (is (= 598 network-read-timeout))
    (is (= 599 network-connect-timeout))))

(deftest status-test
  (is {:name "Internal Server Error"
       :description "There was an internal server error."}
      (status 500)))
