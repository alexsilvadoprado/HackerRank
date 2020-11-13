import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result 
{
    public static int getTotalX(List<Integer> a, List<Integer> b) 
    {
        int A_LCM = lcm(a);
        int B_GCD = gcd(b);
        
        int count = (B_GCD % A_LCM == 0) ? countDiv(B_GCD / A_LCM) : 0;
        
        return count;
    }
    
    /**
     * Euclidean Algorithm
     * Greatest Common Divisor
     */
    private static int gcd(int a, int b)
    {
        while (b != 0) 
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Least Common Multiple
     */
    private static int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }
    
    private static int gcd(List<Integer> array)
    {
        return array.stream().reduce(array.get(0), (a, b) -> gcd(a, b));
    }
    
    private static int lcm(List<Integer> array)
    {
        return array.stream().reduce(array.get(0), (a, b) -> lcm(a, b));
    }
    
    private static int countDiv(int n) 
    {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) 
        {
            if (n % i == 0) 
            {
                count += 2;
            }
        }
        
        if (sqrt * sqrt == n) 
        {
            count--;
        }
        return count;
    }
}

public class Solution 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}