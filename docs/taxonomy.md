# Taxonomy of Cultural Disambiguation Failures

This document defines the main categories of failure addressed in this repository.

The goal is not to provide an exhaustive taxonomy, but a **practical and explainable framework** for analyzing how large language models fail when handling culturally grounded references.

---

## Core Principle

The failures described here are **not necessarily hallucinations** in the strict sense.

Instead, they are better understood as:

> **misidentifications under cultural ambiguity**, often combined with overconfident resolution.

A key issue across cases is:

> **failure to request clarification when multiple plausible interpretations exist**

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
