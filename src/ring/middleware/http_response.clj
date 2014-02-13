(ns ring.middleware.http-response
  (:require [slingshot.slingshot :refer [try+]]))

(defn catch-response
  [handler]
  (fn [request]
    (try+
      (handler request)
      (catch [:type :ring.util.http-response/response] {:keys [response]}
        response))))

