import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Experimento {

    private int id;
    private Dataset dataset;
    private Modelo modelo;
    private Estado estado;
    ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private double accuracy; // porcentaje de aciertos totales
    private double precision; // calidad de las predicciones positivas

    public Experimento(int id, Dataset dataset, Modelo modelo) {
        this.id = id;
        this.dataset = dataset;
        this.modelo = modelo;
        this.estado = Estado.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Estado getEstado() {
        return estado;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getPrecision() {
        return precision;
    }

    public void ejecutar() {
        System.out.println("Comenzando experimento " + id);

        this.accuracy = Math.random();
        this.precision = Math.random();

        scheduler.schedule(() -> {
            System.out.println("Parametros obtenidos del experimento: par1: " + this.accuracy + ", par2: " + this.precision);
            System.out.println("Experimento finalizado.");
            scheduler.shutdown(); // Cerramos el scheduler
        }, 3, TimeUnit.SECONDS);

        this.estado = Estado.EJECUTADO;
    }

    @Override
    public String toString() {
        return "Experimento " + id +
                "\nDataset: " + dataset.getId() +
                "\nModelo: " + modelo.getId() +
                "\nEstado: " + estado +
                "\nAccuracy: " + accuracy +
                "\nPrecision: " + precision + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Experimento)) return false;

        Experimento e = (Experimento) o;
        return this.id == e.getId();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}