// 1. Write a Java program that has an abstract class Polygon with two abstract
// methods area() and perimeter(). Derive three classes Rectangle, Square, and
// Triangle from Polygon class. Write methods to get the details of their
// dimensions and hence calculate their areas and perimeters The sub classes
// should override the two abstract methods (area() and perimeter()) by providing 
// appropriate implementations. Demonstrate polymorphism.
//It defines a common structure for all shapes
abstract class Polygon{
    abstract double area();
    abstract double perimeter();
}

class Rectangle extends Polygon{
    double length,width;

    Rectangle(double l,double w) {
        length=l;
        width=w;
    }

    @Override
    double area(){
        return length*width;
    }

    @Override
    double perimeter(){
        return 2*(length+width);
    }
}

class Square extends Polygon{
    double side;

    

    Square(double s) {
        side=s;
    }

    @Override
    double area(){
        return  side*side;
    }

    @Override 
    double perimeter(){
        return 4*side;
    }
}

class Triangle extends Polygon{
    
    double a,b,c;

    Triangle(double x,double y,double z) {
        a=x;
        b=y;
        c=z;
    }

    @Override
    double area(){
        //Using Heron's formula
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override 
    double perimeter(){
        return a+b+c;
    }
}

//Main class

public class PolygonDemo{
    public static void main(String[] args) {
        //Reference variable of parent class
        Polygon p;

        //Assign Rectangle object
        p=new Rectangle (5,3);
        System.out.println("-------------------------------------");
        System.out.println("Rectangle Area: "+p.area());
        System.out.println("Rectangle Perimeter: "+p.perimeter());

        //Assign Square object (same reference,different object)
        p=new Square(4);
        System.out.println("-------------------------------------");
        System.out.println("\nSquare Area: "+p.area());
        System.out.println("Square Perimeter: "+p.perimeter());

        //Assign Triangle object
        p=new Triangle(3, 4, 5);
        System.out.println("-------------------------------------");
        System.out.println("\nTriangle Area: "+p.area());
        System.out.println("Triangle Perimeter: "+p.perimeter());
        System.out.println("-------------------------------------");
    }
}