(ns ring.middleware.http-response)

(defn- handle-exception [e respond raise]
  (let [{:keys [type response]} (ex-data e)]
    (if (= type :ring.util.http-response/response)
      (respond response)
      (raise e))))

(defn wrap-http-response
  "Catches thrown http-exceptions and converts them into
   corresponding ring-responses. e.g. exception from
   (bad-request! \"bad\") is converted into (bad-request \"bad\").
   Supports async-ring."
  [handler]
  (let [throw #(throw %)]
    (fn
      ([request]
       (try
         (handler request)
         (catch Exception e
           (handle-exception e identity throw))))
      ([request respond raise]
       (try
         (handler request respond #(handle-exception % respond raise))
         (catch Exception e
           (handle-exception e respond throw)))))))

