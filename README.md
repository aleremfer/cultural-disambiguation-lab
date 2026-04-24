# cultural-disambiguation-lab

A small lab for modeling and resolving cultural ambiguity in Spanish popular culture using explainable methods.

> ⚠️ Note  
> This project is an experimental lab.  
> The current runner prints exploratory reports and is intended for inspection, not benchmarking.

---

(https://zenodo.org/badge/DOI/10.5281/zenodo.19729897.svg)](https://doi.org/10.5281/zenodo.19729897)

## 📄 Paper

This repository is a companion artifact to the paper:

**Cultural Anchor Loss (CAL): A Failure Mode in Large Language Models**

DOI: https://doi.org/10.5281/zenodo.19729897

---

## 📚 Citation

If you use this dataset or concept, please cite:

Remeseiro Fernández, Alejandro (2026).
*Cultural Anchor Loss (CAL)*.
Zenodo. https://doi.org/10.5281/zenodo.19729897

---

## Overview

Large language models often struggle with **cultural references that are implicit, context-dependent, or weakly represented in structured or searchable data**.

In Spanish popular culture, this includes:
- music references  
- advertising slogans  
- TV and comedy catchphrases  
- colloquial expressions tied to specific eras or contexts  

These are not standard factual errors, but **failures of cultural grounding distinct from factual hallucination**, often involving:
- **Cultural Anchor Loss**  
- **Entity Misgrounding**  
- **Literalization of non-literal expressions**  
- **Overconfident interpretation under ambiguity**  

This repository explores how to model and resolve these ambiguities using explainable, symbolic approaches rather than opaque machine learning systems.

---

## Motivation

Most NLP systems rely heavily on:
- statistical associations  
- surface similarity  
- web-indexed knowledge  

However, cultural references often:
- have **low visibility in structured data**  
- depend on **shared context or generational memory**  
- are **ambiguous by design**  

As a result, LLMs may:
- invent plausible but incorrect entities  
- misattribute references  
- interpret figurative language literally  

This project aims to:
> **formalize cultural ambiguity as a tractable problem**  
> and explore **transparent ways to reason about it**

---

## Contribution

This project introduces and operationalizes:

- **Cultural Anchor Loss (CAL)** as a distinct failure mode in LLMs  
- A small, inspectable framework for analyzing cultural ambiguity  
- A dataset of real model behaviors under ambiguous cultural input  

The goal is not scale, but **clarity and reproducibility of failure patterns**.

---

## Approach

The core idea is to build a **small, explainable system** based on:
- symbolic representations (EDN / data structures)  
- explicit disambiguation rules  
- controlled example sets  

This shift reflects a key limitation of current LLMs:
> confidence is often driven by familiarity signals rather than verified grounding

This often leads to plausible but incorrect answers instead of clarification.

---

## Data Model

The project currently uses two complementary datasets:

- **cases.edn**  
  A curated set of culturally ambiguous expressions, including expected behavior and associated phenomena.

- **observations.edn**  
  Real interaction data capturing how language models respond to those cases, including:
  - response type (correct, incorrect, partial)  
  - response mode (initial answer vs. corrected after feedback)  
  - observed phenomena  
  - confidence and behavior patterns  

Together, these datasets allow comparison between:
> **expected behavior** and **observed model behavior**

This enables a small but explicit framework for analyzing failure modes in culturally ambiguous contexts.

---

## Why Clojure?

This project uses **Clojure** as an experimental environment for:
- representing rules as data  
- building small domain-specific logic systems  
- keeping the system **fully inspectable and explainable**  

Clojure enables a tight loop between:
- data  
- rules  
- evaluation  

This makes it particularly suitable for studying failure modes where interpretability matters more than performance.

---

## Run locally

```bash
git clone https://github.com/aleremfer/cultural-disambiguation-lab.git
cd cultural-disambiguation-lab
clojure -M -m cultural_disambiguation_lab.run
```

---

## Example Output

```
=== Case summaries ===
ID: gigi-el-amoroso-pajares-1974  
Term: Conoció a una alemana, un poco casquivana y le propuso ir a su país  
Decision: ask_for_clarification  
Reason: cultural ambiguity detected  
Phenomena: ["cultural_misidentification" "parody_source_loss"]

=== Phenomena counts ===
cultural_anchor_loss: 4  
entity_misgrounding: 5  
salience_bias: 4  

=== Cases requiring clarification ===
Total: 6
```
---

## License

This project is released under **Creative Commons Attribution 4.0 International (CC BY 4.0)**.
You are free to use, modify, and distribute the content, provided appropriate attribution is given.
