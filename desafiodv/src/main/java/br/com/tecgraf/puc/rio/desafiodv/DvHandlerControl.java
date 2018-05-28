package br.com.tecgraf.puc.rio.desafiodv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;

/**
 * Classe de controle para os processamento de digito verificador
 *
 */
public class DvHandlerControl {
	
	
	private Operacao generate = new GenerateMatricula();
	private Operacao validate = new ValidateMatricula();
	
	/**
	 * Executa o comando informado a partir dos parâmetros
	 * @param param Parameter parâmetros informados
	 * @throws Exception
	 */
	public void execute(Parameter param) throws Exception {
		
		String opt = param.getCommand();
		switch (opt) {
			case "-G": {
				processaArquivo(param.getInFilePathName(), param.getOuFilePathName(), generate);
				break;
			}
			
			case "-V": {
				processaArquivo(param.getInFilePathName(), param.getOuFilePathName(), validate);
				break;
			}
			default: {
			
			}
		}
	}
	
	
	/**
	 * Executa o processamento de geração de arquivo com matriculas com DV
	 * @param inputFile String contendo o path do arquivo com as matriculas sem DV
	 * @param outputFile String contendo o path do arquivo a ser gerado com as matriculas com DV
	 * @throws Exception
	 */
	private void processaArquivo(String inputFile, String outputFile, Operacao ope) throws Exception {
		
		String in = Paths.get(inputFile).toAbsolutePath().normalize().toString();
		String out = Paths.get(outputFile).toAbsolutePath().normalize().toString();
		
		try (Reader reader = new InputStreamReader(new FileInputStream(in), "UTF-8");
			 BufferedReader linhas = new BufferedReader(reader);
			 Writer writer = new OutputStreamWriter(new FileOutputStream(out), "UTF-8");
			 BufferedWriter	linhasWrite = new BufferedWriter(writer)) {
			
			String matricula = null;
			
		    while ((matricula = linhas.readLine()) != null) {
		    	ope.executa(linhasWrite, matricula);
		    	linhasWrite.newLine();
		    }
			
			
		} catch (IOException io) {
			System.err.println("Erro na geração do arquivo de matriculas com DV");
			throw io;
		} 
	}

}
