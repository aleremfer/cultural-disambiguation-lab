(ns cultural_disambiguation_lab.run
  (:require [clojure.edn :as edn]
            [cultural_disambiguation_lab.rules.disambiguation :as rules]))

(defn load-cases []
  (-> "data/cases.edn"
      slurp
      edn/read-string))

(defn evaluate-cases []
  (let [cases (load-cases)]
    (map rules/decision-for-case cases)))

(defn -main []
  (doseq [result (evaluate-cases)]
    (println result)))
