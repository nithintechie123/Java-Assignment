import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text=sc.nextLine();

        text=text.toLowerCase();

        //Remove punctuations
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");

        //Split into words
        String[] words=text.split("\\s+");

        //Store Frequency of word
        HashMap<String,Integer> wordCount=new HashMap<>();

        for(String word:words){
            if(wordCount.containsKey(word)){
                wordCount.put(word,wordCount.get(word)+1);            
            }else{
                wordCount.put(word,1);
            }
        }
        System.out.println("\nWord Frequency: ");

        for(Map.Entry<String,Integer> entry:wordCount.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        sc.close();
    }
}
