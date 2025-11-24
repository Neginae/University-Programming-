static void main() {
     // System.out.println(factorial(10));
     // System.out.println(power(0.5, 2));
     System.out.println(cosinus(0));
     System.out.println(cosinus(Math.PI));
     System.out.println(cosinus(2 * Math.PI));
}


//* 
// Wie heisst die Methode und was macht sie?
// Parameter und Rückgabewert
// Logik
// Zusaetzliche Punkte
//*


// Normierung: [0, 2p]
//
// Achsensymmetrie: cos(x) = cos(-x)
// und Periodizität: cos(x+2p) = cos(x) ---> while Schleife!!!
// return EINMAL AM ENDE!!!
static double normalize(double x){
     if(x < 0) {
          x = -x;
     }

     while(x > 2 * Math.PI) {
          x = x - (2 * Math.PI);
     }

     return x;
}


// Fakultät: n!
// Parameter: int n, Rückgabewert: double(weil die Zahlen groß werden)
// Fängt von 0! = 1
// Schleife von 1 bis n
// Vergiss die Datentypen nicht!!!
static double factorial(int n) {
     double result = 1;
     for (int i = 1; i <= n; i++) {
          result *= i;
     }
     return result;
}


// Potenz: x^n = x.x.x. ...
// Parameter: double x und int n, Rückgabewert: double
// Fängt von x^0 = 1
// Schleife von 1 bis n
static double power(double x, int n) {
     double result = 1;
     for (int i = 1; i <= n; i++) {
          result *= x;
     }
     return result;
}


// Taylor-Entwicklung: cos(x) = P(n=0 bis 10)  [(-1)^n / (2n)!] * x^2n
// Parameter: double x, Rückgabewert: double 
// Fängt von sum 0
// Schleife 0 bis 10
// Vorzeichen: n gerade --> + und n ungerade --> -
// Methode oben aufrufen
// The last "return" ends the loop so NO updates there!!!
static double cosinus(double x) {
     x = normalize(x);
     double sum = 0;
     double termSign;
     double terms;
     for (int i = 0; i <= 10; i++) {
          if (i % 2 == 0) {
               termSign = 1;
          } else {
               termSign = -1;
          }
          terms = termSign * (power(x, 2 * i) / factorial(2 * i));
          sum = sum + terms;
          
     }
     return sum;
}





