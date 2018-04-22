package br.com.techgraphpuc.desafiodv;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import br.com.techgraph.desafiodv.enumerator.ParameterStatusEnum;

public class Parameter {
	
	private final ParameterStatusEnum parameterStatus;
	
	private final String command;
	private final String inFilePathName;
	private final String outFilePathName;
	
	private Parameter(ParameterStatusEnum parameterStatus) {
		this.parameterStatus = parameterStatus;
		this.command = null;
		this.inFilePathName = null;
		this.outFilePathName = null;
	}
	
	private Parameter(ParameterStatusEnum parameterStatus, 
					  String command, 
					  String inputFilePathName, 
					  String outFilePathName) {
		this.parameterStatus = parameterStatus;
		this.command = command;
		this.inFilePathName = inputFilePathName;
		this.outFilePathName = outFilePathName;
	}
	
	public String getCommand() {
		return command;
	}
	public String getInFilePathName() {
		return inFilePathName;
	}
	public String getOuFilePathName() {
		return outFilePathName;
	}

	public ParameterStatusEnum getParameterStatus() {
		return parameterStatus;
	}
	
	public static final Parameter createParameter(String[] args) {
		
		ParameterStatusEnum status = validateParameters(args);
		if (status == ParameterStatusEnum.PARAMETERS_OK) {
			return new Parameter(ParameterStatusEnum.PARAMETERS_OK, args[0], args[1], args[2]);
		} else {
			return new Parameter(status);
		}
		
	}

	private static ParameterStatusEnum validateParameters(String[] args) {
		ParameterStatusEnum status = null;
		
		if (args.length != 3) {
			return ParameterStatusEnum.INVALID_NUM_PARAMETER;
     	}
		
		Path inputPath;
		try {
			inputPath = Paths.get(args[1]);
		} catch (InvalidPathException e) {
			inputPath = null;
			
		}
		
		Path outputPath;
		try {
			outputPath = Paths.get(args[2]);
		} catch (InvalidPathException e) {
			outputPath = null;
			status = ParameterStatusEnum.INVALID_INPUT_FILE_NAME;
		}
		
		if (!args[0].equals("-G") && !args[0].equals("-V")) {
			status = ParameterStatusEnum.INVALID_COMMAND;
		} if (inputPath == null) {
			status = ParameterStatusEnum.INVALID_INPUT_FILE_NAME;
		} else if (outputPath == null) {
			status = ParameterStatusEnum.INVALID_OUTPUT_FILE_NAME;
		} if (Files.notExists(inputPath.getParent())) {
			status = ParameterStatusEnum.INPUT_DIRECTORY_NOT_EXISTS;
		} else if (Files.notExists(outputPath.getParent())) {
			status = ParameterStatusEnum.OUTPUT_DIRECTORY_NOT_EXISTS;
		} else if (!Files.isReadable(inputPath)) {
			status = ParameterStatusEnum.FILE_READ_NOT_POSSIBLE;
		} else if (!Files.isWritable(outputPath)) {
			status = ParameterStatusEnum.FILE_WRITE_NOT_POSSIBLE;
		}

		return status;
	}

}
