package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //desarrolla el codigo aca

        //Creado por Johan Estiben Bustamante Orozco
        //Creado por Santiago Villa Porras



        //Creando la lista de los productos


        ArrayList<HashMap<String, Object>> productos = new ArrayList<>();

        HashMap<String, Object> producto1 = new HashMap<>();
        producto1.put("id", 1);
        producto1.put("nombre", "Laptop Lenovo IdeaPad 3");
        producto1.put("precio", 1700.0);
        producto1.put("cantidad", 1);

        HashMap<String, Object> producto2 = new HashMap<>();
        producto2.put("id", 2);
        producto2.put("nombre", "Mouse Inalámbrico Logitech M170");
        producto2.put("precio", 250.0);
        producto2.put("cantidad", 1);

        HashMap<String, Object> producto3 = new HashMap<>();
        producto3.put("id", 3);
        producto3.put("nombre", "Audífonos Sony WH-1000XM4");
        producto3.put("precio", 500.0);
        producto3.put("cantidad", 1);

        HashMap<String, Object> producto4 = new HashMap<>();
        producto4.put("id", 4);
        producto4.put("nombre", "Smartphone Samsung Galaxy A54");
        producto4.put("precio", 800.0);
        producto4.put("cantidad", 1);

        HashMap<String, Object> producto5 = new HashMap<>();
        producto5.put("id", 5);
        producto5.put("nombre", "Smartwatch Xiaomi Mi Band 8");
        producto5.put("precio", 200.0);
        producto5.put("cantidad", 1);

// Agregar todos los productos a la lista
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        //NOMBRE DE LA TIENDA VISUALMENTE EN LA CONSOLA

        System.out.println("********🛒🏪********");
        System.out.println("****Bienvenido a E-commerce 🛒🏪****");
        System.out.println("********🛒🏪********");
        System.out.println("-------------------------------");
        System.out.println("Seleccione sus productos...\n");


        // IMPRIMIR PRODUCTOS DE MANERA ESPACIADA UNO DEBAJO DEL OTRO DE UNA MANERA ESTETICA
        for (HashMap<String, Object> producto : productos) {
            System.out.println("ID: " + producto.get("id"));
            System.out.println("Nombre: " + producto.get("nombre"));
            System.out.println("Precio: $" + producto.get("precio"));
            System.out.println("Cantidad: " + producto.get("cantidad"));
            System.out.println("-----------------------------");
        }
        Scanner scanner = new Scanner(System.in);
        ArrayList<HashMap<String, Object>> carrito = new ArrayList<>();

        String continuar = "si";

        while (continuar.equalsIgnoreCase("si")) {
            System.out.print("Ingrese el ID del producto que desea agregar: ");
            int idBuscado = scanner.nextInt();

            // Buscar producto original por ID
            for (HashMap<String, Object> producto : productos) {
                if ((int) producto.get("id") == idBuscado) {

                    // Copia del producto (para modificar cantidad)
                    HashMap<String, Object> productoCarrito = new HashMap<>(producto);

                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();

                    productoCarrito.put("cantidad", cantidad);

                    carrito.add(productoCarrito);
                    System.out.println("Producto agregado al carrito.\n");
                }
            }

            System.out.print("¿Desea agregar otro producto? (si/no): ");
            continuar = scanner.next();
        }

        // Cálculo subtotal
        Double subTotal = calcular_subtotal(carrito);
        System.out.println("\nSubtotal de su compra: $" + subTotal);

        // Impuesto
        Double impuesto = calcular_impuesto(subTotal);
        System.out.println("Impuesto (19%): $" + impuesto);

        // Descuento
        Double descuento = calcular_descuento(subTotal, 10.0); // ejemplo: 10%
        System.out.println("Descuento (10%): -$" + descuento);

        // Envío
        Double costoEnvio = calcular_costo_envio(15.0); // ejemplo distancia 15 km
        System.out.println("Costo de envío: $" + costoEnvio);

        // Total final
        Double totalFinal = calcular_total_a_pagar(subTotal, impuesto, descuento, costoEnvio);
        System.out.println("\nTOTAL A PAGAR: $" + totalFinal);

    }
    //Funcion para calcular el subtotal de la compra
    public static Double calcular_subtotal(ArrayList<HashMap<String,Object>> productos){
        Double subtotal = 0.0;

        for (HashMap<String, Object> producto : productos) {

            Double precio = ((Number) producto.get("precio")).doubleValue();
            Double cantidad = ((Number) producto.get("cantidad")).doubleValue();

            subtotal += precio * cantidad;
        }
        return subtotal;
    }


    //Funcion para calcular el valor del impuesto sobre el valor de la compra(subtotal)
    public static Double calcular_impuesto(Double subtotal) {

        Double impuestos = (subtotal * 0.19);
        return impuestos;
    }
    //Funcion para calcular el valor del descuento sobre el valor de la compra (subtotal)
    public static Double calcular_descuento (Double subtotal, Double porcentajeDescuento) {
        Double descuento = (porcentajeDescuento / 100);
        Double totalDescuento = (subtotal * descuento);
        return totalDescuento;
    }

    //Funcion para calcular el costo del envio respecto a la distancia
    public static  Double calcular_costo_envio(Double distanciaKm){
        Double costoEnvio = 0.0;

        if (distanciaKm <= 5){
            costoEnvio = 100.0;
        } else if (distanciaKm <= 20) {
            costoEnvio = 250.0;
        } else {
            costoEnvio = 500.0;
        }
        return costoEnvio;
    }
    //Funcion para calcular el total de la compra aplicando las demas funciones
    public static Double calcular_total_a_pagar(Double subTotal, Double impuesto, Double descuento, Double costoEnvio){
        return subTotal + impuesto - descuento + costoEnvio;
    }
}