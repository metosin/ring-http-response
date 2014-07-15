(defproject metosin/ring-http-response "0.4.1"
  :description "Real HTTP Statuses for Ring"
  :url "https://github.com/metosin/ring-http-response"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.0"]
                 [slingshot "0.10.3"]
                 [potemkin "0.3.4"]
                 [camel-snake-kebab "0.1.5"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.3"]]
                   :dependencies [[midje "1.6.3"]]}})
