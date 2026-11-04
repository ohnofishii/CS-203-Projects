// Title: Group Activity #1
// Authors: Jake Escala, Alessandro Nguyen
// Class: CS203 
// Year: Fall 26

import java.lang.String; // ...
import java.util.Scanner; // ...
import java.util.Arrays; //...
import java.io.File; // ...
import java.io.FileNotFoundException; // ...

public class Project1 {

   // Desc: Performing a Lomuto Partition to find the value that would be based on
   // the input if the array was sorted.
   // Input: An integer based on the position we are trying to find in the array.
   // Output: An integer from the array that is at the inputted position.
   private static int lomutoPartition(int position, int[] array) {
      // Step 1: Select the pivot (last element of array)
      int pivot = array.length - 1;

      if (position >= array.length) {
         return -1;
      } else {
         // Step 2: Create pointer 1 (will start at -1)
         int i = -1;
         // Step 3: Create pointer 2 (will start at 0)
         int j = 0;

         // Step 4: if pointer 2 < pivot => swap pointers 1 and 2 and increment pointer 1
         for (j = 0; j < array.length; j++) {
            // Moving whatever number we see to be on the left side if it is less than the
            // pivot
            if (array[j] < pivot) {
               // Swapping j and i
               int temp = j;
               j = i;
               i = temp;
               // Incrementing i
               i++;
            }
            // Step 5: Mark traversal complete
            if (j == array.length) {
               // Swapping i with the pivot
               int temp = i;
               i = pivot;
               pivot = temp;
            }
         }

         int foundPosition = array[position] - 1;

         return foundPosition;
      }
   }

   public static void main(String args[]) {
      /*
       * String fileName = args[0]; // Reading file name from command line argument.
       * 
       * // Doing a try-catch to determine if provided file is valid to read.
       * try {
       * // Creating a scanner taking the file name
       * Scanner scannerInputFile = new Scanner(new File(fileName));
       * // int lineCount = 0; // DEBUG: creating int to count # of lines in .txt
       * 
       * while (scannerInputFile.hasNextLine()) {
       * // lineCount++; // DEBUG: read line and increment by 1
       * String inputFileLine = scannerInputFile.nextLine(); // move to next line
       * 
       * // NOTE: probably not need, but can reuse to read the given verticies and
       * edges
       * String[] parts = inputFileLine.split(")");
       * System.out.println("Echo: " + parts[0]); // DEBUG: Printing the first part.
       * }
       * } catch (Exception e) { // TODO: Change exeption class.
       * // ...
       * }
       */
      int sampleArr[] = {7, 2, 1, 9, 6, 5, 3, 8}; // array from the example in instructions

      int position = 4; // desired position we want to get from the array

      int results = lomutoPartition(position, sampleArr); // find the number at postion 4

      System.out.println("Sample array: " + Arrays.toString(sampleArr));

      System.out.println("k=" + position);

      if (results == -1)
      {
         System.out.println("Position is out of bounds.");
      }
      else
      {
         System.out.println("Lomuto Partition output at position: " + position + " is " + results);
      }

      // scannerInputFile.close(); // Closing scanner.
   }
}