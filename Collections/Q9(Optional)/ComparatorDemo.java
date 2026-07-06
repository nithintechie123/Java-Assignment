
import java.util.*;

class Student {

    int id;
    String name;
    int marks;

    Student(int id,
            String name,
            int marks) {

        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {

        return id + " "
                + name + " "
                + marks;
    }
}

class NameComparator
        implements Comparator<Student> {

    @Override
    public int compare(Student s1,
            Student s2) {

        return s1.name.compareTo(
                s2.name);
    }
}

public class ComparatorDemo {

    public static void main(String[] args) {

        ArrayList<Student> students
                = new ArrayList<>();
        NameComparator nameComp = new NameComparator();

        students.add(
                new Student(
                        101,
                        "Nithin",
                        85));

        students.add(
                new Student(
                        102,
                        "Rahul",
                        75));

        students.add(new Student(
                103,
                "Anjali",
                95));

        Collections.sort(
                students,
                nameComp);

        System.out.println(
                students);
    }
}
