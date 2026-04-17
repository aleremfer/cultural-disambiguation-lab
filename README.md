# cultural-disambiguation-lab

A small lab for modeling and resolving cultural ambiguity in Spanish popular culture using explainable methods.

---

## Overview

Large language models often struggle with **cultural references that are implicit, context-dependent, or weakly represented in structured or searchable data**.

In Spanish popular culture, this includes:

* music references
* advertising slogans
* TV and comedy catchphrases
* colloquial expressions tied to specific eras or contexts

These cases are not standard factual errors, but **failures of cultural grounding**. They often involve:

* **Cultural Anchor Loss**
* **Entity Misgrounding**
* **Literalization of non-literal expressions**
* **Overconfident interpretation under ambiguity**

This repository explores **how to model and resolve these ambiguities using explainable, symbolic approaches**, rather than relying solely on opaque machine learning systems.

---

## Motivation

Most NLP systems rely heavily on:

* statistical associations
* surface similarity
* web-indexed knowledge

However, cultural references often:

* have **low visibility in structured data**
* depend on **shared context or generational memory**
* are **ambiguous by design**

As a result, LLMs may:

* invent plausible but incorrect entities
* misattribute references
* interpret figurative language literally

This project aims to:

> **formalize cultural ambiguity as a tractable problem**
> and explore **transparent ways to reason about it**

---

## Approach

The core idea is to build a **small, explainable system** based on:

* symbolic representations (EDN / data structures)
* explicit disambiguation rules
* controlled example sets

Rather than asking:

> “What is the most likely meaning?”

We ask:

> “What are the possible meanings, and how do we justify selecting one?”

---

## Why Clojure?

This project uses **Clojure** as an experimental environment for:

* representing rules as data
* building small domain-specific logic systems
* keeping the system **fully inspectable and explainable**

Clojure enables a tight loop between:

* data
* rules
* evaluation

which is well-suited for semantic and cultural reasoning tasks.

---

## Scope

This repository focuses on:

* Spanish popular culture (primarily late 20th – early 21st century)
* real, verifiable references (no synthetic or invented cases)
* ambiguity that arises in natural language usage

---

## Status

Early-stage project. Initial goals:

* define a minimal data format (EDN)
* implement basic disambiguation rules
* document representative cases

---

## License

This project is released under **Creative Commons Attribution 4.0 International (CC BY 4.0)**.

You are free to use, modify, and distribute the content, provided appropriate attribution is given.
