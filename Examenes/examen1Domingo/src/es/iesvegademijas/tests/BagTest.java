package es.iesvegademijas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.iesvegademijas.genericos.Bag;

class BagTest {

	@Test
	void testAllList() {
		Bag bagList = new Bag();
		
		System.out.println(bagList.toString());
	}
	
	@Test
	void testAddList() {
		Bag bagList = new Bag();
		
		bagList.add(3);
		
		System.out.println(bagList.toString());
	}
	
	@Test
	void testRemoveList() {
		Bag bagList = new Bag();
		
		bagList.remove(3);
		
		System.out.println(bagList.toString());
		
		bagList.remove(3,2);
		
		System.out.println(bagList.toString());
	}

}
