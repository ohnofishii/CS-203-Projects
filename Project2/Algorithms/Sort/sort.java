package Project2.Algorithms.Sort;

public class Sort {
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
    public void mergeSort(int arr[])
    {

    }

    // Desc: Performing quick sort
    // Input: An array
    // Output: A sorted array using quick sort
    public void quickSort(int arr[])
    {
        
    }

    // Desc: Performing heap sort
    // Input: An array
    // Output: A sorted array using heap sort
    public void heapSort(int arr[])
    {

    }
}
