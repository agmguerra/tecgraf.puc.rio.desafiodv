package br.com.tecgraf.puc.rio.desafiodv.enumerator;

/**
 * Enumerator para definir os possíveis erros nos parâmetros na
 * chamada do processament dos dv's
 *
 */
public enum ParameterStatusEnum {
	
	PARAMETERS_OK(0, ""),
	INVALID_NUM_PARAMETER(-10, "Número de parâmetros inválido"),
	INVALID_COMMAND(-11, "Parâmetro comando somente pode assumir os valores -G ou -V"),
	INVALID_INPUT_FILE_NAME(-12, "Parâmetro input file name inválido"),
	INVALID_OUTPUT_FILE_NAME(-13, "Parametro output file name inválido"),
	INPUT_DIRECTORY_NOT_EXISTS(-14, "Diretório de entrada não existe"),
	OUTPUT_DIRECTORY_NOT_EXISTS(-15, "Diretório de saída não existe"),
	FILE_READ_NOT_POSSIBLE(-17, "Não é possível ler o arquivo de entrada"),
	FILE_WRITE_NOT_POSSIBLE(-18, "Não é possível escrever no arquivo de saída");
	
	
	private final int errCode;
	private final String errMessage;
	
	ParameterStatusEnum(int errCode, String errMessage) {
		this.errCode = errCode;
		this.errMessage = errMessage;
	}

	public int getErrCode() {
		return errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

}
