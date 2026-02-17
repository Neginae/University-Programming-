import java.util.Arrays;

record Cylinder(double radius, double height) {

     double volume() {
          return Math.PI * (radius * radius) * height;
     }

     static Cylinder[] sorted(Cylinder[] cylinders) {
          if (cylinders == null) {
               throw new NullPointerException();
          }
          for (Cylinder cylinder : cylinders) {
               if (cylinder == null) {
                    throw new NullPointerException();
               }
          }
          Cylinder[] copy = Arrays.copyOf(cylinders, cylinders.length);

          insertionSort(copy);
          return copy;
     }

     private static void insertionSort(Cylinder[] arr) {
          for (int i = 1; i < arr.length; i++) { 
               Cylinder current = arr[i];
               double currentVol = current.volume();

               int j = i - 1;
               while (j >= 0 && arr[j].volume() > currentVol) {
                    arr[j + 1] = arr[j];
                    j--;
               }
               arr[j + 1] = current;
          }
     }
}
