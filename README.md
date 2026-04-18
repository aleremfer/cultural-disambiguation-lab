# cultural-disambiguation-lab
A small lab for modeling and resolving cultural ambiguity in Spanish popular culture using explainable methods.

---

## Overview

Large language models often struggle with **cultural references that are implicit, context-dependent, or weakly represented in structured or searchable data**.

In Spanish popular culture, this includes:
- music references  
- advertising slogans  
- TV and comedy catchphrases  
- colloquial expressions tied to specific eras or contexts  

These are not standard factual errors, but **failures of cultural grounding**, often involving:
- **Cultural Anchor Loss**  
- **Entity Misgrounding**  
- **Literalization of non-literal expressions**  
- **Overconfident interpretation under ambiguity**  

This repository explores **how to model and resolve these ambiguities using explainable, symbolic approaches**, rather than relying solely on opaque machine learning systems.

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

## Approach

The core idea is to build a **small, explainable system** based on:
- symbolic representations (EDN / data structures)  
- explicit disambiguation rules  
- controlled example sets  

Instead of asking:
> "What is the most likely meaning?"

we ask:
> "What are the possible meanings, and how do we justify selecting one?"

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

which is well-suited for semantic and cultural reasoning tasks.

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
