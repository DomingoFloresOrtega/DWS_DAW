package org.iesvdm.genericos;

public class QueueTest {

	public static void main(String[] args) {
		Queue q = new Queue();
		
		// Agregar elementos a la cola
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(10);
		
		// Extraer elementos de la cola
		q.dequeue(5);
		
		// Devolver el elemento frontal
		System.out.println(q.front());
		
		// Devolver el elemento trasero
		System.out.println(q.rear());
		
		// Devolver si la cola esta vacia o no
		System.out.println("Cola vacia:" + q.vacío());
	}

}
