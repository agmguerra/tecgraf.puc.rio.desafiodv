package br.com.tecgraf.puc.rio.desafiodv;

import java.io.BufferedWriter;
import java.io.IOException;

public class GenerateMatricula implements Operacao {

	@Override
	public void executa(BufferedWriter linhasWrite, String matricula) throws IOException {
		String dv = Matricula.calculateDv(matricula);
        if (dv != null) {
        	linhasWrite.write(matricula + "-" + dv);
        	linhasWrite.newLine();
        } else {
        	linhasWrite.write(matricula + "- matricula inválida");
        	linhasWrite.newLine();
        }

	}

}
