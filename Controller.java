import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            int option = view.getUserOption();

            switch (option) {
                case 1:
                    listarModulos();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    buscarPorNombre();
                    break;
                case 4:
                    ordenarPorCosto();
                    break;
                case 5:
                    procesarCiclos();
                    break;
                case 6:
                    running = false;
                    view.showMessage("Saliendo del programa...");
                    break;
                default:
                    view.showMessage("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void listarModulos() {
        List<Modulo> modulos = model.getCatalog();
        if (modulos.isEmpty()) {
            view.showMessage("No hay módulos construidos.");
        } else {
            view.showMessage("--- Lista de Módulos ---");
            for (Modulo m : modulos) {
                view.showMessage(m.toString());
            }
        }
    }

    private void buscarPorId() {
        int id = view.getIntInput("Ingrese el ID del módulo a buscar: ");
        Modulo modulo = model.buscar(id);
        if (modulo != null) {
            view.showMessage("Módulo encontrado: " + modulo.toString());
        } else {
            view.showMessage("No se encontró ningún módulo con el ID: " + id);
        }
    }

    private void buscarPorNombre() {
        String nombre = view.getStringInput("Ingrese el nombre del módulo a buscar: ");
        Modulo modulo = model.buscar(nombre);
        if (modulo != null) {
            view.showMessage("Módulo encontrado: " + modulo.toString());
        } else {
            view.showMessage("No se encontró ningún módulo con el nombre: " + nombre);
        }
    }

    private void ordenarPorCosto() {
        model.ordenarPorCosto();
        view.showMessage("Catálogo ordenado por costo de construcción.");
        listarModulos();
    }

    private void procesarCiclos() {
        List<Modulo> modulos = model.getCatalog();
        if (modulos.isEmpty()) {
            view.showMessage("No hay módulos para procesar.");
        } else {
            view.showMessage("--- Procesando ciclos ---");
            for (Modulo m : modulos) {
                m.procesarCiclo();
                view.showMessage("Ciclo procesado para: " + m.getNombre());
            }
            view.showMessage("Todos los ciclos han sido procesados.");
        }
    }
}
