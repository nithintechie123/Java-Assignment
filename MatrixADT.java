import java.util.*;

class Matrix{
    private int rows;
    private int cols;
    private int[][] mat;

    Matrix(int r,int c){
        this.rows=r;
        this.cols=c;
        mat=new int[rows][cols];
    }

    public void readMatrix(Scanner sc){
        System.out.println("Enter Matrix Elements: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                mat[i][j]=sc.nextInt();
            }
        }
    }

    public Matrix addMatrix(Matrix m2){
        Matrix result=new Matrix(rows,cols);

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                result.mat[i][j]=this.mat[i][j]+m2.mat[i][j];
            }
        }
        return result;
    }

    public void displayMatrix(){
        System.out.println("Matrix is: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

public class MatrixADT{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter number of rows: ");
        int r=sc.nextInt();
        System.out.println("Enter number of cols: ");
        int c=sc.nextInt();

        Matrix m1=new Matrix(r,c);
        Matrix m2=new Matrix(r,c);

        System.out.println("Enter first Matrix: ");
        m1.readMatrix(sc);

        System.out.println("Enter second Matrix: ");
        m2.readMatrix(sc);

        Matrix sum=m1.addMatrix(m2);

        System.out.println("First Matrix: ");
        m1.displayMatrix();

        System.out.println("Second Matrix");
        m2.displayMatrix();

        System.out.println("Sum Matrix: ");
        sum.displayMatrix();

        sc.close();
    }
}