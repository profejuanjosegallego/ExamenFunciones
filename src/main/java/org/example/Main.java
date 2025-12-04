package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //CRISTIAN CARDONA
        //JEAN CARLO CHINCHAJOA

        Scanner leer = new Scanner(System.in);

        System.out.println("****** Ecommerce INC. ******");
        System.out.println("\nSimulamos tu compra paso a paso...");

        // LISTA DE PRODUCTOS
        ArrayList<HashMap<String,Object>> productos = new ArrayList<>();

        // VARIABLES PARA IMPUESTO, DESCUENTO Y ENVÍO
        HashMap<String,Object> impuesto = new HashMap<>();
        HashMap<String,Object> descuento = new HashMap<>();
        HashMap<String,Object> envio = new HashMap<>();

        //CICLO WHILE PARA PERMITIR AL USUARIO INGRESAR TANTOS PRODUCTOS COMO QUIERA
        int opcion = 0;
        while(opcion != 3){
            System.out.println("\n****** MENU ******");
            System.out.println("1. Ingresar producto");
            System.out.println("2. Revisar proceso de compra");
            System.out.println("3. Salir del programa");
            System.out.print("Elige una opción: ");
            opcion = leer.nextInt();

            switch(opcion){
                case 1:
                    // PEDIR DATOS DE PRODUCTO
                    System.out.print("digita el precio unitario del producto: ");
                    Double precioUnitario = leer.nextDouble();
                    System.out.print("digita la cantidad del producto: ");
                    Integer cantidad = leer.nextInt();
                    HashMap<String,Object> producto = new HashMap<>();
                    producto.put("precioUnitario", precioUnitario);
                    producto.put("cantidad", cantidad);
                    productos.add(producto);

                    // PEDIR DATOS DE IMPUESTO
                    System.out.print("\ndigita el porcentaje de impuesto (%): ");
                    Double porcentajeImpuesto = leer.nextDouble();
                    impuesto.put("porcentaje", porcentajeImpuesto);

                    // PEDIR DATOS DE DESCUENTO
                    System.out.print("\ndigita el porcentaje de descuento (%): ");
                    Double porcentajeDescuento = leer.nextDouble();
                    descuento.put("porcentaje", porcentajeDescuento);

                    // PEDIR DISTANCIA DE ENVÍO
                    System.out.print("\ndigita la distancia en km para el envío: ");
                    Double distanciaKm = leer.nextDouble();
                    envio.put("distancia", distanciaKm);

                    break;

                case 2:
                    if(productos.isEmpty()){
                        System.out.println("Primero debes ingresar al menos un producto.");
                        break;
                    }

                    // LLAMAR FUNCIONES
                    Double subtotal = calcular_subtotal(productos);
                    Double impuestos = calcular_impuestos(subtotal, impuesto);
                    Double descuentoAplicado = calcular_descuento(subtotal, descuento);
                    Double costoEnvio = calcular_envio(envio);
                    Double totalFinal = calcular_total(subtotal, impuestos, descuentoAplicado, costoEnvio);

                    // MOSTRAR RESULTADOS
                    System.out.println("\n********* RESULTADOS *********");
                    System.out.println("Subtotal: " + subtotal);
                    System.out.println("Impuestos: " + impuestos);
                    System.out.println("Descuento: " + descuentoAplicado);
                    System.out.println("Costo envío: " + costoEnvio);
                    System.out.println("TOTAL FINAL: " + totalFinal);
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
            }
        }
    }

    // FUNCIONES

    public static Double calcular_subtotal(ArrayList<HashMap<String,Object>> productos){
        Double subtotal = 0.0;
        for(HashMap<String,Object> producto : productos){
            Double precio = (Double) producto.get("precioUnitario");
            Integer cantidad = (Integer) producto.get("cantidad");
            subtotal += precio * cantidad;
        }
        return subtotal;
    }

    public static Double calcular_impuestos(Double subtotal, HashMap<String,Object> impuesto){
        Double porcentaje = (Double) impuesto.get("porcentaje");
        return subtotal * (porcentaje / 100);
    }

    public static Double calcular_descuento(Double subtotal, HashMap<String,Object> descuento){
        Double porcentaje = (Double) descuento.get("porcentaje");
        return subtotal * (porcentaje / 100);
    }

    public static Double calcular_envio(HashMap<String,Object> envio){
        Double distancia = (Double) envio.get("distancia");
        Double costoEnvio = 0.0;
        if(distancia <= 5){
            costoEnvio = 5.0;
        } else if(distancia <= 20){
            costoEnvio = 12.0;
        } else {
            costoEnvio = 20.0 + (distancia - 20) * 0.5;
        }
        return costoEnvio;
    }

    public static Double calcular_total(Double subtotal, Double impuestos, Double descuento, Double costoEnvio){
        return subtotal + impuestos - descuento + costoEnvio;
    }
}