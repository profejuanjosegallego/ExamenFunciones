package org.example;

import java.util.*;

class Producto {
    private double precioUnitario;
    private int cantidad;

    public Producto(double precioUnitario, int cantidad) {
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }
}

class EcommerceFunciones {

    public static double calcularSubtotal(List<Producto> listaProductos) {
        double subtotal = 0;
        for (Producto producto : listaProductos) {
            subtotal += producto.getPrecioUnitario() * producto.getCantidad();
        }
        return subtotal;
    }

    public static double calcularImpuesto(double subtotal, double porcentajeImpuesto) {
        return subtotal * (porcentajeImpuesto / 100);
    }

    public static double calcularDescuento(double subtotal, double porcentajeDescuento) {
        return subtotal * (porcentajeDescuento / 100);
    }

    public static double calcularCostoEnvio(double distanciaKm) {
        if (distanciaKm <= 5) return 5000;
        else if (distanciaKm <= 20) return 12000;
        else return 12000 + (distanciaKm - 20) * 500;
    }

    public static double calcularTotal(double subtotal, double impuesto, double descuento, double costoEnvio) {
        return subtotal + impuesto - descuento + costoEnvio;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        List<Producto> listaProductos = new ArrayList<>();

        // Diccionario para encuesta (id → respuesta)
        Map<String, String> encuesta = new LinkedHashMap<>();

        double subtotal = 0;
        double totalImpuestos = 0;
        double totalDescuento = 0;
        double totalEnvio = 0;

        int opcionMenu;

        do {
            System.out.println("\n🔥😈===== MENU E-COMMERCE =====😈🔥");
            System.out.println("1. Agregar productos 🍑🍆");
            System.out.println("2. Calcular subtotal 💸");
            System.out.println("3. Calcular impuestos 😭💀");
            System.out.println("4. Calcular descuento 🤑");
            System.out.println("5. Calcular costo de envío 🚚🔥");
            System.out.println("6. Calcular total final 💰👹");
            System.out.println("7. Salir 🏃💨");
            System.out.println("8. Encuesta de satisfacción 📝 (NUEVO)");
            System.out.print("Seleccione una opción: ");
            opcionMenu = entrada.nextInt();

            switch (opcionMenu) {

                case 1:
                    System.out.print("¿Cuántos productos desea agregar? (mínimo 5): ");
                    int cantidadProductos = entrada.nextInt();

                    if (cantidadProductos < 5) {
                        System.out.println("Debe agregar mínimo 5 productos.");
                        break;
                    }

                    for (int i = 1; i <= cantidadProductos; i++) {
                        System.out.println("\nProducto #" + i);

                        System.out.print("Precio unitario: ");
                        double precioUnitario = entrada.nextDouble();

                        System.out.print("Cantidad: ");
                        int cantidad = entrada.nextInt();

                        listaProductos.add(new Producto(precioUnitario, cantidad));
                    }

                    System.out.println("Productos agregados correctamente.");
                    break;

                case 2:
                    subtotal = EcommerceFunciones.calcularSubtotal(listaProductos);
                    System.out.println("Subtotal: " + subtotal);
                    break;

                case 3:
                    if (subtotal == 0) subtotal = EcommerceFunciones.calcularSubtotal(listaProductos);
                    System.out.print("Porcentaje de impuesto (%): ");
                    double porcentajeImpuesto = entrada.nextDouble();
                    totalImpuestos = EcommerceFunciones.calcularImpuesto(subtotal, porcentajeImpuesto);
                    System.out.println("Impuestos: " + totalImpuestos);
                    break;

                case 4:
                    if (subtotal == 0) subtotal = EcommerceFunciones.calcularSubtotal(listaProductos);
                    System.out.print("Porcentaje de descuento (%): ");
                    double porcentajeDescuento = entrada.nextDouble();
                    totalDescuento = EcommerceFunciones.calcularDescuento(subtotal, porcentajeDescuento);
                    System.out.println("Descuento: " + totalDescuento);
                    break;

                case 5:
                    System.out.print("Distancia en kilómetros: ");
                    double distanciaKm = entrada.nextDouble();
                    totalEnvio = EcommerceFunciones.calcularCostoEnvio(distanciaKm);
                    System.out.println("Costo de envío: " + totalEnvio);
                    break;

                case 6:
                    double totalFinal = EcommerceFunciones.calcularTotal(
                            subtotal, totalImpuestos, totalDescuento, totalEnvio
                    );

                    System.out.println("\n===== RESUMEN DE LA COMPRA =====");
                    System.out.println("Subtotal: " + subtotal);
                    System.out.println("Impuestos: " + totalImpuestos);
                    System.out.println("Descuento: " + totalDescuento);
                    System.out.println("Costo de envío: " + totalEnvio);
                    System.out.println("TOTAL FINAL: " + totalFinal);
                    break;

                case 8:
                    entrada.nextLine(); // limpiar buffer

                    System.out.println("\n📝 ENCUESTA DE SATISFACCIÓN DEL SERVICIO");

                    System.out.print("1. ¿Cómo califica el servicio? (1-10): ");
                    String calificacion = entrada.nextLine();
                    encuesta.put("Calificación del servicio", calificacion);

                    System.out.print("2. ¿Recomendaría nuestro e-commerce? (sí/no): ");
                    String recomendacion = entrada.nextLine();
                    encuesta.put("Recomienda el servicio", recomendacion);

                    System.out.print("3. Comentarios adicionales: ");
                    String comentarios = entrada.nextLine();
                    encuesta.put("Comentarios", comentarios);

                    System.out.println("\nGracias por responder la encuesta. ❤️");
                    System.out.println("RESUMEN DE RESPUESTAS:\n");
                    for (String clave : encuesta.keySet()) {
                        System.out.println(clave + ": " + encuesta.get(clave));
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcionMenu != 7);

        entrada.close();
    }
}