package de.hs_el.streekmann.algodat.aufgabe2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListUsingQueueTest {
    private Queue<Integer> queue;
	
	@BeforeEach
	void beforeEach() {
		queue = new ListUsingQueue<>();
	}

	@Test
    void testEmpty() { 
        assertTrue(queue.empty());
    }

	@Test
    void testFirst() { 
		queue.enqueue(2);
        assertEquals(2,queue.first());
    }

	@Test
    void testDequeue() { 
		queue.enqueue(2);
		queue.enqueue(3);
        assertEquals(2,queue.dequeue());
    }

	@Test
    void testEnqueue() { 
        assertEquals(2,queue.enqueue(2));
		queue.enqueue(5);
		assertEquals(2,queue.first());
    }

	@Test
    void testEnqueueDequeueEmpty() { 
		assertThrows(EmptyQueueException.class, () -> queue.first());
		assertThrows(EmptyQueueException.class, () -> queue.dequeue());
		queue.enqueue(5);
		assertEquals(5,queue.dequeue());
		assertThrows(EmptyQueueException.class, () -> queue.dequeue());
		assertTrue(queue.empty());
    }

	@Test
	void emptyNot() {
		queue.enqueue(3);
		queue.enqueue(1);
		assertFalse(queue.empty());
	}
	@Test
	void testEnqueueDequeue() {
		queue.enqueue(3);
		queue.enqueue(1);
		assertEquals(3, queue.dequeue());
		queue.enqueue(2);
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertTrue(queue.empty());
	}
	


}