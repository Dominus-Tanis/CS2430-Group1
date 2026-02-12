package project1CS2430;

public class Sorter {
	 static void sortheap(int[] arr, int n, int i) {
//	    	System.out.println("printing heapsort..."); // p.c.
//	    	System.out.println("n="+n+", i="+i); // p.c.
	        // largest is set to i to setup the variable for comparisons later
//	    	System.out.println(i); // p.c.
	        int largest = i;

	        // left index = 2*i + 1
	        int left = 2 * i + 1;
//	        System.out.println(left); // p.c.

	        // right index = 2*i + 2
	        int right = 2 * i + 2;
//	        System.out.println(right); // p.c.
	        
	        // if left subtree is bigger than root
	        if (left < n && arr[left] > arr[largest]) {
	            largest = left;
//	            System.out.println("left child is larger: "+arr[largest]); // p.c.
	        }
	        // if right subtree is bigger than root
	        if (right < n && arr[right] > arr[largest]) {
	            largest = right;
//	            System.out.println("right child is larger: "+arr[largest]); // p.c.
	        }

	        //if the root got replaced by a child node, set new largest and run again
//	        System.out.println("largest is not root"); // p.c.
	        if (largest != i) {
//	        	System.out.println("largest does not equal i, "+arr[largest]+", "+arr[i]); // p.c.
	            
	        	int temp = arr[i];
//	            System.out.println("printing temp = arr[i]"+arr[i]); // p.c.
	            
	            arr[i] = arr[largest];
//	            System.out.println("printing arr[i] = arr[largest]"+arr[i]); // p.c.
	            
	            arr[largest] = temp;
//	            System.out.println("printing arr[largest] = temp"+arr[largest]); // p.c.

//	            System.out.println("heapsort recursing..."); // p.c.
//	            System.out.println("i = largest"); // p.c.
	          
	            sortheap(arr, n, largest);
//	            System.out.println(""); // p.c.
	        }
	        // printed for clarity
//	        else {
//	        	System.out.println("largest did equal i, "+arr[largest]+", "+arr[i]); // p.c.
//	       	System.out.println(""); // p.c.
//	        }
	    }
}
