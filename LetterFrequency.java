
import java.util.HashMap;
import java.util.Map;


public class LetterFrequency {
    public static void main(String [] args){
        if(args.length==0){
            System.out.println("Please provide a string as a command-line argument");        
        }

        String input=args[0];

        input=input.toLowerCase();

        HashMap<Character,Integer> freqMap=new HashMap<>();

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);

            if(Character.isLetter(ch)){
                freqMap.put(ch,freqMap.getOrDefault(ch, 0)+1);
            }
        }

        System.out.println("Letter Frequency");
        for(Map.Entry<Character,Integer> entry:freqMap.entrySet()){
                System.out.println(entry.getKey()+ ":" +entry.getValue());
        }
    }
}
