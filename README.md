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

```text
totalFinal = subtotal + impuestos - descuento + costoEnvio
