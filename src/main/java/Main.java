import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {

            List<Dataset> datasets = LectorCSV.cargarDatasets("datasets.csv");
            List<Modelo> modelos = LectorCSV.cargarModelos("modelos.csv");

            GestorExperimentos gestor = new GestorExperimentos();

            Scanner sc = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {

                System.out.println("\n------ MENU ------");
                System.out.println("1 Registrar experimento");
                System.out.println("2 Ejecutar experimentos pendientes");
                System.out.println("3 Listar experimentos por dataset");
                System.out.println("4 Listar experimentos por modelo");
                System.out.println("5 Ver historial de experimentos");
                System.out.println("6 Ver experimentos pendientes de ejecución");
                System.out.println("7 Salir");

                int opcion = sc.nextInt();

                switch (opcion) {

                    case 1:

                        System.out.println("\nCreación de nuevo experimento");
                        System.out.println("Ingrese el ID del experimento (este ID debe ser asignado por usted):");
                        int idExp = sc.nextInt();

                        System.out.println("\nDatasets disponibles:");

                        for (Dataset ds : datasets) {
                            System.out.println(ds.toString());
                        }

                        System.out.println("Ingrese el ID del dataset que desea usar:");
                        int idDs = sc.nextInt();

                        System.out.println("\nModelos disponibles:");

                        for (Modelo m : modelos) {
                            System.out.println(m.toString());
                        }

                        System.out.println("Ingrese el ID del modelo que desea usar:");
                        int idModelo = sc.nextInt();

                        Dataset dsSeleccionado = null;
                        Modelo modeloSeleccionado = null;

                        for (Dataset ds : datasets) {
                            if (ds.getId() == idDs) {
                                dsSeleccionado = ds;
                            }
                        }

                        for (Modelo m : modelos) {
                            if (m.getId() == idModelo) {
                                modeloSeleccionado = m;
                            }
                        }

                        if (dsSeleccionado != null && modeloSeleccionado != null) {

                            gestor.registrarExperimento(idExp, dsSeleccionado, modeloSeleccionado);
                            System.out.println("Experimento registrado correctamente.");

                        } else {

                            System.out.println("Dataset o modelo no encontrado.");

                        }

                        break;

                    case 2:
                        gestor.ejecutarExperimentos();
                        System.out.println("Experimentos pendientes ejecutados.");
                        break;

                    case 3:

                        System.out.println("\nDatasets disponibles:");

                        for (Dataset ds : datasets) {
                            System.out.println(ds.toString());
                        }

                        System.out.println("Ingrese el ID del dataset:");
                        int idDataset = sc.nextInt();

                        for (Dataset ds : datasets) {
                            if (ds.getId() == idDataset) {
                                gestor.listarPorDataset(ds);
                            } else System.out.println("No hay experimentos registrados con ese dataset.");
                            break;
                        }

                        break;

                    case 4:

                        System.out.println("\nModelos disponibles:");

                        for (Modelo m : modelos) {
                            System.out.println(m.toString());
                        }

                        System.out.println("Ingrese el ID del modelo:");
                        int idModeloBuscar = sc.nextInt();

                        for (Modelo m : modelos) {
                            if (m.getId() == idModeloBuscar) {
                                gestor.listarPorModelo(m);
                            } else System.out.println("No hay experimentos registrados con ese modelo.");
                            break;
                        }

                        break;

                    case 5:
                        if (!gestor.hayEjecutados()){
                            System.out.println("No hay experiment1" +
                                    "os ejecutados.");
                        } else {
                            gestor.listarHistorial();
                        }
                        break;


                    case 6:
                        if (!gestor.hayPendientes()){
                            System.out.println("No hay experimentos pendientes.");
                        } else {
                            gestor.listarPendientes();
                        }
                        break;
                    case 7:
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error leyendo archivos: " + e.getMessage());
        }
    }
}