public class Matrix {
     private final int[][] matrix;

     Matrix(int[][] matrix) {
          if (matrix == null || matrix.length == 0 || matrix[0] == null) {
               throw new IllegalArgumentException();
          }

          int cols = matrix[0].length;
          if (cols == 0) {
               throw new IllegalArgumentException();
          }

          for (int i = 0; i < matrix.length; i++) {
               if (matrix[i] == null || matrix[i].length != cols) {
                    throw new IllegalArgumentException();
               }
          }

          this.matrix = new int[matrix.length][cols];
          for (int i = 0; i < matrix.length; i++) {
               for (int j = 0; j < cols; j++) {
                    this.matrix[i][j] = matrix[i][j];
               }
          }
     }

     int get (int row, int column) {
          if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length) {
               throw new IndexOutOfBoundsException();
          }
          return matrix[row][column];
     }

     Matrix multiply(Matrix other) {
          if (other == null || this.matrix[0].length != other.matrix.length) {
               throw new IllegalArgumentException();
          }

          int rows = this.matrix.length;
          int cols = other.matrix[0].length;
          int common = this.matrix[0].length;
          int[][] result = new int[rows][cols];


          for (int i = 0; i < rows; i++) {
               for (int j = 0; j < cols ; j++) {
                    for (int k = 0; k < common; k++) {
                         result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                    }
               }
          }
          return new Matrix(result);
     }
     
     @Override
     public String toString() {
          String result = "";
          for (int i = 0; i < matrix.length; i++) {
               for (int j = 0; j < matrix[i].length; j++) {
                    result += matrix[i][j];

                    if (j < matrix[i].length - 1) {
                         result += " ";
                    }
               }
               if (i < matrix.length - 1) {
                    result += "\n";
               }
          }
          return result;
     }

     //Test:
     /*public static void main(String[] args) {
          int[][] aArr = {{1,2,3}, {4,5,6}};
          int[][] bArr = {{7,8}, {9,10}, {11,12}};

          Matrix a = new Matrix(aArr);
          Matrix b = new Matrix(bArr);

          System.out.println("A:");
          System.out.println(a);

          System.out.println("\nB:");
          System.out.println(b);

          System.out.println("\nA.get(1,2) (soll 6 sein): " + a.get(1, 2));

          Matrix c = a.multiply(b);
          System.out.println("\nA * B:");
          System.out.println(c);
          System.out.println("\nErwartet:");
          System.out.println("58 64\n139 154");

          // Defensive-Copy-Test:
          aArr[0][0] = 99;
          System.out.println("\nNach aArr[0][0] = 99, A soll unverändert bleiben:");
          System.out.println(a);

          
     }*/


}
