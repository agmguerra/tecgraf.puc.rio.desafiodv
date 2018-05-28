package br.com.tecgraf.puc.rio.desafiodv;

import java.io.BufferedWriter;
import java.io.IOException;

public class ValidateMatricula implements Operacao {

	@Override
	public void executa(BufferedWriter linhasWrite, String matricula) throws IOException {
    	if (Matricula.isValidDv(matricula)) {
    		linhasWrite.write(matricula + " verdadeiro");
    	} else {
    		linhasWrite.write(matricula + " falso");
    	}
	}

}
