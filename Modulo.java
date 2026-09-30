import java.util.Objects;

public abstract class Modulo implements Comparable<Modulo> {
    private int id;
    private String nombre;
    private double estadoDeSalud;
    private double costoConstruccion;

    public Modulo(int id, String nombre, double estadoDeSalud, double costoConstruccion) {
        this.id = id;
        this.nombre = nombre;
        this.estadoDeSalud = estadoDeSalud;
        this.costoConstruccion = costoConstruccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public void setEstadoDeSalud(double estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public double getCostoConstruccion() {
        return costoConstruccion;
    }

    public void setCostoConstruccion(double costoConstruccion) {
        this.costoConstruccion = costoConstruccion;
    }

    public abstract void procesarCiclo();

    @Override
    public int compareTo(Modulo otro) {
        return Double.compare(this.costoConstruccion, otro.costoConstruccion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modulo modulo = (Modulo) o;
        return id == modulo.id &&
               Double.compare(modulo.estadoDeSalud, estadoDeSalud) == 0 &&
               Double.compare(modulo.costoConstruccion, costoConstruccion) == 0 &&
               Objects.equals(nombre, modulo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, estadoDeSalud, costoConstruccion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estadoDeSalud=" + estadoDeSalud +
                ", costoConstruccion=" + costoConstruccion +
                '}';
    }
}
