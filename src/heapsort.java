//Required Libraries imported.
import java.util.Arrays; 
import java.util.Scanner; 

//Defining the main class with it's attributes.
public class heapsort 
{  
	int parent,left,right;
   
	//Method "heapify": predefined method used for sorting and defining parent node and other connected child nodes.
   	void heapify(int tree[], int s, int i) 
   	{ 
   		this.parent = i; 
        this.left  = 2*i + 1;  // condition for tree branch at left node
        this.right  = 2*i + 2;  // condition for tree branch at right node

        if (left < s && tree[left] > tree[parent]) // Checking for left hand using if condition.
       	{
        	parent = left ; //If  left node of the tree is greater than the parent node, swap the value.
       	}

        if (right  < s && tree[right ] > tree[parent]) // Checking for right hand using if condition.
       	{
        	parent = right ; //If  right node of the tree is greater than the parent node, swap the value.
       	}

       if (parent != i) //Checking if the current value of parent node is not equals to the initial value of the parent node.
       {
           int swap = tree[i];
           tree[i] = tree[parent];
           tree[parent] = swap;
           heapify(tree, s, parent); 
       }
   }
   	
 // Calling the main method 
   	public static void main(String[] args) 
   	{     
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); //defining "scan" for getting the inputs from the user.

   		System.out.print("Enter the size of array: "); // Getting the size of the array as input.
   		int sz = scan.nextInt();
   
   		System.out.println("\n Enter the values of array: \n"); // Inputing the value of the array.
   		int[] unsortedarray = new int[sz];

   		for(int i = 0; i < sz; i++) //Saving the array inputs to new unsorted array[i].
   		{
   			unsortedarray[i] = scan.nextInt();
   		}
   
   			heapsort H = new heapsort(); //Taking H as new heap sort.
   		
   
   		//Comment either one to check the different result.
   			
   			//For Descending Order
   			for (int i = sz / 2 - 1; i >= 0; i--)
   			H.heapify(unsortedarray, sz, i);

   			//For Ascending Order
   			for (int i=sz-1; i>=0; i--) 
   			{
   				int x = unsortedarray[0];
   				unsortedarray[0] = unsortedarray[i];
   				unsortedarray[i] = x;

   				H.heapify(unsortedarray, i, 0);
   			}
   			
   			System.out.println("Sorted array: " + Arrays.toString(unsortedarray)); // Sorted array is printed

   	}
}
	