/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * 
 * @author Steven Treadway, Acuna
 * @version 1.0
 */
import java.util.NoSuchElementException;
    
//TODO: implement.
public class BaseDeque<Item> implements Deque<Item> {
	
	private int size;
    private Node first;
    private Node last;
    
    private class Node {
        Item item;
        Node next;
        Node previous;
    }

	
	/**  
     * Adds one element to the front of this deque. 
     * @param element the element to be added to the front of the deque  
     */
    public void enqueueFront(Item element) {
    	throwNullException(element);
    	
    	Node newFirst = new Node();
        newFirst.item = element;

        if (first != null) {
            newFirst.next = first;
            first.previous = newFirst;
        }
        first = newFirst;
        if (last == null) 
        	last = first;

        size++;
    }
    
    /**  
     * Adds one element to the back of this deque. 
     * @param element the element to be added to the back of the deque  
     */
    public void enqueueBack(Item element) {
    	throwNullException(element);
    	
    	Node newLast = new Node();
        newLast.item = element;

        if (last != null) {
            newLast.previous = last;
            last.next = newLast;
        }
        
        last = newLast;
        
        if (first == null)
        	first = last;
        
        size++;
    }

    /**  
     * Removes and returns the element at the front of this deque.
     * Throws an exception if the deque is empty.
     * @return the element at the front of this deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item dequeueFront() throws NoSuchElementException {
    	throwNoElementException();
    	
    	Node oldFirst = first;
        first = first.next;

        if (first == null)
            last = null;
        else
            first.previous = null;

        size--;

        return oldFirst.item;
    }
    
    /**  
     * Removes and returns the element at the back of this deque.
     * Throw an exception if the deque is empty.
     * @return the element at the back of the deque. 
     * @throws NoSuchElementException if the deque is empty
     */
    public Item dequeueBack() throws NoSuchElementException {
    	throwNoElementException();
    	
    	Node oldLast = last;
        last = oldLast.previous;

        if (last == null)
            first = null;
        else
            last.next = null;

        size--;

        return oldLast.item;
    }

    /**  
     * Returns, without removing, the element at the front of this deque.
     * Should throw an exception if the deque is empty.
     * @return the first element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item first() throws NoSuchElementException {
    	return first.item;
    }
    
    /**  
     * Returns, without removing, the element at the back of this deque.
     * Should throw an exception if the deque is empty.
     * @return the last element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item last() throws NoSuchElementException {
    	return last.item;
    }

    /**  
     * Returns true if a given element exists inside the deque, false
     * otherwise.
     * @return if element exists in list
     */
    public boolean contains(Item element) {
    	throwNullException(element);
    	return false;
    }
   
    /**  
     * Returns true if this deque is empty and false otherwise.
     * @return if deque empty
     */
    public boolean isEmpty() {
    	return first == null;
    }

    /**  C
     * Returns the number of elements in this deque. 
     * @return the number of elements in the deque
     */
    public int size() {
    	return size;
    }

    /**  
     * Returns a string representation of this deque. The back element
     * occurs first, and each element is separated by a space. If the
     * deque is empty, returns "empty".
     * @return the string representation of the deque
     */
    @Override
    public String toString() {
    	return "";
    }
    
    private void throwNullException(Item element) {
    	if (element == null)
    		throw new NullPointerException();
    }
    
    private void throwNoElementException()) {
        if (first == null)
            throw new NoSuchElementException();
    }


    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        BaseDeque<Integer> deque = new BaseDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());            
    }
} 