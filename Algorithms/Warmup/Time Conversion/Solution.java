import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution 
{
    static String timeConversion(String s) 
    {
        try 
        {
            DateFormat oldFormat = new SimpleDateFormat("hh:mm:ssaa");
        
            DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = oldFormat.parse(s);
            
            String output = outputFormat.format(date);
            
            return output;
        } catch(Exception e){}
        
        return "";
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}