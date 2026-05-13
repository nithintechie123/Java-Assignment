
import java.util.Map;
import java.util.TreeMap;

// 6. Write a Java program that counts the occurrences of words in a text and
// displays the words and their occurrences in alphabetical order of words.
// Hint:Use a TreeMap to store an entry consisting of a word and its count.

public class WordCount {
    public static void main(String[] args) {
        String text="Hello java,Java is easy and java is powerfull";
    
        String[] words=text.split(" ");

        TreeMap<String,Integer> wordMap=new TreeMap<>();

        for(String word:words){
            if(wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word)+1);
            }else{
                wordMap.put(word,1);
            }
        }

        System.out.println("Word Occurences in Alphabetical Order:\n");

        for(Map.Entry<String,Integer> entry:wordMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
