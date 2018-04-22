package br.com.techgraphpuc.desafiodv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class DvHandlerControl {
	
	public void execute(Parameter param) {
		
		String opt = param.getCommand();
		switch (opt) {
			case "-G": {
				generateMatriculasWithDv(param.getInFilePathName(), param.getOuFilePathName());
				break;
			}
			
			case "-V": {
				validateMatriculaWithDv(param.getInFilePathName(), param.getOuFilePathName());
				break;
			}
			default: {
			
			}
		}
	}
	
	private void generateMatriculasWithDv(String inputFile, String outputFile) {
		
		
		try (Reader reader = new InputStreamReader(new FileInputStream(inputFile), "UTF-8");
			 BufferedReader linhas = new BufferedReader(reader);
			 Writer writer = new OutputStreamWriter(new FileOutputStream(inputFile), "UTF-8");
			 BufferedWriter	linhasWrite = new BufferedWriter(writer)) {
			
			String matricula = null;
			
		    while ((matricula = linhas.readLine()) != null) {
		        String dv = Matricula.calculateDv(matricula);
		        if (dv != null) {
		        	String matriculaComDv = matricula + "-" + dv;
		        	linhasWrite.write(matriculaComDv);
		        	linhasWrite.newLine();
		        }
		    }
			
			
		} catch (IOException io) {
			System.err.println("Erro na geração do arquivo de matriculas com DV");
			System.exit(-999);
		} 
	}
	
	private void validateMatriculaWithDv(String inputFile, String outputFile) {
		
	}

}
