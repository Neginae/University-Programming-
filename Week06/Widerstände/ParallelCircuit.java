package Widerstände;

public class ParallelCircuit implements Resistor {
     
     private final Resistor w1;
     private final Resistor w2;

     public ParallelCircuit(Resistor w1, Resistor w2) {
          this.w1 = w1;
          this.w2 = w2;
     }

     public double resistance() {
          double wEins = w1.resistance();
          double wZwei = w2.resistance();
          return ((wEins * wZwei) / (wEins + wZwei));
     }

     public int resistorCount() {
          return w1.resistorCount() + w2.resistorCount();
     }
}
