package arquetipoAhorcadoBDTest;

import bbdd.BBDDAhorcado;
import bbdd.PlayerPojo;

import org.junit.Test;
import junit.framework.TestCase;

public class TestBBDDAhorcado extends TestCase {
	private BBDDAhorcado bd = new BBDDAhorcado();
	private PlayerPojo player = new PlayerPojo();
	/*
	 * testGetValorHorca: Comprobamos que todos los estados devuelven la cadena que se espera.
	 * 
	 */
	@Test
	public void testBBDD() {
		//Limpiamos el usuario Ezequiel
		player.setNombre("Ezequiel");
		bd.cleanPlayer(player);
		//Obtenemos el usuario Ezequiel de la base de datos
		player = bd.getPlayer("Ezequiel");
		//Comprobamos que lo ha "limpiado" (reseteado) correctamente
		assertEquals("Ezequiel",player.getNombre());
		assertEquals("" ,player.getPalabraJuego());
		assertEquals("",player.getLetrasUtilizadas());
		assertEquals(0, player.getEstado());
		assertEquals((Integer) 0, player.getIntentos());
		
		//Creamos un nuevo estado para el jugador Ezequiel
		player.setNombre("Ezequiel");
		player.setEstado(1);
		player.setIntentos(1);
		player.setLetrasUtilizadas("A,B");
		player.setPalabraJuego("GATO");
		
		//Lo guardamos en la base de datos
		bd.savePlayer(player);
		//Lo recuperamos nuevamente
		player = bd.getPlayer("Ezequiel");
		//Comprobamos que se ha guardado correctamente en la base de datos con el nuevo estado.
		assertEquals("Ezequiel",player.getNombre());
		assertEquals("GATO" ,player.getPalabraJuego());
		assertEquals("A,B",player.getLetrasUtilizadas());
		//assertEquals(1, player.getIntentos());
		assertEquals(1, player.getEstado());
		assertEquals((Integer) 1, player.getIntentos());
	}

}
