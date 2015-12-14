(defproject metosin/ring-http-response "0.6.5"
  :description "Handling HTTP Statuses with Clojure(Script)"
  :url "https://github.com/metosin/ring-http-response"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[ring/ring-core "1.4.0"]
                 [potemkin "0.4.2"]
                 [slingshot "0.12.2"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]
                             [lein-midje "3.2"]]
                   :resource-paths ["templates"]
                   :source-paths ["dev"]
                   :dependencies [[org.clojure/clojure "1.7.0"]
                                  [org.tobereplaced/lettercase "1.0.0"]
                                  [stencil "0.5.0"]
                                  [midje "1.8.2"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}}
  :aliases {"all" ["with-profile" "dev:dev,1.6" "midje"]
            "test-ancient" ["midje"]})
