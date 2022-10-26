package lambdas.teoria.platos;

public class Dish {
	String name;
	double calorias;
	boolean disponible;
	
	public Dish(String name, double calorias, boolean disponible) {
		this.name = name;
		this.calorias = calorias;
		this.disponible = disponible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	
}
