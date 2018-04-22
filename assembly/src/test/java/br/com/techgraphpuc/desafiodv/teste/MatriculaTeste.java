package br.com.techgraphpuc.desafiodv.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.tecgraf.puc.rio.desafiodv.Matricula;

/**
 * Classe de teste das operações de matricula
 */
public class MatriculaTeste {
	
	
	@Test
	public void testeCalculaDvOk() {	
		// dv = (0*5 + 0*4 + 0*3 + 1*2) % 16 = 2
		String dv = Matricula.calculateDv("0001");
		assertEquals("2", dv);
		
		dv = Matricula.calculateDv("9999");
		assertEquals("E", dv);

	}
	
	@Test
	public void testeCalculaDvMatriculaInvalida() {
		String dv = Matricula.calculateDv("q234");
		assertEquals(null, dv);
	}
	
	@Test
	public void testeCalculaDvHexa() {
		String dv = Matricula.calculateDv("9876");
		assertEquals("E", dv);
	}

}
