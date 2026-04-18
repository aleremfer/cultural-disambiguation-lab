# Taxonomy of Cultural Disambiguation Failures

This document defines the main categories of failure addressed in this repository.

The goal is not to provide an exhaustive taxonomy, but a **practical and explainable framework** for analyzing how large language models fail when handling culturally grounded references.

---

## Core Principle

The failures described here are **not necessarily hallucinations** in the strict sense.

Instead, they are better understood as:

> **misidentifications under cultural ambiguity**, often combined with overconfident resolution.

A key issue across cases is:

> failure to request clarification when multiple plausible interpretations exist  

In more complex cases, this failure becomes iterative, with the model continuing to generate plausible but incorrect hypotheses instead of adapting its strategy.


---

## Categories

### 1. Cultural Misidentification

Incorrect identification of a culturally specific reference.

The model selects a plausible but wrong entity due to:

* incomplete cultural grounding
* superficial similarity
* weak representation in training data

**Example patterns:**

* attributing a lyric to the wrong artist
* confusing culturally adjacent entities

---

### 2. Entity Misgrounding

Failure to correctly link a term or phrase to its intended real-world referent.

This includes:

* mapping to a generic concept instead of a specific entity
* selecting a high-frequency but incorrect referent

**Typical causes:**

* lack of contextual anchoring
* dominance of global priors over local knowledge

---

### 3. Cultural Anchor Loss

Loss of the original cultural context of a phrase or expression.

The model:

* ignores its origin (media, time period, cultural domain)
* treats it as a generic or decontextualized statement

**Common in:**

* advertising slogans
* TV or comedy catchphrases
* legacy media references

---

### 4. Literalization Risk

Interpretation of a non-literal or culturally loaded expression as literal language.

The model fails to detect:

* irony
* stylization
* rhetorical intent

**Result:**

* overly literal explanations
* semantic flattening

---

### 5. Salience Bias

Over-reliance on more prominent or widely known entities when resolving ambiguity.

The model prefers:

* well-known artists
* canonical authors
* high-frequency references

even when they are incorrect in context.

---

### 6. Literary Bias

A specific form of salience bias where:

* phrases with a literary tone are incorrectly attributed to canonical authors

**Example pattern:**

* attributing modern lyrics to classical poetry

---

### 7. Failure to Ask for Clarification

The model proceeds to answer despite clear ambiguity.

This is a **decision-level failure**, not just a knowledge error.

Expected behavior in such cases:

> ask the user to disambiguate between multiple plausible interpretations

#### Iterative Failure to Ask for Clarification

A more severe form of this failure occurs when the model:

- produces multiple plausible but incorrect hypotheses  
- receives corrective feedback  
- continues to generate new guesses instead of switching strategy  

In these cases, the model fails to transition from:

> answer generation  

to:

> clarification request  

This results in:

- cascading misidentifications  
- overconfident iterative guessing  
- delayed or absent abstention  

This pattern is especially common in culturally ambiguous contexts with multiple plausible anchors, and is explicitly modeled in this repository's dataset.

---

### 8. Parody Source Loss

Failure to correctly link a cultural reference to its parodic or derivative form.

The model may:

- correctly identify the original source  
- fail to retrieve the local adaptation or parody  
- collapse both into a single referent  

This reflects a loss of relational structure between:

> original work ↔ adaptation ↔ parody  

**Typical patterns:**

- identifying the original international work but not its local version  
- ignoring culturally specific reinterpretations  
- prioritizing canonical sources over local variants  

This failure is particularly relevant in domains where parody and adaptation are common, such as:

- music  
- television  
- comedy and revue  

---

### 9. Cross-Case Contamination

Failure where the model incorrectly combines elements from multiple culturally related references.

Instead of selecting a single plausible interpretation, the model:

- activates a cultural cluster (e.g. advertising, music, TV)  
- retrieves elements from different cases within that cluster  
- merges them into a single, coherent but incorrect response  

**Typical patterns:**

- mixing slogans from different brands  
- combining entities from related cultural domains  
- attributing a phrase correctly but linking it to the wrong context or persona  

This results in outputs that are:

- semantically plausible  
- culturally coherent at a superficial level  
- but factually incorrect due to cross-case blending  

---

## Intended Use

This taxonomy is designed to support:

* qualitative analysis of LLM outputs
* construction of evaluation datasets
* development of explainable disambiguation systems
* identification of failure modes beyond standard hallucination metrics

---

## Notes

This taxonomy is intentionally:

* **minimal** → easy to apply
* **interpretable** → no hidden assumptions
* **extensible** → new categories can be added as needed

It reflects a working hypothesis:

> cultural ambiguity is a distinct and underexplored failure mode in language models


## Label Mapping (EDN ↔ Taxonomy)

The following labels are used in the dataset (`cases.edn`) and map directly to the categories defined above:

- cultural_misidentification → Cultural Misidentification  
- entity_misgrounding → Entity Misgrounding  
- cultural_anchor_loss → Cultural Anchor Loss  
- literalization_risk → Literalization Risk  
- salience_bias → Salience Bias  
- literary_bias → Literary Bias  
- failure_to_ask_clarification → Failure to Ask for Clarification  
- iterative_misidentification → Iterative Failure to Ask for Clarification  
- parody_source_loss → Parody Source Loss  


It reflects a working hypothesis:

> cultural ambiguity is a distinct and underexplored failure mode in language models
