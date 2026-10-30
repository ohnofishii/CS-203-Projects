// Jake Escala, Alessandro Nyguy

import java.lang.String; // ...
import java.util.Scanner; // ...
import java.io.File; // ...
import java.io.FileNotFoundException; // ...

public class Project1 {
   public static void Main(String args[]){
      String fileName = args[0];
      
      try{
            Scanner scannerInputFile = new Scanner( new File( fileName ) );
            int lineCount = 0; //Debug
            while( scannerInputFile.hasNextLine() ) {
            lineCount++;
            String inputFileLine = scannerInputFile.nextLine();
            
            String[] parts = inputFileLine.split(")");
            System.out.println("Echo: " + parts[0] );
         }
      }
      catch(Exception e){
      }
   }
}