package lambdas.teoria;

public class Ejemplos {

	public static void ejemplo3() {

		// Forma anterior a Java 8
		List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegetarian) // <-> .filter( dish ->
																				// dish.isVegetarian() )
				// en filter los elementos del stream que no cumplen el predicado se eliminan
				.collect(toList());

		// Forma stream Java 8
		List<Dish> vegetarianDishes = new ArrayList<>();

		for (Dish d : menu) {
			if (d.isVegetarian()) {
				vegetarianDishes.add(d);
			}
		}

	}

	public static void ejemplo4() {
		List<Dish> specialMenu = Arrays.asList(new Dish("seasonal fruit", true, 120, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER));
//Fíjate que specialMenu está ordenado de menor a mayor calorías..

		List<Dish> filteredMenu = specialMenu.stream().takeWhile(dish -> dish.getCalories() < 320) // Selecciona hasta
																									// que deja de
																									// cumplirse por 1a
																									// vez el predicado.
				// tomaMientras (secuencialmente) -sólo con sentido en colecciones ordenadas.
				.collect(toList());
//En filteredMenu tendremos solo: seasonal fruit, prawns

	}

}
