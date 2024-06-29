(defproject metosin/ring-http-response "0.9.4"
  :description "Handling HTTP Statuses with Clojure(Script)"
  :url "https://github.com/metosin/ring-http-response"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[ring/ring-core "1.12.2"]
                 [potemkin "0.4.7"]]
  :profiles {:dev {:plugins [[lein-clojars "0.9.1"]]
                   :resource-paths ["templates"]
                   :source-paths ["dev"]
                   :dependencies [[org.clojure/clojure "1.11.3"]
                                  [org.tobereplaced/lettercase "1.0.0"]
                                  [stencil "0.5.0"]]}
             :1.10 {:dependencies [[org.clojure/clojure "1.10.3"]]}}
  :deploy-repositories [["releases" {:url "https://repo.clojars.org/"
                                     :sign-releases false
                                     :username :env/CLOJARS_USER
                                     :password :env/CLOJARS_DEPLOY_TOKEN}]]
  :aliases {"all" ["with-profile" "dev:dev,1.10" "test"]})
