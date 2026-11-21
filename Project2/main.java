package Project2;
import Project2.Algorithms.Sort.sort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        sort alg = new sort();
        int[] arr = new int[100];

        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random() * arr.length);
        }

        // Debug:
        System.out.println( Arrays.toString(arr) );

        alg.mergeSort(arr);
    }
}
