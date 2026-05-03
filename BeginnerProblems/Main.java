import java.util.Scanner;

class Complex{
    private double real;
    private double imag;

    public Complex(double real,double imag){
        this.real=real;
        this.imag=imag;
    };

    public static Complex readComplex(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter real part: ");
        double r=sc.nextDouble();
        System.out.print("Enter imag part: ");
        double i=sc.nextDouble();

        return new Complex(r,i);
    };
    

    public void display(){
        if(imag>=0){
            System.out.println(real + " + " + imag + "i");
        }else{
            System.out.println(real + " - " + (-imag) + "i");
        }
    }

    public Complex add(Complex c){
        double r=this.real+c.real;
        double i=this.imag+c.imag;
        return new Complex(r, i);
    }

    public Complex multiply(Complex c){
        double r=(this.real * c.real) - (this.imag * c.imag);
        double i=(this.real * c.imag) + (this.imag * c.real);
        return new Complex(r, i);
    }
    
};

public class Main{
    public static void main(String[] args){
        System.out.println("Enter First Complex Number:  ");
        Complex c1=Complex.readComplex();

        System.out.println("Enter Second Complex Number:  ");
        Complex c2=Complex.readComplex();

        System.out.println("First Complex Number");
        c1.display();

        System.out.println("Second Complex Number");
        c2.display();

        Complex sum=c1.add(c2);
        System.out.println("Addition of Complex Numbers: ");
        sum.display();

        Complex mul=c1.multiply(c2);
        System.out.println("Multiplication of Complex Numbers: ");
        mul.display();
        
    };
};