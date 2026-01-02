import java.util.*;

public class BinarySearch {
	public int binarySearchRecursive(int[] searchArray, int start, int end, int key) {
		// This method searches a binary tree for a value recursively
		// Returns the index of the key if key found in array or return -1

		int mid = (start + end) / 2;
		if (key == searchArray[mid])
			return mid;
		if (start > end)
			return -1;
		if (key < searchArray[mid]) {
			return binarySearchRecursive(searchArray, start, mid-1, key);
		} else {
			return binarySearchRecursive(searchArray, mid+1, end, key);
		}
	}

	public int binarySearchIterative(int[] searchArray, int start, int end, int key) {
		// This method searches a binary tree for a value iteratively		
		// Returns the index of the key if found in array, otherwise return -1

		int mid = (start + end) / 2;
		while (start <= end) {
			if (key == searchArray[mid])
				return mid;
			if (key < searchArray[mid]) { // key in first part
				end = mid - 1;
			} else { // key in second part
				start = mid + 1;
			}
		}
		return -1; // key not found
	}
}