# cultural-disambiguation-lab

Un pequeño laboratorio para modelar y resolver la ambigüedad cultural en la cultura popular española mediante métodos explicables.

---

## Descripción general

Los modelos de lenguaje de gran tamaño suelen tener dificultades con **referencias culturales implícitas, dependientes del contexto o poco representadas en datos estructurados o fácilmente recuperables**.

En la cultura popular española, esto incluye:

* referencias musicales
* eslóganes publicitarios
* frases hechas de televisión y comedia
* expresiones coloquiales ligadas a épocas o contextos específicos

Estos casos no son errores factuales estándar, sino **fallos de anclaje cultural**. Suelen implicar:

* **Pérdida de anclaje cultural (Cultural Anchor Loss)**
* **Desanclaje o mala asignación de entidad (Entity Misgrounding)**
* **Literalización de expresiones no literales**
* **Interpretaciones excesivamente confiadas en contextos ambiguos**

Este repositorio explora **cómo modelar y resolver estas ambigüedades mediante enfoques simbólicos y explicables**, en lugar de depender exclusivamente de sistemas de aprendizaje automático opacos.

---

## Motivación

La mayoría de sistemas de PLN se basan en gran medida en:

* asociaciones estadísticas
* similitud superficial
* conocimiento indexado en la web

Sin embargo, las referencias culturales:

* tienen **baja visibilidad en datos estructurados**
* dependen de **contexto compartido o memoria generacional**
* son **ambiguas por naturaleza**

Como resultado, los LLM pueden:

* inventar entidades plausibles pero incorrectas
* atribuir referencias de forma errónea
* interpretar literalmente expresiones figuradas

Este proyecto busca:

> **formalizar la ambigüedad cultural como un problema tratable**
> y explorar **formas transparentes de razonar sobre ella**

---

## Enfoque

La idea central es construir un **sistema pequeño y explicable** basado en:

* representaciones simbólicas (EDN / estructuras de datos)
* reglas explícitas de desambiguación
* conjuntos de ejemplos controlados

En lugar de preguntar:

> «¿Cuál es el significado más probable?»

Planteamos:

> «¿Cuáles son los posibles significados y cómo justificamos la elección de uno de ellos?»

---

## ¿Por qué Clojure?

Este proyecto utiliza **Clojure** como entorno experimental para:

* representar reglas como datos
* construir pequeños sistemas lógicos específicos de dominio
* mantener el sistema **totalmente inspeccionable y explicable**

Clojure permite un ciclo muy directo entre:

* datos
* reglas
* evaluación

lo que lo hace especialmente adecuado para tareas de razonamiento semántico y cultural.

---

## Alcance

Este repositorio se centra en:

* cultura popular española (principalmente finales del siglo XX y principios del XXI)
* referencias reales y verificables (sin casos inventados)
* ambigüedad surgida en el uso natural del lenguaje

---

## Estado

Proyecto en fase inicial. Objetivos actuales:

* definir un formato mínimo de datos (EDN)
* implementar reglas básicas de desambiguación
* documentar casos representativos

---

## Licencia

Este proyecto se distribuye bajo **Creative Commons Attribution 4.0 International (CC BY 4.0)**.

Puedes usar, modificar y distribuir el contenido libremente, siempre que se proporcione la atribución correspondiente.
