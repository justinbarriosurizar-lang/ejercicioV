public class ModuloEnergia extends Modulo {
    public ModuloEnergia(int id, String nombre, double estadoDeSalud, double costoConstruccion) {
        super(id, nombre, estadoDeSalud, costoConstruccion);
    }

    @Override
    public void procesarCiclo() {
        System.out.println("Modulo de Energia '" + getNombre() + "' procesando ciclo: generando energia para el satelite.");
    }
}
