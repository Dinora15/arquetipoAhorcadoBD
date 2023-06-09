package arquetipoAhorcadoBDTest;
import arquetipoAhorcadoBD.*;
import static org.junit.Assert.*;


import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;


import junit.framework.TestCase;

@SuppressWarnings("unused")
public class TestPalabra extends TestCase {
	private Palabra palabra = new Palabra("gato");
	/*
	 * testComprobarLetra: se prueba el método comprobarLetra
	 * 
	 * La palabra establecida ha sido gato
	 */
	public void  testComprobarLetra(char letra_in) {
		assertFalse( palabra.ComprobarLetra('z')); // Comprobamos si la palabra contiene la letra Z, debe dar falso
		assertEquals(palabra.getLetrasERROR(), 1); // Copmrobamos cuantos errores hemos cometido al intentar acertar la palabra, en este caso debe ser 1
		assertTrue(palabra.ComprobarLetra('g'));  // Se busca la letra g, en este caso debe dar verdadero.
		assertEquals(palabra.getLetrasERROR(), 1);  // Y como hemos acertado, debe seguir habiendo un sólo error.
		
	}
	
	/*
	 * testPalabraEncontrada: se testea el método palabraEncontrada
	 */
	public void testPalabraEncontrada() {
		Set<Character> palabras = new TreeSet<Character>();
		palabras.add('G');
		palabras.add('A'); //Se añaden 2 letras (G,A) 
		assertFalse(palabra.PalabraEncontrada(palabras)); //Debe dar falso, aún no hemos encontrado todas las letras
		palabras.add('T');
		palabras.add('O'); //Ahora se agrega (T,O)
		assertTrue(palabra.PalabraEncontrada(palabras));  //Debe dar verdadero, ya tenemos todas la letras que conforman la palabra a adivinar.
		
	}
	
	/*
	 * testContinuarJuego: Se prueba el metodo continuarJuego
	 */
	public void testContinuarJuego() {
		Set<Character> palabras = new TreeSet<Character>();
		palabras.add('G');
		palabras.add('A');
		assertTrue(palabra.ContinuarJuego(palabras)); // Debe dar verdadero ya que aún no hemos encontrado la palabra ni llegado al máximo de errores
		palabras.add('T');
		palabras.add('O');
		assertFalse(palabra.ContinuarJuego(palabras)); // Falso, ya hemos encontrado la palabra por lo que no se continua con el juego.
		palabras.clear(); // Limpiamos el juego para volver a empezar.
		palabra.ComprobarLetra('z');
		palabra.ComprobarLetra('z');
		palabra.ComprobarLetra('z');
		palabra.ComprobarLetra('z');
		palabra.ComprobarLetra('z');
		palabra.ComprobarLetra('z'); // Forzamos el máximo de intentos permitidos
		assertFalse(palabra.ContinuarJuego(palabras)); // Falso, hemos llegado al máximo de errores posibles y el juego no continua.
		
		
	}
	
}

