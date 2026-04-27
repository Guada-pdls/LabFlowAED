import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorDatasetTest {
    @Test
    void deberiaEncontrarDatasetPorId() {
        GestorDataset gestor = new GestorDataset();

        gestor.registrar(1, "Dataset 1", 2, TipoDataset.CLASIFICACION);
        gestor.registrar(2, "Dataset 2", 2, TipoDataset.REGRESION);
        gestor.registrar(3, "Dataset 3", 2, TipoDataset.CLASIFICACION);

        Dataset resultado = gestor.buscar(2);

        assertNotNull(resultado);
        assertEquals(2, resultado.getId());
    }

    @Test
    void deberiaRetornarNullSiNoExisteElId() {
        GestorDataset gestor = new GestorDataset();

        gestor.registrar(1, "Dataset 1", 2, TipoDataset.CLASIFICACION);
        gestor.registrar(2, "Dataset 2", 2, TipoDataset.REGRESION);

        Dataset resultado = gestor.buscar(99);

        assertNull(resultado);
    }

    @Test
    void deberiaRetornarFalseSiExisteElId() {
        GestorDataset gestor = new GestorDataset();

        gestor.registrar(1, "Dataset 1", 2, TipoDataset.CLASIFICACION);
        boolean resultado = gestor.registrar(1, "Dataset 2", 2, TipoDataset.REGRESION);

        assertFalse(resultado);
    }

    @Test
    void deberiaEliminarDatasetExistente() {
        GestorDataset gestor = new GestorDataset();

        Dataset ds = new Dataset(1, "Test", 100, TipoDataset.REGRESION);
        gestor.registrar(1, "Test", 100, TipoDataset.CLASIFICACION);

        boolean resultado = gestor.eliminar(ds);

        assertTrue(resultado);
        assertNull(gestor.buscar(1));
    }

    @Test
    void noDeberiaEliminarDatasetInexistente() {
        GestorDataset gestor = new GestorDataset();

        Dataset ds = new Dataset(99, "Dataset", 50, TipoDataset.REGRESION);

        boolean resultado = gestor.eliminar(ds);

        assertFalse(resultado);
    }
}
