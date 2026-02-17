package Widerstände;

public class SeriesCircuit implements Resistor {
     
     private final Resistor w1;
     private final Resistor w2;

     // Java weisst nicht, wie man zwei Objekte addiert
     public SeriesCircuit(Resistor w1, Resistor w2) {
          this.w1 = w1;
          this.w2 = w2;
     }

     public double resistance() {
          return w1.resistance() + w2.resistance();
     }

     public int resistorCount() {
          return w1.resistorCount() + w2.resistorCount();
     }
}
