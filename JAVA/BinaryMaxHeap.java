import java.util.*;

public class BinaryMaxHeap {
	// BinaryMaxHeap class implements binary maxheap data structure represented using an array.
	ArrayList<Integer> heap;
	
	public BinaryMaxHeap() {
		heap = new ArrayList<Integer>();
	}

	public int largest() {
		// Returns the largest value in the heap
		return heap.get(0);
	}

	public ArrayList<Integer> insert(int value) {
		// Inserts the value into a heap structure and return the ArrayList
		
		this.heap.add(value);
		if (this.heap.size() == 1) { // arrayList is initially empty
			return heap;
		}
		int value_index = this.heap.size() - 1;
		int parent_index;
		if (value_index % 2 == 0) { //value added as a right child
			parent_index = (value_index - 1) / 2;
		} else { // value added as a left child
			parent_index = value_index / 2;
		}		
		while(value_index > 0 && value > this.heap.get(parent_index)) { // if value_index is not root AND value is bigger than its parent			
			this.heap.set(value_index, this.heap.get(parent_index)); // move parent value to its newly added child position
			if (value_index % 2 == 0) { //value added as a right child
				value_index = (value_index - 1) / 2
				parent_index = (value_index - 1) / 2;
			} else { // value added as a left child
				value_index = value_index / 2
				parent_index = value_index / 2;
			}
		}
		this.heap.set(value_index, value);
		return heap;
	}

	public ArrayList<Integer> delete(ArrayList<Integer> newArrayList) {
		// Delete function deletes the root(item with the largest value) from a heap.
		// Return the new heap after the deletion
		
		int arraySize = newArrayList.size();
				
		newArrayList.set(0, newArrayList.get(arraySize-1)); // 0 index offset. Last element in arraylist replaces first element
		newArrayList.remove(arraySize-1);
		 // delete last element in array list
		return siftDown(newArrayList, 0, newArrayList.size());
	}

	public static ArrayList<Integer> heapify(ArrayList<Integer> newArrayList) {
		// Rearranges the data in the array newArrayList so that it represents a heap
		// Returns the new heap after rearrangement
		
		int last_index = newArrayList.size()-1;
		int parent_index;
		
		if (last_index % 2 == 0) { //last value a right child
			parent_index = (last_index - 1) / 2;
		} else { // value added as a left child
			parent_index = last_index / 2;
		}
		for(int i = parent_index; i >= 0; i--) {
			siftDown(newArrayList, i, newArrayList.size());
		}
		return newArrayList;
	}

	public static ArrayList<Integer> heapSort(ArrayList<Integer> newArrayList) {
		// Heapsort sorts the array newArrayList in nondecreasing order.
		// It uses siftDown() and heapify() algorithms to achieve intermediate outcomes
		// Returns a sorted array in nondecreasing order

		ArrayList<Integer> sortingArray = heapify(newArrayList); // make the array into a heap		
		
		for(int i = sortingArray.size()-1; i >= 1; i--) { // heap is now at indexes 0 through i - 1 after each iteration
			// Performs a swap between the first and the last element in the sub-array that is unsorted
			int temp = sortingArray.get(0);		
			newArrayList.set(0, sortingArray.get(i));
			newArrayList.set(i, temp);

			siftDown(sortingArray, 0, i); // restore the heap structure of the remaining elements
		}
		return sortingArray;
	}

	private static ArrayList<Integer> siftDown(ArrayList<Integer> newArrayList, int pos, int arraySize) {
		// The function heapify a binary heap tree indexed from 0 to arraySize-1.
		// The left and right subtrees of node at index pos are heaps. After function is executed, the subtree rooted at pos is a heap.
		// The worse case time is O(floor(lg h)). where h is the height of the tree newArrayList
		
		int maxIndex = arraySize - 1; // 0 index offset
		int temp = newArrayList.get(pos);

		while (2 * pos + 1 <= maxIndex) { // while there is a left node in heap subtree
			int child_index = 2 * pos + 1;
			if (child_index < maxIndex && newArrayList.get(child_index+1) > newArrayList.get(child_index)) { 			
				child_index += 1;
			} // child_index is now the bigger contained value of the 2 subtrees

			if (newArrayList.get(child_index) > temp) { 
				newArrayList.set(pos, newArrayList.get(child_index));
			} else {
				break; // heap structure is maintained
			}			
			pos = child_index; // go down the level to compare the new subroot			
		}
		newArrayList.set(pos, temp); // insert original root value in correct spot
		return newArrayList;
	}


	public static void main(String[] args) {
		BinaryMaxHeap newHeap = new BinaryMaxHeap();
		newHeap.insert(104);
		newHeap.insert(71);
		newHeap.insert(24);
		newHeap.insert(66);
		newHeap.insert(27);
		newHeap.insert(23);
		newHeap.insert(8);
		newHeap.insert(5);
		newHeap.insert(32);
		newHeap.insert(25);
		newHeap.insert(18);
		newHeap.insert(22);
		System.out.println(newHeap.heap);
		System.out.println(newHeap.largest());
		ArrayList<Integer> nh1 = newHeap.delete(newHeap.heap);
		System.out.println(nh1);
		
		System.out.println("======");
		
		ArrayList<Integer> unheap = new ArrayList<Integer>();
		unheap.add(3);
		unheap.add(6);
		unheap.add(10);
		unheap.add(18);
		unheap.add(8);
		unheap.add(7);
		unheap.add(25);
		unheap.add(400);
		System.out.println(newHeap.heapify(unheap));

		System.out.println("======");

		ArrayList<Integer> testingHeapSort = new ArrayList<Integer>();
		testingHeapSort.add(4);
		testingHeapSort.add(12);
		testingHeapSort.add(30);
		testingHeapSort.add(16);
		testingHeapSort.add(5);
		testingHeapSort.add(15);
		System.out.println(testingHeapSort);
		System.out.println(heapSort(testingHeapSort));
	}
}