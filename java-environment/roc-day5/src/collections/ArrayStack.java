package collections;

public class ArrayStack {
	/*
	 * This is the array in question...we create an array
	 * and arbitrarily set its size to 5
	 */
	private Integer[] stack = new Integer[5];
	
	/*
	 * This keeps track of the size of our array. 
	 * 'lastElementIndex' is a bit of a misnommer...
	 * this number will always be 1 higher than the
	 * index of the last element in the array.
	 * 
	 * See below for more details
	 */
	private int lastElementIndex = 0;
	
	/*
	 *  A push method used to add elements to the end of 
	 *  our ArrayStack
	 */
	public void push(int element) {
		/*
		 * Since arrays cannot change their size in Java
		 * we have to manually increase the size
		 * 
		 * To do this we will first check if the current 
		 * stack is full by using 'lastElementIndex'
		 */
		if (lastElementIndex >= stack.length) {
			/*
			 * If so...
			 * Create a new, temporary, array which we will
			 * use to hold data while we increase the size 
			 * of our array
			 * 
			 * We will arbitrarily make this temporary array 
			 * 2x bigger than our current stack
			 */
			Integer[] tempStack = new Integer[stack.length * 2];
			
			/*
			 * Now, we will loop through all the elements of
			 * our stack, and add them to our temporary stack.
			 * 
			 * Note: There are some built-in method that can
			 * handle this, but we are doing this manually to
			 * illustrate the thought process
			 */
			for (int j = 0; j<stack.length; j++) {
				tempStack[j] = stack[j];
			}
			
			/*
			 * Now, we reassign the 'stack' reference variable
			 * to the memory address of the temporary stack we
			 * created. This effectively removes the previous
			 * array in favor of the new information
			 * 
			 * 
			 * 
			 * [1,2,3,4,5,6,7,8,9,10]
			 * [1,2,3,4,5,6,7,8,9,10, , , , , , , , , ,]
			 */
			
			stack = tempStack;
		}
		
		/*
		 * If we have enough space in our array, or 
		 * after expanding the size of our array, the 
		 * new element is added to the end of our stack
		 */
		stack[lastElementIndex] = element;
		
		/*
		 * Finally, increase last element index. Note that 
		 * this is why lastElementIndex is always 1 higher 
		 * than the last index of our stack
		 */
		lastElementIndex++;
	}
	
	/*
	 * The pop function 'Removes' the last element from 
	 * the array...
	 * This is accomplished by decreasing 'lastElementIndex'
	 * 
	 * Note: This does not actually remove the information
	 * from the array...instead, by decreasing 'lastElementIndex'
	 * we effectively remove it because we do not provide 
	 * a means to access this information otherwise. We limit
	 * interaction with our stack to the 'push', 'pop' or 
	 * 'peek' methods, which all use the 'lastElementIndex' 
	 * variable to reference data in the stack.
	 * 
	 * If we decrease 'lastElementIndex' we have changed what 
	 * our methods see as the 'lastItem' of our collection. 
	 * 
	 * Functionally, our user will never know this difference.
	 * This is another example of abstraction!
	 */
	public Integer pop() {
		if (lastElementIndex > 0) {
			return stack[--lastElementIndex];
		} else {
			return null;
		}
	}

	// View the last element in the stack
	public Integer peek() {
		if (lastElementIndex > 0)
			return stack[lastElementIndex - 1];
		
		return null;
	}
}
