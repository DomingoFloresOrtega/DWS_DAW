package lambdas.teoria.calculadora;

public class PruebaFuncional {
	
	public static void main(String[] args) {
		
		Operacion op = (j,i) -> j - i;
		
		System.out.println(op.oper(2, 1));
		PruebaFuncional.imprimoOp(op);
		PruebaFuncional.imprimoOp((j,i) -> j * i);
		
		PruebaFuncional.imprimoOp((j,i) -> j - i);
		PruebaFuncional.imprimoOp(PruebaFuncional::resta);
		
	}
	
	public static void imprimoOp(Operacion op) {
		System.out.println(op.oper(3, 1));
	}
	
	public static int resta(int i1, int i2) {
		return i1 - i2;
	}
	
}
