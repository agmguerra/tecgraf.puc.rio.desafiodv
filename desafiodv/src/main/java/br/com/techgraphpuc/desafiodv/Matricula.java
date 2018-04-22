package br.com.techgraphpuc.desafiodv;

public class Matricula {
	
	private static final String[] hexaDv = {"A", "B", "C", "D", "E", "F"};
	
	public static final String calculateDv(String matricula) {
		
		
		String dv = null;
				
		if (!matricula.matches("^\\d{4}$")) {
			
			byte[] seq = matricula.getBytes();
			
			int calcDv = (seq[0]*5 + seq[1]*4 + seq[2]*3 + seq[1] * 2) % 16; 
			
			if (calcDv > 9) {
				dv = hexaDv[calcDv - 10];
			} else {
				dv = String.valueOf(calcDv);
			}
			
		} 
		
		return dv;
		
	}

}
