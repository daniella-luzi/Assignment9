import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//This has a choice of merge sort or bubble sort

public class CompareBubbleMerge {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello! Press 1 for BubbleSort or 2 for MergeSort");
        
        Scanner scanner = new Scanner(System.in);
        int nextResponse = scanner.nextInt();

        if (nextResponse == 1) {
            System.out.println("Press 3 for a random array or 4 for a file");
            int response = scanner.nextInt();
            if (response == 3) {
                System.out.println("Enter the length of the array: ");
            int arrayLength = scanner.nextInt();
            int[] array = createRandomArray(arrayLength);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            bubbleSort(array);
            writeArrayToFile(array, "sortedArray.txt");
            
        }

        if (response == 4) {
            System.out.println("Enter the name of the file:");
            String filename = scanner.next();
            int[] array = readFileToArray(filename);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            bubbleSort(array);
            writeArrayToFile(array, "sortedArray2.txt");

        }
        scanner.close();
        }

        if (nextResponse == 2) {
            System.out.println("Press 3 for a random array or 4 for a file");
            int response = scanner.nextInt();
            if (response == 3) {
                System.out.println("Enter the length of the array: ");
                int arrayLength = scanner.nextInt();
                int[] array = createRandomArray(arrayLength);
                System.out.println("Here is your array before it is sorted:");
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i] + " ");
                }
                System.out.println("Here is your array after it is sorted:");
                mergeSort(array);
                printArray(array);
                writeArrayToFile(array, "sortedArray.txt");

            }

            if (response == 4) {
                System.out.println("Enter the name of the file:");
            String filename = scanner.next();
            int[] array = readFileToArray(filename);
            System.out.println("Here is your array before it is sorted:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i] + " ");
            }
            System.out.println("Here is your array after it is sorted:");
            mergeSort(array);
            printArray(array);
            writeArrayToFile(array, "sortedArray2.txt");

        }
        scanner.close();
    }
            }
    
private static void mergeSort(int[] inputArray) {
    int inputLength =  inputArray.length;
        
    if (inputLength < 2) {
    return;
    }
        
    int mid = inputLength / 2;
    int[] leftArray = new int[mid];
    int[] rightArray = new int[inputLength - mid];
        
        for(int i = 0; i < mid; i++) {
            leftArray[i] = inputArray[i];
                }
        
        for(int i = mid; i < inputLength; i++) {
            rightArray[i - mid] = inputArray[i];
            }
        
        mergeSort(leftArray);
        mergeSort(rightArray);
        
        merge(inputArray, leftArray, rightArray);
                
            }      
            
private static void merge(int[] inputArray, int[] leftArray, int[] rightArray) {
    int leftHalf = leftArray.length;
    int rightHalf = rightArray.length;
        
    int i = 0;
    int j = 0;
    int k = 0;
        
        while(i < leftHalf  && j < rightHalf) {
            if(leftArray[i] <= rightArray[j]) {
                inputArray[k] = leftArray[i];
                    i++;
                }
            else {
                inputArray[k] = rightArray[j];
                    j++;
                }
                    k++;
                }
        
        while(i < leftHalf) {
            inputArray[k] = leftArray[i];
                i++;
                k++;
                }
        
        while(j < rightHalf) {
            inputArray[k] = rightArray[j];
                j++;
                k++;
                }
        
            }


public static int[] createRandomArray(int arrayLength){
    Random random = new Random();
    int[] array = new int[arrayLength];
    for(int i = 0; i < arrayLength; i++){
        array[i] = random.nextInt(100); 
    }
    return array;
}

public static void bubbleSort(int[] array) {
    boolean swapped = true;
    while (swapped) {
        swapped = false;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                swapped = true;
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        
    }
    for(int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
}

public static void writeArrayToFile(int[] array, String filename) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for(int i = 0; i < array.length; i++){
        writer.write(array[i] + " ");
        writer.newLine();
    }
    writer.close();
}

public static int[] readFileToArray(String filename) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    int count = 0;
    String line;
    while((line  = reader.readLine()) != null) {
        count++;
    }
    int[] array = null;
    if (count > 0) {
        array = new int[count];
        int index = 0;
        reader.close();
        reader = new BufferedReader(new FileReader(filename));
        while((line = reader.readLine()) != null){
            String[] values = line.split(" ");
            for(String value : values){
                array[index++] = Integer.parseInt(value);
            }
        }
    }
    
    reader.close();
    return array;
}

private static void printArray(int[] num) {
    for (int i = 0; i < num.length; i++) {
        System.out.println(num[i]);
    }
}
}




