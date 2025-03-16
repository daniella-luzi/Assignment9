import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//This is just merge sort

public class MergeSortTest2 {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello! Press 1 to generate an array of random integers, sort them, and store to a file.");
        System.out.println("Press 2 to read a file, sort it, and store into another file");

        Scanner scanner = new Scanner(System.in);
        int nextResponse = scanner.nextInt();

        if (nextResponse == 1) {
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

        if (nextResponse == 2) {
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

    public static int[] createRandomArray(int arrayLength){
        Random random = new Random();
        int[] array = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt(100); 
        }
        return array;
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
