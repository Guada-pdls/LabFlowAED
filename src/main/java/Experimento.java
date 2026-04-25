public class Experimento {

    private int id;
    private Dataset dataset;
    private Modelo modelo;
    private Estado estado;

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
        this.accuracy = Math.random();
        this.precision = Math.random();

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
}