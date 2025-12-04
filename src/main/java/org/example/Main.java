package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //App desarrollada por
        // DAVID HENAO MONCADA
        // JUAN JOSE GOMEZ

        Scanner leer = new Scanner(System.in); //Iniciamos Scanner

        //E-COMMERCE APLICATIVO DIGITAL COMERCE J&D
        System.out.println("-----------------------------------------------");
        System.out.println("*****🏪🛒 -- DIGITAL COMERCE J&D🛒🏪 -- *****");
        System.out.println("-----------------------------------------------");

        //Se crea lista de productos
        ArrayList<HashMap<String, Object>> productos = new ArrayList<>();

        int opcion = 0; //Opcion para el while

        while (opcion != 8) {  //Se crea while para menu interactivo

            System.out.println("\n*****🏪🛒 -- MENU DIGITAL COMERCE J&D🛒🏪 -- *****");
            System.out.println("1 - Ingresar producto ⬅️");
            System.out.println("2 - Mostrar productos 👁️");
            System.out.println("3 - Calcular subtotal 🚇");
            System.out.println("4 - Calcular impuestos 🧮");
            System.out.println("5 - Calcular descuento ➖");
            System.out.println("6 - Calcular costo de envío 🛩️");
            System.out.println("7 - Calcular total final 💵");
            System.out.println("8 - Salir ⛔");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine(); //Limpiamos el buffer para evitar problemas con los cases

            switch (opcion) { //Este switch lee la opcion que se escogio

                case 1:
                    System.out.println("\n----- 📋 Registrar Producto 📋 -----");

                    System.out.print("Nombre del producto 👉 ");
                    String nombre = leer.nextLine();

                    System.out.print("Precio unitario 👉 ");
                    double precio = leer.nextDouble();
                    leer.nextLine();

                    System.out.print("Cantidad 👉 ");
                    int cantidad = leer.nextInt();
                    leer.nextLine();

                    HashMap<String, Object> producto = new HashMap<>(); //Se crea diccionario de productos

                    //Se almacenan los datos dentro del diccionario
                    producto.put("nombre", nombre);
                    producto.put("precio_unitario", precio);
                    producto.put("cantidad", cantidad);

                    productos.add(producto); //Se mandan los datos almacenados en el diccionario, a la lista productos

                    System.out.println("El producto se ha guardado ✅😁");
                    break;

                case 2:
                    System.out.println("\n--- 👁️ Ver la lista de productos 👁️ ---");

                    if (productos.isEmpty()) { //Comprueba que producctos no esta vacio
                        System.out.println("No hay productos registrados❎"); //En caso de estar vacio muestra esto
                    } else {
                        int i = 1; //Este numerito es para poder mostrar en pantalla que producto mostramos
                        for (HashMap<String, Object> p : productos) { //Un for-each para extraer los datos del case anterior
                            System.out.println("\nProducto #" + i++);
                            System.out.println("Nombre: " + p.get("nombre"));
                            System.out.println("Precio: " + p.get("precio_unitario"));
                            System.out.println("Cantidad: " + p.get("cantidad"));
                        }
                    }
                    break;

                case 3:
                    double subtotal = calcularSubtotal(productos); //Llama a la funcion de calcular descuento
                    System.out.println("\nSubtotal actual: $" + subtotal);
                    break;

                case 4:
                    System.out.print("Ingrese porcentaje de impuesto⬅️: ");
                    double impuesto = leer.nextDouble();

                    double impuestos = calcularImpuestos(calcularSubtotal(productos), impuesto); //Se llama a la funcion de calcularImpuestos
                    System.out.println("Impuestos: $" + impuestos);
                    break;

                case 5:
                    System.out.print("Ingrese porcentaje de descuento⬅️: ");
                    double descuento1 = leer.nextDouble();

                    double descuento = calcularDescuento(calcularSubtotal(productos), descuento1); //Llamamos a la funcion de calcular descuento
                    System.out.println("Descuento: $" + descuento);
                    break;

                case 6:
                    System.out.print("Distancia en km del envío🛻: ");
                    double km = leer.nextDouble();

                    double envio = calcularEnvio(km); //Se llama a la funcion de calcular envio
                    System.out.println("Costo de envío: $" + envio);
                    break;

                case 7:
                    double sub = calcularSubtotal(productos); //Se llama a la funcion

                    System.out.print("Porcentaje de impuesto🤩: ");
                    double imp2 = leer.nextDouble();

                    System.out.print("Porcentaje de descuento🛒: ");
                    double desc2 = leer.nextDouble();

                    System.out.print("Distancia en km🛻: ");
                    double km2 = leer.nextDouble();

                    double totalFinal = calcularTotalFinal(
                            sub,
                            calcularImpuestos(sub, imp2),
                            calcularDescuento(sub, desc2),
                            calcularEnvio(km2)
                    );
                    System.out.println("TOTAL FINAL A PAGAR: $" + totalFinal);
                    break;

                case 8:
                    System.out.println("Saliendo...💨");
                    break;

                default:
                    System.out.println("Opción inválida❎");
            }
        }
    }
    //FUNCIONES

    //Funcion para calcular el costo total de la venta (Subtotal)
    public static double calcularSubtotal(ArrayList<HashMap<String, Object>> productos) {

        double subtotal = 0; //Iniciamos variable subtotal

        for (HashMap<String, Object> producto : productos) { //Ciclo For-Each
            double precio = (double) producto.get("precio_unitario"); //Va al diccionario y busca el precio
            int cantidad = (int) producto.get("cantidad"); //Va al diccionario y busca la cantidad
            subtotal = subtotal + (precio * cantidad);
        }

        return subtotal;
    }
    //Funcion para aplicar impuestos
    public static double calcularImpuestos(double subtotal, double porcentajeImpuesto) {
        return subtotal * (porcentajeImpuesto / 100); //Se calcula el porcentaje
    }

    //Funcion para aplicar descuentos
    public static double calcularDescuento(double subtotal, double porcentajeDescuento) {
        return subtotal * (porcentajeDescuento / 100); //Calcula el descuento
    }

    //Funcion para calcular costo de encios según distancia
    public static double calcularEnvio(double distancia) {

        if (distancia <= 5) { //Condicional para calcular el precio del envio dependiendo de la distancia
            return 5000;
        } else if (distancia <= 20) {
            return 12000;
        } else {
            return 12000 + (distancia - 20) * 800;
        }
    }

    //Funcion para calcular el total final de la compra
    public static double calcularTotalFinal(double subtotal, double impuestos, double descuento, double envio) {
        return subtotal + impuestos - descuento + envio; //Calculo del total final
    }

}