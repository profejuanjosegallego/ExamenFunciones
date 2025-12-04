package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         //Examen presentado por: Maria Fernanda Hernandez y Fannerys Guardia
        Scanner leer = new Scanner(System.in);

        System.out.println("****** 🛒⭐Tienda Online - Proceso de Compra ****** ⭐🛒");

        // Crear una lista de productos, cada producto es un HashMap- simulando agregar los productos al carrito
        ArrayList<HashMap<String, Object>> carritoDeCompras = new ArrayList<>();

        // Producto 1: Camiseta
        HashMap<String, Object> productoUno = new HashMap<>();
        productoUno.put("nombre", "Camiseta Deportiva");
        productoUno.put("precioUnitario", 50000.0);
        productoUno.put("cantidad", 2);
        carritoDeCompras.add(productoUno);

        // Producto 2: tennis
        HashMap<String, Object> productoDos = new HashMap<>();
        productoDos.put("nombre", "Zapatillas Running");
        productoDos.put("precioUnitario", 120000.0);
        productoDos.put("cantidad", 1);
        carritoDeCompras.add(productoDos);

        // Pedir la distancia (valor que necesitamos)
        System.out.print("¿Distancia de envío en Km? 🛞: ");
        double distanciaKm = leer.nextDouble();

        // Porcentajes quemados
        double porcentajeImpuesto = 19.0; // 19% de IVA
        double porcentajeDescuento = 10.0; // 10% por ser cliente nuevo

        // LLAMADAS A FUNCIONES



        leer.close();
    }
     // CREANDO FUNCIONES

    //Función para calcular el subtotal de la compra
    public static Double calcular_costo_total_productos(ArrayList<HashMap<String, Object>> productos) {
        Double subtotal = 0.0;
        // Recorremos o iteramos cada producto en la lista- es un forEach
        for (HashMap<String, Object> producto : productos) {
            // se convierte de un tipo de dato a otro (Double e Integer)
            Double precio = (Double) producto.get("precioUnitario");
            Integer cantidad = (Integer) producto.get("cantidad");
            subtotal += (precio * cantidad); // Sumamos el costo de este producto al total
        }
        return subtotal;
    }
     //Función para aplicar descuentos
    public static Double aplicar_descuentos(Double subtotal, Double porcentajeDescuento) {
        //Descuento = Subtotal * (Descuento / 100)
        Double valorDescuento = subtotal * (porcentajeDescuento / 100.0);
        return valorDescuento;
    }

     // Función para aplicar impuestos (IVA)
    public static Double aplicar_impuestos(Double subtotal, Double porcentajeImpuesto) {
        //  Subtotal * (Impuesto / 100)
        Double valorImpuesto = subtotal * (porcentajeImpuesto / 100.0);
        return valorImpuesto;
    }
     //Función para calcular el costo de envío según la distancia.

    public static Double calcular_costo_envio(Double distanciaEnKm) {
        Double costoEnvio = 0.0;
        //si la distancia es <= 5.0 ---> 5.000
        //si la distancia es > 5.0 y la distancia es <= 20.0 ---> 12.000
        if (distanciaEnKm <= 5.0) {
            costoEnvio = 5000.0;
        } else if (distanciaEnKm > 5.0 && distanciaEnKm <= 20.0) {
            costoEnvio = 12000.0;
        } else { // Si es mayor a 20 km
            // Tarifa por Km: 1.000 por cada Km extra después de los 20
            double kmExtra = distanciaEnKm - 20.0;
            costoEnvio = 15000.0 + (kmExtra * 1000.0); // Tarifa base + extra
        }
        return costoEnvio;
    }

     //Función para calcular el total final de la compra

    public static Double calcular_total_final(Double subtotal, Double impuestos, Double descuento, Double costoEnvio) {
        // Sumamos, restamos el descuento, y sumamos el envío
        return subtotal + impuestos - descuento + costoEnvio;
    }

}



