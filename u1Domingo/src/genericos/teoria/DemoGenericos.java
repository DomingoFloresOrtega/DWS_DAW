package genericos.teoria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DemoGenericos {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(Integer.parseInt("1"));
		
		Integer i = list.iterator().next();

	}

}
