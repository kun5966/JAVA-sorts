package sortModule;
//import java.util.Arrays;

public class sortModule
{

	public static void main(String[] args)
	{
		// Create Variables
                int f;
                int max = 17;
                int size = 25;
                int [] newArray;
                
                // Generate an array of random numbers
                newArray = makeIntArray(size);
                
		// Calculate fibbonacci sequence
                System.out.println("Fibonacci sequence from 1 to "+max);
                for(int x = 0; x <=max; x++){
                    f = fib(x);
                    System.out.print(f + "\t");
                }
                
                // Display the unsorted array
                System.out.println("\n\nUnsorted Array:");
                for(int i = 0; i < newArray.length; i++){
                    System.out.print(newArray[i] + "\t");
                }
                System.out.println("\n\nBubble Sort:");
                
                // Call function to sort array using bubble sort                
                bubbleW(newArray);

                // Display the sorted array
                for(int j = 0; j < newArray.length; j++){
                    System.out.print(newArray[j]+"\t");
                }
                
                System.out.println("\n");
                
                // Create a new array of integers
                newArray = makeIntArray(size);
                
                // Call function to sort array using insertion sort
                System.out.println("Insertion Sort - Descending:");
                for(int i = 0; i < newArray.length; i++){
                    System.out.print(newArray[i] + "\t");
                }
                System.out.println();
                insertionSortD(newArray);
                // Display the sorted array
                for(int j = 0; j < newArray.length; j++){
                    System.out.print(newArray[j]+"\t");
                }
                System.out.println("\n");
                
                // Create a new array of integers
                newArray = makeIntArray(size);
                
                System.out.println("Insertion Sort - Ascending:");
                for(int i = 0; i < newArray.length; i++){
                    System.out.print(newArray[i] + "\t");
                }
                System.out.println();
                insertionSortA(newArray);
                // Display the sorted array
                for(int j = 0; j < newArray.length; j++){
                    System.out.print(newArray[j]+"\t");
                }
                System.out.println("\n");
                
                
                // Create a new array of integers
                newArray = makeIntArray(size);
                System.out.println("\n\nInsertion Sort:");
                for(int i = 0; i < newArray.length; i++){
                    System.out.print(newArray[i] + "\t");
                }
                System.out.println();
                shellSortD(newArray);
                for(int j = 0; j < newArray.length; j++){
                    System.out.print(newArray[j]+"\t");
                }
                // Java built-in sort method
                /*
                Arrays.sort(newArray);
                for(int j = 0; j < newArray.length; j++){
                    System.out.print(newArray[j]+"\t");
                }
                System.out.println();
                        
                */
	}
        
        
        
        
        
        
        //  Bubble sort using nested for loops
        public static void bubbleF(int[] sortMe){
            int len = sortMe.length;
            int tmp;
            for(int j = 0; j<sortMe.length; j++){
                for(int i = 0; i<len-1; i++){
                    if(sortMe[i] > sortMe[i+1]){
                        tmp = sortMe[i+1];
                        sortMe[i+1] = sortMe[i];
                        sortMe[i] = tmp;
                    }    
                }
               
            }
            
        }
        
        //  Bubble sort function using a for loop nested in a while loop
        public static void bubbleW(int[] sortMe){
            int l = 0;
            boolean swapped = true;
            int tmp;
            while(swapped){
                swapped = false;
                l++;
                for(int i = 0; i<sortMe.length - l; i++){
                    if(sortMe[i] > sortMe[i+1]){
                        tmp = sortMe[i+1];
                        sortMe[i+1] = sortMe[i];
                        sortMe[i] = tmp;
                        swapped = true;
                    } 
                }
            }
            
        }
        

        public static int fib(int n){
            if(n == 1){
                return 1;
            } else if(n == 0){
                return 0;
            } else {
                return (fib(n-1) + fib(n-2));
            }
        }
        
        
        public static int[] makeIntArray(int i){
            
            int[] tmpArray = new int[i];
            int newRandom;
            for(int j = 0; j < i; j++){
                newRandom = (int)(Math.random() * 1000 + 1);
                tmpArray[j] = newRandom;
            }
            return tmpArray;
        }
        
        
        public static void insertionSortD(int[] sortMe){
            int j;                     
            int key;               
            int i;  

            for (j = 1; j < sortMe.length; j++)    // Start with 1 (not 0)
            {
                key = sortMe[ j ];
                for(i = j - 1; (i >= 0) && (sortMe[ i ] < key); i--)   // Smaller values are moving up
                {
                    sortMe[ i+1 ] = sortMe[ i ];
                }
                sortMe[ i+1 ] = key;    // Put the key in its proper location
            }
        }
        
        public static void insertionSortA(int[] sortMe){
            int j;                     
            int key;               
            int i;  

            for (j = 1; j < sortMe.length; j++)    // Start with 1 (not 0)
            {
                key = sortMe[ j ];
                for(i = j - 1; (i >= 0) && (sortMe[ i ] > key); i--)   // Smaller values are moving down
                {
                    sortMe[ i+1 ] = sortMe[ i ];
                }
                sortMe[ i+1 ] = key;    // Put the key in its proper location
            }
        }
        
        public static void shellSortD(int[] sortMe){
            
            int key;
            int inc = (sortMe.length - 1) / 2;
            int walker, current;
            //int cycles = 0;
            while(inc > 0){
                current = inc ;
                while(current < sortMe.length){
                    key = sortMe[current];
                    walker = current - inc;
                    while((walker >= 0) && (key < sortMe[walker])){
                        sortMe[walker + inc] = sortMe[walker];
                        walker = walker - inc;
                        //cycles += 1;
                    }
                    sortMe[walker + inc] = key;
                    current += 1;
                    //cycles += 1;
                }
                inc = inc / 2;
                //cycles += 1;
            }
            //System.out.println(cycles);
        }
        
}