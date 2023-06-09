package arquetipoAhorcadoBDTest;

import static org.junit.Assert.*;
import arquetipoAhorcadoBD.*;
import org.junit.Test;
import junit.framework.TestCase;

public class TestEstadoAhorcado extends TestCase {
	private EstadoAhorcado estadoAhorcado;
	/*
	 * testGetValorHorca: Comprobamos que todos los estados devuelven la cadena que se espera.
	 * 
	 */
	@Test
	public void testGetValorHorca() {
		String inicial = "+---+\n" + "  | |\n" + "    |\n" + "    |\n" + "    |\n" + "    |\n" + "=======\n";
		String cabeza = "+---+\n" + "  | |\n" + "  O |\n" + "    |\n" + "    |\n" + "    |\n" + "=======\n";
		String cuerpo = "+---+\n" + "  | |\n" + "  O |\n" + "  | |\n" + "    |\n" + "    |\n" + "======\n";
		String brazoDerecho = "+---+\n" + "  | |\n" + "  O |\n" + "  |\\|\n" + "    |\n" + "    |\n" + "======\n";
		String brazoIzquierdo = "+---+\n" + "  | |\n" + "  O |\n" + " /|\\|\n" + "    |\n" + "    |\n" + "======\n";
		String piernaDerecha = "+---+\n" + "  | |\n" + "  O |\n" + " /|\\|\n" + " /  |\n" + "    |\n" + "======\n";
		String piernaIzquierda = "+---+\n" + "  | |\n" + "  O |\n" + " /|\\|\n" + " / \\|\n" + "    |\n" + "======\n";
		// Comprobamos la string para cada uno de los estados
		assertEquals(inicial, this.estadoAhorcado.INICIAL.getFigura());
		assertEquals(cabeza, this.estadoAhorcado.CABEZA.getFigura());
		assertEquals(cuerpo, this.estadoAhorcado.CUERPO.getFigura());
		assertEquals(brazoDerecho, this.estadoAhorcado.BRAZO_DERECHO.getFigura());
		assertEquals(brazoIzquierdo, this.estadoAhorcado.BRAZO_IZQUIERDO.getFigura());
		assertEquals(piernaDerecha, this.estadoAhorcado.PIERNA_DERECHA.getFigura());
		assertEquals(piernaIzquierda, this.estadoAhorcado.PIERNA_IZQUIERDA.getFigura());
		// Comprobamos el número para cada uno de los estados
		assertEquals(0, this.estadoAhorcado.INICIAL.getEstado());
		assertEquals(1, this.estadoAhorcado.CABEZA.getEstado());
		assertEquals(2, this.estadoAhorcado.CUERPO.getEstado());
		assertEquals(3, this.estadoAhorcado.BRAZO_DERECHO.getEstado());
		assertEquals(4, this.estadoAhorcado.BRAZO_IZQUIERDO.getEstado());
		assertEquals(5, this.estadoAhorcado.PIERNA_DERECHA.getEstado());
		assertEquals(6, this.estadoAhorcado.PIERNA_IZQUIERDA.getEstado());
	}

}

