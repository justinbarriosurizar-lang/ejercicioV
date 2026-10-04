import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    private List<Modulo> catalog;

    public Model() {
        catalog = new ArrayList<>();
        catalog.add(new ModuloEnergia(1, "Panel Solar A", 100.0, 50000.0));
        catalog.add(new ModuloEnergia(2, "Panel Solar B", 100.0, 50000.0));
        catalog.add(new ModuloEnergia(3, "Bateria Principal", 95.0, 75000.0));
        catalog.add(new ModuloVuelo(4, "Camara Infrarroja", 98.0, 120000.0));
        catalog.add(new ModuloVuelo(5, "Sensor de Radiacion", 100.0, 80000.0));
        catalog.add(new ModuloVuelo(6, "Camara Alta Resolucion", 90.0, 250000.0));
        catalog.add(new ModuloTierra(7, "Antena de Banda X", 85.0, 150000.0));
        catalog.add(new ModuloTierra(8, "Antena Omnidireccional", 99.0, 45000.0));
        catalog.add(new ModuloTierra(9, "Transmisor Telemetria", 100.0, 60000.0));
        catalog.add(new ModuloEnergia(10, "Bateria Respaldo", 100.0, 65000.0));
    }

    public List<Modulo> getCatalog() {
        return catalog;
    }

    public Modulo buscar(int id) {
        for (Modulo m : catalog) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public Modulo buscar(String nombre) {
        for (Modulo m : catalog) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    public void ordenarPorCosto() {
        Collections.sort(catalog);
    }
}
