(defproject hello "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :min-lein-version "2.5.3"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-2"]]

  :source-paths ["src"]

  :clean-targets ["index.js"
                  "target"]

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src"]
              :figwheel true
              :compiler {
                :main hello.core
                :output-to "target/server_dev/hello.js"
                :output-dir "target/server_dev"
                :target :nodejs
                :optimizations :none
                :source-map true}}
             ;; zip hello.zip index.js package.json
             ;; execute function: hello.core.index
             {:id "prod"
              :source-paths ["src"]
              :compiler {
                :output-to "index.js"
                :output-dir "target/server_prod"
                :target :nodejs
                ;:hashbang false
                :optimizations :simple}}]})
