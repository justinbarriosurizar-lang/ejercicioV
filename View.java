import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Listar todos los módulos");
        System.out.println("2. Buscar módulo por ID");
        System.out.println("3. Buscar módulo por Nombre");
        System.out.println("4. Ordenar catálogo por costo de construcción");
        System.out.println("5. Procesar ciclo en todos los módulos");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public int getUserOption() {
        while (true) {
            if (!scanner.hasNextLine()) {
                System.exit(0);
            }
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor ingrese un número: ");
            }
        }
    }

    public int getIntInput(String message) {
        System.out.print(message);
        while (true) {
            if (!scanner.hasNextLine()) {
                System.exit(0);
            }
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor ingrese un número válido: ");
            }
        }
    }

    public String getStringInput(String message) {
        System.out.print(message);
        while (true) {
            if (!scanner.hasNextLine()) {
                System.exit(0);
            }
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.print("La entrada no puede estar vacía. " + message);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
