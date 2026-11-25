package Project2.Algorithms.Sort;

import java.util.Arrays;

public class sort {
    private int count;
    // TODO: add a timer to track the time it takes to execute (probably somehting outside this file that will manage it)

    // Desc: Performing insertion sort
    // Input: An array
    // Output: A sorted array using insertion sort
    public void insertionSort(int arr[]) 
    {
        int length = arr.length;

        if (length < 2)
        {
            return; // input array is empty nor does it have more than 1 number; exit
        } 
        else
        {
            for (int i = 1; i < length; ++i)
            {
                int fastPointer = arr[i]; // setting the fast pointer
                int slowPointer = i - 1; // setting the slow pointer (behind the fast pointer)

                // do the comparisons; if slow pointer is greater than fast pointer, then swap the pointers
                while (slowPointer <= 0 && arr[slowPointer] > fastPointer)
                {
                    arr[slowPointer + 1] = arr[slowPointer]; // move slow pointer to be in fast pointer's position
                    slowPointer = slowPointer - 1; // move slow pointer behind the fast pointer's new position.
                    count++; // counting amount of comparisons done
                }

                arr[slowPointer + 1] = fastPointer; // set fast pointer to be ahead of slow pointer's position 
            }
        }
    }

    // Desc: Performing selection sort
    // Input: An array
    // Output: A sorted array using selection sort
    public void selectionSort(int arr[])
    {
        int length = arr.length;

        if (length < 2)
        {
            return; // input array is empty nor does it have more than 1 number; exit
        }
        else
        {
            for (int i = 0; i < length - 1; i++)
            {
                int minIndex = i; // taking the 1st index as an assumption for the minimum number

                // looping through to compare all values in the array 
                // to find if there is a smaller number than the first index's value
                for (int j = i + 1; j < length; j++)
                {
                    if (arr[j] < arr[minIndex])
                    {
                        // when the compared number is less than the index, update the minimum index to be that smaller number
                        minIndex = j;
                        count++; // counting amount of comparisons done
                    }
                }

                // swapping the minimum value to correct position
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Desc: Performing bubble sort
    // Input: An array
    // Output: A sorted array using bubble sort
    public void bubbleSort(int arr[])
    {
        int length = arr.length;

        if (length < 2)
        {
            return; // input array is empty nor does it have more than 1 number; exit
        }
        else
        {
            for (int i = 0; i < length - 1; i++)
            {
                for (int j = 1; j < length - 1 - i; j++)
                {
                    // comparing if the value ahead is greater than the one before
                    if (arr[j+1] < arr[j])
                    {
                        // swapping the values' position
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        count++; // counting the comparisions done
                    }
                }
            }
        }
    }

    // Desc: Performing an optimized version of bubble sort
    // Input: An array
    // Output: A sorted array using optimized bubble sort
    public void optimizedBubbleSort(int arr[])
    {
        int length = arr.length;

        if (length < 2)
        {
            return; // input array is empty nor does it have more than 1 number; exit
        }
        else
        {
            for (int i = 0; i < length - 1; i++)
            {
                boolean swapped = false; // initializing flag
                for (int j = 1; j < length - 1 - i; j++)
                {
                    // comparing if the value ahead is greater than the one before
                    if (arr[j+1] < arr[j])
                    {
                        // swapping the values' position
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                        count++; // counting the comparisons done
                    }
                }
                if (!swapped)
                {
                    return;
                }
            }
        }
    }

    // Desc: Performing merge sort
    // Input: An array
    // Output: A sorted array using merge sort
    public void mergeSort(int[] arr)
    {
        mergeSortRecursive(arr, 0, arr.length);
        // Debug:
        // System.out.println( Arrays.toString(arr) );
    }

    // Desc: uses l and r to partition the array,
    // l is inclusive, r is exclusive
    // Input: An array, left index, and right index 
    // Output: applies changes to arr
    private void mergeSortRecursive(int[] arr, int l, int r)
    {   
        //get the middle of the partition
        int m1 = (r - l)/2 + l;
        int m2 = m1;
        
        //Check if size of partition is greater than 1;
        if(r - l > 1){
        mergeSortRecursive(arr, l, m1);
        mergeSortRecursive(arr, m1, r);
        }

        // Create a temporary array with a size of r - l;
        int[] tempArr = new int[r-l];
        int tempArrIndex = 0;
        

        //Create a placeholder variable to not change l
        int l2 = l;
        //Sort the left and right arrays into a temporary array;
        //loop through both left and right simultaniusly
        //Check if left and right index is smaller than size of its partition
        while (l2 < m1 || m2 < r) {
        //Check if l2 is in bounds
        if(  l2 < m1 )
        {
            //Check if m2 is in bounds
            if ( m2 < r)
            {
                //check if arr[l2] less than or equal to arr[m2]
                if( arr[l2] <= arr[m2] )
                {
                    tempArr[tempArrIndex++] = arr[l2];
                    l2++;
                }
                else //arr[m2] is greater than arr[l2]
                {
                    tempArr[tempArrIndex++] = arr[m2];
                    m2++;
                }

            } else
            {
                tempArr[tempArrIndex++] = arr[l2];
                l2++;
            }
            
        }
        else //else m2 is in bounds
        {
            tempArr[tempArrIndex++] = arr[m2];
            m2++;
        }
        }

        //Put variables in tempArr into main array
        for(int num : tempArr)
        {
        arr[l++] = num;
        }

          

    }

    // Desc: Performing quick sort
    // Input: An array
    // Output: A sorted array using quick sort
    public void quickSort(int arr[], int left, int right)
    {
        
        // NOTE: We can perform a better pivot selection to avoid the worst case scenario
        // NOTE: We can perform insertion sort when the subarray is small
        // NOTE: We can perform quick sort iteratively instead of recursively 

        if (left < right)
        {
            // Step 1: Get the pivot via Lomuto Partitioning
            int partitionNum = lomutoPartition(arr, left, right);
            // Step 2: Quick sort of left-right & right-left subarrays 
            quickSort(arr, left, partitionNum-1);
            quickSort(arr, partitionNum+1, right);
        }
    }

    // Desc: Performing heap sort
    // Input: An array
    // Output: A sorted array using heap sort
    public void heapSort(int[] arr)
    {   
        // Create a heap from a random array
        heapSortBuildMaxHeap(arr);

        // Debug:
        // System.out.println(Arrays.toString(arr));

        //Build a sorted array from a heap
        for( int i = arr.length - 1; i > 0; i--){
            //swap first and index i
            swap(arr, 0, i);
            //apply heapify on first node
            heapSortHeapify(arr, 0, i);
        }
        // Debug:
        // System.out.println(Arrays.toString(arr));

    }


    // Desc: helper method, builds a max heap from an array of random numbers
    // Input: an array
    // Output: applies changes to input arr
    private void heapSortBuildMaxHeap(int[] arr)
    {
        //Get the last parent node location
        int root = (int)( Math.ceil ( arr.length - 1 / 2 ) ) - 1;

        //apply heapify to all parent nodes starting from the end.
        for(int i = root ; i >= 0; i--) {
            heapSortHeapify(arr, i, arr.length);
        }
        
    }

    // Desc: helped method, recursive, swaps root node with greatest child if less than child, continues down tree
    // Input: An array, a root index
    // Output: applies changes to input arr
    private void heapSortHeapify(int[] arr, int root, int lastNode)
    {
        int leftChild = root * 2 + 1;
        int rightChild = leftChild + 1;

        //Check if right child exists
        if(rightChild < lastNode) 
        {
            //Check if the greatest child is bigger than the root
            if ( Math.max(arr[leftChild], arr[rightChild]) > arr[root] )
                {
                    //check if leftChild is greater than right
                if(arr[leftChild] >= arr[rightChild]) 
                    {
                        swap(arr, leftChild, root);
                        //call heapify on the next substree
                        heapSortHeapify(arr, leftChild, lastNode);
                    }
                else //rightchild is greater than left
                {
                    swap(arr, rightChild, root);
                    //call heapify on the next substree
                    heapSortHeapify(arr, rightChild, lastNode);
                }
            }
        //Check if left child exists,  right child does not exist
        }else if(leftChild < lastNode)
        {
            //Check if leftchild is greater than root
            if( arr[leftChild] > arr[root])
            {
                swap(arr, leftChild, root);
                //call heapify on the next substree
                heapSortHeapify(arr, leftChild, lastNode);
            }
        }
        //If there is no leftchild or right child then do nothing
    }

    // Desc: helper method, swaps 2 integers inside of an array
    // Input: an array, 2 positions
    // Output: applies changes to input arr
    private void swap(int[] arr, int p, int q )
    {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    // Desc: Performing Lomuto Partitioning. Helper function for quickSort.
    // Input: 
    public int lomutoPartition(int arr[], int left, int right)
    {
        int pivot = arr[right]; // choosing last element as pivot
        int i = left-1;

        for (int j = 0; j < arr.length-1; j++)
        {
            if (arr[j] < pivot)
            {
                 i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, arr[right]);
        return i + 1;
    }
}
