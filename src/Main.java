/**
 * Clase principal para ejecutar la generación de archivos CSV.
 * 
 * <p>
 * Esta versión es simple y está pensada para uso académico.
 * Solo define cantidades fijas y ejecuta el generador.
 * </p>
 */
public class Main {

    public static void main(String[] args) {

        // Cantidades a generar
        int vendedores = 10;
        int productos = 10;
        int ventas = 20;

        // Crear generador
        GenerateInfoFiles generator = new GenerateInfoFiles();

        // Generar archivos
        System.out.println("Generando vendedores...");
        generator.generateVendedoresFile(vendedores);

        System.out.println("Generando productos...");
        generator.generateProductosFile(productos);

        System.out.println("Generando ventas...");
        generator.generateVentasFile(ventas, vendedores, productos);

        System.out.println("Proceso finalizado.");
    }
}