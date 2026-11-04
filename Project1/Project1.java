// Title: Group Activity #1
// Authors: Jake Escala, Alessandro Nguyen
// Class: CS203 
// Year: Fall 26

import java.lang.String; // ...
import java.util.Scanner; // ...
import java.util.Arrays; //...
import java.io.File; // ...
import java.io.FileNotFoundException; // ...
import java.util.Arrays;

public class Project1 {
   public static void main(String args[]) {
      // problem 1:
      String fileName = args[0]; // Reading file name from command line argument.

      // Doing a try-catch to determine if provided file is valid to read.
      try {
         // Creating a scanner taking the file name
         Scanner scannerInputFile = new Scanner(new File(fileName));
         // int lineCount = 0; // DEBUG: creating int to count # of lines in .txt

         // int group for each line in txt
         int group = 1;
         while (scannerInputFile.hasNextLine()) {
            // lineCount++; // DEBUG: read line and increment by 1
            String inputFileLine = scannerInputFile.nextLine(); // move to next line
            int[] comps = part1(inputFileLine);

            // String to print
            String strComps = "{";
            // number of components
            int numOfComps = 0;
            for (int i = 0; i < comps.length; i++) {
               // check if at comps[i] is not 0
               if (comps[i] != 0) {
                  strComps = strComps + comps[i];
                  if (comps[i + 1] != 0) {
                     strComps = strComps + ", ";
                  } else {
                     strComps = strComps + "} {";
                  }

                  // check if at comps[i] is 0
               } else if (comps[i] == 0) {
                  // if the previous is also 0 then there are no more components
                  if (i - 1 >= 0 && comps[i - 1] == 0)
                     break;
                  // increase num of components
                  numOfComps++;
               }
            }
            System.out.println("Graph" + group++ + ":\n" + numOfComps + " connected components: "
                  + strComps.substring(0, strComps.length() - 1) + "\n");
         }
      } catch (java.io.IOException e) { // Exeption class: catches error if file name is not valid
         System.out.println("File name not found");
      }

      // problem 2:
      int sampleArr[] = { 7, 2, 1, 9, 6, 5, 3, 8 }; // array from the example in instructions

      int position = 4; // desired position we want to get from the array

      int results = lomutoPartition(position, sampleArr); // find the number at postion 4

      System.out.println("Sample array: " + Arrays.toString(sampleArr));

      System.out.println("k=" + position);

      if (results == -1) {
         System.out.println("Position is out of bounds.");
      } else {
         System.out.println("Lomuto Partition output at position: " + position + " is " + results);
      }
   }

   // returns the components of string s as an array of integers for main method to
   // print
   private static int[] part1(String s) {

      // Input numbers into an array
      // create array for numbers
      int[] arr = new int[s.length() * 2 / 5 + 1];
      int numPos = 0;

      // get first number in string
      // find numbers in string
      // get the starting index of the number in string
      {
         int i;
         for (i = 1; true; i++) {
            if (s.charAt(i) == ' ') {
               try {
                  arr[numPos++] = Integer.parseInt(s.substring(0, i));
               } catch (NumberFormatException e) {
                  System.out.println("String could not be parsed into an integer");
               }
               break;
            }
         }
         i = i + 1;
         for (int j = i + 2; j < s.length(); j++) {

            // location of a number is between i and j
            if (s.charAt(j) == ',') {

               // put number in array at index numPos and increase numPos by 1
               try {
                  arr[numPos++] = Integer.parseInt(s.substring(i + 1, j));

               } catch (NumberFormatException e) {
                  System.out.println("String could not be parsed into an integer");
               }

               // increase i and j for next position of number in current parethisis
               i = j;
               j = j + 1;

               // elif is for gathering the 2nd number in current parethisis
            } else if (s.charAt(j) == ')') {

               // put number in array at index numPos and increase numPos by 1
               try {
                  arr[numPos++] = Integer.parseInt(s.substring(i + 1, j));

               } catch (NumberFormatException e) {
                  System.out.println("String could not be parsed into an integer");
               }
               // increase i and j for next position of number in next parethisis
               i = j + 1;
               j = i + 1;
            }
         }
      }
      // System.out.println(Arrays.toString(arr)); //Debug

      // put different graph nodes as components within the array comp
      int[] comps = new int[arr[0] * 2];
      int compIndex = 0;

      boolean numInArr = true;
      while (numInArr == true) {
         numInArr = false;
         // check if there exists a number in arr
         for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
               numInArr = true;
               // find next nodes of the num in arr;
               compIndex = DFS(arr, comps, compIndex, arr[i], i);
               // increase compsIndex to differentiate different components;
               compIndex++;
               break;
            }
         }

         // if there is no num in arr then break out of loop
         if (numInArr == false) {
            break;
         }
      }

      // System.out.println(Arrays.toString(comps)); //Debug
      // return comps for main method to print;
      return comps;
   }

   // recursive
   // returns current compIndex
   // finds a number in arr
   // deletes it
   // calls itself if deleted an elemnt;
   // arr: the array of integers
   // comps: components of the
   // num: a "node"
   private static int DFS(int[] arr, int[] comps, int compIndex, int num, int pos) {
      int i;
      // find num in arr
      for (i = pos; i < arr.length; i++) {
         if (arr[i] == num) {
            // if in arr put in comps if not in comps
            for (int j = 0; j <= compIndex; j++) {
               if (comps[j] == num) {
                  break;
               } else if (j == compIndex) {
                  comps[compIndex++] = num;
                  break;
               }
            }

            // remove the number
            arr[i] = 0;
            // check if number is odd to find its partner
            int nextNum;
            if (i % 2 == 1) {
               nextNum = arr[i + 1];
               arr[i + 1] = 0;
            } else {
               nextNum = arr[i - 1];
               arr[i - 1] = 0;
            }
            // put nextnum in comps if not in comps
            for (int j = 0; j <= compIndex; j++) {
               if (comps[j] == nextNum) {
                  break;
               } else if (j == compIndex) {
                  comps[compIndex++] = nextNum;
                  break;
               }

            }
            // call DFS on next num
            compIndex = DFS(arr, comps, compIndex, nextNum, 1);
            // call DFS on currNum
            compIndex = DFS(arr, comps, compIndex, num, 1);
            // stop the loop;
            break;
         }
      }
      // do nothing if num is not found
      return compIndex;
   }

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
}