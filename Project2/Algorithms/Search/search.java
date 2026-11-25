package Project2.Algorithms.Search;

public class search {
    // binary search
    public int binarySearchIterative(int[] arr, int input)
    {
        if (arr.length < 1)
        {
            return -1; // input size is zero; exit with -1 to indiciate number not found
        }

        //create left and right indicie;
        int l = 0; // l is inclusive
        int r = arr.length; // r is exclusive
        
        //loop while partition has a length
        while ( r - l > 0) {
            int m = (r - l) / 2;

            //Check if position has the number
            if( arr[m] == input  ) 
                return m;
            //Check if input is less than the positions number
            else if( input < arr[m])
                r = m;
            else // if ( arr[m] < input )
                l = m + 1;  //position m is already known; m+1 is not;
            
        }
        
        return -1; // input is not found; exit with -1 to indiciate number not found
        
    }

    public int binarySearchRecursive(int[] arr, int input)
    {   
        if (arr.length < 1)
        {
            return -1; // input size is zero; exit with -1 to indiciate number not found
        }
        return binarySearchRecursiveHelper(arr, input, 0, arr.length);
    }

    private int binarySearchRecursiveHelper(int[] arr, int input, int l, int r)
    {   
        int m = l - r;
        // check if partition length is less than 1; base case
        if( m < 1 ) return -1; 
        if( arr[m] == input  ) 
            return m;
        //Check if input is less than the positions number
        else if( input < arr[m])
            r = m;
        else // if ( arr[m] < input )
            l = m + 1;  //position m is already known; m+1 is not;
        //recursive call for next l and r positions.
        return binarySearchRecursiveHelper(arr, input, l, r);
    }

    // sequential search
    public int sequentialSearch(int[] arr, int input)
    {
        if (arr.length < 1)
        {
            return -1; // input size is zero; exit with -1 to indiciate number not found
        }

        for (int i = 0; i < arr.length ; i++)
        {
            if(arr[i] == input) return i;
        }
        return -1;  // input is not found; exit with -1 to indiciate number not found
    }

    // sequential search recursive
    public int sequentialSearchRecursive(int[] arr, int input)
    {
        if (arr.length < 1)
        {
            return -1; // input size is zero; exit with -1 to indiciate number not found
        }

        return sequentialSearchRecursiveHelper(arr, input, 0)
    }

    // sequential search recursive helper
    private int sequentialSearchRecursiveHelper(int[] arr, int input, int index)
    {
        if(arr[index] == input) return index;
        return sequentialSearchRecursiveHelper(arr, input, ++index);
    }

}
