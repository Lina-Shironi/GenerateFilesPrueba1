public class Main {
    public static void main(String[] args) {
        GenerateInfoFiles generator = new GenerateInfoFiles();

        generator.generateVendedoresFile(10);   // 10 vendedores
        generator.generateProductosFile(10);    // 10 productos
        generator.generateVentasFile(20, 10, 10); // 20 ventas
    }
}
