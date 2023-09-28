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
        //Testet ob bei leerem Stack und pop die Empty Stack Exception geworfen wird
        assertTrue(stack.empty());
        //assertThrows(EmptyStackException.class, () -> stack.pop());     
    }

        @Test
    void testPeek() { 
        //Testet ob bei leerem Stack und pop die Empty Stack Exception geworfen wird
        assertThrows(EmptyStackException.class, () -> stack.peek());
    }
    
}
