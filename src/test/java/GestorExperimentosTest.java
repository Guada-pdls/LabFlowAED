import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GestorExperimentosTest {


    @Test
    void deberiaRegistrarExperimentos(){
        GestorExperimentos gestor = new GestorExperimentos();
        Dataset ds = new Dataset(1, "Dataset", 100, TipoDataset.CLASIFICACION);
        Modelo modelo = new Modelo(1,"Modelo", "Arbol", "j1lpms" );

        Experimento resultado = gestor.registrarExperimento(1, ds, modelo);
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals(ds, resultado.getDataset());
        assertEquals(modelo, resultado.getModelo());

    }

    @Test
    void deberiaListarPorDatset() {

        GestorExperimentos gestor = new GestorExperimentos();

        Dataset ds1 = new Dataset(1345, "dataset1", 10, TipoDataset.CLASIFICACION);
        Dataset ds2 = new Dataset(2456, "dataset2", 25, TipoDataset.REGRESION);

        Modelo md1 = new Modelo(1673, "modelo1", "tipo1", "parametro1");
        Modelo md2 = new Modelo(2373, "modelo2", "tipo2", "parametro2");

        gestor.registrarExperimento(1, ds1, md1);
        gestor.registrarExperimento(2, ds1, md2);
        gestor.registrarExperimento(3, ds2, md1);

        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        gestor.listarPorDataset(ds1);

        String resultado = salida.toString();

        assertTrue(resultado.contains("Experimento 1"));
        assertTrue(resultado.contains("Experimento 2"));
        assertFalse(resultado.contains("Experimento 3"));

    }


    @Test
    void deberiaRegistrarMultiplesExperimentos() {
        GestorExperimentos gestor = new GestorExperimentos();
        Dataset ds1 = new Dataset(1, "Dataset 1", 100, TipoDataset.CLASIFICACION);
        Dataset ds2 = new Dataset(2, "Dataset 2", 200, TipoDataset.REGRESION);
        Modelo modelo1 = new Modelo(1, "Modelo 1", "Arbol", "2727227");
        Modelo modelo2 = new Modelo(2, "Modelo 2", "Arbol 2", "98765");

        Experimento exp1 = gestor.registrarExperimento(1, ds1, modelo1);
        Experimento exp2 = gestor.registrarExperimento(2, ds2, modelo2);

        assertNotSame(exp1, exp2);
        assertEquals(1, exp1.getId());
        assertEquals(2, exp2.getId());
    }

    @Test
    void deberiaAgregarExperimentoAlHistorial() {
        GestorExperimentos gestor = new GestorExperimentos();
        Dataset ds = new Dataset(1, "Dataset", 100, TipoDataset.CLASIFICACION);
        Modelo modelo = new Modelo(1, "Modelo", "Arbol", "09gh12");

        gestor.registrarExperimento(1, ds, modelo);
        Experimento resultado = gestor.registrarExperimento(2, ds, modelo);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
    }


}
