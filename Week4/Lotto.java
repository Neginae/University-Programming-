static void main() {
     int[] lotto = ziehung(6, 49);

    // Ausgabe zum Testen
     for (int i = 0; i < lotto.length; i++) {
          System.out.print(lotto[i] + " ");
     }
}

static int[] ziehung(int n, int m) {
     int[] numbers = new int[n];

     for (int i = 0; i < numbers.length; i++) {

          int number;
          boolean drin;

          do {
            number = (int) (Math.random() * m) + 1;
               drin = false;

               // Erste Runde auf jeden Fall(do-while): 0 !< 0 ... wird überhaupt nicht ausgeführt ... zur Zeile 32 
               for (int j = 0; j < i; j++) {
                    if (numbers[j] == number) {
                    drin = true;
                    }
               }

          } while (drin);

          numbers[i] = number;
     }

     return numbers;
}