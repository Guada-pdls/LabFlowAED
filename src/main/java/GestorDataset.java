import java.util.LinkedList;

public class GestorDataset {
    private LinkedList<Dataset> datasets;

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
}
