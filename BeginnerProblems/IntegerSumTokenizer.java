import java.util.Scanner;
import java.util.StringTokenizer;

public class IntegerSumTokenizer {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter integers separated by spaces: ");
        String input=sc.nextLine();

        StringTokenizer st=new StringTokenizer(input);

        int sum=0;

        System.out.println("Integers are: ");
        while(st.hasMoreTokens()){
            String token=st.nextToken();

            int num=Integer.parseInt(token);
            System.out.println(num);
            sum+=num;
        }

        System.out.println("Sum of integers is: "+ sum);
    }

}
