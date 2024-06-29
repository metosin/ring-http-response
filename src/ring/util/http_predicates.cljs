(ns ring.util.http-predicates)

(defn informational?
  "Check whether the response type is Informational (status code is between
  100 and 199)."
  [response]
  {:pre (map? response)}
  (<= 100 (:status response) 199))

(defn success?
  "Check whether the response type is Success (status code is between
  200 and 299)."
  [response]
  {:pre (map? response)}
  (<= 200 (:status response) 299))

(defn redirection?
  "Check whether the response type is Redirection (status code is between
  300 and 399)."
  [response]
  {:pre (map? response)}
  (<= 300 (:status response) 399))

(defn client-error?
  "Check whether the response type is ClientError (status code is between
  400 and 499)."
  [response]
  {:pre (map? response)}
  (<= 400 (:status response) 499))

(defn server-error?
  "Check whether the response type is ServerError (status code is between
  500 and 599)."
  [response]
  {:pre (map? response)}
  (<= 500 (:status response) 599))

(defn continue?
  "Checks whether the response has status code 100"
  [response]
  {:pre (map? response)}
  (= (:status response) 100))

(defn switching-protocols?
  "Checks whether the response has status code 101"
  [response]
  {:pre (map? response)}
  (= (:status response) 101))

(defn processing?
  "Checks whether the response has status code 102"
  [response]
  {:pre (map? response)}
  (= (:status response) 102))

(defn ok?
  "Checks whether the response has status code 200"
  [response]
  {:pre (map? response)}
  (= (:status response) 200))

(defn created?
  "Checks whether the response has status code 201"
  [response]
  {:pre (map? response)}
  (= (:status response) 201))

(defn accepted?
  "Checks whether the response has status code 202"
  [response]
  {:pre (map? response)}
  (= (:status response) 202))

(defn non-authoritative-information?
  "Checks whether the response has status code 203"
  [response]
  {:pre (map? response)}
  (= (:status response) 203))

(defn no-content?
  "Checks whether the response has status code 204"
  [response]
  {:pre (map? response)}
  (= (:status response) 204))

(defn reset-content?
  "Checks whether the response has status code 205"
  [response]
  {:pre (map? response)}
  (= (:status response) 205))

(defn partial-content?
  "Checks whether the response has status code 206"
  [response]
  {:pre (map? response)}
  (= (:status response) 206))

(defn multi-status?
  "Checks whether the response has status code 207"
  [response]
  {:pre (map? response)}
  (= (:status response) 207))

(defn already-reported?
  "Checks whether the response has status code 208"
  [response]
  {:pre (map? response)}
  (= (:status response) 208))

(defn im-used?
  "Checks whether the response has status code 226"
  [response]
  {:pre (map? response)}
  (= (:status response) 226))

(defn multiple-choices?
  "Checks whether the response has status code 300"
  [response]
  {:pre (map? response)}
  (= (:status response) 300))

(defn moved-permanently?
  "Checks whether the response has status code 301"
  [response]
  {:pre (map? response)}
  (= (:status response) 301))

(defn found?
  "Checks whether the response has status code 302"
  [response]
  {:pre (map? response)}
  (= (:status response) 302))

(defn see-other?
  "Checks whether the response has status code 303"
  [response]
  {:pre (map? response)}
  (= (:status response) 303))

(defn not-modified?
  "Checks whether the response has status code 304"
  [response]
  {:pre (map? response)}
  (= (:status response) 304))

(defn use-proxy?
  "Checks whether the response has status code 305"
  [response]
  {:pre (map? response)}
  (= (:status response) 305))

(defn temporary-redirect?
  "Checks whether the response has status code 307"
  [response]
  {:pre (map? response)}
  (= (:status response) 307))

(defn permanent-redirect?
  "Checks whether the response has status code 308"
  [response]
  {:pre (map? response)}
  (= (:status response) 308))

(defn bad-request?
  "Checks whether the response has status code 400"
  [response]
  {:pre (map? response)}
  (= (:status response) 400))

(defn unauthorized?
  "Checks whether the response has status code 401"
  [response]
  {:pre (map? response)}
  (= (:status response) 401))

(defn payment-required?
  "Checks whether the response has status code 402"
  [response]
  {:pre (map? response)}
  (= (:status response) 402))

(defn forbidden?
  "Checks whether the response has status code 403"
  [response]
  {:pre (map? response)}
  (= (:status response) 403))

(defn not-found?
  "Checks whether the response has status code 404"
  [response]
  {:pre (map? response)}
  (= (:status response) 404))

(defn method-not-allowed?
  "Checks whether the response has status code 405"
  [response]
  {:pre (map? response)}
  (= (:status response) 405))

(defn not-acceptable?
  "Checks whether the response has status code 406"
  [response]
  {:pre (map? response)}
  (= (:status response) 406))

(defn proxy-authentication-required?
  "Checks whether the response has status code 407"
  [response]
  {:pre (map? response)}
  (= (:status response) 407))

(defn request-timeout?
  "Checks whether the response has status code 408"
  [response]
  {:pre (map? response)}
  (= (:status response) 408))

(defn conflict?
  "Checks whether the response has status code 409"
  [response]
  {:pre (map? response)}
  (= (:status response) 409))

(defn gone?
  "Checks whether the response has status code 410"
  [response]
  {:pre (map? response)}
  (= (:status response) 410))

(defn length-required?
  "Checks whether the response has status code 411"
  [response]
  {:pre (map? response)}
  (= (:status response) 411))

(defn precondition-failed?
  "Checks whether the response has status code 412"
  [response]
  {:pre (map? response)}
  (= (:status response) 412))

(defn request-entity-too-large?
  "Checks whether the response has status code 413"
  [response]
  {:pre (map? response)}
  (= (:status response) 413))

(defn request-uri-too-long?
  "Checks whether the response has status code 414"
  [response]
  {:pre (map? response)}
  (= (:status response) 414))

(defn unsupported-media-type?
  "Checks whether the response has status code 415"
  [response]
  {:pre (map? response)}
  (= (:status response) 415))

(defn requested-range-not-satisfiable?
  "Checks whether the response has status code 416"
  [response]
  {:pre (map? response)}
  (= (:status response) 416))

(defn expectation-failed?
  "Checks whether the response has status code 417"
  [response]
  {:pre (map? response)}
  (= (:status response) 417))

(defn im-a-teapot?
  "Checks whether the response has status code 418"
  [response]
  {:pre (map? response)}
  (= (:status response) 418))

(defn enhance-your-calm?
  "Checks whether the response has status code 420"
  [response]
  {:pre (map? response)}
  (= (:status response) 420))

(defn unprocessable-entity?
  "Checks whether the response has status code 422"
  [response]
  {:pre (map? response)}
  (= (:status response) 422))

(defn locked?
  "Checks whether the response has status code 423"
  [response]
  {:pre (map? response)}
  (= (:status response) 423))

(defn failed-dependency?
  "Checks whether the response has status code 424"
  [response]
  {:pre (map? response)}
  (= (:status response) 424))

(defn unordered-collection?
  "Checks whether the response has status code 425"
  [response]
  {:pre (map? response)}
  (= (:status response) 425))

(defn upgrade-required?
  "Checks whether the response has status code 426"
  [response]
  {:pre (map? response)}
  (= (:status response) 426))

(defn precondition-required?
  "Checks whether the response has status code 428"
  [response]
  {:pre (map? response)}
  (= (:status response) 428))

(defn too-many-requests?
  "Checks whether the response has status code 429"
  [response]
  {:pre (map? response)}
  (= (:status response) 429))

(defn request-header-fields-too-large?
  "Checks whether the response has status code 431"
  [response]
  {:pre (map? response)}
  (= (:status response) 431))

(defn retry-with?
  "Checks whether the response has status code 449"
  [response]
  {:pre (map? response)}
  (= (:status response) 449))

(defn blocked-by-windows-parental-controls?
  "Checks whether the response has status code 450"
  [response]
  {:pre (map? response)}
  (= (:status response) 450))

(defn unavailable-for-legal-reasons?
  "Checks whether the response has status code 451"
  [response]
  {:pre (map? response)}
  (= (:status response) 451))

(defn internal-server-error?
  "Checks whether the response has status code 500"
  [response]
  {:pre (map? response)}
  (= (:status response) 500))

(defn not-implemented?
  "Checks whether the response has status code 501"
  [response]
  {:pre (map? response)}
  (= (:status response) 501))

(defn bad-gateway?
  "Checks whether the response has status code 502"
  [response]
  {:pre (map? response)}
  (= (:status response) 502))

(defn service-unavailable?
  "Checks whether the response has status code 503"
  [response]
  {:pre (map? response)}
  (= (:status response) 503))

(defn gateway-timeout?
  "Checks whether the response has status code 504"
  [response]
  {:pre (map? response)}
  (= (:status response) 504))

(defn http-version-not-supported?
  "Checks whether the response has status code 505"
  [response]
  {:pre (map? response)}
  (= (:status response) 505))

(defn variant-also-negotiates?
  "Checks whether the response has status code 506"
  [response]
  {:pre (map? response)}
  (= (:status response) 506))

(defn insufficient-storage?
  "Checks whether the response has status code 507"
  [response]
  {:pre (map? response)}
  (= (:status response) 507))

(defn loop-detected?
  "Checks whether the response has status code 508"
  [response]
  {:pre (map? response)}
  (= (:status response) 508))

(defn bandwidth-limit-exceeded?
  "Checks whether the response has status code 509"
  [response]
  {:pre (map? response)}
  (= (:status response) 509))

(defn not-extended?
  "Checks whether the response has status code 510"
  [response]
  {:pre (map? response)}
  (= (:status response) 510))

(defn network-authentication-required?
  "Checks whether the response has status code 511"
  [response]
  {:pre (map? response)}
  (= (:status response) 511))

(defn network-read-timeout?
  "Checks whether the response has status code 598"
  [response]
  {:pre (map? response)}
  (= (:status response) 598))

(defn network-connect-timeout?
  "Checks whether the response has status code 599"
  [response]
  {:pre (map? response)}
  (= (:status response) 599))
