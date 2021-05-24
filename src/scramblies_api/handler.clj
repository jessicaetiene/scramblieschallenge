(ns scramblies-api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [ring.util.response :refer [response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [scramblies-api.service :refer :all]))

(defroutes app-routes

  (GET "/api/scramblies/word1/:word1/word2/:word2"
       [word1 word2]
       (response (check-words word1 word2)))
  (route/not-found "Not Found"))

(def app
  (-> (wrap-defaults app-routes site-defaults)
      (json/wrap-json-params)
      (json/wrap-json-response)))
