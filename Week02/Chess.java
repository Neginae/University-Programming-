static void main() {
     // Positive ganze Zahl n
     int number = 15;

     // Gibt ein Schachbrett der Größe n * n
     for (int i = 1; i <= number; i++) {
          for (int j = 1; j <= number; j++) {
               if (i % 2 != 0) {
                    if (j % 2 != 0) {
                    System.out.print("*");  
                    } else {
                         System.out.print(" ");
                    }
               }else {
                    if (j % 2 == 0) {
                         System.out.print("*"); 
                    } else {
                         System.out.print(" ");
                    }
               }
          }
          System.out.println();
     }    
}

