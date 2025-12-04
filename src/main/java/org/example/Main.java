package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leerTeclado = new Scanner(System.in);
        //
        // Colores para UX
        String GREEN = "\u001B[32m";

        // Título del e-commerce
        System.out.println(GREEN + "\n-----NEVADA COMMERCE -----");
        System.out.println(GREEN + "===BY: STEVEN & ADRIANA'S CORP===");
        System.out.println("Calculamos tu compra paso a paso...\n");
        System.out.println("*********************************");

        // Lista donde guardaré todos los productos
        ArrayList<HashMap<String, Object>> productos = new ArrayList<>();

        // Aquí permito al usuario agregar varios productos
        System.out.print("¿Cuántos productos desea registrar?: ");
        Integer cantidadProductosLista = leerTeclado.nextInt();
        leerTeclado.nextLine(); // Limpia buffer

        // Ciclo para agregar productos
        for (int i = 0; i < cantidadProductosLista; i++) {

            System.out.println("\nProducto #" + (i + 1));

            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = leerTeclado.nextLine();

            System.out.print("Ingrese el precio unitario: ");
            Double precioUnitario = leerTeclado.nextDouble();

            System.out.print("Ingrese la cantidad: ");
            Integer cantidad = leerTeclado.nextInt();
            leerTeclado.nextLine();

            // Creo el diccionario del producto
            HashMap<String, Object> producto = new HashMap<>();
            producto.put("nombre", nombreProducto);
            producto.put("precioUnitario", precioUnitario);
            producto.put("cantidad", cantidad);

            // Lo agrego a la lista
            productos.add(producto);
        }




    }

    // Función para calcular el subtotal (precio * cantidad)
    public static Double calcularSubtotal(ArrayList<HashMap<String, Object>> listaProductos) {

        Double subtotal = 0.0;

        for (HashMap<String, Object> producto : listaProductos) {
            Double precio = (Double) producto.get("precioUnitario");
            Integer cantidad = (Integer) producto.get("cantidad");

            subtotal += precio * cantidad; // Sumo al subtotal
        }

        return subtotal;
    }

    // Función para calcular impuestos
    public static Double calcularImpuestos(Double subtotal, Double porcentaje) {
        Double impuesto = (subtotal * porcentaje) / 100;
        return impuesto;
    }

    // Función para calcular descuentos
    public static Double calcularDescuentos(Double subtotal, Double porcentaje) {
        Double descuento = (subtotal * porcentaje) / 100;
        return descuento;
    }

    // Función para evaluar el costo del envío según la distancia
    public static Double evaluarCostoDistancia(Double distancia) {

        if (distancia <= 5) {
            return 5000.0; // Envío económico
        } else if (distancia <= 20) {
            return 12000.0; // Envío medio
        } else {
            return 20000.0; // Envío largo
        }
    }
    public static Double calcularTotalFinal(Double subtotal, Double impuesto, Double descuento, Double envio) {
        return subtotal + impuesto - descuento + envio;
    }


}
