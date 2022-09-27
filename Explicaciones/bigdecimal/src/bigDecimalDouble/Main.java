package bigDecimalDouble;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		double valor = 0.1d;
		
		System.out.println(Double.toString(valor));
		
		// No utilizar double con el constructor
		BigDecimal bdStr = new BigDecimal(0.1d);
		BigDecimal bdStr2 = new BigDecimal("0.1");
		
		BigDecimal bd = BigDecimal.valueOf(0.1d);
		
		System.out.println(bd);
		System.out.println(bdStr);
		System.out.println(bdStr2);
	}

}
