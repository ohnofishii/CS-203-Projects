// Title: Group Activity #1
// Authors: Jake Escala, Alessandro Nguyen
// Class: CS203 
// Year: Fall 26

import java.lang.String; // ...
import java.util.Scanner; // ...
import java.io.File; // ...
import java.io.FileNotFoundException; // ...

public class Project1 {
   public static void Main(String args[]) {
      String fileName = args[0]; // Reading file name from command line argument.

      // Doing a try-catch to determine if provided file is valid to read.
      try {
         // Creating a scanner taking the file name
         Scanner scannerInputFile = new Scanner(new File(fileName));
         // int lineCount = 0; // DEBUG: creating int to count # of lines in .txt

         while (scannerInputFile.hasNextLine()) {
            // lineCount++; // DEBUG: read line and increment by 1
            String inputFileLine = scannerInputFile.nextLine(); // move to next line

            // NOTE: probably not need, but can reuse to read the given verticies and edges
            String[] parts = inputFileLine.split(")"); 
            System.out.println("Echo: " + parts[0]); // DEBUG: Printing the first part.
         }
      } catch (Exception e) { // TODO: Change exeption class.
         // ...
      }

      scannerInputFile.close(); // Closing scanner.
   }
}