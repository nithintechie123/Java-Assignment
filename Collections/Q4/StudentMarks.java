
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// 4. Write a Java program to perform the following:
// i)Create a HashMap that contains 4 mappings of student names and their end
// marks in a subject.
// ii)Obtain a set view of the mappings. Then traverse the set using an iterator and
// display the contents of the map.



public class StudentMarks {
    public static void main(String[] args) {
        HashMap<String,Integer> students =new HashMap<>();

        students.put("Ravi",85);
        students.put("Anu",92);
        students.put("Kiran",78);
        students.put("Sneha",90);
        students.put("Virat",65);
        
        Set<Map.Entry<String,Integer>> set=students.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator=set.iterator();

        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            System.out.println("Student Name: "+entry.getKey());
            System.out.println("Marks: "+entry.getValue());
            System.out.println();
        }

    }
}
