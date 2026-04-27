import javax.xml.crypto.Data;
import java.util.LinkedList;

public class GestorDataset {
    private LinkedList<Dataset> datasets = new LinkedList<>();

    public Dataset buscar(int id) {
        for (Dataset ds : datasets) {
            if (ds.getId() == id) {
                return ds;
            }
        }

        return null;
    }

    public boolean eliminar(Dataset dataset) {
        return datasets.remove(dataset);
    }

    public boolean registrar(int id, String nombre, int tamanio, TipoDataset tipo) {
        Dataset existente = this.buscar(id);

        if (existente != null) {
            System.out.println("Ya existe un dataset con ese identificador");
            return false;
        }

        datasets.add(new Dataset(id, nombre, tamanio, tipo));
        return true;
    }

    public void listar() {
        for (Dataset ds : datasets) {
            ds.imprimir();
        }
    }

}
