package org.example;

import java.util.ArrayList;
import java.util.List;
//Parcial De Angie Meneses y Cristian Marquez

public class Main {
    public static void main(String[] args) {
        // Crear una lista de productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(40, 2));
        productos.add(new Producto(20000, 1));
        productos.add(new Producto(5000, 3));

        // Calcular el subtotal
        double subtotal = calcularSubtotal(productos);
        System.out.println("Subtotal: " + subtotal);

        // Calcular los impuestos
        double impuestos = aplicarImpuestos(subtotal, 19);
        System.out.println("Impuestos: " + impuestos);

        // Calcular el descuento
        double descuento = aplicarDescuento(subtotal, 10);
        System.out.println("Descuento: " + descuento);

        // Calcular el costo de envío
        double costoEnvio = calcularCostoEnvio(12);
        System.out.println("Costo de envío: " + costoEnvio);

        // Calcular el total final
        double totalFinal = calcularTotalFinal(subtotal, impuestos, descuento, costoEnvio);
        System.out.println("Total final: " + totalFinal);
    }

    // Función 1: Calcular el costo total de la venta (subtotal)
    public static double calcularSubtotal(List<Producto> productos) {
        double subtotal = 0;
        for (Producto producto : productos) {
            subtotal += producto.getPrecioUnitario() * producto.getCantidad();
        }
        return subtotal;
    }

    // Función 2: Aplicar impuestos
    public static double aplicarImpuestos(double subtotal, double porcentajeImpuesto) {
        double impuestos = subtotal * (porcentajeImpuesto / 100);
        return impuestos;
    }

    // Función 3: Aplicar descuentos
    public static double aplicarDescuento(double subtotal, double porcentajeDescuento) {
        double descuento = subtotal * (porcentajeDescuento / 100);
        return descuento;
    }

    // Función 4: Calcular el costo de envío según la distancia
    public static double calcularCostoEnvio(double distanciaEnKm) {
        double costoEnvio;
        if (distanciaEnKm <= 5) {
            costoEnvio = 5000;
        } else if (distanciaEnKm <= 20) {
            costoEnvio = 10000;
        } else {
            costoEnvio = 15000;
        }
        return costoEnvio;
    }

    // Función 5: Calcular el total final de la compra
    public static double calcularTotalFinal(double subtotal, double impuestos, double descuento, double costoEnvio) {
        double totalFinal = subtotal + impuestos - descuento + costoEnvio;
        return totalFinal;
    }
}










