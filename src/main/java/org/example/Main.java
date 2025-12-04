package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //desarrolla el codigo aca

        //Dilan Echavarria Arboleda
        //Jeisson Andres Yela

        Scanner leer = new Scanner(System.in);

        System.out.print("Ingrese la distancia a la que se encuentra en Km: ");
        Double distancia = leer.nextDouble();
        leer.nextLine();


        ArrayList<HashMap<String,Object>> productos = new ArrayList<>();

        String opcion = " ";

        while (!opcion.equals("no")) {

            HashMap<String, Object> producto = new HashMap<>();

            System.out.println("Ingrese el nombre del producto: ");
            producto.put("nombreProducto", leer.nextLine());

            System.out.println("Ingrese el precio del producto: ");
            producto.put("precioUnitarioProducto", leer.nextInt());

            System.out.println("Ingrese la cantidad que desea comprar: ");
            producto.put("cantidadProducto", leer.nextInt());

            leer.nextLine();

            System.out.print("Desea ingresar otro producto(Ingrese no para salir): ");
            opcion = leer.nextLine();

            productos.add(producto);

        }
        System.out.println("Este es el subtotal");
        Double subtotal = calcular_subtotal_compra(productos);
        System.out.println(subtotal);

        System.out.println("Este es el impuesto de su compra");
        Double impuestoSubtotal=calcular_impuesto_subtotal(subtotal);
        System.out.println(impuestoSubtotal);

        System.out.println("Este es el descuento de su compra");
        Double descuentoSubtotal= calcular_descuento_subtototal(subtotal);
        System.out.println(descuentoSubtotal);

        System.out.println("Este es el costo de su envio");
        Double costoEnvio=calcular_valor_distancia(distancia);
        System.out.println(costoEnvio);







    }
    public static Double calcular_subtotal_compra(ArrayList<HashMap<String, Object>> productos) {
        Double subtotal = 0.0;

        for (HashMap<String, Object> producto : productos) {
            Double precio = ((Number) producto.get("precioUnitarioProducto")).doubleValue();
            Integer cantidad = ((Number) producto.get("cantidadProducto")).intValue();
            subtotal += precio * cantidad;
        }

        return subtotal;
    }

    public static Double calcular_impuesto_subtotal(Double subtotal) {
        Double impuesto = 0.19;
        Double impuestoSubtotal= subtotal * impuesto;
        return impuestoSubtotal;

    }

    public static Double calcular_descuento_subtototal(Double subtotal) {
        Double descuento = 0.10;
        Double descuentoSubtotal=subtotal * descuento;
        return descuentoSubtotal;
    }

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


}