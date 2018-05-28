package br.com.tecgraf.puc.rio.desafiodv;

/**
 * Classe que representa a matricula
 * 
 *
 */
public class Matricula {
	
	private static final int HEXA_VAL = 16;
	private static final int MAIOR_NUMERO_HEXA = 9;
	
	
	/**
	 * Calcula o dígito verificador da matricula seguindo o padrão:
	 * 
	 * Exemplo: matrícula = 9876
	 * Total = (9 * 5) + (8 * 4) * (7 * 3) + (6 * 2) = 110
	 * Resto da divisão de 110 por 16 é igual a 14. 
	 * O número 14 em base 16 é "E". Este é o dígito verificador da matrícula.
	 * Matrícula completa = 9876-E
	 * 
	 * @param matricula
	 * @return o digito verificador ou null se a matricula informada for inválida
	 */
	public static final String calculateDv(String matriculaComDv) {
		
		
		String dv = null;
		String matSemDv = matriculaComDv.split("-")[0];
		int matSize = matSemDv.length();
				
		if (matSemDv.matches("^\\d{" + matSize + "}$")) {
			
			String[] numeros = matSemDv.split("");
			
			int val = 0;
			int fator = matSize + 1;
			for (int i = 0; i < numeros.length; i++) {
				val += Integer.parseInt(numeros[i]) * fator;
				fator--;
			}
			
			int calcDv = val % HEXA_VAL; 
			
			dv = (calcDv > MAIOR_NUMERO_HEXA) ? Integer.toHexString(calcDv).toUpperCase() : String.valueOf(calcDv);
			
		} 
		
		return dv;
		
	}
	
	/**
	 * Verifica se o dv da matricula está correto
	 * @param matricula String contendo a matricula contendo o dv
	 * @return true se o dv estiver ok e false se não
	 */
	public static final boolean isValidDv(String matricula) {
		String dvCalc = calculateDv(matricula);
		String dv = matricula.substring(matricula.length()-1);
		
		return (dv.equals(dvCalc)) ? true : false;
		
	}

}
