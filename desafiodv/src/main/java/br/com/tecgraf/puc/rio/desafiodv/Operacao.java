package br.com.tecgraf.puc.rio.desafiodv;

import java.io.BufferedWriter;
import java.io.IOException;

public interface Operacao {
	
	public void executa(BufferedWriter linhasWriter, String matricula) throws IOException;

}
