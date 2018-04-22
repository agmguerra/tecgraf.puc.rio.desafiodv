package br.com.techgraphpuc.desafiodv.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.techgraph.desafiodv.enumerator.ParameterStatusEnum;
import br.com.techgraphpuc.desafiodv.Parameter;

/**
 * 
 * Classe de teste das operações de Parameter
 *
 */
public class ParameterTeste {
	
	
	@Test
	public void testeNumeroParametrosError() {
		
		String[] args = {"-G"};
		Parameter param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.INVALID_NUM_PARAMETER, param.getParameterStatus());
	}
	
	
	@Test
	public void testeCommandParamError() {
		
		String[] args = {"S", "", ""};
		
		Parameter param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.INVALID_COMMAND, param.getParameterStatus());
	}
	
	@Test
	public void testeInputDirParamError() {
		
		String[] args = {"-G", "src\\test\\resoces\\matriculasSemDV.txt", "src\\test\\resources\\matriculasComDV.txt"};
		Parameter param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.INPUT_DIRECTORY_NOT_EXISTS, param.getParameterStatus());
		
		args[1] = "src\\test\\resour?|ces\\matriculasSemDV.txt";
		param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.INVALID_INPUT_FILE_NAME, param.getParameterStatus());

	}
	
	@Test
	public void testeOutputDirParamError() {
		
		String[] args = {"-G", "src\\test\\resources\\matriculasSemDV.txt", "src\\test\\resoces\\matriculasComDV.txt"};
		Parameter param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.OUTPUT_DIRECTORY_NOT_EXISTS, param.getParameterStatus());
		
		args[2] = "src\\test\\resou?|rces\\matriculasComDV.txt";
		param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.INVALID_OUTPUT_FILE_NAME, param.getParameterStatus());
		
	}

	@Test
	public void testeParametrosOk() {
		String[] args = {"-G", "src\\test\\resources\\matriculasSemDV.txt", "src\\test\\resources\\matriculasComDV.txt"};
		Parameter param = Parameter.createParameter(args);
		assertEquals(ParameterStatusEnum.PARAMETERS_OK, param.getParameterStatus());

	}
	
}
