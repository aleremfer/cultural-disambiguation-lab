(ns cultural_disambiguation_lab.run
  (:require [clojure.edn :as edn]
            [cultural_disambiguation_lab.rules.disambiguation :as rules]))

(defn load-edn [path]
  (-> path
      slurp
      edn/read-string))

(defn load-cases []
  (load-edn "data/cases.edn"))

(defn load-observations []
  (load-edn "data/observations.edn"))

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

;; --------------------------------------------------
;; Observations 
;; --------------------------------------------------

(defn observations-by-case [observations]
  (group-by :case_id observations))

(defn count-response-types [observations]
  (frequencies (map :response_type observations)))

(defn count-response-modes [observations]
  (frequencies (map :response_mode observations)))

(defn count-actual-behaviors [observations]
  (frequencies (map :actual_behavior observations)))

(defn count-confidence-levels [observations]
  (frequencies (map :confidence observations)))

(defn count-observed-phenomena [observations]
  (frequencies (mapcat :observed_phenomena observations)))

(defn corrected-after-feedback [observations]
  (filter #(= "corrected_after_feedback" (:response_mode %)) observations))

(defn initial-incorrect-observations [observations]
  (filter #(and (= "initial_answer" (:response_mode %))
                (= "incorrect" (:response_type %)))
          observations))

(defn clarification-failures [observations]
  (filter #(and (= "ask_for_clarification" (:expected_behavior %))
                (not= "ask_for_clarification" (:actual_behavior %)))
          observations))

(defn expected-direct-identification [observations]
  (filter #(= "direct_identification" (:expected_behavior %)) observations))

(defn print-observations-overview [observations]
  (println "\n=== Observations overview ===\n")
  (println (str "Total observations: " (count observations))))

(defn print-response-type-report [observations]
  (println "\n=== Observation response types ===\n")
  (doseq [[response-type count] (sort-by key (count-response-types observations))]
    (println (str response-type ": " count))))

(defn print-response-mode-report [observations]
  (println "\n=== Observation response modes ===\n")
  (doseq [[response-mode count] (sort-by key (count-response-modes observations))]
    (println (str response-mode ": " count))))

(defn print-actual-behavior-report [observations]
  (println "\n=== Observation actual behaviors ===\n")
  (doseq [[behavior count] (sort-by key (count-actual-behaviors observations))]
    (println (str behavior ": " count))))

(defn print-confidence-report [observations]
  (println "\n=== Observation confidence levels ===\n")
  (doseq [[confidence count] (sort-by key (count-confidence-levels observations))]
    (println (str confidence ": " count))))

(defn print-observed-phenomena-report [observations]
  (println "\n=== Observed phenomena counts ===\n")
  (doseq [[phenomenon count] (sort-by key (count-observed-phenomena observations))]
    (println (str phenomenon ": " count))))

(defn print-observations-by-case-report [observations]
  (let [grouped (observations-by-case observations)]
    (println "\n=== Observations per case ===\n")
    (doseq [[case-id obs-list] (sort-by key grouped)]
      (println (str "- " case-id ": " (count obs-list) " observation(s)")))))

(defn print-clarification-failures-report [observations]
  (let [failures (clarification-failures observations)]
    (println "\n=== Clarification failures ===\n")
    (println "Expected behavior was ask_for_clarification, but the observed behavior was different.")
    (println (str "Total: " (count failures)))
    (doseq [obs failures]
      (println
       (str "- " (:id obs)
            " | case: " (:case_id obs)
            " | response_type: " (:response_type obs)
            " | actual_behavior: " (:actual_behavior obs))))))

(defn print-corrected-after-feedback-report [observations]
  (let [corrected (corrected-after-feedback observations)]
    (println "\n=== Corrected after feedback ===\n")
    (println (str "Total: " (count corrected)))
    (doseq [obs corrected]
      (println
       (str "- " (:id obs)
            " | case: " (:case_id obs)
            " | response_type: " (:response_type obs)
            " | summary: " (:response_summary obs))))))

(defn print-initial-incorrect-report [observations]
  (let [incorrect (initial-incorrect-observations observations)]
    (println "\n=== Initial incorrect answers ===\n")
    (println (str "Total: " (count incorrect)))
    (doseq [obs incorrect]
      (println
       (str "- " (:id obs)
            " | case: " (:case_id obs)
            " | confidence: " (:confidence obs)
            " | summary: " (:response_summary obs))))))

(defn print-direct-identification-baselines [observations]
  (let [baseline-cases (expected-direct-identification observations)]
    (println "\n=== Direct identification baselines ===\n")
    (println (str "Total: " (count baseline-cases)))
    (doseq [obs baseline-cases]
      (println
       (str "- " (:id obs)
            " | case: " (:case_id obs)
            " | response_type: " (:response_type obs)
            " | actual_behavior: " (:actual_behavior obs))))))

(defn print-observation-summary [obs]
  (println "----------------------------------------")
  (println (str "Observation ID: " (:id obs)))
  (println (str "Case ID: " (:case_id obs)))
  (println (str "Model: " (:model obs)))
  (println (str "Date: " (:date obs)))
  (println (str "Prompt: " (:prompt obs)))
  (println (str "Response summary: " (:response_summary obs)))
  (println (str "Response type: " (:response_type obs)))
  (println (str "Response mode: " (:response_mode obs)))
  (println (str "Expected behavior: " (:expected_behavior obs)))
  (println (str "Actual behavior: " (:actual_behavior obs)))
  (println (str "Observed phenomena: " (:observed_phenomena obs)))
  (println (str "Confidence: " (:confidence obs)))
  (println (str "Notes: " (:notes obs))))

(defn print-full-observation-report [observations]
  (println "\n=== Full observation summaries ===\n")
  (doseq [obs observations]
    (print-observation-summary obs)))

(defn -main []
  (let [cases (load-cases)
        observations (load-observations)]
    (print-decision-report cases)
    (print-phenomena-report cases)
    (print-clarification-report cases)

    (print-observations-overview observations)
    (print-response-type-report observations)
    (print-response-mode-report observations)
    (print-actual-behavior-report observations)
    (print-confidence-report observations)
    (print-observed-phenomena-report observations)
    (print-observations-by-case-report observations)
    (print-clarification-failures-report observations)
    (print-corrected-after-feedback-report observations)
    (print-initial-incorrect-report observations)
    (print-direct-identification-baselines observations)))
