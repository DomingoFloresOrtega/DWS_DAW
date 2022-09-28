package genericos.teoria;

public class ParImpl<K,V> implements Par<K,V> {

	private K clave;
	private V valor;
	
	public ParImpl(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}
	
	@Override
	public K getClave() {

		return clave;
	}

	@Override
	public V getValor() {

		return valor;
	}

	public static void main(String[] args) {
		Par<Integer, String> parIntStr = new ParImpl<>(Integer.valueOf(1), "Hola mundo!");
		
		System.out.printf("Clave %d y valor %s", parIntStr.getClave(), parIntStr.getValor());
	}


}