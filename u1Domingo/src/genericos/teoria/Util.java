package genericos.teoria;

public class Util {
	
	public static <K,V> boolean compare(Par<K,V> par1, Par<K,V> par2) {
		
		return par1.getClave().equals(par2.getClave()) && par1.getValor().equals(par2.getValor());
		
	}
	
	public static void main(String[] args) {
		
		Par<Integer, String> par1 = new ParImpl<Integer, String>(Integer.valueOf(1), "Pera");
		Par<Integer, String> par2 = new ParImpl<Integer, String>(Integer.valueOf(2), "Manzana");
		
		boolean mismo = Util.<Integer, String>compare(par1, par2);
		
		System.out.println("Mismo: " + mismo);
		
	}

}

