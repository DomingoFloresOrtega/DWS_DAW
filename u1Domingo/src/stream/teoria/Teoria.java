package stream.teoria;

import java.util.OptionalInt;

import lambdas.teoria.platos.Dish;

public class Teoria {
	OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
	//OptionalInt va a evaluar directamente a tipo primitivo int

	int max = maxCalories.orElse(1);

}
