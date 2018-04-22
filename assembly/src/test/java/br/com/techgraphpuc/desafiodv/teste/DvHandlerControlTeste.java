package br.com.techgraphpuc.desafiodv.teste;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Test;

import br.com.tecgraf.puc.rio.desafiodv.DvHandlerControl;
import br.com.tecgraf.puc.rio.desafiodv.Parameter;
import br.com.tecgraf.puc.rio.desafiodv.enumerator.ParameterStatusEnum;

/**
 * Classe de teste do controlador do processmento de dv's
 *
 */
public class DvHandlerControlTeste {
	
	@Test
	public void testeGenerateMatriculaComDv() {
		
		DvHandlerControl control = new DvHandlerControl();
		
		String args[] = {"-G", "src\\test\\resources\\matriculasSemDVTeste.txt", "src\\test\\resources\\matriculasComDVTeste.txt"};
		
		Parameter parm = Parameter.createParameter(args);
		if (parm.getParameterStatus() == ParameterStatusEnum.PARAMETERS_OK) {
			try {
				control.execute(parm);
				
				try {
					byte[] f1 = Files.readAllBytes(Paths.get("src\\test\\resources\\matriculasComDVTeste.txt").toAbsolutePath().normalize());
					byte[] f2 = Files.readAllBytes(Paths.get("src\\test\\resources\\matriculasComDVTesteCompare.txt").toAbsolutePath().normalize());
					
					assertTrue(Arrays.equals(f1, f2));
					
					Files.delete(Paths.get("src\\test\\resources\\matriculasComDVTeste.txt").toAbsolutePath().normalize());
					
				} catch (IOException e) {
					assertTrue(false);
				}
			} catch (Exception e) {
				assertTrue(false);
			}

		} else {
			
			assertTrue(false);
		}		
		
	}
	
	@Test
	public void testeValidateMatriculaComDv() {
		
		DvHandlerControl control = new DvHandlerControl();
		
		String args[] = {"-V", "src\\test\\resources\\matriculasParaVerificarTeste.txt", "src\\test\\resources\\matriculasVerificadasTeste.txt"};
		
		Parameter parm = Parameter.createParameter(args);
		if (parm.getParameterStatus() == ParameterStatusEnum.PARAMETERS_OK) {
			try {
				control.execute(parm);
				
				try {
					byte[] f1 = Files.readAllBytes(Paths.get("src\\test\\resources\\matriculasVerificadasTeste.txt").toAbsolutePath().normalize());
					byte[] f2 = Files.readAllBytes(Paths.get("src\\test\\resources\\matriculasVerificadasTesteCompare.txt").toAbsolutePath().normalize());
					
					assertTrue(Arrays.equals(f1, f2));
					
					Files.delete(Paths.get("src\\test\\resources\\matriculasVerificadasTeste.txt").toAbsolutePath().normalize());
					
				} catch (IOException e) {
					assertTrue(false);
				}
			} catch (Exception e) {
				assertTrue(false);
			}

		} else {
			
			assertTrue(false);
		}		
		
	}

}
