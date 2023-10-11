package de.hs_el.streekmann.algodat.aufgabe2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ListUsingStackTest {
    private Stack<Integer> stack;
	
	@BeforeEach
	void beforeEach() {
		stack = new ListUsingStack<>();
	}
    @Test
    void testPopEmptyStack() { 
        //Testet ob bei leerem Stack und pop die Empty Stack Exception geworfen wird
        assertThrows(EmptyStackException.class, () -> stack.pop());     
    }

	@Test
    void testPushPeek() {
        //Testet ob Push und Peek funktionieren
        stack.push(5);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    void testPopPeek() {
        //Testet ob Pop und Peek funktionieren
        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.pop();
        assertEquals(2, stack.pop());
        stack.pop();
        stack.push(420);
        assertEquals(420, stack.peek());
    }
    
    @Test
    void testPushPopPeek() {
        //Testet ob Push, Pop und Peek funktionieren
        assertEquals(5, stack.push(5));
        stack.push(589);
        stack.push(6);
        assertEquals(6, stack.pop());
        assertEquals(589, stack.peek());
    }

    @Test
    void testPeek() {
        //Testet ob Peek funktioniert
        assertThrows(EmptyStackException.class, () -> stack.peek());
        stack.push(69);
        assertEquals(69, stack.peek());
    }

    @Test
    void testEmpty() {
        //Testet ob Empty funktioniert
        assertTrue(stack.empty());
        stack.push(69);
        assertFalse(stack.empty());
        stack.pop();
        assertThrows(EmptyStackException.class, () -> stack.pop());     
    }

    @Test
    void testPop() {
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.pop());
    }
}
