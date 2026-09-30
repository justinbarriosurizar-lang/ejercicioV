public class ModuloTierra extends Modulo {
    public ModuloTierra(int id, String nombre, double estadoDeSalud, double costoConstruccion) {
        super(id, nombre, estadoDeSalud, costoConstruccion);
    }

    @Override
    public void procesarCiclo() {
        System.out.println("Modulo de Tierra '" + getNombre() + "' procesando ciclo: consumiendo energia para descargar datos.");
    }
}
