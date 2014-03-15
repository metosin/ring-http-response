(ns ring.util.http-response-test
  (:require [midje.sweet :refer :all]
            [slingshot.slingshot :refer [try+]]
            [ring.util.http-response :refer :all]))

(facts "http-responses"

  (facts "Informational"
    (continue)                                      => {:status 100 :headers {} :body ""}
    (switching-protocols)                           => {:status 101 :headers {} :body ""}
    (processing)                                    => {:status 102 :headers {} :body ""})

  (facts "Success"
    (ok "body")                                     => {:status 200 :headers {} :body "body"}
    (created "body")                                => {:status 201 :headers {} :body "body"}
    (accepted "body")                               => {:status 202 :headers {} :body "body"}
    (non-authoritative-information "body")          => {:status 203 :headers {} :body "body"}
    (no-content)                                    => {:status 204 :headers {} :body ""}
    (reset-content "body")                          => {:status 205 :headers {} :body "body"}
    (partial-content "body")                        => {:status 206 :headers {} :body "body"}
    (multi-status "body")                           => {:status 207 :headers {} :body "body"}
    (already-reported "body")                       => {:status 208 :headers {} :body "body"}
    (im-used "body")                                => {:status 226 :headers {} :body "body"})

  (facts "Redirection"
    (multiple-choices "/url")                       => {:status 300 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (moved-permanently "/url")                      => {:status 301 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (found "/url")                                  => {:status 302 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (see-other "/url")                              => {:status 303 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (not-modified "/url")                           => {:status 304 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (use-proxy "/url")                              => {:status 305 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (temporary-redirect "/url")                     => {:status 307 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"}
    (permanent-redirect "/url")                     => {:status 308 :headers {"Location" "/url"} :body "<a href=\"/url\">/url</a>"})

  (facts "ClientError"
    (bad-request "body")                            => {:status 400 :headers {} :body "body"}
    (unauthorized "body")                           => {:status 401 :headers {} :body "body"}
    (payment-required "body")                       => {:status 402 :headers {} :body "body"}
    (forbidden "body")                              => {:status 403 :headers {} :body "body"}
    (not-found "body")                              => {:status 404 :headers {} :body "body"}
    (method-not-allowed "body")                     => {:status 405 :headers {} :body "body"}
    (not-acceptable "body")                         => {:status 406 :headers {} :body "body"}
    (proxy-authentication-required "body")          => {:status 407 :headers {} :body "body"}
    (request-timeout "body")                        => {:status 408 :headers {} :body "body"}
    (conflict "body")                               => {:status 409 :headers {} :body "body"}
    (gone "body")                                   => {:status 410 :headers {} :body "body"}
    (length-required "body")                        => {:status 411 :headers {} :body "body"}
    (precondition-failed "body")                    => {:status 412 :headers {} :body "body"}
    (request-entity-too-large "body")               => {:status 413 :headers {} :body "body"}
    (request-uri-too-long "body")                   => {:status 414 :headers {} :body "body"}
    (unsupported-media-type "body")                 => {:status 415 :headers {} :body "body"}
    (requested-range-not-satisfiable "body")        => {:status 416 :headers {} :body "body"}
    (expectation-failed "body")                     => {:status 417 :headers {} :body "body"}
    (enhance-your-calm "body")                      => {:status 420 :headers {} :body "body"}
    (unprocessable-entity "body")                   => {:status 422 :headers {} :body "body"}
    (locked "body")                                 => {:status 423 :headers {} :body "body"}
    (failed-dependency "body")                      => {:status 424 :headers {} :body "body"}
    (unordered-collection "body")                   => {:status 425 :headers {} :body "body"}
    (upgrade-required "body")                       => {:status 426 :headers {} :body "body"}
    (precondition-required "body")                  => {:status 428 :headers {} :body "body"}
    (too-many-requests "body")                      => {:status 429 :headers {} :body "body"}
    (request-header-fields-too-large "body")        => {:status 431 :headers {} :body "body"}
    (retry-with "body")                             => {:status 449 :headers {} :body "body"}
    (blocked-by-parental-controls "body")           => {:status 450 :headers {} :body "body"}
    (unavailable-for-legal-reasons "body")          => {:status 451 :headers {} :body "body"})

  (facts "ServerError"
    (internal-server-error "body")                  => {:status 500 :headers {} :body "body"}
    (not-implemented "body")                        => {:status 501 :headers {} :body "body"}
    (bad-gateway "body")                            => {:status 502 :headers {} :body "body"}
    (service-unavailable "body")                    => {:status 503 :headers {} :body "body"}
    (gateway-timeout "body")                        => {:status 504 :headers {} :body "body"}
    (http-version-not-supported "body")             => {:status 505 :headers {} :body "body"}
    (variant-also-negotiates "body")                => {:status 506 :headers {} :body "body"}
    (insufficient-storage "body")                   => {:status 507 :headers {} :body "body"}
    (loop-detected "body")                          => {:status 508 :headers {} :body "body"}
    (bandwidth-limit-exceeded "body")               => {:status 509 :headers {} :body "body"}
    (not-extended "body")                           => {:status 510 :headers {} :body "body"}
    (network-authentication-required "body")        => {:status 511 :headers {} :body "body"}
    (network-read-timeout "body")                   => {:status 598 :headers {} :body "body"}
    (network-connect-timeout "body")                => {:status 599 :headers {} :body "body"}))

(defn slingshots [expected]
  (throws clojure.lang.ExceptionInfo
    (fn [x]
      (let [{:keys [response type]} (-> x .getData :object)]
        (and (= type :ring.util.http-response/response)
          (= response expected))))))

(facts "Slingshotting error-responses with !"

  (facts "ClientError"
    (bad-request! "body")                           => (slingshots {:status 400 :headers {} :body "body"})
    (unauthorized! "body")                          => (slingshots {:status 401 :headers {} :body "body"})
    (payment-required! "body")                      => (slingshots {:status 402 :headers {} :body "body"})
    (forbidden! "body")                             => (slingshots {:status 403 :headers {} :body "body"})
    (not-found! "body")                             => (slingshots {:status 404 :headers {} :body "body"})
    (method-not-allowed! "body")                    => (slingshots {:status 405 :headers {} :body "body"})
    (not-acceptable! "body")                        => (slingshots {:status 406 :headers {} :body "body"})
    (proxy-authentication-required! "body")         => (slingshots {:status 407 :headers {} :body "body"})
    (request-timeout! "body")                       => (slingshots {:status 408 :headers {} :body "body"})
    (conflict! "body")                              => (slingshots {:status 409 :headers {} :body "body"})
    (gone! "body")                                  => (slingshots {:status 410 :headers {} :body "body"})
    (length-required! "body")                       => (slingshots {:status 411 :headers {} :body "body"})
    (precondition-failed! "body")                   => (slingshots {:status 412 :headers {} :body "body"})
    (request-entity-too-large! "body")              => (slingshots {:status 413 :headers {} :body "body"})
    (request-uri-too-long! "body")                  => (slingshots {:status 414 :headers {} :body "body"})
    (unsupported-media-type! "body")                => (slingshots {:status 415 :headers {} :body "body"})
    (requested-range-not-satisfiable! "body")       => (slingshots {:status 416 :headers {} :body "body"})
    (expectation-failed! "body")                    => (slingshots {:status 417 :headers {} :body "body"})
    (enhance-your-calm! "body")                     => (slingshots {:status 420 :headers {} :body "body"})
    (unprocessable-entity! "body")                  => (slingshots {:status 422 :headers {} :body "body"})
    (locked! "body")                                => (slingshots {:status 423 :headers {} :body "body"})
    (failed-dependency! "body")                     => (slingshots {:status 424 :headers {} :body "body"})
    (unordered-collection! "body")                  => (slingshots {:status 425 :headers {} :body "body"})
    (upgrade-required! "body")                      => (slingshots {:status 426 :headers {} :body "body"})
    (precondition-required! "body")                 => (slingshots {:status 428 :headers {} :body "body"})
    (too-many-requests! "body")                     => (slingshots {:status 429 :headers {} :body "body"})
    (request-header-fields-too-large! "body")       => (slingshots {:status 431 :headers {} :body "body"})
    (retry-with! "body")                            => (slingshots {:status 449 :headers {} :body "body"})
    (blocked-by-parental-controls! "body")          => (slingshots {:status 450 :headers {} :body "body"})
    (unavailable-for-legal-reasons! "body")         => (slingshots {:status 451 :headers {} :body "body"}))

  (facts "ServerError"
    (internal-server-error! "body")                 => (slingshots {:status 500 :headers {} :body "body"})
    (not-implemented! "body")                       => (slingshots {:status 501 :headers {} :body "body"})
    (bad-gateway! "body")                           => (slingshots {:status 502 :headers {} :body "body"})
    (service-unavailable! "body")                   => (slingshots {:status 503 :headers {} :body "body"})
    (gateway-timeout! "body")                       => (slingshots {:status 504 :headers {} :body "body"})
    (http-version-not-supported! "body")            => (slingshots {:status 505 :headers {} :body "body"})
    (variant-also-negotiates! "body")               => (slingshots {:status 506 :headers {} :body "body"})
    (insufficient-storage! "body")                  => (slingshots {:status 507 :headers {} :body "body"})
    (loop-detected! "body")                         => (slingshots {:status 508 :headers {} :body "body"})
    (bandwidth-limit-exceeded! "body")              => (slingshots {:status 509 :headers {} :body "body"})
    (not-extended! "body")                          => (slingshots {:status 510 :headers {} :body "body"})
    (network-authentication-required! "body")       => (slingshots {:status 511 :headers {} :body "body"})
    (network-read-timeout! "body")                  => (slingshots {:status 598 :headers {} :body "body"})
    (network-connect-timeout! "body")               => (slingshots {:status 599 :headers {} :body "body"})))

(fact "throw!"
  (throw! (bad-request "body"))                     => (slingshots {:status 400 :headers {} :body "body"})
  (throw! (header (bad-request "body") "a" "1"))    => (slingshots {:status 400 :headers {"a" "1"} :body "body"}))

(facts "vars are imported correctly"
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
    (fact {:midje/description v}
      (-> v meta :ns ns-name) => 'ring.util.response)))
