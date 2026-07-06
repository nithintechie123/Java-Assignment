// 2.Write a Java program that demonstrates how run-time polymorphism can be
// achieved through an interface reference variable.

package InheritanceInterfacePolymorphism;

interface Shape{
    void draw();
    void calculateArea();
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }

    @Override
    public void calculateArea(){
        System.out.println("Area of Circle");
    }
}

class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Rectangle");
    }
     @Override
    public void calculateArea(){
        System.out.println("Area of Rectangle");
    }
}

class Triangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Triangle");
    }
    
    @Override
    public void calculateArea(){
        System.out.println("Area of Triangle");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        
        //Interface reference
        Shape s;

        //Assign Circle object
        s=new Circle();
        s.draw(); //Calls Circle's draw()
        s.calculateArea();

        //Assign Rectangle object
        s=new Rectangle();
        s.draw(); //Calls Rectangle's draw()
        s.calculateArea();

        //Assign Triangle object
        s=new Triangle();
        s.draw();  //Calls Triangle's draw()
        s.calculateArea();
    }
}
