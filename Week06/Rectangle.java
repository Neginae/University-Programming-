public class Rectangle {

     private final int width;
     private final int height;

     Rectangle(int width, int height) {
          this.width = width;
          this.height = height;
     }

     Rectangle() {
          this.width = 0;
          this.height = 0;
     }

     int area() {
          int area = this.height * this.width;
          return area;
     }

     int perimeter() {
          int perimeter = 2 * (this.height + this.width);
          return perimeter;
     }

     boolean isSquare() {
          return width == height;
     }

     public String toString() {
          String result = "";
          for (int i = 0; i < height; i++) {
               for (int j = 0; j < width; j++) {
                    result += "* ";
               }
               result += "\n";
          }
          return result;
     }

     // nur zum Testen
     static void main() {
          Rectangle rectangle = new Rectangle(5, 3);
          Rectangle square = new Rectangle(2, 2);

          System.out.println(rectangle.isSquare());
          System.out.println(rectangle.perimeter());
          System.out.println(rectangle.area());
          System.out.println(rectangle.toString());

          System.out.println(square.isSquare());
          System.out.println(square);
     }
}
