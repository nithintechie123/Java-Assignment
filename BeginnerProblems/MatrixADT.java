import java.util.Scanner;

// Matrix ADT
class Matrix {
    int rows, cols;
    int[][] mat;

    // Constructor
    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        mat = new int[rows][cols];
    }

    // Read Matrix
    void readMatrix(Scanner sc) {
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    // Print Matrix
    void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Matrix Addition
    Matrix add(Matrix m) throws Exception {
        if (rows != m.rows || cols != m.cols) {
            throw new Exception("Matrix addition not possible.");
        }

        Matrix result = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.mat[i][j] = mat[i][j] + m.mat[i][j];
            }
        }

        return result;
    }

    // Matrix Multiplication
    Matrix multiply(Matrix m) throws Exception {
        if (cols != m.rows) {
            throw new Exception("Matrix multiplication not possible.");
        }

        Matrix result = new Matrix(rows, m.cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m.cols; j++) {
                result.mat[i][j] = 0;

                for (int k = 0; k < cols; k++) {
                    result.mat[i][j] += mat[i][k] * m.mat[k][j];
                }
            }
        }

        return result;
    }
}

// Main Class
public class MatrixADT {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Matrix A
            System.out.print("Enter rows and columns of Matrix A: ");
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();

            Matrix A = new Matrix(r1, c1);
            A.readMatrix(sc);

            // Matrix B
            System.out.print("Enter rows and columns of Matrix B: ");
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            Matrix B = new Matrix(r2, c2);
            B.readMatrix(sc);

            // Print Matrices
            System.out.println("\nMatrix A:");
            A.printMatrix();

            System.out.println("\nMatrix B:");
            B.printMatrix();

            // Addition
            try {
                Matrix sum = A.add(B);
                System.out.println("\nAddition of Matrices:");
                sum.printMatrix();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Multiplication
            try {
                Matrix product = A.multiply(B);
                System.out.println("\nMultiplication of Matrices:");
                product.printMatrix();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid Input: " + e.getMessage());
        }

        sc.close();
    }
}