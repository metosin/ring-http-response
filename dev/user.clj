(ns user
  (:require [org.tobereplaced.lettercase :as lc]
            [stencil.core :as mustache]))

(def responses
  "Format: [status name description & [options]]"
  [[100 "Continue" "The server has received the request headers and the client should proceed to send the request body."]
   [101 "Switching Protocols" "The server is switching protocols because the client requested the switch."]
   [102 "Processing" "The server is processing the request but no response is available yet."]
   [200 "OK" "OK"]
   [201 "Created" "The request has been fulfilled and resulted in a new resource being created." {:location? true, :entity? true}]
   [202 "Accepted" "The request has been accepted for processing but the processing has not been completed."]
   [203 "Non-Authoritative Information" "The server successfully processed the request but is returning information that may be from another source."]
   [204 "No Content" "The server successfully processed the request, but is not returning any content. Usually used as a response to a successful delete request." {:entity? false}]
   [205 "Reset Content" "The server successfully processed the request but is not returning any content. Unlike a 204 response, this response requires that the requester reset the document view." {:entity? false}]
   [206 "Partial Content" "The server is delivering only part of the resource due to a range header sent by the client."]
   [207 "Multi-Status" "The message body that follows is an XML message and can contain a number of separate response codes depending on how many sub-requests were made."]
   [208 "Already Reported" "The members of a DAV binding have already been enumerated in a previous reply to this request and are not being included again."]
   [226 "IM Used" "The server has fulfilled a GET request for the resource and the response is a representation of the result of one or more instance-manipulations applied to the current instance."]
   [300 "Multiple Choices" "There are multiple options for the resource that the client may follow."]
   [301 "Moved Permanently" "This and all future requests should be directed to the given URI."]
   [302 "Found" "The resource was found but at a different URI."]
   [303 "See Other" "The response to the request can be found under another URI using a GET method."]
   [304 "Not Modified" "The resource has not been modified since last requested." {:location? false}]
   [305 "Use Proxy" "This single request is to be repeated via the proxy given by the Location field."]
   [307 "Temporary Redirect" "The request should be repeated with another URI but future requests can still use the original URI."]
   [308 "Permanent Redirect" "The request and all future requests should be repeated using another URI."]
   [400 "Bad Request" "The request contains bad syntax or cannot be fulfilled."]
   [401 "Unauthorized" "Authentication is possible but has failed or not yet been provided."]
   [402 "Payment Required" "Reserved for future use."]
   [403 "Forbidden" "The request was a legal request but the server is refusing to respond to it."]
   [404 "Not Found" "The requested resource could not be found but may be available again in the future."]
   [405 "Method Not Allowed" "A request was made of a resource using a request method not supported by that resource;"]
   [406 "Not Acceptable" "The requested resource is only capable of generating content not acceptable according to the Accept headers sent in the request."]
   [407 "Proxy Authentication Required" "Proxy authentication is required to access the requested resource."]
   [408 "Request Timeout" "The server timed out waiting for the request."]
   [409 "Conflict" "The request could not be processed because of conflict in the request such as an edit conflict."]
   [410 "Gone" "The resource requested is no longer available and will not be available again."]
   [411 "Length Required" "The request did not specify the length of its content which is required by the requested resource."]
   [412 "Precondition Failed" "The server does not meet one of the preconditions that the requester put on the request."]
   [413 "Request Entity Too Large" "The request is larger than the server is willing or able to process."]
   [414 "Request-URI Too Long" "The URI provided was too long for the server to process."]
   [415 "Unsupported Media Type" "The request entity has a media type which the server or resource does not support."]
   [416 "Requested Range Not Satisfiable" "The client has asked for a portion of the file but the server cannot supply that portion."]
   [417 "Expectation Failed" "The server cannot meet the requirements of the Expect request-header field."]
   [420 "Enhance Your Calm" "You are being rate-limited."]
   [422 "Unprocessable Entity" "The request was well-formed but was unable to be followed due to semantic errors."]
   [423 "Locked" "The resource that is being accessed is locked."]
   [424 "Failed Dependency" "The request failed due to failure of a previous request."]
   [425 "Unordered Collection" "The collection is unordered."]
   [426 "Upgrade Required" "The client should switch to a different protocol."]
   [428 "Precondition Required" "The server requires the request to be conditional."]
   [429 "Too Many Requests" "The user has sent too many requests in a given amount of time."]
   [431 "Request Header Fields Too Large" "The server is unwilling to process the request because either an individual header field or all the header fields collectively are too large."]
   [449 "Retry With" "The request should be retried after doing the appropriate action."]
   [450 "Blocked by Windows Parental Controls" "Windows Parental Controls are turned on and are blocking access to the given webpage."]
   [451 "Unavailable For Legal Reasons" "Resource access is denied for legal reasons."]
   [500 "Internal Server Error" "There was an internal server error."]
   [501 "Not Implemented" "The server either does not recognize the request method or it lacks the ability to fulfill the request."]
   [502 "Bad Gateway" "The server was acting as a gateway or proxy and received an invalid response from the upstream server."]
   [503 "Service Unavailable" "The server is currently unavailable (because it is overloaded or down for maintenance)."]
   [504 "Gateway Timeout" "The server was acting as a gateway or proxy and did not receive a timely request from the upstream server."]
   [505 "HTTP Version Not Supported" "The server does not support the HTTP protocol version used in the request."]
   [506 "Variant Also Negotiates" "Transparent content negotiation for the request results in a circular reference."]
   [507 "Insufficient Storage" "Insufficient storage to complete the request."]
   [508 "Loop Detected" "The server detected an infinite loop while processing the request."]
   [509 "Bandwidth Limit Exceeded" "Bandwidth limit has been exceeded."]
   [510 "Not Extended" "Further extensions to the request are required for the server to fulfill it."]
   [511 "Network Authentication Required" "The client needs to authenticate to gain network access."]
   [598 "Network read timeout" ""]
   [599 "Network connect timeout" ""]])

(def types
  [{:type "Informational", :entity? false, :location? false, :success? true,  :start 100, :end 199}
   {:type "Success",       :entity? true,  :location? false, :success? true,  :start 200, :end 299}
   {:type "Redirection",   :entity? false, :location? true,  :success? true,  :start 300, :end 399}
   {:type "ClientError",   :entity? true,  :location? false, :success? false, :start 400, :end 499}
   {:type "ServerError",   :entity? true,  :location? false, :success? false, :start 500, :end 599}])

(def types-by-code (into {} (for [type types]
                              [(:start type) type])))

(defn get-type [status]
  (get types-by-code (- status (mod status 100))))

(def template
  (for [[status name description options] responses]
    (merge
     {:fn-name (lc/lower-hyphen-name name)
      :status status
      :name name
      :description description
      :location-entity? (and (:location? options) (:entity? options))}
     (get-type status)
     options)))

(def type-template
  (map (fn [{:keys [type] :as m}]
         (assoc m :fn-name (lc/lower-hyphen-name type)))
       types))

(def imports
  ["status" "header" "file-response" "content-type" "find-header" "get-header"
   "update-header" "charset" "set-cookie" "response?" "resource-data"
   "url-response" "resource-response" "get-charset"])

(stencil.loader/set-cache (clojure.core.cache/ttl-cache-factory {} :ttl 0))

(defn generate! []
  (spit "src/ring/util/http_response.clj"
        (mustache/render-file "http-response.mustache"
                              {:template template
                               :imports imports}))
  (doseq [ext ["clj" "cljs"]]
    (spit (str "src/ring/util/http_status." ext)
          (mustache/render-file "http-status.mustache"
                                {:template template}))

    (spit (str "src/ring/util/http_predicates." ext)
          (mustache/render-file "http-predicates.mustache"
                                {:template template
                                 :types type-template}))))

(comment
  (generate!))
