static void main(){
     pascalTriangle(5);
}

// (0,0) ... 1
// (1,0) ... 1 ... (1,1) ... 1 ....> 1 1
// (2,0) ... 1 ... (2,1) ... rekursive: links: p(1,0) rechts: p(1,1) ... 2 ... (2,2) ... 1 ...> 1 2 1
static int pascalRecursive(int z, int s) {
     int result;
     if (s == 0 || s == z ) {
          result = 1;
     }
     else {
          int links = pascalRecursive(z-1, s-1);
          int rechts = pascalRecursive(z-1, s);
          result = links + rechts;
     }
     return result;
}


// Die ist void: GIBT NIX ZURÜCK --> deswegen nicht in println oben beim main!!!
static void pascalTriangle(int n) {
     int result;
     for (int i = 0; i <= n; i++) {
// Innere Schleife kleiner gleich äußere Schleife (j<=i)!! Sieh oben.
          for (int j = 0; j <= i; j++) {
          result = pascalRecursive(i, j);
// Kein println: alle Zahlen erstmal in einer Zeile!!! (print + " ")
          System.out.print(result + " ");
          } 
          System.out.println();
     }    
}

// WENN DIE MATHEFORMEL REKURSIV IST, WIRD DER CODE AUCH REKURSIV
// ODER
// SOBALD EIN PROBLEM AUF SICH SELBST ZEIGT, STEHT DA REKURSION