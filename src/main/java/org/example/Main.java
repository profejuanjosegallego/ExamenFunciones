//Integrantes de equipo Ludivia Morales, Alejandro Montoya
package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //desarrolla el codigo aca
        Scanner leerTeclado = new Scanner(System.in);

        // ---------------------------------------------------------------------
        //  INGRESO DE PRODUCTOS POR EL USUARIO
        // ---------------------------------------------------------------------
        ArrayList<HashMap<String, Object>> productos = new ArrayList<>();

        System.out.println("📦 REGISTRO DE 3 PRODUCTOS");
        for (int i = 1; i <= 3; i++) {

            System.out.println("\nProducto #" + i);

            HashMap<String, Object> producto = new HashMap<>();

            System.out.print("👉 Nombre del producto: ");
            String nombre = leerTeclado.nextLine();
            producto.put("nombre", nombre);

            System.out.print("👉 Precio del producto: ");
            Double precio = leerTeclado.nextDouble();
            producto.put("precio", precio);

            System.out.print("👉 Cantidad comprada: ");
            Integer cantidad = leerTeclado.nextInt();
            producto.put("cantidad", cantidad);

            leerTeclado.nextLine(); // limpiar buffer del Enter

            productos.add(producto);
        }

        // ---------------------------------------------------------------------
        // DATOS ADICIONALES DEL USUARIO
        // ---------------------------------------------------------------------
        System.out.print("\n💰 Ingrese el porcentaje de impuestos (%): ");
        double impuesto = leerTeclado.nextDouble();

        System.out.print("🎯 Ingrese el porcentaje de descuento (%): ");
        double descuentoUser = leerTeclado.nextDouble();

        System.out.print("🚚 Ingrese la distancia en km para el envío: ");
        double distanciaUser = leerTeclado.nextDouble();

        // ---------------------------------------------------------------------
        // CÁLCULOS MEDIANTE FUNCIONES
        // ---------------------------------------------------------------------
        Double subtotal = calcularSubtotal(productos);
        Double impuestos = calcularImpuestos(subtotal, impuesto);
        Double descuento = calcularDescuento(subtotal, descuentoUser);
        Double costoEnvio = calcularEnvio(distanciaUser);
        Double totalFinal = calcularTotalFinal(subtotal, impuestos, descuento, costoEnvio);

        // ---------------------------------------------------------------------
        // RESULTADOS
        // ---------------------------------------------------------------------
        System.out.println("\n===========================================");
        System.out.println("🧾 RESULTADO DE LA COMPRA");
        System.out.println("===========================================");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Impuestos (" + impuesto + "%): $" + impuestos);
        System.out.println("Descuento (" + descuentoUser + "%): $" + descuento);
        System.out.println("Costo de envío (" + distanciaUser + " km): $" + costoEnvio);
        System.out.println("-------------------------------------------");
        System.out.println("TOTAL FINAL A PAGAR: $" + totalFinal);
        System.out.println("===========================================");

        leerTeclado.close();
    }

    public static Double calcularSubtotal(ArrayList<HashMap<String, Object>> productos) {
        Double subtotal = 0.0;

        for (HashMap<String, Object> producto : productos) {
            Double precio = (Double) producto.get("precio");
            Integer cantidad = (Integer) producto.get("cantidad");

            subtotal += precio * cantidad;
        }
        return subtotal;
    }

    public static Double calcularImpuestos(Double subtotal, double porcentaje) {
        return subtotal * (porcentaje / 100);
    }

    public static Double calcularDescuento(Double subtotal, double porcentaje) {
        return subtotal * (porcentaje / 100);
    }

    public static Double calcularEnvio(double distanciaKm) {
        if (distanciaKm <= 5) {
            return 5000.0;
        } else if (distanciaKm <= 20) {
            return 12000.0;
        } else {
            double extra = (distanciaKm - 20) * 800;
            return 12000.0 + extra;
        }
    }

    public static Double calcularTotalFinal(Double subtotal, Double impuestos, Double descuento, Double envio) {
        return subtotal + impuestos - descuento + envio;
    }
}

