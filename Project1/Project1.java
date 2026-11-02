// Title: Group Activity #1
// Authors: Jake Escala, Alessandro Nguyen
// Class: CS203 
// Year: Fall 26

import java.lang.String; // ...
import java.util.Scanner; // ...
import java.io.File; // ...
import java.io.FileNotFoundException; // ...
import java.util.Arrays;

public class Project1 {
   public static void main(String args[]) {
      String fileName = args[0]; // Reading file name from command line argument.
   
      // Doing a try-catch to determine if provided file is valid to read.
      try {
         // Creating a scanner taking the file name
         Scanner scannerInputFile = new Scanner(new File(fileName));
         // int lineCount = 0; // DEBUG: creating int to count # of lines in .txt
      
         while (scannerInputFile.hasNextLine()) {
            // lineCount++; // DEBUG: read line and increment by 1
            String inputFileLine = scannerInputFile.nextLine(); // move to next line            
            part1(inputFileLine);
         }
      } catch (java.io.IOException e) { //Exeption class: catches error if file name is not valid
         System.out.println("File name not found");
      }
   }
   
   private static void part1(String s){
      
      //Input numbers into an array
      //create array for numbers
      int[] arr = new int[s.length() * 2 / 5 + 1];
      int numPos = 0;
      
      //get first number in string
      for(int i = 1; true ; i++){
         if ( s.charAt(i) == ' ' ){
            try {
               arr[numPos++] = Integer.parseInt(s.substring(0, i));
            } catch(NumberFormatException e){
               System.out.println("String could not be parsed into an integer");
            }
            break;
         }
      }
      
      //find numbers in string
      //get the starting index of the number in string
      for(int i = 2; i < s.length(); i++){ //Note: loop is redunant, only gets used at the begining of the string.
         
         //find a character that is always before numbers
         if(s.charAt(i) != '('){
            continue;
         } else{
            //get final index of the number in string 
            for(int j = i + 2; j < s.length(); j++){
            
               //location of a number is between i and j
               if (s.charAt(j) == ','){
               
                  //put number in array at index numPos and increase numPos by 1
                  try {
                     arr[numPos++] = Integer.parseInt(s.substring(i + 1, j));
                     
                  } catch(NumberFormatException e){
                     System.out.println("String could not be parsed into an integer");
                  }
                  
                  //increase i and j for next position of number in current parethisis
                  i = j;
                  j = j + 1;
                 
                 //elif is for gathering the 2nd number in current parethisis
               } else if( s.charAt(j) == ')' ){
               
                  //put number in array at index numPos and increase numPos by 1
                  try {
                     arr[numPos++] = Integer.parseInt(s.substring(i + 1, j));
                     
                  } catch(NumberFormatException e){
                     System.out.println("String could not be parsed into an integer");
                  }
                  //increase i and j for next position of number in next parethisis
                  i = j + 1;
                  j = i + 1;
               }
            }
         } 
      }
      System.out.println(Arrays.toString(arr)); //Debug
      int[] components = new int[arr.length * 2];
      for(int i = 0; i < components.length; i++){
         
      }
   }
}