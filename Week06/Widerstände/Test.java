package Widerstände;

public class Test {
     public static void main(String[] args) {

          SingleResistor r1 = new SingleResistor(100);
          SingleResistor r2 = new SingleResistor(200);
          SingleResistor r3 = new SingleResistor(300);

          ParallelCircuit r23 = new ParallelCircuit(r2, r3);
          SeriesCircuit r123 = new SeriesCircuit(r1, r23);

          System.out.println(r123.resistance()); // 220.0
          System.out.println(r123.resistorCount()); // 3
     }
}
