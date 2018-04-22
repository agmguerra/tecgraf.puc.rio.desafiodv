package br.com.techgraphpuc.desafiodv;

import br.com.techgraphpuc.desafiodv.enumerator.ParameterStatusEnum;

/**
 * Classe principal para iniciar o processamento dos dv's
 * Esta classe é apenas o ponto inicial. Ela delega para outras
 * o processmento soliciado
 *
 */
public class DvHandlerMain 
{
    public static void main( String[] args )
    {
    	
    	Parameter param = Parameter.createParameter(args);
    	if (param.getParameterStatus() == ParameterStatusEnum.PARAMETERS_OK) {
    		processaComando(param);
    		
    	} else {
    		System.err.println(param.getParameterStatus().getErrMessage());
    		System.exit(param.getParameterStatus().getErrCode());
    	}
        
    }

	private static void processaComando(Parameter param) {
		DvHandlerControl control = new DvHandlerControl();
		try {
			control.execute(param);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(-999);
		}
		
	}
}
