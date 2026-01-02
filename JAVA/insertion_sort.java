import java.util.*;

public class insertion_sort {
	public static int[] sort(int[] array) {
		// Takes in an unsorted array and returns a sorted array
		// Time complexity of O(n**2)
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int current = i - 1;
			while (current >= 0 && temp < array[current]) {
				array[current+1] = array[current];
				current -= 1;
			}
			array[current+1] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] num_array = {36,14,27,40,31};
		String num_array_string = Arrays.toString(sort(num_array));
		System.out.println(num_array_string);
	}
}