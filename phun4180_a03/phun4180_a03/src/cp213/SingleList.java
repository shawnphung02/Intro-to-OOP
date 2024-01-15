package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> value contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author your name, id, email here
 * @version 2022-10-26
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The value to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {
    	// Create address for iterating
    	SingleNode<T> prev = null;
    	SingleNode<T> curr = this.front;
    	boolean isFound = false;
    	
    	// Iterate through list
    	while(!isFound && curr != null) {
    		// Key is found
    		if(curr.getDatum().compareTo(key) == 0) {
    			isFound = true;
    		}else {
    			// Key not found
    			prev = curr;
    			curr = curr.getNext();
    		}
    	}
    	// If key not found
    	if(!isFound) {
    		prev = null;
    	}
	return prev;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param datum The value to append.
     */
    public void append(final T datum) {

    	SingleNode<T> node = new SingleNode<T>(datum, null);
		if (this.front == null && this.rear == null) {
			this.front = node;
		} else {
			this.rear.setNext(node);
		}
		this.rear = node;
		this.length++;
	
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each value formerly present in this SingleList. The first occurrence of
     * each value is preserved.
     */
    public void clean() {

    	SingleNode<T> temp1 = this.front;
    	SingleNode<T> temp2 = null;
    	SingleNode<T> dupe = null;
    	
    	// Iterate through list
    	while(temp1  != null && temp1.getNext() != null) {
    		temp2 = temp1;
    		// Iterate through second list
    		if (temp1.getDatum().compareTo(temp2.getNext().getDatum()) == 0) {
				dupe = temp2.getNext();
				temp2.setNext(temp2.getNext().getNext());
				this.length--;
			} else {
				temp2 = temp2.getNext();
			}
		}
		temp1 = temp1.getNext();
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

        int leftL = left.length;
        int rightL = right.length;
        int counter = leftL + rightL;
        while (counter != 0) {

            if (!left.isEmpty()) {
                this.moveFrontToFront(left);
                counter--;
            }
            if (!right.isEmpty()) {
                this.moveFrontToFront(right);
                counter--;
            }
        }
        return;
	}
    	
    

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key value to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {
    	
    	boolean contain = false;
		// Check if key exists in list
		SingleNode<T> value = this.linearSearch(key);
		// If linear search returns not null, key is found, otherwise false
		if (value != null) {
			contain = true;
		}

	return contain;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The value to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

    	int count = 0;
    	// Non-empty List
    	if(this.length > 0) {
    		// Create node to iterate through list
    		SingleNode<T> node = this.front;
    		int i = 0;
    		// Iterate through list
    		while(i < this.length) {
    			if(node.getDatum().compareTo(key) == 0) {
    				// Node matches with key, increment count
    				count ++;
    			}
    			node = node.getNext();
    			i ++;
    		}
    	}

	return count;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {

		SingleNode<T> head = this.front;
		T value = null;

		while (!this.isEmpty()) {
			if (this.front.getDatum() == key) {
				value = this.front.getDatum();
				break;
			} else {
				this.front = this.front.getNext();
			}
		}
		this.front = head;
	return value;

    }

    /**
     * Get the nth item in this SingleList.
     *
     * @param n The index of the item to return.
     * @return The nth item in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

		int index = 0;
		SingleNode<T> node = this.front;
		// Iterate through list based on n
		while(index < n) {
			node = node.getNext();
			index ++;
		}
	// Reached n, get value of node
	return node.getDatum();
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same values in the same order as
     *         source, false otherwise.
     */
    public boolean identical(final SingleList<T> source) {

		boolean isIdentical = true;
		// Check list lengths
		if(this.length != source.length) {
			isIdentical = false;
		}else {
			int index = 0;
			// Create addresses for iterating
			SingleNode<T> thisNode = this.front;
			SingleNode<T> sourceNode = source.front;
			// Iterate through lists and compare
			while(index < this.length && isIdentical) {
				if(thisNode.getDatum().compareTo(sourceNode.getDatum())!= 0) {
					// Nodes don't match
					isIdentical = false;
				}
				thisNode = thisNode.getNext();
				sourceNode = sourceNode.getNext();
				index ++;
			}
		}

	return isIdentical;
    }

    /**
     * Finds the first location of a value by key in this SingleList.
     *
     * @param key The value to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

		int index = 0;
		boolean found = false;
		SingleNode<T> node = this.front;
		while (!found && index < this.length) {
			if (node.getDatum().compareTo(key) == 0) {
				found = true;
			} else {
				index++;
				node = node.getNext();
			}
		}

		if (!found) {
			index = -1;
		}
		return index;
	}

    /**
     * Inserts value into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i     The index to insert the new data at.
     * @param datum The new value to insert into this SingleList.
     */
    public void insert(int i, final T datum) {

    	SingleNode<T> node = new SingleNode<T>(datum, null);
    	// Insert to rear
    	if (this.length <= i) {
    		// Rear empty
    		if(this.rear == null) {
    			this.front = node;
        		this.rear = node;
    		}else {
    		// Rear not empty
    			this.rear.setNext(node);
    			this.rear = node;
    		}
    		
    	}else if(i == 0) {
    		// Insert to front
    		node.setNext(this.front);
    		this.front = node;
    	}else {
    		// Insert in middle
    		SingleNode<T> curr = this.front;
    		// Iterate until i index
    		for(int j = 1; j < i; j++) {
    			curr = curr.getNext();
    		}
    		// Insert
    		node.setNext(curr.getNext());
    		curr.setNext(node);
    	}
    	// Update list
    	this.length ++;
    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then values from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {
    	// Node to iterate through left list
		SingleNode<T> node = left.front;
		// Iterate through list
		for(int i = 0; i < left.length; i++) {
			// Node exists in both list
			if(right.contains(node.getDatum())) {
				this.append(node.getDatum());
			}
			node = node.getNext();
		}
    }

    /**
     * Finds the maximum value in this SingleList.
     *
     * @return The maximum value.
     */
    public T max() {
		T max = null;
		// Iterate through list
		if (this.length > 0) {
			max = this.front.getDatum();
			SingleNode<T> curr = this.front;
			while (curr.getNext() != null) {
				if (curr.getDatum().compareTo(max) >= 0) {
					max = curr.getDatum();
				}
				curr = curr.getNext();
			}
		}

		return max;
    }

    /**
     * Finds the minimum value in this SingleList.
     *
     * @return The minimum value.
     */
    public T min() {
		// Set min value to front value
    	T min = null;
    	// Iterate through list
        if (this.length > 0) {
            min = this.front.getDatum();
            SingleNode<T> curr = this.front;
            while (curr.getNext() != null) {
                if (curr.getDatum().compareTo(min) <= 0) {
                    min = curr.getDatum();
                }
                curr = curr.getNext();
            }
        }

        return min;
    }

    /**
     * Inserts value into the front of this SingleList.
     *
     * @param datum The value to insert into the front of this SingleList.
     */
    public void prepend(final T datum) {
    	SingleNode<T> node = new SingleNode<T>(datum, null);
    	// Set front
    	this.front = node;
    	// If there's no rear, update rear
    	if(this.rear == null) {
    		this.rear = this.front;
    	}
    	// Update length
    	this.length++;
    }

    /**
     * Finds, removes, and returns the value in this SingleList that matches key.
     *
     * @param key The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {

    	boolean isFound = false;
    	SingleNode<T> curr = this.front;
    	SingleNode<T> prev = null;
    	T match = null;
    	// List not empty
    	if(curr != null) {
    		// Key found
    		if (curr.getDatum().compareTo(key) == 0) {
    			isFound = true;
    			match = curr.getDatum();
    			prev = curr.getNext();
    		}
    		while(!isFound) {
    			if(curr.getNext() != null) {
	    			prev = curr;
	    			curr = curr.getNext();
	    			if(curr.getDatum().compareTo(key) == 0) {
	    				isFound = true;
	    				match = curr.getDatum();
	    				prev.setNext(curr.getNext());
	    			}
    			}else {
    				break;
    			}
    		}
    		if(isFound) {
    			this.length --;
    		}
    	}
	return match;
    }

    /**
     * Removes the value at the front of this SingleList.
     *
     * @return The value at the front of this SingleList.
     */
    public T removeFront() {

		SingleNode<T> node = this.front;
		// Update front and length
		this.front = this.front.getNext();
		this.length --;
		
		// If list empty, update rear
		if(this.length == 0) {
			this.rear = null;
		}
		
	return node.getDatum();
    }

    /**
     * Finds and removes all values in this SingleList that match key.
     *
     * @param key The value to search for.
     */
    public void removeMany(final T key) {

    	SingleNode<T> prev = this.front;
    	SingleNode<T> curr = this.front;	
		int x = 0;
		// Iterate through list
		while (x < this.length) {
			if (curr.getDatum().compareTo(key) == 0) {
				// Key found
				if (curr == this.front) {
					this.front = this.front.getNext();
					curr = this.front;
				}
				else {
					prev.setNext(curr.getNext());
					if (curr == this.rear) {
						this.rear = prev;
					}
					curr = curr.getNext();
				}
				this.length--;
			}
			else {
				prev = curr;
				curr = curr.getNext();
				x++;
			}
		}
		// Update empty list
		if (this.front == null) {
			this.rear = null;
		}

    }

    /**
     * Reverses the order of the values in this SingleList.
     */
    public void reverse() {
    	SingleNode<T> next;
		SingleNode<T> prev = null;
		SingleNode<T> curr = this.front;
		// Iterate through list
		for (int i = 0; i <this.length; i++) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}		
		next = this.front;		
		this.front = this.rear;		
		this.rear = next;
		
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * item than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

		int change = this.length / 2;
		// Iterate through list
		while(this.length > 0) {
			if(this.length > change) {
				left.moveFrontToRear(this);
			}else {
				right.moveFrontToRear(this);
			}
		}

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move value or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {
    	// Iterate through list
    	while(this.length > 0) {
    		// Append to left
    		left.moveFrontToRear(this);
    		if(this.length > 0) {
    			// If not empty, append to right
    			right.moveFrontToRear(this);
    		}
    	}

    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies value
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then values from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {
    	SingleNode<T> tempLeft = left.front;
    	SingleNode<T> tempRight = right.front;
    	// Iterate through left
    	while(!left.isEmpty()) {
    		this.append(left.front.getDatum());
    		left.front = left.front.getNext();
    	}
    	// Iterate through right
    	while(!right.isEmpty()) {
    		this.append(right.front.getDatum());
    		right.front = right.front.getNext();
    	}
    	// Update left and right
    	left.front = tempLeft;
    	right.front = tempRight;
	return;
    }
}
