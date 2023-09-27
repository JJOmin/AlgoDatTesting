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
    void testPushPeak() {
        stack.push(5);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    void testPop() {
        stack.push(5);
        stack.push(2);
        stack.push(6);
        stack.pop();
        assertEquals(2, stack.pop());
    }
    
    @Test
    void testPopEmpty() {
        stack.push(5);
        stack.pop();
        assertEquals(null, stack.peek());
    }

    @Test
    void testEmptyUsed() {
        stack.push(5);
        assertEquals(false, stack.empty());
    }

    @Test
    void testEmptyUnused() {
        assertEquals(true, stack.empty());
    }
}
