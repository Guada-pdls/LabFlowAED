public class Modelo {

    private int id;
    private String nombre;
    private String tipoModelo;
    private String parametros;

    public Modelo(int id, String nombre, String tipoModelo, String parametros) {
        this.id = id;
        this.nombre = nombre;
        this.tipoModelo = tipoModelo;
        this.parametros = parametros;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Modelo " + id + " - " + nombre +
                "\nTipo: " + tipoModelo +
                "\nParametros: " + parametros + "\n";
    }
}