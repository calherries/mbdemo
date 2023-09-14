(ns mbdemo
  (:require
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.middleware.defaults :refer [site-defaults
                                     wrap-defaults]]
   [ring.util.response :as resp]
   [selmer.parser :as html]))

(defn handler [req]
  (-> (resp/response (html/render-file "hello.html" {:name "Code"}))
      (resp/content-type "text/json")))

(def app (wrap-defaults #'handler site-defaults))

(comment 
  (def server (run-jetty #'app {:join? false :port 8888}))
  )

(defn -main 
  "I don't do much"
  [& args]
  (prn "Hello, world!"))
