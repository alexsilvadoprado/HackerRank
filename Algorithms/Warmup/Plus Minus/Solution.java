import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution 
{
    static void plusMinus(int[] arr) 
    {
        int qtdPositives = 0;
        int qtdNegatives = 0;
        int qtdZeros = 0;
        
        for(int i : arr) 
        {
            if(i > 0)
                qtdPositives++;
            else if(i < 0)
                qtdNegatives++;
            else
                qtdZeros++;
        }
        
        double positiveRatio = (double) qtdPositives / arr.length;
        double negativeRatio = (double) qtdNegatives / arr.length;
        double zeroRatio = (double) qtdZeros / arr.length;
        
        System.out.println(String.format("%.6f", positiveRatio));
        System.out.println(String.format("%.6f", negativeRatio));
        System.out.println(String.format("%.6f", zeroRatio));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) 
        {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}