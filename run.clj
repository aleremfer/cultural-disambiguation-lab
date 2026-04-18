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

(defn count-phenomena [cases]
  (frequencies (mapcat :phenomena cases)))

(defn cases-requiring-clarification [cases]
  (filter #(= "ask_for_clarification" (:expected_behavior %)) cases))

(defn print-case-summary [case]
  (println "----------------------------------------")
  (println (str "ID: " (:id case)))
  (println (str "Term: " (:term case)))
  (println (str "Type: " (:type case)))
  (println (str "Phenomena: " (:phenomena case)))
  (println (str "Expected behavior: " (:expected_behavior case))))

(defn print-decision-report [cases]
  (println "\n=== Case summaries ===\n")
  (doseq [case cases]
    (print-case-summary case)
    (println (rules/explain-decision case))))

(defn print-phenomena-report [cases]
  (println "\n=== Phenomena counts ===\n")
  (doseq [[phenomenon count] (sort-by key (count-phenomena cases))]
    (println (str phenomenon ": " count))))

(defn print-clarification-report [cases]
  (let [clarification-cases (cases-requiring-clarification cases)]
    (println "\n=== Cases requiring clarification ===\n")
    (println (str "Total: " (count clarification-cases)))
    (doseq [case clarification-cases]
      (println (str "- " (:id case) " -> " (:term case))))))

(defn -main []
  (let [cases (load-cases)]
    (print-decision-report cases)
    (print-phenomena-report cases)
    (print-clarification-report cases)))
