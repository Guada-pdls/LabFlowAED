public class Dataset {
    private int id;
    private String nombre;
    private int tamanio;
    private TipoDataset tipo;

    public Dataset(int id, String nombre, int tamanio, TipoDataset tipo) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.tipo = tipo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void imprimir() {
        System.out.println(
                "Dataset " + id + " - " + nombre + "\n"
                + "Tamanio: " + tamanio + "\n"
                + "Tipo: " + tipo + "\n"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dataset)) return false;
        Dataset d = (Dataset) o;
        return this.id == d.getId();
    }

}
