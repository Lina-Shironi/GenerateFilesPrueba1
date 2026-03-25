
/**
 *
 * Clase: GenerateInfoFiles
 *
 * Versión simplificada para uso académico.
 *
 * Genera archivos CSV con datos aleatorios de:
 * * Vendedores
 * * Productos
 * * Ventas
 *
 * Características:
 * * Métodos simples (sin helpers)
 * * Validaciones básicas
 * * Uso de UTF-8
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class GenerateInfoFiles {

    private final Random random = new Random();

    private final String[] nombres = {"Juan", "Ana", "Carlos", "Luisa", "Pedro", "Sofia"};
    private final String[] ciudades = {"Bogotá", "Medellín", "Cali", "Barranquilla"};
    private final String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Impresora"};

    /**
     * Genera el archivo vendedores.csv
     */
    public void generateVendedoresFile(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("vendedores.csv"), StandardCharsets.UTF_8))) {

            writer.write("id,nombre,ciudad\n");

            for (int i = 1; i <= cantidad; i++) {
                String nombre = nombres[random.nextInt(nombres.length)];
                String ciudad = ciudades[random.nextInt(ciudades.length)];

                writer.write(i + "," + nombre + "," + ciudad + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera el archivo productos.csv
     */
    public void generateProductosFile(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("productos.csv"), StandardCharsets.UTF_8))) {

            writer.write("id,nombre,precio\n");

            for (int i = 1; i <= cantidad; i++) {
                String nombreProducto = productos[random.nextInt(productos.length)];
                int precio = 50 + random.nextInt(3001);

                writer.write(i + "," + nombreProducto + "," + precio + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Genera el archivo ventas.csv
     */
    public void generateVentasFile(int cantidadVentas, int maxVendedores, int maxProductos) {
        if (cantidadVentas <= 0 || maxVendedores <= 0 || maxProductos <= 0) {
            throw new IllegalArgumentException("Parámetros inválidos");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("ventas.csv"), StandardCharsets.UTF_8))) {

            writer.write("idVenta,idVendedor,idProducto,cantidad\n");

            for (int i = 1; i <= cantidadVentas; i++) {
                int idVendedor = 1 + random.nextInt(maxVendedores);
                int idProducto = 1 + random.nextInt(maxProductos);
                int cantidad = 1 + random.nextInt(10);

                writer.write(i + "," + idVendedor + "," + idProducto + "," + cantidad + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
