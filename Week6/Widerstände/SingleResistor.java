package Widerstände;

public class SingleResistor implements Resistor {

     // Unveränderlich
     private final double widerstand;

     // Der Widerstandswert soll bei der Erzeugung angegeben werden! ---> public
     public SingleResistor(double widerstand) {
          this.widerstand = widerstand;
     }

     // Diese Methoden sind im Interface automatisch public, deshalb wenn implementiert, muessen auch public sein!!
     public double resistance() {
          return widerstand;
     }

     public int resistorCount() {
          return 1;
     }

}