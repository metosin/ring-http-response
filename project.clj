(defproject metosin/ring-http-status "0.1.0"
  :description "HTTP Statuses for Ring"
  :url "https://github.com/metosin/ring-http-status"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [camel-snake-kebab "0.1.2"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.1"]]
                   :dependencies [[midje "1.6.0"]]}})
