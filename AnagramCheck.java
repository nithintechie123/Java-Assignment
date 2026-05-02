import java.util.*;

public class AnagramCheck {
    public static boolean isAnagram(String str1,String str2){
       

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        if(str1.length()!=str2.length()){
            return  false;
        }

        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter String one: ");
        String s1=sc.next();
        System.out.println("Enter String two: ");
        String s2=sc.next();

        if(isAnagram(s1, s2)){
            System.out.println(s1 + " and " + s2 + " are Anagrams");
        }else{
            System.out.println(s1 + " and " + s2 + " are not Anagrams" );
        }
    }
}
