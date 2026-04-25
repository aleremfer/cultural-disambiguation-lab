# cultural-disambiguation-lab

Un pequeño laboratorio para modelar y resolver la ambigüedad cultural en la cultura popular española mediante métodos explicables.

> ⚠️ Nota  
> Este proyecto es un laboratorio experimental.  
> El runner actual genera informes exploratorios y está pensado para inspección, no para benchmarking.

---

[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.19729897.svg)](https://doi.org/10.5281/zenodo.19729897)

## 📄 Artículo

Este repositorio es un artefacto complementario del artículo:

**Cultural Anchor Loss (CAL): A Failure Mode in Large Language Models**

https://doi.org/10.5281/zenodo.19729897

---

## 📚 Cita

Si utilizas este dataset o concepto, por favor cita:

Remeseiro Fernández, Alejandro.  
“Cultural Anchor Loss and Related Failure Patterns  
in Large Language Models: Evidence from Spanish Popular Culture”.  
Zenodo, 24 de abril de 2026. https://doi.org/10.5281/zenodo.19729897.

---

## Visión general

Los modelos de lenguaje suelen tener dificultades con **referencias culturales implícitas, dependientes del contexto o con baja presencia en datos estructurados o fácilmente indexables**.

En la cultura popular española, esto incluye:
- referencias musicales  
- eslóganes publicitarios  
- frases icónicas de televisión y comedia  
- expresiones coloquiales ligadas a épocas o contextos concretos  

No se trata de errores factuales estándar, sino de **fallos de anclaje cultural distintos de la alucinación**, que suelen implicar:
- **Cultural Anchor Loss**  
- **Entity Misgrounding**  
- **Literalización de expresiones no literales**  
- **Interpretación excesivamente confiada en contextos ambiguos**  

Este repositorio explora cómo modelar y resolver estas ambigüedades mediante enfoques simbólicos y explicables, en lugar de sistemas opacos basados únicamente en aprendizaje automático.

---

## Motivación

La mayoría de los sistemas de NLP se apoyan fuertemente en:
- asociaciones estadísticas  
- similitud superficial  
- conocimiento indexado en la web  

Sin embargo, las referencias culturales suelen:
- tener **baja visibilidad en datos estructurados**  
- depender de **contexto compartido o memoria generacional**  
- ser **ambiguas por diseño**  

Como resultado, los LLM pueden:
- generar entidades plausibles pero incorrectas  
- atribuir referencias de forma errónea  
- interpretar literalmente expresiones figuradas  

Este proyecto busca:
> **formalizar la ambigüedad cultural como un problema abordable**  
> y explorar **formas transparentes de razonar sobre ella**

---

## Contribución

Este proyecto introduce y operacionaliza:

- **Cultural Anchor Loss (CAL)** como un modo de fallo diferenciado en LLMs  
- Un marco pequeño e inspeccionable para analizar ambigüedad cultural  
- Un dataset de comportamientos reales de modelos ante inputs culturalmente ambiguos  

El objetivo no es la escala, sino la **claridad y reproducibilidad de los patrones de fallo**.

---

## Enfoque

La idea central es construir un **sistema pequeño y explicable** basado en:
- representaciones simbólicas (EDN / estructuras de datos)  
- reglas explícitas de desambiguación  
- conjuntos de ejemplos controlados  

Este enfoque responde a una limitación clave de los LLM actuales:

> la confianza suele venir impulsada por señales de familiaridad, no por un anclaje verificado

Lo que a menudo lleva a respuestas plausibles pero incorrectas en lugar de solicitar aclaración.

---

## Modelo de datos

El proyecto utiliza actualmente dos datasets complementarios:

- **cases.edn**  
  Conjunto curado de expresiones culturalmente ambiguas, con comportamiento esperado y fenómenos asociados.

- **observations.edn**  
  Datos reales de interacción que recogen cómo responden los modelos, incluyendo:
  - tipo de respuesta (correcta, incorrecta, parcial)  
  - modo de respuesta (respuesta inicial vs. corrección tras feedback)  
  - fenómenos observados  
  - patrones de confianza y comportamiento  

Ambos permiten comparar:

> **comportamiento esperado** vs. **comportamiento observado del modelo**

Esto proporciona un marco pequeño pero explícito para analizar modos de fallo en contextos culturalmente ambiguos.

---

## ¿Por qué Clojure?

Este proyecto utiliza **Clojure** como entorno experimental para:
- representar reglas como datos  
- construir sistemas lógicos específicos de dominio  
- mantener el sistema **completamente inspeccionable y explicable**  

Clojure permite un bucle estrecho entre:
- datos  
- reglas  
- evaluación  

Lo que lo hace especialmente adecuado para estudiar fallos donde la interpretabilidad es más importante que el rendimiento.

---

## Ejecutar en local

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
