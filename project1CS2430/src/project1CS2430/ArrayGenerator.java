package project1CS2430;
/**
 * Description:The Array Generator has been built when given an array to return the next 
 * lexicographically greater permutation of the array.
 * 
 * Contributers: GeeksForGeeks SpencerJPeck
 * Contributions:
 * 	GeeksForGeeks: Origin Code
 * 	SpencerJPeck: Adaptation and Documentation for current Project
 */
public class ArrayGenerator {

	/**
	 * Provided with an integer array and two indices this method
	 *  swaps the "Left" index with the "Right" index.
	 * @param data An int array to be mutated.
	 * @param left The first or "Left" index.
	 * @param right The second or "Right" index.
	 * @return The mutated array.
	 */
    private static int[] swap(int data[], int left, int right)
    {

        // Swap the provided indices
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;

        // Return the updated array
        return data;
    }

    /**
     * Provided with an array and two indices this method
     * reverses the order of all indices between the first and the second indexes
     * including the provided indices.
     * @param data An int array.
     * @param left The starting index.
     * @param right The ending index.
     * @return The mutated array.
     */
    private static int[] reverse(int data[], int left, int right)
    {

        // Reverse the sub-array
        while (left < right) {
            int temp = data[left];
            data[left++] = data[right];
            data[right--] = temp;
        }

        // Return the updated array
        return data;
    }

    /**
     * Creates an array of size n starting at 0 where each element is +1 of the previous element.
     * This array serves as the first lexicographically permeation of those numbers. 
     * @param n The size of array you wish to create.
     * @return array of size n starting at 0 where each element is +1 of the previous element.
     */
    public static int[] firstPermutation(int n) {
    	//If the passed number would create an empty array 
    	//or an array with negative length return an empty array.
    	if( n < 1) {return new int[0];}
    	//If a positive non zero number was passed, create an array with ascending values.
    	else {
    		//Create return array
    		int[] data = new int[n];
    		
    		//Loop through n times adding the iteration count at the respective index
    		for(int i = 0; i < n; i++) {
    			data[i] = i;
    		}
    		return data;
    	}
    }
    
    /**
     * Provided with an int array this method finds
     * the next lexicographically greater permutation of the provided array.
     * Doing this repeatedly will result in unique arrays.
     * Should there be no lexicographically greater permutation this method will return false.
     * @param data An int array to base the next permutation.
     * @return True, if the operation mutated the provided array into greater permutation.
     * @return False, if no greater permutation exists.
     */
    public static boolean findNextPermutation(int data[])
    {

        // If the given dataset is empty
        // or contains only one element
        // next_permutation is not possible
        if (data.length <= 1)
            return false;

        int last = data.length - 2;

        // find the longest non-increasing suffix
        // and find the pivot
        while (last >= 0) {
            if (data[last] < data[last + 1]) {
                break;
            }
            last--;
        }

        // If there is no increasing pair
        // there is no higher order permutation
        if (last < 0)
            return false;

        int nextGreater = data.length - 1;

        // Find the rightmost successor to the pivot
        for (int i = data.length - 1; i > last; i--) {
            if (data[i] > data[last]) {
                nextGreater = i;
                break;
            }
        }

        // Swap the successor and the pivot
        data = swap(data, nextGreater, last);

        // Reverse the suffix
        data = reverse(data, last + 1, data.length - 1);

        // Return true as the next_permutation is done
        return true;
    }
}
