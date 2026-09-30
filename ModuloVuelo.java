public class ModuloVuelo extends Modulo {
    public ModuloVuelo(int id, String nombre, double estadoDeSalud, double costoConstruccion) {
        super(id, nombre, estadoDeSalud, costoConstruccion);
    }

    @Override
    public void procesarCiclo() {
        System.out.println("Modulo de Vuelo '" + getNombre() + "' procesando ciclo: consumiendo energia para recolectar datos.");
    }
}
