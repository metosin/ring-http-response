(ns ring.util.http-status)

(def continue 100)

(defn continue?
  "Checks whether the response has status code 100"
  [response]
  {:pre (map? response)}
  (= (:status response) 100))

(def switching-protocols 101)

(defn switching-protocols?
  "Checks whether the response has status code 101"
  [response]
  {:pre (map? response)}
  (= (:status response) 101))

(def processing 102)

(defn processing?
  "Checks whether the response has status code 102"
  [response]
  {:pre (map? response)}
  (= (:status response) 102))

(def ok 200)

(defn ok?
  "Checks whether the response has status code 200"
  [response]
  {:pre (map? response)}
  (= (:status response) 200))

(def created 201)

(defn created?
  "Checks whether the response has status code 201"
  [response]
  {:pre (map? response)}
  (= (:status response) 201))

(def accepted 202)

(defn accepted?
  "Checks whether the response has status code 202"
  [response]
  {:pre (map? response)}
  (= (:status response) 202))

(def non-authoritative-information 203)

(defn non-authoritative-information?
  "Checks whether the response has status code 203"
  [response]
  {:pre (map? response)}
  (= (:status response) 203))

(def no-content 204)

(defn no-content?
  "Checks whether the response has status code 204"
  [response]
  {:pre (map? response)}
  (= (:status response) 204))

(def reset-content 205)

(defn reset-content?
  "Checks whether the response has status code 205"
  [response]
  {:pre (map? response)}
  (= (:status response) 205))

(def partial-content 206)

(defn partial-content?
  "Checks whether the response has status code 206"
  [response]
  {:pre (map? response)}
  (= (:status response) 206))

(def multi-status 207)

(defn multi-status?
  "Checks whether the response has status code 207"
  [response]
  {:pre (map? response)}
  (= (:status response) 207))

(def already-reported 208)

(defn already-reported?
  "Checks whether the response has status code 208"
  [response]
  {:pre (map? response)}
  (= (:status response) 208))

(def im-used 226)

(defn im-used?
  "Checks whether the response has status code 226"
  [response]
  {:pre (map? response)}
  (= (:status response) 226))

(def multiple-choices 300)

(defn multiple-choices?
  "Checks whether the response has status code 300"
  [response]
  {:pre (map? response)}
  (= (:status response) 300))

(def moved-permanently 301)

(defn moved-permanently?
  "Checks whether the response has status code 301"
  [response]
  {:pre (map? response)}
  (= (:status response) 301))

(def found 302)

(defn found?
  "Checks whether the response has status code 302"
  [response]
  {:pre (map? response)}
  (= (:status response) 302))

(def see-other 303)

(defn see-other?
  "Checks whether the response has status code 303"
  [response]
  {:pre (map? response)}
  (= (:status response) 303))

(def not-modified 304)

(defn not-modified?
  "Checks whether the response has status code 304"
  [response]
  {:pre (map? response)}
  (= (:status response) 304))

(def use-proxy 305)

(defn use-proxy?
  "Checks whether the response has status code 305"
  [response]
  {:pre (map? response)}
  (= (:status response) 305))

(def temporary-redirect 307)

(defn temporary-redirect?
  "Checks whether the response has status code 307"
  [response]
  {:pre (map? response)}
  (= (:status response) 307))

(def permanent-redirect 308)

(defn permanent-redirect?
  "Checks whether the response has status code 308"
  [response]
  {:pre (map? response)}
  (= (:status response) 308))

(def bad-request 400)

(defn bad-request?
  "Checks whether the response has status code 400"
  [response]
  {:pre (map? response)}
  (= (:status response) 400))

(def unauthorized 401)

(defn unauthorized?
  "Checks whether the response has status code 401"
  [response]
  {:pre (map? response)}
  (= (:status response) 401))

(def payment-required 402)

(defn payment-required?
  "Checks whether the response has status code 402"
  [response]
  {:pre (map? response)}
  (= (:status response) 402))

(def forbidden 403)

(defn forbidden?
  "Checks whether the response has status code 403"
  [response]
  {:pre (map? response)}
  (= (:status response) 403))

(def not-found 404)

(defn not-found?
  "Checks whether the response has status code 404"
  [response]
  {:pre (map? response)}
  (= (:status response) 404))

(def method-not-allowed 405)

(defn method-not-allowed?
  "Checks whether the response has status code 405"
  [response]
  {:pre (map? response)}
  (= (:status response) 405))

(def not-acceptable 406)

(defn not-acceptable?
  "Checks whether the response has status code 406"
  [response]
  {:pre (map? response)}
  (= (:status response) 406))

(def proxy-authentication-required 407)

(defn proxy-authentication-required?
  "Checks whether the response has status code 407"
  [response]
  {:pre (map? response)}
  (= (:status response) 407))

(def request-timeout 408)

(defn request-timeout?
  "Checks whether the response has status code 408"
  [response]
  {:pre (map? response)}
  (= (:status response) 408))

(def conflict 409)

(defn conflict?
  "Checks whether the response has status code 409"
  [response]
  {:pre (map? response)}
  (= (:status response) 409))

(def gone 410)

(defn gone?
  "Checks whether the response has status code 410"
  [response]
  {:pre (map? response)}
  (= (:status response) 410))

(def length-required 411)

(defn length-required?
  "Checks whether the response has status code 411"
  [response]
  {:pre (map? response)}
  (= (:status response) 411))

(def precondition-failed 412)

(defn precondition-failed?
  "Checks whether the response has status code 412"
  [response]
  {:pre (map? response)}
  (= (:status response) 412))

(def request-entity-too-large 413)

(defn request-entity-too-large?
  "Checks whether the response has status code 413"
  [response]
  {:pre (map? response)}
  (= (:status response) 413))

(def request-uri-too-long 414)

(defn request-uri-too-long?
  "Checks whether the response has status code 414"
  [response]
  {:pre (map? response)}
  (= (:status response) 414))

(def unsupported-media-type 415)

(defn unsupported-media-type?
  "Checks whether the response has status code 415"
  [response]
  {:pre (map? response)}
  (= (:status response) 415))

(def requested-range-not-satisfiable 416)

(defn requested-range-not-satisfiable?
  "Checks whether the response has status code 416"
  [response]
  {:pre (map? response)}
  (= (:status response) 416))

(def expectation-failed 417)

(defn expectation-failed?
  "Checks whether the response has status code 417"
  [response]
  {:pre (map? response)}
  (= (:status response) 417))

(def enhance-your-calm 420)

(defn enhance-your-calm?
  "Checks whether the response has status code 420"
  [response]
  {:pre (map? response)}
  (= (:status response) 420))

(def unprocessable-entity 422)

(defn unprocessable-entity?
  "Checks whether the response has status code 422"
  [response]
  {:pre (map? response)}
  (= (:status response) 422))

(def locked 423)

(defn locked?
  "Checks whether the response has status code 423"
  [response]
  {:pre (map? response)}
  (= (:status response) 423))

(def failed-dependency 424)

(defn failed-dependency?
  "Checks whether the response has status code 424"
  [response]
  {:pre (map? response)}
  (= (:status response) 424))

(def unordered-collection 425)

(defn unordered-collection?
  "Checks whether the response has status code 425"
  [response]
  {:pre (map? response)}
  (= (:status response) 425))

(def upgrade-required 426)

(defn upgrade-required?
  "Checks whether the response has status code 426"
  [response]
  {:pre (map? response)}
  (= (:status response) 426))

(def precondition-required 428)

(defn precondition-required?
  "Checks whether the response has status code 428"
  [response]
  {:pre (map? response)}
  (= (:status response) 428))

(def too-many-requests 429)

(defn too-many-requests?
  "Checks whether the response has status code 429"
  [response]
  {:pre (map? response)}
  (= (:status response) 429))

(def request-header-fields-too-large 431)

(defn request-header-fields-too-large?
  "Checks whether the response has status code 431"
  [response]
  {:pre (map? response)}
  (= (:status response) 431))

(def retry-with 449)

(defn retry-with?
  "Checks whether the response has status code 449"
  [response]
  {:pre (map? response)}
  (= (:status response) 449))

(def blocked-by-windows-parental-controls 450)

(defn blocked-by-windows-parental-controls?
  "Checks whether the response has status code 450"
  [response]
  {:pre (map? response)}
  (= (:status response) 450))

(def unavailable-for-legal-reasons 451)

(defn unavailable-for-legal-reasons?
  "Checks whether the response has status code 451"
  [response]
  {:pre (map? response)}
  (= (:status response) 451))

(def internal-server-error 500)

(defn internal-server-error?
  "Checks whether the response has status code 500"
  [response]
  {:pre (map? response)}
  (= (:status response) 500))

(def not-implemented 501)

(defn not-implemented?
  "Checks whether the response has status code 501"
  [response]
  {:pre (map? response)}
  (= (:status response) 501))

(def bad-gateway 502)

(defn bad-gateway?
  "Checks whether the response has status code 502"
  [response]
  {:pre (map? response)}
  (= (:status response) 502))

(def service-unavailable 503)

(defn service-unavailable?
  "Checks whether the response has status code 503"
  [response]
  {:pre (map? response)}
  (= (:status response) 503))

(def gateway-timeout 504)

(defn gateway-timeout?
  "Checks whether the response has status code 504"
  [response]
  {:pre (map? response)}
  (= (:status response) 504))

(def http-version-not-supported 505)

(defn http-version-not-supported?
  "Checks whether the response has status code 505"
  [response]
  {:pre (map? response)}
  (= (:status response) 505))

(def variant-also-negotiates 506)

(defn variant-also-negotiates?
  "Checks whether the response has status code 506"
  [response]
  {:pre (map? response)}
  (= (:status response) 506))

(def insufficient-storage 507)

(defn insufficient-storage?
  "Checks whether the response has status code 507"
  [response]
  {:pre (map? response)}
  (= (:status response) 507))

(def loop-detected 508)

(defn loop-detected?
  "Checks whether the response has status code 508"
  [response]
  {:pre (map? response)}
  (= (:status response) 508))

(def bandwidth-limit-exceeded 509)

(defn bandwidth-limit-exceeded?
  "Checks whether the response has status code 509"
  [response]
  {:pre (map? response)}
  (= (:status response) 509))

(def not-extended 510)

(defn not-extended?
  "Checks whether the response has status code 510"
  [response]
  {:pre (map? response)}
  (= (:status response) 510))

(def network-authentication-required 511)

(defn network-authentication-required?
  "Checks whether the response has status code 511"
  [response]
  {:pre (map? response)}
  (= (:status response) 511))

(def network-read-timeout 598)

(defn network-read-timeout?
  "Checks whether the response has status code 598"
  [response]
  {:pre (map? response)}
  (= (:status response) 598))

(def network-connect-timeout 599)

(defn network-connect-timeout?
  "Checks whether the response has status code 599"
  [response]
  {:pre (map? response)}
  (= (:status response) 599))

(def statuses
  "Maps status to name and description"
  {
   100 {:name "Continue"
        :description "The server has received the request headers and the client should proceed to send the request body."}
   101 {:name "Switching Protocols"
        :description "The server is switching protocols because the client requested the switch."}
   102 {:name "Processing"
        :description "The server is processing the request but no response is available yet."}
   200 {:name "OK"
        :description "OK"}
   201 {:name "Created"
        :description "The request has been fulfilled and resulted in a new resource being created."}
   202 {:name "Accepted"
        :description "The request has been accepted for processing but the processing has not been completed."}
   203 {:name "Non-Authoritative Information"
        :description "The server successfully processed the request but is returning information that may be from another source."}
   204 {:name "No Content"
        :description "The server successfully processed the request, but is not returning any content. Usually used as a response to a successful delete request."}
   205 {:name "Reset Content"
        :description "The server successfully processed the request but is not returning any content. Unlike a 204 response, this response requires that the requester reset the document view."}
   206 {:name "Partial Content"
        :description "The server is delivering only part of the resource due to a range header sent by the client."}
   207 {:name "Multi-Status"
        :description "The message body that follows is an XML message and can contain a number of separate response codes depending on how many sub-requests were made."}
   208 {:name "Already Reported"
        :description "The members of a DAV binding have already been enumerated in a previous reply to this request and are not being included again."}
   226 {:name "IM Used"
        :description "The server has fulfilled a GET request for the resource and the response is a representation of the result of one or more instance-manipulations applied to the current instance."}
   300 {:name "Multiple Choices"
        :description "There are multiple options for the resource that the client may follow."}
   301 {:name "Moved Permanently"
        :description "This and all future requests should be directed to the given URI."}
   302 {:name "Found"
        :description "The resource was found but at a different URI."}
   303 {:name "See Other"
        :description "The response to the request can be found under another URI using a GET method."}
   304 {:name "Not Modified"
        :description "The resource has not been modified since last requested."}
   305 {:name "Use Proxy"
        :description "This single request is to be repeated via the proxy given by the Location field."}
   307 {:name "Temporary Redirect"
        :description "The request should be repeated with another URI but future requests can still use the original URI."}
   308 {:name "Permanent Redirect"
        :description "The request and all future requests should be repeated using another URI."}
   400 {:name "Bad Request"
        :description "The request contains bad syntax or cannot be fulfilled."}
   401 {:name "Unauthorized"
        :description "Authentication is possible but has failed or not yet been provided."}
   402 {:name "Payment Required"
        :description "Reserved for future use."}
   403 {:name "Forbidden"
        :description "The request was a legal request but the server is refusing to respond to it."}
   404 {:name "Not Found"
        :description "The requested resource could not be found but may be available again in the future."}
   405 {:name "Method Not Allowed"
        :description "A request was made of a resource using a request method not supported by that resource;"}
   406 {:name "Not Acceptable"
        :description "The requested resource is only capable of generating content not acceptable according to the Accept headers sent in the request."}
   407 {:name "Proxy Authentication Required"
        :description "Proxy authentication is required to access the requested resource."}
   408 {:name "Request Timeout"
        :description "The server timed out waiting for the request."}
   409 {:name "Conflict"
        :description "The request could not be processed because of conflict in the request such as an edit conflict."}
   410 {:name "Gone"
        :description "The resource requested is no longer available and will not be available again."}
   411 {:name "Length Required"
        :description "The request did not specify the length of its content which is required by the requested resource."}
   412 {:name "Precondition Failed"
        :description "The server does not meet one of the preconditions that the requester put on the request."}
   413 {:name "Request Entity Too Large"
        :description "The request is larger than the server is willing or able to process."}
   414 {:name "Request-URI Too Long"
        :description "The URI provided was too long for the server to process."}
   415 {:name "Unsupported Media Type"
        :description "The request entity has a media type which the server or resource does not support."}
   416 {:name "Requested Range Not Satisfiable"
        :description "The client has asked for a portion of the file but the server cannot supply that portion."}
   417 {:name "Expectation Failed"
        :description "The server cannot meet the requirements of the Expect request-header field."}
   420 {:name "Enhance Your Calm"
        :description "You are being rate-limited."}
   422 {:name "Unprocessable Entity"
        :description "The request was well-formed but was unable to be followed due to semantic errors."}
   423 {:name "Locked"
        :description "The resource that is being accessed is locked."}
   424 {:name "Failed Dependency"
        :description "The request failed due to failure of a previous request."}
   425 {:name "Unordered Collection"
        :description "The collection is unordered."}
   426 {:name "Upgrade Required"
        :description "The client should switch to a different protocol."}
   428 {:name "Precondition Required"
        :description "The server requires the request to be conditional."}
   429 {:name "Too Many Requests"
        :description "The user has sent too many requests in a given amount of time."}
   431 {:name "Request Header Fields Too Large"
        :description "The server is unwilling to process the request because either an individual header field or all the header fields collectively are too large."}
   449 {:name "Retry With"
        :description "The request should be retried after doing the appropriate action."}
   450 {:name "Blocked by Windows Parental Controls"
        :description "Windows Parental Controls are turned on and are blocking access to the given webpage."}
   451 {:name "Unavailable For Legal Reasons"
        :description "Resource access is denied for legal reasons."}
   500 {:name "Internal Server Error"
        :description "There was an internal server error."}
   501 {:name "Not Implemented"
        :description "The server either does not recognize the request method or it lacks the ability to fulfill the request."}
   502 {:name "Bad Gateway"
        :description "The server was acting as a gateway or proxy and received an invalid response from the upstream server."}
   503 {:name "Service Unavailable"
        :description "The server is currently unavailable (because it is overloaded or down for maintenance)."}
   504 {:name "Gateway Timeout"
        :description "The server was acting as a gateway or proxy and did not receive a timely request from the upstream server."}
   505 {:name "HTTP Version Not Supported"
        :description "The server does not support the HTTP protocol version used in the request."}
   506 {:name "Variant Also Negotiates"
        :description "Transparent content negotiation for the request results in a circular reference."}
   507 {:name "Insufficient Storage"
        :description "Insufficient storage to complete the request."}
   508 {:name "Loop Detected"
        :description "The server detected an infinite loop while processing the request."}
   509 {:name "Bandwidth Limit Exceeded"
        :description "Bandwidth limit has been exceeded."}
   510 {:name "Not Extended"
        :description "Further extensions to the request are required for the server to fulfill it."}
   511 {:name "Network Authentication Required"
        :description "The client needs to authenticate to gain network access."}
   598 {:name "Network read timeout"
        :description ""}
   599 {:name "Network connect timeout"
        :description ""}
   })
