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


        ArrayList<HashMap<String,Object>> productos = new ArrayList<>();

        String opcion = " ";

        while (!opcion.equals("no")) {

            HashMap<String, Object> producto = new HashMap<>();

            System.out.println("Ingrese el nombre de el producto: ");
            producto.put("nombreProducto", leer.nextLine());

            System.out.println("Ingrese el precio el del producto: ");
            producto.put("precioUnitarioProducto", leer.nextInt());

            System.out.println("Ingrese la cantidad que desea comprar: ");
            producto.put("cantidadProducto", leer.nextInt());

            leer.nextLine();

            System.out.print("Desea ingresar otro producto(Ingrese no para salir): ");
            opcion = leer.nextLine();

            productos.add(producto);

        }
        Double subtotal = calcular_subtotal_compra(productos);

        System.out.println(subtotal);

        







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


}