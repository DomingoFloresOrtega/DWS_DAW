package lambdas.teoria.platos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

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
	
	public static void ejemplo5() {
		List<String> dishNames = menu.stream() 
                .map(Dish::getName)  //Aplica a cada elemento del flujo una función, en este caso, Dish::getName
                // Mapear se puede interpretar por transformar, el elemento se mapea con el resultado de la función (se transforma)
                .collect(toList());

		dishNames.forEach(t -> System.out.println(t));
		dishNames.forEach(System.out::println);
	}
	
	public static void ejemplo6(List<Dish> menu) {
		
		String[] arrayOfWords = {"Goodbye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		
		String[] letras = "Goodbye".split("");
		
		List<String> uniqueCharacters = streamOfWords 
                .map(word -> word.split("")) 
                //.flatMap(Arrays::stream) 
                .flatMap(t -> Arrays.stream(t))
                .distinct() 
                .collect(toList());
		
		Set<String> items = new HashSet<>();
		List<String> dupliqueCharacters = Arrays.stream(arrayOfWords).map(word -> word.split(""))
				.flatMap(Arrays::stream)
				.filter(l -> !items.add(l)).collect(toList());
	}
	
	public static void ejemplo7(List<Dish> menu) {
		Optional<Dish> dish = menu.stream() 
                .filter(d -> d.getCalories()<10) 
                .findAny(); //Devuelve alguno, de tipo Optional<T>
		
		dish.ifPresent(d -> System.out.println(d));
		
		System.out.println(dish.orElse(new Dish(null, false, 0, null)));
		
		if (dish != null) {
			
		}

	}
	
	public static void ejemplo8(List<Dish> menu) {
		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		
		int sum = someNumbers.stream()
				.peek(t -> System.out.println(t) )
                .reduce(0, (a, b) -> a + b);
		
		System.out.println(sum);
		
		int totalCalorias = menu.stream().map(Dish::getCalorias)
			.reduce(0,Integer::sum);
		
		System.out.println(totalCalorias);
		
		Optional<Integer> sum1 = someNumbers.stream()
                .reduce((a, b) -> (a + b));



	}
	
	public static void ejemploFrase() {
		String str = "hola mundo!";
		
		Arrays.stream(str.split("")).filter(t -> !"".equals(t));
	}
}
