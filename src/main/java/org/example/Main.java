package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static final String negro = "\u001B[0m";
    public static final String verde = "\u001B[32m";
    public static final String rojo = "\u001B[31m";
    public static final String azul = "\u001B[34m";
    public static final String morado = "\u001B[35m";

    public static void main(String[] args) {

        System.out.println(azul + "*** 🛒 --Bienvenido al simulador de compra-- 🛒 ***" + negro);

        ArrayList<HashMap<String, Object>> productos = new ArrayList<>();
        Scanner leer = new Scanner(System.in);

        HashMap<String, Object> producto1 = new HashMap<>();
        producto1.put("Producto", "Diamante");
        producto1.put("Precio", 1000000);
        producto1.put("Cantidad", 1);

        HashMap<String, Object> producto2 = new HashMap<>();
        producto2.put("Producto", "Aguacate");
        producto2.put("Precio", 80000);
        producto2.put("Cantidad", 5);

        HashMap<String, Object> producto3 = new HashMap<>();
        producto3.put("Producto", "Panela");
        producto3.put("Precio", 5000);
        producto3.put("Cantidad", 10);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        Integer continuar = 1;

        while (continuar >= 1) {
            System.out.print(verde + "\nBienvenido a nuestro menu: \n" +
                    "\n1. Ver lista en el carrito y total. " +
                    "\n2. Aplicar impuestos. " +
                    "\n3. Aplicar descuentos " +
                    "\n4. Calcular costos de envio. " +
                    "\n5. Calcular total con envio y descuentos" +
                    "\n6. Salir" +
                    "\nDigita la opción de tu elección: " + negro);

            Integer decisión = leer.nextInt();
            leer.nextLine();

            switch (decisión) {
                case 1:

                    System.out.println(azul + "\n🛒 Tu lista actual:\n" + negro);
                    for (HashMap<String, Object> item : productos) {
                        System.out.println("- " + item.get("Producto") +
                                " | Precio: $" + item.get("Precio") +
                                " | Cantidad: " + item.get("Cantidad"));
                    }

                    double totalCompra = calcular_costo_venta(productos);
                    System.out.println(morado + "El total de la compra es: $" + totalCompra + negro);

                    break;

                case 2:
                    double totalBaseImpuestos = calcular_costo_venta(productos);
                    double impuestos = calcular_impuestos(totalBaseImpuestos);

                    System.out.println(azul + "\n📌 Aplicando impuestos del 19%..." + negro);
                    System.out.println("Subtotal: $" + totalBaseImpuestos);
                    System.out.println("Impuestos (19%): $" + impuestos);
                    System.out.println(morado + "Total con impuestos: $" + (totalBaseImpuestos + impuestos) + negro);
                    break;

                case 3:
                    double totalBaseDescuentos = calcular_costo_venta(productos);
                    double descuentos = calcular_descuento(totalBaseDescuentos);

                    System.out.println(azul + "\n💳 Aplicando descuento del 15%..." + negro);
                    System.out.println("Subtotal: $" + totalBaseDescuentos);
                    System.out.println("Impuestos (19%): $" + descuentos);
                    System.out.println(morado + "Total con descuento: $" + (totalBaseDescuentos - descuentos) + negro);

                    break;

                case 4:
                    System.out.print(azul + "Ingrese la distancia en kilometros a la cual se realizara el envio 🗺️: " + negro);
                    Integer distanciaEnvio = leer.nextInt();

                    double totalBaseEnvio = calcular_costo_venta(productos);
                    double costoEnvio = calcular_costo_envio(distanciaEnvio);

                    System.out.println(azul + "\n💳 Aplicando costos de envio..." + negro);
                    System.out.println("Subtotal: $" + totalBaseEnvio);
                    System.out.println("Costo de Envio: $" + costoEnvio);
                    System.out.println(morado + "Total con descuento: $" + (totalBaseEnvio + costoEnvio) + negro);

                    break;

                case 6:
                    continuar = 0;
                    break;

                default:
                    System.out.println(rojo + "\n🛑 ¡¡Opcion ingresada no valida!! 🛑" + negro);
            }
        }
    }

    public static Double calcular_costo_venta(ArrayList<HashMap<String,Object>> productos){

        // esta funcion calcula los productos de la lista y muestra el total

        double total_venta = 0.0;

        for (HashMap<String, Object> item : productos) {

            double precio = ((Integer) item.get("Precio")).doubleValue();
            int cantidad = (int) item.get("Cantidad");

            total_venta += precio * cantidad;
        }

        return total_venta;
    }

    public static Double calcular_impuestos(Double totalCompra){

        // esta funcion es parta calcular los impuestos

        return totalCompra * 0.19;
    }

    public static Double calcular_descuento(Double totalCompra){


        // esta funcion es para calcular los descuentos

        return  totalCompra * 0.15;
    }
    public static Double calcular_costo_envio(Integer distanciaEnvio){

        // esta funcion calcula los costes de envio segun la distancia

        Double costoEnvio = 0.0;

        if (distanciaEnvio <= 5){
            costoEnvio = 20000.0;
        } else if (distanciaEnvio <= 30) {
            costoEnvio = 30000.0;
        } else {
            costoEnvio = 50000.0;
        }

        return costoEnvio;
    }
}