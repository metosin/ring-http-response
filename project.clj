(defproject metosin/ring-http-response "0.5.0-SNAPSHOT"
  :description "Real HTTP Statuses for Ring"
  :url "https://github.com/metosin/ring-http-response"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.1"]
                 [slingshot "0.10.3"]
                 [potemkin "0.3.8"]
                 [camel-snake-kebab "0.2.4"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.3"]]
                   :dependencies [[midje "1.6.3"]]}})
