/*  
Warum ein Interface?

Ganz wichtiges Denken hier:
	•	SingleResistor
	•	SeriesCircuit
	•	ParallelCircuit

👉 sind verschiedene Klassen,
👉 aber alle sind „Widerstände“

➡️ Gemeinsame Eigenschaft:
Man kann immer fragen:
	1.	👉 Wie groß ist dein Widerstand?
	2.	👉 Aus wie vielen Einzelwiderständen bestehst du?

Genau DAS beschreibt das Interface.

Nur Methoden-Signaturen, keine Logik, keine Variablen.

Das ist Polymorphie!
*/

package Widerstände;

public interface Resistor {

     // returns the resistance value of the resistor
     double resistance();

     // returns the total number of individual resistors within the resistor
     int resistorCount();
}

