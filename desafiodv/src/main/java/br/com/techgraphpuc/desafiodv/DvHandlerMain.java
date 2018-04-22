package br.com.techgraphpuc.desafiodv;

import br.com.techgraph.desafiodv.enumerator.ParameterStatusEnum;

/**
 * Hello world!
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
		// TODO Auto-generated method stub
		
	}
}
