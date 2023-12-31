package de.hs_el.streekmann.algodat.aufgabe2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LinkedStackTest {
    private Stack<Integer> stack;
	
	@BeforeEach
	void beforeEach() {
		stack = new LinkedStack<>();
	}
    @Test
    void testEmpty() { 
        assertTrue(stack.empty());
    }

    @Test
    void testPeek() { 
        //Testet ob bei leerem Stack und pop die Empty Stack Exception geworfen wird
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }

   

    @Test
    void testPush() { 
        assertEquals(1, stack.push(1));
    }

    @Test
    void testPopEmpty() { 
        assertThrows(EmptyStackException.class, () -> stack.pop());
        stack.push(5);
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void testPushPopPeek() { 
        stack.push(5);
        assertEquals(1, stack.push(1));
        stack.pop();
        assertEquals(5, stack.peek());
    }

    @Test
    void testPeekEmpty() { 
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }
     @Test
    void testPeekAnna() {
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.peek());
    }
    @Test
    void testIsEmpty() {
        assertTrue(stack.empty());
        stack.push(3);
        assertFalse(stack.empty());
    }
    @Test
    void testPushPeek() {
    stack.push(3);
    stack.push(1);
    assertEquals(1, stack.peek());
    stack.push(2);
    assertEquals(2, stack.peek());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.peek());
    assertEquals(1, stack.pop());
    assertEquals(3, stack.peek());
    assertEquals(3, stack.pop());
    assertTrue(stack.empty());
    }
    @Test
    void testPushPop() {
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.pop());
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertTrue(stack.empty());
    }
    @Test
    void testPop() {
        stack.push(3);
        stack.push(1);
        assertEquals(1, stack.pop());
    }
    
}
