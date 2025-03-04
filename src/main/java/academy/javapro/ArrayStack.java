package academy.javapro;

/**
 * Array-based implementation of the CustomStack interface.
 * @param <T> the type of elements in the stack
 */
public class ArrayStack<T extends Number> implements CustomStack<T> {
    // Constants for stack configuration
    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    // Static variables for tracking across all instances
    private static int totalStacks = 0;
    private static int totalElements = 0;

    // Instance variables
    private Object[] elements;  // Using Object[] since generic arrays aren't directly supported
    private int top;  // Index of the top element
    private int operationCount;  // Tracks operations on this stack
    private final int stackId;  // Unique identifier for this stack instance


    /**
     * Creates a new ArrayStack with default capacity.
     */
    public ArrayStack() {
        // TODO: Initialize the elements array with the DEFAULT_CAPACITY
        elements = new Object[DEFAULT_CAPACITY];

        // TODO: Set top to -1 (indicating an empty stack)
        top = -1;

        // TODO: Initialize operationCount to 0
        operationCount = 0;

        // TODO: Assign a unique stackId by incrementing totalStacks
        stackId = ++totalStacks;
    }

    /**
     * Adds an element to the top of the stack.
     * @param element the element to add
     */
    @Override
    public void push(T element) {
        // TODO: Increment operationCount
        operationCount++;

        // TODO: Check if the array is full (top == elements.length - 1)
        if (top == elements.length - 1) {
            resize();
        }

        // TODO: Add the element to the top of the stack
        elements[++top] = element;

        // TODO: Increment totalElements
        totalElements++;
    }

    /**
     * Removes and returns the top element from the stack.
     * @return the top element, or null if the stack is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        // TODO: Increment operationCount
        operationCount++;

        // TODO: Check if the stack is empty (isEmpty())
        if (isEmpty()) {
            return null;
        }

        // TODO: Retrieve the top element
        T popped = (T) elements[top];

        // TODO: Clear the reference in the array to help garbage collection
        elements[top] = null;

        //Moving pointer down
        top--;

        // TODO: Decrement totalElements
        totalElements--;

        // TODO: Return the popped element
        return popped;
    }
        // Placeholder return, replace with actual implementation
    

    /**
     * Returns but does not remove the top element from the stack.
     * @return the top element, or null if the stack is empty
     */
    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        // TODO: Increment operationCount
        operationCount++;

        // TODO: Check if the stack is empty (isEmpty())
        if (isEmpty()) {
            return null;
        }

        // TODO: Return the top element without removing it
        return (T) elements[top];
    }

    // Placeholder return, replace with actual implementation
    

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        // TODO: Increment operationCount
        operationCount++;

        // TODO: Return true if the stack is empty (top == -1)
        return (top == -1);
    }

        // Placeholder return, replace with actual implementation
    

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements
     */
    @Override
    public int size() {
        // TODO: Increment operationCount
        operationCount++;

        // TODO: Return the number of elements in the stack (top + 1)
        return top + 1;
    }
        // Placeholder return, replace with actual implementation
    

    /**
     * Resizes the array when it becomes full.
     */
    private void resize() {
        // TODO: Calculate the new capacity using GROWTH_FACTOR
        int newCapacity = (int) (elements.length * GROWTH_FACTOR);

        // TODO: Create a new array with the new capacity
        Object[] newArray = new Object[newCapacity];

        // TODO: Copy elements from the old array to the new array
        System.arraycopy(elements, 0, newArray, 0, elements.length);

        // TODO: Update the elements reference to point to the new array
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        
        //point elements to new array 
        elements = newArray;
    }

    /**
     * Adds the top two elements and pushes the result back onto the stack.
     * Works only for numeric types.
     */
    public void addTopTwo() {
        // TODO: Check if the stack has at least two elements (size() < 2)
        if (size() < 2) {
            return;
        }

        // TODO: Pop the top two elements
        T first = pop();
        T second = pop();

        // TODO: Add the two numbers and determine the appropriate type for the result

        // TODO: If the original elements were Integers, push the result as Integer
        if (first == null || second == null) {
            return;
        }

        // TODO: Otherwise, treat the result as a Double
        double sum = first.doubleValue() + second.doubleValue();

        // If both are integers, push the sum as an Integer
        if (first instanceof Integer && second instanceof Integer) {
            push((T) (Integer) ((int) sum));
        } else {
            // Otherwise, treat as Double
            push((T) (Double) sum);
        }
    }

    /**
     * Gets statistics for this stack instance.
     */
    public String getStats() {
        return "Stack #" + stackId + ": Size=" + size() + ", Operations=" + operationCount;
    }

    /**
     * Gets statistics across all ArrayStack instances.
     */
    public static String getGlobalStats() {
        return "Total stacks: " + totalStacks + ", Total elements: " + totalElements;
    }
}