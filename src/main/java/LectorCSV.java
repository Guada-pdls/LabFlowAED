import java.io.*;
import java.util.*;

public class LectorCSV {

    public static List<Dataset> cargarDatasets(String archivo) throws IOException {

        List<Dataset> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea = br.readLine(); // salta header

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");

            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            int tamano = Integer.parseInt(datos[2]);
            TipoDataset tipo = TipoDataset.valueOf(datos[3]);

            lista.add(new Dataset(id, nombre, tamano, tipo));
        }

        br.close();

        return lista;
    }

    public static List<Modelo> cargarModelos(String archivo) throws IOException {

        List<Modelo> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea = br.readLine();

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");

            int id = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            String tipo = datos[2];
            String parametro = datos[3];

            lista.add(new Modelo(id, nombre, tipo, parametro));
        }

        br.close();

        return lista;
    }
}