# Taxonomy of Cultural Disambiguation Failures

This document defines the main categories of failure addressed in this repository.

The goal is not to provide an exhaustive taxonomy, but a **practical and explainable framework** for analyzing how large language models fail when handling culturally grounded references.

---

## Core Principle

The failures described here are **not necessarily hallucinations** in the strict sense.

Instead, they are better understood as:

> **misidentifications under cultural ambiguity, where overconfident resolution replaces clarification**

In many cases, the model does not lack knowledge entirely, but rather:

- fails to correctly resolve between multiple plausible interpretations  
- relies on superficial similarity or dominant associations  
- selects a culturally adjacent but incorrect referent  

A central issue across cases is:

> **failure to request clarification when multiple plausible interpretations exist under uncertainty**

This is not only a knowledge problem, but a **decision-level failure**.

This failure is frequently accompanied by overconfident responses.

---

## Key Hypothesis

> Cultural ambiguity exposes a distinct class of failure modes in language models, where the primary issue is not missing knowledge, but incorrect resolution under uncertainty.

---

## Conceptual Structure

The categories in this taxonomy operate at different levels. A single failure may involve multiple layers.

### 1. Precursors (Input Interpretation Failures)

Conditions that distort how the input is interpreted before resolution:

- Cultural Anchor Loss  
- Literalization Risk  

These do not directly produce incorrect answers, but **increase the likelihood of downstream errors**.

---

### 2. Mechanisms (Why the Error Happens)

Underlying processes influencing resolution:

- Salience Bias  
- Literary Bias  
- Cross-Case Contamination  

These influence which candidate interpretation is selected among competing plausible options.

---

### 3. Outcomes (What Happens)

Observable result of the model’s response:

- Cultural Misidentification  
- Entity Misgrounding  

---

### 4. Behavior (Decision-Level Failures)

How the model behaves under ambiguity:

- Failure to Ask for Clarification  
- Iterative Failure to Seek Clarification  

---

### 5. Cross-Cutting Phenomena

These operate across multiple levels and are not directly annotated in the dataset:

- Overconfidence under Ambiguity  

---

## Interaction Between Categories

These categories are not mutually exclusive.

A single response may involve:

- a precursor (e.g. Cultural Anchor Loss)  
- a mechanism (e.g. Salience Bias)  
- an outcome (e.g. Cultural Misidentification)  
- a behavioral failure (e.g. Failure to Ask for Clarification)  

Understanding failures requires analyzing these layers jointly.

This layered structure helps distinguish between:
- what failed  
- why it failed  
- and how the model behaved under uncertainty  

---

## Categories

### 1. Cultural Misidentification

Incorrect identification of a culturally specific reference.

The model selects a plausible but incorrect referent due to:

- incomplete cultural grounding  
- superficial similarity  
- weak representation in training data  

---

### 2. Entity Misgrounding

Failure to correctly link a term or phrase to its intended real-world referent.

Includes:

- mapping to a generic concept instead of a specific entity  
- selecting a high-frequency but incorrect referent  

---

### 3. Cultural Anchor Loss (Precursor)

Loss of the original cultural context of a phrase or expression.

The model:

- ignores its origin (media, time period, cultural domain)  
- treats it as a generic or decontextualized statement  

This acts as a **precursor condition** that may lead to:

- Cultural Misidentification  
- Entity Misgrounding  

---

### 4. Literalization Risk (Precursor)

Interpretation of a non-literal or culturally loaded expression as literal language.

The model fails to detect:

- irony  
- stylization  
- rhetorical intent  

---

### 5. Salience Bias

Over-reliance on prominent or high-frequency entities when resolving ambiguity.

The model prefers:

- well-known artists  
- canonical figures  
- dominant references  

even when incorrect in context.

---

### 6. Literary Bias

A stylistic bias where linguistic tone is incorrectly mapped to canonical or literary sources.

Example:

- attributing modern expressions to classical literature  

---

### 7. Failure to Ask for Clarification

The model answers despite clear ambiguity.

Expected behavior:

> request clarification when multiple interpretations are plausible  

This represents a **decision-level failure**, not a knowledge limitation.

---

### 8. Iterative Failure to Seek Clarification  
*(represented in the dataset as `iterative_misidentification`)*

A stronger form of the previous failure.

The model:

- generates multiple plausible but incorrect hypotheses  
- receives corrective signals  
- continues generating plausible guesses instead of changing strategy  

This reflects failure to transition from:

> answer generation → clarification request  

---

### 9. Parody Source Loss

Failure to preserve relationships between:

> original work ↔ adaptation ↔ parody  

The model may:

- identify the original but not the parody  
- collapse multiple layers into a single referent  

---

### 10. Cross-Case Contamination

Incorrect blending of elements from multiple related cultural references.

The model:

- activates a cultural cluster  
- retrieves partial elements from different cases  
- merges them into a coherent but incorrect response  

This often occurs when multiple partially activated candidates are not properly resolved.

---

## Cross-Cutting Phenomena: Overconfidence under Ambiguity

The model produces a confident response despite insufficient grounding.

This phenomenon is not encoded as a separate label in the dataset, but emerges consistently across observed failure patterns.

It reflects a mismatch between:

> epistemic uncertainty  
> and expressed confidence  

---

## Intended Use

This taxonomy supports:

- qualitative analysis of LLM outputs  
- construction of evaluation datasets  
- development of explainable disambiguation systems  
- identification of failure modes beyond standard hallucination metrics  

---

## Notes

This taxonomy is intentionally:

- **minimal** → easy to apply  
- **interpretable** → no hidden assumptions  
- **extensible** → new categories can be added  

---

## Label Mapping (EDN ↔ Taxonomy)

The following labels are used in the dataset (`cases.edn`) and map directly to the categories defined above.

These labels are intentionally limited to **annotatable phenomena**, and do not include higher-level or cross-cutting concepts.

- cultural_misidentification → Cultural Misidentification  
- entity_misgrounding → Entity Misgrounding  
- cultural_anchor_loss → Cultural Anchor Loss  
- literalization_risk → Literalization Risk  
- salience_bias → Salience Bias  
- literary_bias → Literary Bias  
- failure_to_ask_clarification → Failure to Ask for Clarification  
- iterative_misidentification → Iterative Failure to Seek Clarification  
- parody_source_loss → Parody Source Loss  
- cross_case_contamination → Cross-Case Contamination  
