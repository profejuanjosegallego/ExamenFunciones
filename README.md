# Evaluación: Funciones para administrar las ventas de un e-commerce

## Descripción

En esta evaluación deberás implementar un conjunto de **funciones** para administrar las ventas de un e-commerce.  
La idea es simular el proceso de una compra, desde el cálculo del costo de los productos hasta el valor total a pagar por el cliente.

Trabajarás con al menos estos elementos:

- Productos (precio y cantidad)
- Impuesto
- Descuento
- Distancia para el envío

---

## Objetivo de la actividad

Evaluar tu capacidad para:

- Diseñar e implementar funciones reutilizables.
- Recibir parámetros y devolver resultados coherentes.
- Encadenar funciones (usar el resultado de una en otra).
- Simular un flujo simple de negocio de un e-commerce.

---

## Funciones requeridas

### 1. Función para calcular el costo total de la venta (subtotal)

**Propósito:**  
Calcular el **subtotal** de la compra, es decir, la suma de todos los productos sin impuestos, descuentos ni envío.

**Recomendación:**  
- Recibir una lista/arreglo de productos.
- Cada producto debe tener al menos: `precioUnitario` y `cantidad`.
- Retornar el valor numérico del subtotal.

Ejemplo conceptual:

- Entrada: lista de productos  
- Salida: `subtotal = 150000`

---

### 2. Función para aplicar impuestos

**Propósito:**  
Calcular el valor de los **impuestos** a partir del subtotal.

**Recomendación:**

- Recibir el `subtotal` y el `porcentajeImpuesto` (por ejemplo, 19 para 19%).
- Retornar el valor de los impuestos calculados.

Ejemplo conceptual:

- Entrada: `subtotal = 150000`, `impuesto = 19%`  
- Salida: `impuestos = 28500`

---

### 3. Función para aplicar descuentos

**Propósito:**  
Calcular el valor del **descuento** que se aplicará a la compra.

**Recomendación (elige una de las dos o implementa ambas si el profe lo pidió):**

- Opción A: Recibir el `subtotal` y el `porcentajeDescuento`.
- Opción B: Recibir el `subtotal` y un valor fijo de descuento.

La función debe retornar el **valor** del descuento (no el total final).

Ejemplo conceptual:

- Entrada: `subtotal = 150000`, `descuento = 10%`  
- Salida: `descuento = 15000`

---

### 4. Función para calcular el costo de envío según la distancia

**Propósito:**  
Calcular el **costo de envío** de acuerdo con la distancia a la que se debe enviar el pedido.

**Recomendación:**

- Recibir la `distanciaEnKm`.
- Definir una regla de negocio, por ejemplo:
  - Hasta 5 km: envío base.
  - De 5 a 20 km: un valor mayor.
  - Más de 20 km: valor máximo o tarifa por km.
- Retornar el costo de envío.

Ejemplo conceptual:

- Entrada: `distancia = 12 km`  
- Salida: `costoEnvio = 12000`

---

### 5. Función propuesta: calcular el total final de la compra

**Propósito:**  
Calcular el **total a pagar** por el cliente, usando los resultados de las funciones anteriores.

**Recomendación:**

- Recibir al menos:
  - `subtotal`
  - `impuestos`
  - `descuento`
  - `costoEnvio`
- Retornar el **totalFinal** de la compra.

Fórmula sugerida (puede variar según la lógica que definan):

`totalFinal = subtotal + impuestos - descuento + costoEnvio`

---

## Entregables

- Archivo(s) de código con:
  - Las **5 funciones** claramente identificadas.
  - Un ejemplo de uso (caso de prueba) donde se:
    1. Cree una lista de productos.
    2. Calcule el subtotal.
    3. Calcule impuestos.
    4. Calcule descuento.
    5. Calcule costo de envío.
    6. Calcule el total final de la compra.
- Comentarios mínimos que expliquen qué hace cada función.

---

## Criterios de evaluación

- ✔ Correcta implementación de las 5 funciones.
- ✔ Uso adecuado de parámetros y valores de retorno.
- ✔ Lógica coherente y ordenada en el flujo de cálculo.
- ✔ Código legible (nombres de variables y funciones claros).
- ✔ Caso de prueba funcional que muestre todo el proceso de la compra.

---

## 🧢 Modo Pokémon: ¡Entrenadores del e-commerce!

Así como un buen entrenador no entra a un gimnasio Pokémon sin prepararse, ustedes tampoco llegan a este examen sin haber entrenado: ya han practicado funciones, parámetros, retornos y lógica de negocio. 💻⚡

En esta evaluación:

- Cada función que creen es como un nuevo movimiento en la lista de su Pokémon.
- El e-commerce es su combate.
- Y el código bien organizado… es su mejor estrategia para ganar la batalla. 💪

Vengan tranquilos, con calma y concentrados:

- Si algo no compila a la primera, no es un fracaso: es **experiencia**.
- Si se equivocan, revisan, corrigen y vuelven a intentar: así es como suben de nivel. 🔁✨  

> Recuerden: *“El truco está en no rendirse, seguir entrenando y confiar en lo que ya saben.”*  

---
![Entrenador de e-commerce](https://i.imgflip.com/2w76sl.png)
---

¡Ahora sí, entrenadores del código, es hora de programar! 🚀
