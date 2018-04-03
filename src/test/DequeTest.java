package test;

import core.BaseDeque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DequeTest {
	
	private BaseDeque<Integer> deque;

	@BeforeEach
	void setUp() throws Exception {
		deque = new BaseDeque<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		deque = null;
	}

	@Test
	void testSize() {
		deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(15);
        deque.dequeueFront();        
        deque.enqueueBack(20);
        deque.enqueueBack(10);
        deque.dequeueFront();
		assertEquals(3, deque.size(), "Size should be equal to 3.");
	}
	
	@Test
	void testContents() {
		deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(15);
        deque.dequeueFront();        
        deque.enqueueBack(20);
        deque.enqueueBack(10);
        deque.dequeueFront();
		assertEquals("10 20 15", deque.toString(), "Contents should equal: 10 20 15.");
	}
	
	@Test
	void testContains() {
		deque.enqueueBack(10);
        assertEquals(true, deque.contains(10), "Deque contains 10 (true).");
	}
	
	@Test
	void testError() {
		Throwable e = assertThrows(
				NullPointerException.class, () -> deque.enqueueFront(null));
		assertEquals("Element parameter required.", e.getMessage());
	}

}
