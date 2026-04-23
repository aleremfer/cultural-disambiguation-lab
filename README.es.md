# cultural-disambiguation-lab

Un pequeño laboratorio para modelar y resolver la ambigüedad cultural en la cultura popular española mediante métodos explicables.

> ⚠️ Nota  
> Este proyecto es un laboratorio experimental.  
> El runner actual genera informes exploratorios y está pensado para inspección, no como sistema de benchmarking.

---

## Visión general

Los modelos de lenguaje suelen tener dificultades con **referencias culturales implícitas, dependientes del contexto o poco representadas en datos estructurados o fácilmente recuperables**.

En la cultura popular española, esto incluye:
- referencias musicales  
- eslóganes publicitarios  
- frases de televisión y humor  
- expresiones coloquiales ligadas a épocas o contextos concretos  

No se trata de errores factuales estándar, sino de **fallos de anclaje cultural**, que suelen implicar:
- **pérdida de anclaje cultural (Cultural Anchor Loss)**  
- **desanclaje de entidad (Entity Misgrounding)**  
- **literalización de expresiones no literales**  
- **interpretación con exceso de confianza en contextos ambiguos**  

Este repositorio explora cómo modelar y resolver estas ambigüedades mediante enfoques simbólicos y explicables, en lugar de depender exclusivamente de métodos opacos de aprendizaje automático.

---

## Motivación

La mayoría de sistemas de PLN se apoyan principalmente en:
- asociaciones estadísticas  
- similitud superficial  
- conocimiento indexado en la web  

Sin embargo, las referencias culturales suelen:
- tener **baja visibilidad en datos estructurados**  
- depender de **contexto compartido o memoria generacional**  
- ser **ambiguas por naturaleza**  

Como resultado, los modelos pueden:
- inventar entidades plausibles pero incorrectas  
- atribuir mal las referencias  
- interpretar literalmente lenguaje figurado  

Este proyecto pretende:
> **formalizar la ambigüedad cultural como un problema tratable**  
> y explorar **formas transparentes de razonar sobre ella**

---

## Enfoque

La idea central es construir un **sistema pequeño y explicable** basado en:
- representaciones simbólicas (EDN / estructuras de datos)  
- reglas explícitas de desambiguación  
- conjuntos de ejemplos controlados  

En lugar de preguntar:
> “¿Cuál es el significado más probable?”

planteamos:
> “¿Cuáles son los posibles significados y cómo justificamos la elección de uno?”

---

## Modelo de datos

El proyecto utiliza actualmente dos conjuntos de datos complementarios:

- **cases.edn**  
  Un conjunto curado de expresiones culturalmente ambiguas, con el comportamiento esperado y los fenómenos asociados.

- **observations.edn**  
  Datos de interacción reales que recogen cómo responden los modelos de lenguaje a esos casos, incluyendo:
  - tipo de respuesta (correcta, incorrecta, parcial)  
  - modo de respuesta (respuesta inicial frente a corrección tras feedback)  
  - fenómenos observados  
  - patrones de comportamiento y nivel de confianza  

En conjunto, estos datasets permiten comparar:
> **comportamiento esperado** vs. **comportamiento observado del modelo**

Esto configura un marco pequeño pero explícito para analizar fallos en contextos culturalmente ambiguos.

---

## ¿Por qué Clojure?

Este proyecto utiliza **Clojure** como entorno experimental para:
- representar reglas como datos  
- construir pequeños sistemas lógicos de dominio específico  
- mantener el sistema **totalmente inspeccionable y explicable**  

Clojure permite un ciclo muy directo entre:
- datos  
- reglas  
- evaluación  

lo que lo hace especialmente adecuado para tareas de razonamiento semántico y cultural.

---

## Ejecución local

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

Se permite el uso, modificación y distribución del contenido, siempre que se atribuya correctamente la autoría.
