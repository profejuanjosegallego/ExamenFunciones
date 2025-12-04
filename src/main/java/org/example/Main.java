package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CALCULO DE COSTO ===");

        //      ELEGIR CATEGORÍA

        System.out.println("\nSeleccione la categoría del producto:");
        System.out.println("1. Ropa");
        System.out.println("2. Juguetes");
        System.out.println("3. Tecnología");
        System.out.print("Ingrese opción: ");
        int categoria = sc.nextInt();

        String nombreProducto = "";
        double precio = 0;
        double impuesto = 0;
        double descuento = 0;

        //   ARTÍCULOS POR CATEGORÍA

        switch (categoria) {

            case 1:
                System.out.println("\n--- ROPA ---");
                System.out.println("1. Camiseta");
                System.out.println("2. Pantalón");
                System.out.println("3. Chaqueta");
                System.out.print("Elija un producto: ");
                int ropa = sc.nextInt();

                if (ropa == 1) { nombreProducto = "Camiseta"; precio = 30000; impuesto = 8; descuento = 5; }
                else if (ropa == 2) { nombreProducto = "Pantalón"; precio = 60000; impuesto = 10; descuento = 3; }
                else if (ropa == 3) { nombreProducto = "Chaqueta"; precio = 120000; impuesto = 12; descuento = 7; }
                else { System.out.println("Opción inválida"); return; }
                break;

            case 2:
                System.out.println("\n--- JUGUETES ---");
                System.out.println("1. Carro de juguete");
                System.out.println("2. Muñeca");
                System.out.println("3. Rompecabezas");
                System.out.print("Elija un producto: ");
                int juguete = sc.nextInt();

                if (juguete == 1) { nombreProducto = "Carro de juguete"; precio = 45000; impuesto = 5; descuento = 2; }
                else if (juguete == 2) { nombreProducto = "Muñeca"; precio = 35000; impuesto = 6; descuento = 3; }
                else if (juguete == 3) { nombreProducto = "Rompecabezas"; precio = 20000; impuesto = 4; descuento = 1; }
                else { System.out.println("Opción inválida"); return; }
                break;

            case 3:
                System.out.println("\n--- TECNOLOGÍA ---");
                System.out.println("1. Audífonos");
                System.out.println("2. Teclado");
                System.out.println("3. Celular");
                System.out.print("Elija un producto: ");
                int tec = sc.nextInt();

                if (tec == 1) { nombreProducto = "Audífonos"; precio = 80000; impuesto = 15; descuento = 0; }
                else if (tec == 2) { nombreProducto = "Teclado"; precio = 100000; impuesto = 12; descuento = 5; }
                else if (tec == 3) { nombreProducto = "Celular"; precio = 1200000; impuesto = 19; descuento = 10; }
                else { System.out.println("Opción inválida"); return; }
                break;

            default:
                System.out.println("Categoría inválida.");
                return;
        }

        //        PEDIR DISTANCIA

        System.out.print("\nIngrese la distancia a recorrer (en km): ");
        double distancia = sc.nextDouble();

        // Validaciones
        if (distancia <= 0) {
            System.out.println("ERROR: La distancia debe ser mayor a 0.");
            return;
        }
        if (distancia > 2000) {
            System.out.println("ERROR: La distancia no puede superar los 2000 km.");
            return;
        }

        double precioKm = 5000;

        double costoDistancia = distancia * precioKm;
        double valorImpuesto = precio * (impuesto / 100);
        double valorDescuento = precio * (descuento / 100);
        double precioFinalProducto = precio + valorImpuesto - valorDescuento;

        double totalFinal = precioFinalProducto + costoDistancia;

        System.out.println("\n=== RESUMEN ===");
        System.out.println("Producto seleccionado : " + nombreProducto);
        System.out.println("Precio base           : $" + precio);
        System.out.println("Impuesto (" + impuesto + "%) : $" + valorImpuesto);
        System.out.println("Descuento (" + descuento + "%) : $" + valorDescuento);
        System.out.println("Precio final producto : $" + precioFinalProducto);
        System.out.println("------------------------------------");
        System.out.println("Distancia recorrida   : " + distancia + " km");
        System.out.println("Costo por distancia   : $" + costoDistancia);
        System.out.println("------------------------------------");
        System.out.println("TOTAL A PAGAR         : $" + totalFinal);
    }
}
