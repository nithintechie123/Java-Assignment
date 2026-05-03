import java.util.Scanner;

class Complex {

    // Immutable fields
    private final double real;
    private final double imag;

    // Constructor
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // ----------------------------------------------------
    // Static method to read complex number
    // ----------------------------------------------------
    public static Complex readComplex(Scanner sc) {

        System.out.print("Enter real part: ");
        double r = sc.nextDouble();

        System.out.print("Enter imaginary part: ");
        double i = sc.nextDouble();

        return new Complex(r, i);
    }

    // ----------------------------------------------------
    // Addition
    // ----------------------------------------------------
    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }

    // ----------------------------------------------------
    // Multiplication
    // ----------------------------------------------------
    public Complex multiply(Complex c) {
        return new Complex(
            (this.real * c.real) - (this.imag * c.imag),
            (this.real * c.imag) + (this.imag * c.real)
        );
    }

    // ----------------------------------------------------
    // toString() for clean output
    // ----------------------------------------------------
    @Override
    public String toString() {
        return (imag >= 0)
                ? real + " + " + imag + "i"
                : real + " - " + (-imag) + "i";
    }

    // ----------------------------------------------------
    // Main method
    // ----------------------------------------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Single Scanner

        System.out.println("Enter First Complex Number:");
        Complex c1 = readComplex(sc);

        System.out.println("\nEnter Second Complex Number:");
        Complex c2 = readComplex(sc);

        System.out.println("\nFirst Complex Number: " + c1);
        System.out.println("Second Complex Number: " + c2);

        Complex sum = c1.add(c2);
        System.out.println("\nAddition: " + sum);

        Complex product = c1.multiply(c2);
        System.out.println("Multiplication: " + product);

        sc.close();
    }
}