(defproject metosin/ring-http-response "0.6.0"
  :description "Handling HTTP Statuses with Clojure(Script)"
  :url "https://github.com/metosin/ring-http-response"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-core "1.3.2"]
                 [potemkin "0.3.11"]
                 [slingshot "0.12.2"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.1.3"]]
                   :resource-paths ["templates"]
                   :source-paths ["dev"]
                   :dependencies [[org.tobereplaced/lettercase "1.0.0"]
                                  [stencil "0.3.5"]
                                  [midje "1.6.3"]]}}
  :aliases {"test-ancient" ["midje"]})
