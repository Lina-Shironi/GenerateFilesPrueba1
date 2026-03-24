import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    Random random = new Random();

    String[] nombres = {"Juan", "Ana", "Carlos", "Luisa", "Pedro", "Sofia"};
    String[] ciudades = {"Bogota", "Medellin", "Cali", "Barranquilla"};
    String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Impresora"};

    public void generateVendedoresFile(int cantidad) {
        try (FileWriter writer = new FileWriter("vendedores.csv")) {
            writer.write("id,nombre,ciudad\n");

            for (int i = 1; i <= cantidad; i++) {
                String nombre = nombres[random.nextInt(nombres.length)];
                String ciudad = ciudades[random.nextInt(ciudades.length)];

                writer.write(i + "," + nombre + "," + ciudad + "\n");
            }

            System.out.println("Vendedores generados");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateProductosFile(int cantidad) {
        try (FileWriter writer = new FileWriter("productos.csv")) {
            writer.write("id,nombre,precio\n");

            for (int i = 1; i <= cantidad; i++) {
                String nombreProducto = productos[random.nextInt(productos.length)];
                int precio = 50 + random.nextInt(3000); // precios entre 50 y 3050

                writer.write(i + "," + nombreProducto + "," + precio + "\n");
            }

            System.out.println("Productos generados");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateVentasFile(int cantidadVentas, int maxVendedores, int maxProductos) {
        try (FileWriter writer = new FileWriter("ventas.csv")) {
            writer.write("idVenta,idVendedor,idProducto,cantidad\n");

            for (int i = 1; i <= cantidadVentas; i++) {
                int idVendedor = 1 + random.nextInt(maxVendedores);
                int idProducto = 1 + random.nextInt(maxProductos);
                int cantidad = 1 + random.nextInt(10);

                writer.write(i + "," + idVendedor + "," + idProducto + "," + cantidad + "\n");
            }

            System.out.println("Ventas generadas");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}