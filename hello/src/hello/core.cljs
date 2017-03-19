(ns hello.core
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

; Responds to any HTTP request that can provide a "message" field in the body.
;
; @param {!Object} req Cloud Function request context.
; @param {!Object} res Cloud Function response context.
(defn ^:export hello [req res]
  ;  Example input: {"message": "Hello!"}
  (if (= req.body.message js/undefined)
    ; This is an error case, as "message" is required.
    (.send (.status res 400) "No message defined!")
    ; Everything is okay.
    (do
      (.log js/console req.body.message)
      (.send (.status res 200) (str "Success: " req.body.message)))))

(defn -main []
  (println "Hello world!"))

(set! *main-cli-fn* -main)
