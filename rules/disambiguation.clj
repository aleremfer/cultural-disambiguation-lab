(ns cultural_disambiguation_lab.rules.disambiguation)

(defn should-ask-clarification?
  "Returns true when the expected behavior is to ask for clarification."
  [case]
  (= (:expected_behavior case) "ask_for_clarification"))

(defn decision-for-case
  "Returns a simple decision map for a given case."
  [case]
  (if (should-ask-clarification? case)
    {:decision "ask_for_clarification"
     :reason "cultural ambiguity detected"
     :term (:term case)
     :phenomena (:phenomena case)}
    {:decision "attempt_resolution"
     :reason "no clarification required"
     :term (:term case)
     :phenomena (:phenomena case)}))

(defn summarize-case
  "Returns a compact summary of the case."
  [case]
  {:id (:id case)
   :term (:term case)
   :type (:type case)
   :ground_truth (:ground_truth case)
   :common_misinterpretation (:common_misinterpretation case)
   :expected_behavior (:expected_behavior case)})

(defn explain-decision
  "Returns a human-readable explanation for the decision."
  [case]
  (let [decision (decision-for-case case)]
    (str "Term: " (:term decision)
         " | Decision: " (:decision decision)
         " | Reason: " (:reason decision))))
