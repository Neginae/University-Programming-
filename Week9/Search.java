public class Search {

     private static int split(int[] haystack, int needle, int left, int right) {
          
          if (haystack[right] == haystack[left]) {
               return left;
          }

          double fraction = (double) (needle - haystack[left]) / (haystack[right] - haystack[left]);
          int x = (int) (left + fraction * (right - left));

          if (x < left) {
               x = left;
          }
          if (x > right) {
               x = right;
          }

          return x;
          
     }

     static int search(int[] haystack, int needle) {
          int left = 0;
          int right = haystack.length - 1;

          while (left <= right &&
                    needle >= haystack[left] &&
                    needle <= haystack[right]) {

               int x = split(haystack, needle, left, right);

               if (haystack[x] == needle) {
                    return x;
               }

               if (haystack[x] < needle) {
                    left = x + 1;
               } else {
                    right = x - 1;
               }
          }

          return -1;
     }

     public static void main(String[] args) {
          int needle = Integer.parseInt(args[0]);

          int[] haystack = new int[args.length - 1];
          for (int i = 1; i < args.length; i++) {
               haystack[i - 1] = Integer.parseInt(args[i]);
          }
          System.out.println(search(haystack, needle));
     }
}
