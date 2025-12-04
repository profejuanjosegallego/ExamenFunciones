package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //desarrolla el codigo aca

        //Dilan Echavarria Arboleda
        //Jeisson Andres Yela
        System.out.println("=========================");
        System.out.println("Aplicacion para su pedido");
        System.out.println("=========================");

        Scanner leer = new Scanner(System.in);

        System.out.print("\nIngrese la distancia a la que se encuentra en Km: ");
        Double distancia = leer.nextDouble();
        leer.nextLine();


        ArrayList<HashMap<String,Object>> productos = new ArrayList<>();

        String opcion = " ";

        /*ciclo para pedir los productos*/

        while (!opcion.equals("no")) {

            HashMap<String, Object> producto = new HashMap<>();

            System.out.print("Ingrese el nombre del producto: ");
            producto.put("nombreProducto", leer.nextLine());

            System.out.print("Ingrese el precio del producto: ");
            producto.put("precioUnitarioProducto", leer.nextInt());

            System.out.print("Ingrese la cantidad que desea comprar: ");
            producto.put("cantidadProducto", leer.nextInt());

            leer.nextLine();

            System.out.print("Desea ingresar otro producto (Ingrese no para salir): ");
            opcion = leer.nextLine();

            productos.add(producto);

        }

        System.out.println("\n==========================");
        System.out.println("Esta es su colilla de pago");
        System.out.println("==========================");
        System.out.println("\nEste es el subtotal");
        Double subtotal = calcular_subtotal_compra(productos);
        System.out.println(subtotal);

        System.out.println("\nEste es el impuesto de su compra");
        Double impuestoSubtotal=calcular_impuesto_subtotal(subtotal);
        System.out.println(impuestoSubtotal);

        System.out.println("\nEste es el descuento de su compra");
        Double descuentoSubtotal= calcular_descuento_subtototal(subtotal);
        System.out.println(descuentoSubtotal);

        System.out.println("\nEste es el costo de su envio");
        Double costoEnvio=calcular_valor_distancia(distancia);
        System.out.println(costoEnvio);

        System.out.println("\nEste es el costo total de su pedido");
        Double costoTotal=calcular_valor_total(subtotal,impuestoSubtotal,descuentoSubtotal,costoEnvio);
        System.out.println(costoTotal);







    }

    /* funcion para calcular el subtotal*/
    public static Double calcular_subtotal_compra(ArrayList<HashMap<String, Object>> productos) {
        Double subtotal = 0.0;

        for (HashMap<String, Object> producto : productos) {
            Double precio = ((Number) producto.get("precioUnitarioProducto")).doubleValue();
            Integer cantidad = ((Number) producto.get("cantidadProducto")).intValue();
            subtotal += precio * cantidad;
        }

        return subtotal;
    }
    /* funcion para calcular el impuesto*/
    public static Double calcular_impuesto_subtotal(Double subtotal) {
        Double impuesto = 0.19;
        Double impuestoSubtotal= subtotal * impuesto;
        return impuestoSubtotal;

    }

    /*Funcion para calcular el descuento*/
    public static Double calcular_descuento_subtototal(Double subtotal) {
        Double descuento = 0.10;
        Double descuentoSubtotal=subtotal * descuento;
        return descuentoSubtotal;
    }

    /*funcion para calcular el envio*/
    public static Double calcular_valor_distancia(Double distancia) {
        Double costoEnvio=0.0;
        if (distancia <= 5) {
            costoEnvio=5000.0;
        } else if (distancia > 5 && distancia<=20) {
            costoEnvio=10000.0;
        }else {
            costoEnvio=20000.0;
        }
        return costoEnvio;
    }

    /*funcion para calcular el valor total*/
    public static Double calcular_valor_total (Double subtotal,Double impuestoSubtotal,Double descuentoSubtotal,Double costoEnvio) {
        Double costoTotal=subtotal+impuestoSubtotal-descuentoSubtotal+costoEnvio;
        return costoTotal;
    }


}