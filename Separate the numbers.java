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

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) 
    {
    // Write your code here
        if(s.charAt(0)=='0'||s.length()==1)
        {
            System.out.println("NO");
            return;
        }
        for(int i=1;i<=s.length()/2;i++)
        {
            long num=Long.parseLong(s.substring(0,i));
            String s1=Long.toString(num);
            int j=i;
            while(j<s.length())
            {
                num++;
                String s2=Long.toString(num);
                if(j+s2.length()>s.length()||!s.substring(j,j+s2.length()).equals(s2))
                {
                    break;
                }
                s1+=s2;
                j+=s2.length();
            }
            if(j==s.length())
            {
                System.out.println("YES "+s.substring(0, i));
                return; 
            }
        }
        System.out.println("NO");

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
