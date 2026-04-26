import java.util.LinkedList;

public class GestorModelo {

    private LinkedList<Modelo> modelos;

    public GestorModelo() {
        modelos = new LinkedList<>();
    }

    public Modelo buscar(int id) {
        for (Modelo m : modelos) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public boolean registrar(int id, String nombre, String tipoModelo, String parametros) {
        if (buscar(id) != null) {
            System.out.println("Ya existe un modelo con ese identificador");
            return false;
        }

        Modelo nuevo = new Modelo(id, nombre, tipoModelo, parametros);
        modelos.add(nuevo);
        return true;
    }

    public boolean eliminar(Modelo modelo) {
        return modelos.remove(modelo);
    }

    public void listar() {
        for (Modelo m : modelos) {
            System.out.println(m);
        }
    }
}