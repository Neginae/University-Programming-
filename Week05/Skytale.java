/* 
Ich muss einen Text mit der Skytale verschlüsseln oder entschlüsseln, 
indem ich ihn in ein 4*7 Raster(2D-Array) schreibe und dann anders wieder ablese
*/

/* 
Raster 4 Zeilen, 7 Spalten
Msg ganue 28 Zeichen ---> ERROR
Zwei Richtungen:
     zeilenweise 
     spaltenweise 
*/

public class Skytale {

     static void main(String[] args) {

          if (args.length != 2) {
               System.out.println("ERROR: Es soll zwei Argumente geben");
               return;
          }

          /*
           * char[] msg = args[1].toCharArray();
           * Für Test löschen!
           */
          String msg = args[1];
          if (msg.length() != 28) {
               System.out.println("ERROR: die Nachricht soll 28 Zeichen haben");
               return;
          }

          if (args[0].equals("E")) {
               System.out.println(new String(verschluesseln(msg)));
          } else if (args[0].equals("D")) {
               System.out.println(new String(entschluesseln(msg)));
          } else {
               System.out.println(
                         "ERROR: Bitte geben Sie am Anfang entweder E für verschlüsselte Nachricht oder D für Entschüsselte");
          }

     }

     // String msg = "WIR GREIFEN MORGEN MITTAG AN";
     static char[][] zeilenweiseInRasterSchreiben(char[] msg) {
          char[][] raster = new char[4][7];
          int k = 0;

          for (int i = 0; i < raster.length; i++) {
               for (int j = 0; j < raster[i].length; j++) {
                    raster[i][j] = msg[k];
                    k++;
               }
          }

          return raster;
     }

     static char[] rasterSpaltenweiseAblesen(char[][] raster) {

          char[] result = new char[28];
          int k = 0;

          for (int i = 0; i < raster[0].length; i++) {
               for (int j = 0; j < raster.length; j++) {
                    result[k] = raster[j][i];
                    k++;
               }
          }
          return result;

     }

     static char[][] spaltenweiseInRasterSchreiben(char[] msg) {
          char[][] raster = new char[4][7];
          int k = 0;

          for (int i = 0; i < raster[0].length; i++) {
               for (int j = 0; j < raster.length; j++) {
                    raster[j][i] = msg[k];
                    k++;
               }
          }

          return raster;
     }

     static char[] rasterZeilenweiseAblesen(char[][] raster) {

          char[] result = new char[28];
          int k = 0;

          for (int i = 0; i < raster.length; i++) {
               for (int j = 0; j < raster[i].length; j++) {
                    result[k] = raster[i][j];
                    k++;
               }
          }
          return result;

     }

     static char[] verschluesseln(char[] msg) {
          char[][] result = zeilenweiseInRasterSchreiben(msg);
          return rasterSpaltenweiseAblesen(result);
     }

     static char[] entschluesseln(char[] msg) {
          char[][] result = spaltenweiseInRasterSchreiben(msg);
          return rasterZeilenweiseAblesen(result);
     }

     // ===== String-Wrapper für Tests =====

     static char[][] zeilenweiseInRasterSchreiben(String msg) {
          return zeilenweiseInRasterSchreiben(msg.toCharArray());
     }

     static char[][] spaltenweiseInRasterSchreiben(String msg) {
          return spaltenweiseInRasterSchreiben(msg.toCharArray());
     }

     static String rasterZeilenweiseAblesen(String msg) {
          char[][] raster = spaltenweiseInRasterSchreiben(msg);
          return new String(rasterZeilenweiseAblesen(raster));
     }

     static String rasterSpaltenweiseAblesen(String msg) {
          char[][] raster = zeilenweiseInRasterSchreiben(msg);
          return new String(rasterSpaltenweiseAblesen(raster));
     }

     static String verschluesseln(String msg) {
          return new String(verschluesseln(msg.toCharArray()));
     }

     static String entschluesseln(String msg) {
          return new String(entschluesseln(msg.toCharArray()));
     }

}
