static void main() {
  int minimal = 2;
  int maximal = 6;
                     // [0,1)              // Strecke=5 [0,5)         // [2,7) ... 6 ist doch drin!
  int augenzahl = (int)(Math.random() * (maximal - minimal + 1) + minimal );
  System.out.println(augenzahl);
}
