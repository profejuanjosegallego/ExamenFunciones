package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* *****Evaluación: Funciones para administrar las ventas de un e-commerce ***** */
        /*
        Alumnos
        - Alejandro Meneses García
        - Wbeimar Andres Villa Serna

        Fecha: 04/12/2025
        Area: Backend I
        Docente: Juan José Gallego
        */

        Scanner leerTeclado = new Scanner(System.in);
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";
        String yellowColor = "\u001B[33m";
        String blueColor = "\u001B[34m";
        String purpleColor = "\u001B[35m";
        String whiteColor = "\u001B[37m";

        System.out.println(greenColor + "**** 🤑VENTAS E-COMMERCE🤑 ****");

        /* ***************** INGRESO DE PRODUCTOS PARA LA FUNCION 1 ***************** */
        //Se realiza una Lista y Diccionario para almacenar los datos ingresados dentro de un ciclo While
        //Con estos datos se podran realizar las operaciones dentro de la primera funcion, "calcular_subtotal".
        ArrayList<HashMap<String, Object>> productos = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println(blueColor + "\n--- MENÚ DE PRODUCTOS ---" + whiteColor);
            System.out.println("1. Ingresar producto");
            System.out.println("2. Calcular subtotal y continuar");
            System.out.print("Seleccione una opción: ");

            int opcion = leerTeclado.nextInt();
            leerTeclado.nextLine();

            if (opcion == 1) {
                System.out.print(blueColor + "🔤Digite el nombre del producto: ");
                String nombre = leerTeclado.nextLine();

                System.out.print(blueColor + "💵Digite el precio unitario del producto: ");
                Integer precio = leerTeclado.nextInt();

                System.out.print(blueColor + "🔢Digite la cantidad: ");
                Integer cantidad = leerTeclado.nextInt();
                leerTeclado.nextLine();

                HashMap<String, Object> nuevoProducto = new HashMap<>();
                nuevoProducto.put("nombre", nombre);
                nuevoProducto.put("precioUnitario", precio);
                nuevoProducto.put("cantidad", cantidad);

                productos.add(nuevoProducto);

                System.out.println(greenColor + "✅Producto agregado exitosamente.\n" + whiteColor);

            } else if (opcion == 2) {
                continuar = false;
            } else {
                System.out.println(redColor + "❌Opción inválida. Intente nuevamente." + whiteColor);
            }
        }

        /* ***************** MOSTRAR PRODUCTOS INGRESADOS ***************** */
        //Este es un ciclo for-each, que pasa por cada producto que se guarda en la ArrayList productos
        //Cada producto dentro del ArrayList es un HashMap que contiene tres claves:
        //nombre, precioUnitario y cantidad.
        //Entonces se creo una variable p para que cada que el ciclo se repita esta variable muestre el diccionario.
        //Con el .get se obtiene lo guardado dentro de cada clave del diccionario.
        System.out.println(purpleColor + "\n===== PRODUCTOS INGRESADOS =====" + whiteColor);
        for (HashMap<String, Object> p : productos) {
            System.out.println("• " + p.get("nombre") +
                    " | Precio: " + p.get("precioUnitario") +
                    " | Cantidad: " + p.get("cantidad"));
        }

        //Se hizo el llamado de la Función 1, para poder mostar el subtotal antes de seguir ingresando datos,
        //y poder continuar con el programa.
        Double subtotal = calcular_subtotal(productos);

        //Se muestra el subtotal obtenido en la función 1
        System.out.println(yellowColor + "\nSubtotal de la compra: " + greenColor + subtotal);

        // ***************** PEDIR DATOS DEL RESTO DE LAS FUNCIONES *****************//
        //Se ingresan los datos para las operaciones de las funciones

        System.out.print(blueColor + "\n🏦Ingresa el porcentaje de impuestos (ej: 19): " + whiteColor);
        double porcentajeImpuesto = leerTeclado.nextDouble();

        System.out.print(blueColor + "\n🏷️Ingresa el porcentaje de descuento (ej: 10): " + whiteColor);
        double porcentajeDescuento = leerTeclado.nextDouble();

        System.out.print(blueColor + "\n📩Ingresa la distancia del envío en km: " + whiteColor);
        double distanciaKm = leerTeclado.nextDouble();

        // ***************** LLAMADO DE LAS FUNCIONES *****************//
        //Se realiza el llamado de las funciones 2 - 5 que son de tipo Double
        Double descuento = calcular_descuento(subtotal, porcentajeDescuento);
        Double impuestos = calcular_Impuestos(subtotal, porcentajeImpuesto);
        Double costoEnvio = calcular_envio(distanciaKm);
        Double totalFinal = calcular_total_final(subtotal, impuestos, descuento, costoEnvio);

        // ***************** SALIDAS *****************//
        //Se muestra por "sout" el valor de cada funcion junto a total final
        System.out.println(greenColor + "\n************ RESULTADOS DE LA COMPRA ************");
        System.out.println(yellowColor + "Subtotal: " + purpleColor + subtotal);
        System.out.println(yellowColor + "Impuestos (" + porcentajeImpuesto + "%): " + purpleColor + impuestos);
        System.out.println(yellowColor + "Descuento (" + porcentajeDescuento + "%): " + purpleColor + descuento);
        System.out.println(yellowColor + "Costo de envío (" + distanciaKm + " km): " + purpleColor + costoEnvio);
        System.out.println(greenColor + "TOTAL A PAGAR: " + purpleColor + totalFinal);
        System.out.println(greenColor + "*********************************************************");
    }

    // ***************** FUNCIONES *****************//
    //Calcular subtotal
    //Se calcula el subtotal de la compra, sumando el valor de cada producto sin el impuesto, descuento ni costo de envio.
    //Se declaro la variable subTotal inicializada en 0, y con el ciclo for se recorre cada dato que ingreso
    //el usuario, donde cada producto se guarda en un diccionario, este ciclo busca sumar el costo total de cada producto
    //y guardarlo en la variable subTotal.
    public static double calcular_subtotal(ArrayList<HashMap<String, Object>> productos) {
        double subtotal = 0;
        for (HashMap<String, Object> p : productos) {
            Integer precio = (Integer) p.get("precioUnitario");
            Integer cantidad = (Integer) p.get("cantidad");
            subtotal = subtotal + (precio * cantidad);
        }
        return subtotal;
    }

    //Calcular Impuestos
    //Se calcula el valor del impuesto,
    //Esta función calcula el valor de los impuestos que se deben cobrar sobre una compra,
    //tomando como base el subtotal y el porcentaje de impuesto (el cual es ingresado por el usuario).
    public static Double calcular_Impuestos(Double subtotal, Double porcentajeImpuesto) {
        Double impuestos = subtotal * (porcentajeImpuesto / 100);
        return impuestos;
    }

    //Calcular Descuento
    //Esta función calcula cuánto dinero se le va a descontar al cliente en el subtotal de la compra
    //el porcentaje a descontar fue ingresado anteriormente por el usuario.
    public static Double calcular_descuento(Double subtotal, Double porcentajeDescuento) {
        return subtotal * (porcentajeDescuento / 100);
    }

    //Calcular Envío
    //Esta función calcula cuánto cuesta el envío del pedido dependiendo de la distancia a la que debe
    //llegar el producto.
    //Entre mas lejos sea el envio mas costoso sera, la distancia tambien fue ingresada por el usuario.
    //Se definieron 3 costos fijos dependiendo de la distancia y se uso un if, else if, else para mirar
    //si se cumple la condicion, en cada return se retorna la variable en la que se guardo el valor fijo
    // para cada distancia.

    public static Double calcular_envio(Double distanciaKm) {
        Double ENVIO_BASE = 5000.0;
        Double ENVIO_INTERMEDIO = 12000.0;
        Double ENVIO_MAXIMO = 20000.0;

        if (distanciaKm <= 5) {
            return ENVIO_BASE;
        } else if (distanciaKm <= 20) {
            return ENVIO_INTERMEDIO;
        } else {
            return ENVIO_MAXIMO;
        }
    }
    //Calcular total
    //Esta función calcula el total final que debe pagar el cliente,
    //sumando y restando todos los valores que existen dentro de la compra:
    //subtotal, impuestos, descuento y costo de envio.

    public static Double calcular_total_final(Double subtotal, Double impuestos, Double descuento, Double costoEnvio) {
        Double totalFinal = subtotal + impuestos - descuento + costoEnvio;
        return totalFinal;
    }
}