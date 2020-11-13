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

public class Solution 
{
    static void bonAppetit(List<Integer> bill, int k, int b) 
    {
        int sum = 0;
        for(int i = 0; i < bill.size(); i++)
        {
            if(i == k)
                continue;
            sum += bill.get(i);
        }
        
        int split = sum / 2;
        
        int overCharged = b - split;
        
        if(overCharged == 0)
            System.out.println("Bon Appetit");
        else
            System.out.println(overCharged);
    }

    public static void main(String[] args) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}