package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Timeout;

import JUnit.Junit09_Geometria.dto.Geometria;

class TestGeometria {
	//tests unitarios metodos:
	@org.junit.jupiter.api.Test
	public void testAreacuadrado() {
		int resultado = Geometria.areacuadrado(5);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testAreaCirculo() {
		double resultado = Geometria.areaCirculo(5);
		double esperado = 78.54;
		double delta = 1.0;
		assertEquals(esperado, resultado, delta);
	}
	
	@org.junit.jupiter.api.Test
	public void testAreaTriangulo() {
		int resultado = Geometria.areatriangulo(5, 5);
		int esperado = 12;
		double delta = 1;
		assertEquals(esperado, resultado, delta);
	}
	
	@org.junit.jupiter.api.Test
	public void testAreaRectangulo() {
		int resultado = Geometria.arearectangulo(5, 5);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	@org.junit.jupiter.api.Test
	public void testAreaPentagono() {
		int resultado = Geometria.areapentagono(5, 5);
		int esperado = 12;
		int delta = 1;
		assertEquals(esperado, resultado, delta);
	}
	
	@org.junit.jupiter.api.Test
	public void testAreaRombo() {
		int resultado = Geometria.arearombo(5, 5);
		int esperado = 12;
		int delta = 1;
		assertEquals(esperado, resultado, delta);
	}
	
	@org.junit.jupiter.api.Test
	public void testAreaRomboide() {
		int resultado = Geometria.arearomboide(5, 5);
		int esperado = 25;
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testAreaTrapecio() {
		int resultado = Geometria.areatrapecio(5, 5, 5);
		int esperado = 25;
		int delta = 1;
		assertEquals(esperado, resultado, delta);
	}
	@org.junit.jupiter.api.Test
	public void testFigura() {
		String resultado1 = Geometria.figura(1);
		String esperado1 = "cuadrado";
		assertEquals(esperado1, resultado1);
		String resultado2 = Geometria.figura(2);
		String esperado2 = "Circulo";
		assertEquals(esperado2, resultado2);
		String resultado3 = Geometria.figura(3);
		String esperado3 = "Triangulo";
		assertEquals(esperado3, resultado3);
		String resultado4 = Geometria.figura(4);
		String esperado4 = "Rectangulo";
		assertEquals(esperado4, resultado4);
		String resultado5 = Geometria.figura(5);
		String esperado5 = "Pentagono";
		assertEquals(esperado5, resultado5);
		String resultado6 = Geometria.figura(6);
		String esperado6 = "Rombo";
		assertEquals(esperado6, resultado6);
		String resultado7 = Geometria.figura(7);
		String esperado7 = "Romboide";
		assertEquals(esperado7, resultado7);
		String resultado8 = Geometria.figura(8);
		String esperado8 = "Trapecio";
		assertEquals(esperado8, resultado8);
		String resultado9 = Geometria.figura(9);
		String esperado9 = "Default";
		assertEquals(esperado9, resultado9);
	}
	//getters y setters
	@org.junit.jupiter.api.Test
	public void testSetId() {
		Geometria geom = new Geometria();
		geom.setId(5);
		int resultado = geom.getId();
		int esperado = 5;
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testSetNom() {
		Geometria geom = new Geometria();
		geom.setNom("notDefault");
		String resultado = geom.getNom();
		String esperado = "notDefault";
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testGetArea() {
		Geometria geom = new Geometria();
		geom.setArea(12.2);

		double resultado = geom.getArea();
		double esperado = 12.2;
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testToString() {
		Geometria geom = new Geometria(5);
		String resultado = geom.toString();
		String esperado = "Geometria [id=5, nom=Pentagono, area=0.0]";
		assertEquals(esperado, resultado);
	}
	
	//tests unitarios constructores:
	@org.junit.jupiter.api.Test
	public void testConstructorSinParam1() {
		Geometria geom = new Geometria();
		String resultado = geom.getNom();
		String esperado = "Default";
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testConstructorSinParam2() {
		Geometria geom = new Geometria();
		int resultado = geom.getId();
		int esperado = 9;
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testConstructorConParam1() {
		Geometria geom = new Geometria(5);
		String resultado = geom.getNom();
		String esperado = "Pentagono";
		assertEquals(esperado, resultado);
	}
	
	@org.junit.jupiter.api.Test
	public void testConstructorConParam2() {
		Geometria geom = new Geometria(5);
		int resultado = geom.getId();
		int esperado = 5;
		assertEquals(esperado, resultado);
	}
	
	@BeforeEach
	public void before() {
		System.out.println("before()");
	}
	
	
	@AfterEach
	public void after() {
		System.out.println("after()");
	}
	//tiempo de ejecucion del metodo
	@org.junit.jupiter.api.Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	public void testAlgoritmoOptimo() {
		int resultado = Geometria.areatriangulo(5, 5);
	}
	
	
}
