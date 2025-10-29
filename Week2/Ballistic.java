static void main() {
  double x0 = 2;          
  double v0 = 10;
  double t = 1.5;
  double g = 9.81;

  // Berehnet in welcher Höhe sich ein Objekt nach t befindet, wenn von x0 aus mit v0 nach oben geworfen
  System.out.println(x0 + (v0 * t) - ((g * t * t) / 2)); 
}
