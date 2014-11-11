(defproject metosin/ring-http-response "0.5.2"
  :description "Real HTTP Statuses for Ring"
  :url "https://github.com/metosin/ring-http-response"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.1"]
                 [slingshot "0.11.0"]
                 [potemkin "0.3.9"]
                 [org.tobereplaced/lettercase "1.0.0"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.3"]]
                   :dependencies [[midje "1.6.3"]]}}
  :aliases {"test-ancient" ["midje"]})
