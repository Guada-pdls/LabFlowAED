import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorModeloTest {

    @Test
    void deberiaRegistrarModeloCorrectamente() {
        GestorModelo gestor = new GestorModelo();

        boolean resultado = gestor.registrar(1, "Modelo Ventas", "Regresion lineal", "configA");

        assertTrue(resultado);
        assertNotNull(gestor.buscar(1));
    }

    @Test
    void noDeberiaRegistrarModeloConIdDuplicado() {
        GestorModelo gestor = new GestorModelo();

        gestor.registrar(1, "Modelo Ventas", "Regresion lineal", "configA");
        boolean resultado = gestor.registrar(1, "Modelo Alternativo", "Red neuronal", "configB");

        assertFalse(resultado);
    }

    @Test
    void deberiaBuscarModeloExistente() {
        GestorModelo gestor = new GestorModelo();

        gestor.registrar(1, "Modelo Ventas", "Regresion lineal", "configA");

        Modelo modelo = gestor.buscar(1);

        assertNotNull(modelo);
        assertEquals(1, modelo.getId());
    }

    @Test
    void deberiaRetornarNullSiModeloNoExiste() {
        GestorModelo gestor = new GestorModelo();

        Modelo modelo = gestor.buscar(99);

        assertNull(modelo);
    }

    @Test
    void deberiaEliminarModeloExistente() {
        GestorModelo gestor = new GestorModelo();

        gestor.registrar(1, "Modelo Ventas", "Regresion lineal", "configA");
        Modelo modelo = gestor.buscar(1);

        boolean eliminado = gestor.eliminar(modelo);

        assertTrue(eliminado);
        assertNull(gestor.buscar(1));
    }

    @Test
    void noDeberiaEliminarModeloInexistente() {
        GestorModelo gestor = new GestorModelo();

        Modelo modelo = new Modelo(99, "Modelo Prueba", "KNN", "configX");

        boolean eliminado = gestor.eliminar(modelo);

        assertFalse(eliminado);
    }

    @Test
    void noDeberiaEliminarDosVecesElMismoModelo() {
        GestorModelo gestor = new GestorModelo();

        gestor.registrar(1, "Modelo Ventas", "Regresion lineal", "configA");
        Modelo modelo = gestor.buscar(1);

        gestor.eliminar(modelo);
        boolean resultado = gestor.eliminar(modelo);

        assertFalse(resultado);
    }

    @Test
    void deberiaMantenerMultiplesModelos() {
        GestorModelo gestor = new GestorModelo();

        gestor.registrar(1, "Modelo Ventas", "Regresion lineal", "configA");
        gestor.registrar(2, "Clasificador Clientes", "Arbol de decision", "configB");

        assertNotNull(gestor.buscar(1));
        assertNotNull(gestor.buscar(2));
    }

    @Test
    void modelosConMismoIdDeberianSerIguales() {
        Modelo m1 = new Modelo(1, "Modelo A", "Regresion lineal", "configA");
        Modelo m2 = new Modelo(1, "Modelo B", "Arbol de decision", "configB");

        assertEquals(m1, m2);
    }

    @Test
    void modelosConDistintoIdNoDeberianSerIguales() {
        Modelo m1 = new Modelo(1, "Modelo A", "Regresion lineal", "configA");
        Modelo m2 = new Modelo(2, "Modelo A", "Regresion lineal", "configA");

        assertNotEquals(m1, m2);
    }
}

