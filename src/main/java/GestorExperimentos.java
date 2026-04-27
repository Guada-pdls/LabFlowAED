import java.util.LinkedList;
import java.util.Queue;

public class GestorExperimentos {
    private LinkedList<Experimento> ejecutados = new LinkedList<Experimento>();
    private Queue<Experimento> pendientes;

    public Experimento registrarExperimento(int id, Dataset ds, Modelo modelo) {
        Experimento nuevo = new Experimento(id, ds, modelo);
        ejecutados.add(nuevo);
        return nuevo;
    }

    public void listarPorDataset(Dataset ds) {
        for (Experimento e : ejecutados) {
            if (e.getDataset() == ds) {
                System.out.println(e.toString());
            }
        }
    }

    public void listarPorModelo(Modelo modelo) {
        for (Experimento e : ejecutados) {
            if (e.getModelo() == modelo) {
                System.out.println(e.toString());
            }
        }
    }

    public void ejecutarExperimentos() {
        Experimento e = pendientes.poll();
        while (e != null) {
            e.ejecutar();
            ejecutados.add(e);
            e = pendientes.poll();
        }
    }

    public void listarHistorial() {
        for (Experimento e : ejecutados) {
            System.out.println(e.toString());
        }

    }
}
