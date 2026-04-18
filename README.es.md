# cultural-disambiguation-lab

> Un pequeño laboratorio para modelar y resolver la ambigüedad cultural en la cultura popular española mediante enfoques explicables.

---

## Visión general

Los modelos de lenguaje suelen tener dificultades con **referencias culturales implícitas, dependientes del contexto o poco representadas en datos estructurados o fácilmente accesibles**.

En la cultura popular española, esto incluye:

- referencias musicales  
- eslóganes publicitarios  
- frases de televisión y comedia  
- expresiones coloquiales ligadas a una época o contexto concreto  

Estos casos no son errores factuales clásicos, sino **fallos de anclaje cultural**, que suelen implicar:

- **Pérdida de anclaje cultural (Cultural Anchor Loss)**  
- **Desanclaje de entidad (Entity Misgrounding)**  
- **Literalización de expresiones no literales**  
- **Exceso de confianza en contextos ambiguos**  

Este repositorio explora **cómo modelar y resolver estas ambigüedades mediante enfoques simbólicos y explicables**, en lugar de depender únicamente de sistemas opacos basados en aprendizaje automático.

---

## Motivación

La mayoría de los sistemas de NLP se apoyan en:

- asociaciones estadísticas  
- similitud superficial  
- conocimiento indexado en la web  

Sin embargo, las referencias culturales:

- tienen **baja visibilidad en datos estructurados**  
- dependen de **memoria compartida o generacional**  
- son **ambiguas por naturaleza**  

Como resultado, los modelos pueden:

- inventar entidades plausibles pero incorrectas  
- atribuir mal referencias  
- interpretar literalmente expresiones figuradas  

Este proyecto intenta:

> **formalizar la ambigüedad cultural como un problema abordable**  
> y explorar **formas transparentes de razonar sobre ella**

---

## Enfoque

La idea central es construir un **sistema pequeño y explicable** basado en:

- representaciones simbólicas (EDN / estructuras de datos)  
- reglas explícitas de desambiguación  
- conjuntos de ejemplos controlados  

En lugar de preguntar:

> "¿Cuál es el significado más probable?"

planteamos:

> "¿Qué significados son posibles y cómo justificamos la elección de uno?"

---

## ¿Por qué Clojure?

Este proyecto utiliza **Clojure** como entorno experimental para:

- representar reglas como datos  
- construir lógica de dominio específica  
- mantener el sistema **totalmente inspeccionable y explicable**  

Clojure permite un bucle muy directo entre:

- datos  
- reglas  
- evaluación  

lo que encaja especialmente bien con tareas de razonamiento semántico y cultural.

---

## Ejecución en local

```bash
git clone https://github.com/aleremfer/cultural-disambiguation-lab.git
cd cultural-disambiguation-lab
clojure -M -m cultural_disambiguation_lab.run
```

---

## Ejemplo de salida
Salida generada por el sistema:
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

## Licencia

Este proyecto se distribuye bajo la licencia **Creative Commons Attribution 4.0 International (CC BY 4.0)**.

Se permite el uso, modificación y distribución del contenido, siempre que se cite correctamente la fuente.
