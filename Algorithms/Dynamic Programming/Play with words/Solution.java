import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution 
{
    static int playWithWords(String s) 
    {
        int max = 0;
        int[][] tabela = LCS(s);
        for(int i = 1; i < s.length() - 1; i++)
        {
            max = Math.max(tabela[i][1] * tabela[s.length() - i][i+1], max);
        }
        
        return max;
    }
    
    public static int[][] LCS(String str) 
    {
        int[][] tabela = new int[str.length() + 1][str.length() + 1];
        for(int i = 1; i <= str.length(); i++)
        {
            tabela[1][i] = 1;
        }
        
        tabela[1][str.length()] = 0;
        for(int i = 2; i < str.length(); i++)
        {
            for(int j = 0; j < str.length() - i + 1; j++)
            {
                if(str.charAt(j) == str.charAt(j + i - 1))
                    tabela[i][j + 1] = 2 + tabela[i - 2][j + 2];
                else
                    tabela[i][j+1] = Math.max(tabela[i - 1][j+1], tabela[i - 1][j + 2]);
            }
        }
        return tabela;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException 
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = playWithWords(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}