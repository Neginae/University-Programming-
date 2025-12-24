static int numbers(int[] dice, int category) {
    // Hilfsmethode:
    // Summiere Augenzahlen, die mit Kategorie-Nummer übereinstimmen
    int sum = 0;
    for(int number: dice) {
        if(number == category) {
            sum += number;
        }
    }
    return sum;
}

/**
 * Einser
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 1 zeigen
 */
static int aces(int[] dіce) {
    return numbers(dіce, 1);
}

/**
 * Zweier
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 2 zeigen
 */
static int twos(int[] dice) {
    return numbers(dice, 2);
}

/**
 * Dreier
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 3 zeigen
 */
static int threes(int[] dice) {
    return numbers(dice, 3);
}

/**
 * Vierer
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 4 zeigen
 */
static int fours(int[] dice) {
    return numbers(dice, 4);
}

/**
 * Fünfer
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 5 zeigen
 */
static int fives(int[] dice) {
    return numbers(dice, 5);
}

/**
 * Sechser
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return die Summe der Augenzahlen aller Würfel, die eine 6 zeigen
 */
static int sixes(int[] dice) {
    return numbers(dice, 6);
}




static int sum(int[] dice) {
    // Hilfsmethode für den Rest
    int sum = 0;
    for(int number: dice) {
        sum += number;
    }
    return sum;
}

/**
 * Dreierpasch
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return Summe aller Augenzahlen, wenn mind. 3 gleiche Zahlen vorhanden, ansonsten 0 Punkte
 */
static int threeOfAKind(int[] dice) {
    // Idee: Wenn die Würfel 1-3, 2-4 oder 3-5 dieselbe Augenzahl haben
    boolean firstThreeSame = dice[0] == dice[1] && dice[0] == dice[2];
    boolean midThreeSame = dice[1] == dice[2] && dice[1] == dice[3];
    boolean lastThreeSame = dice[2] == dice[3] && dice[2] == dice[4];
    if(firstThreeSame || midThreeSame || lastThreeSame) {
        return sum(dice);
    }
    return 0;
}

/**
 * Viererpasch
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return Summe aller Augenzahlen, wenn mind. 4 gleiche Zahlen vorhanden, ansonsten 0 Punkte
 */
static int fourOfAKind(int[] dice) {
    // Idee: Wenn die Würfel 1-4 oder 2-5 dieselbe Augenzahl haben 
    boolean firstFourSame = dice[0] == dice[1] && dice[0] == dice[2] && dice[0] == dice[3];
    boolean lastFourSame = dice[1] == dice[2] && dice[1] == dice[3] && dice[1] == dice[4];
    if(firstFourSame || lastFourSame) {
        return sum(dice);
    }
    return 0;
}

/**
 * Full House
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 25 Punkte bei drei gleichen und zwei gleichen Zahlen (aber nicht alle gleich), ansonsten 0 Punkte
 */
static int fullHouse(int[] dice) {
    // Idee: Wenn die Würfel 1-2 und 3-5 dieselbe Augenzahl haben oder 1-3 und 2-5, aber verschieden
    boolean twoPlusThree = dice[0] == dice[1] && dice[2] == dice[3] && dice[2] == dice[4];
    boolean threePlusTwo = dice[0] == dice[1] && dice[1] == dice[2] && dice[3] == dice[4];
    boolean notAllSame = dice[0] != dice[4];
    if((twoPlusThree || threePlusTwo) && notAllSame) {
        return 25;
    }
    return 0;
}

/**
 * Kleine Straße
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 30 Punkte bei vier aufeinanderfolgenden Augenzahlen, ansonsten 0 Punkte
 */
static int smallStraight(int[] dice) {
    // Idee: 3 und 4 müssen vorkommen, zusätzlich noch 2+5, 1+2 oder 5+6

    // Speicher in einem Array, welche Zahlen vorkommen (Array-Index = Augenzahl - 1) ---> "Track Presence"
    boolean[] numbersFound = new boolean[6];
    for(int gewürfelt: dice) {
        numbersFound[gewürfelt - 1] = true;
    }

    if(!numbersFound[2] || !numbersFound[3]) {
        return 0;
    }

    if((numbersFound[0] && numbersFound[1]) || (numbersFound[1] && numbersFound[4]) || (numbersFound[4] && numbersFound[5])) {
        return 30;
    }

    return 0;
}

/**
 * Große Straße
 * @param dice gewürfelte⁢ Augenzahlen, aufsteigend sortiert
 * @return 40 Punkte bei fünf aufeinanderfolgenden Augenzahlen, ansonsten 0 Punkte
 */
static int largeStraight(int[] dice) {
    // Idee: Wenn die Augenzahlen nicht immer um genau 1 größer werden 

    for(int i = 1; i < dice.length; i++) {
        if(dice[i-1] + 1 != dice[i]) {
            return 0;
        }
    }

    return 40;
}

/**
 * Kniffel
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return 50 Punkte bei fünf gleichen Zahlen, ansonsten 0 Punkte
 */
static int kniffel(int[] dice) {
    if(dice[0] == dice[1] && dice[0] == dice[2] && dice[0] == dice[3] && dice[0] == dice[4]) {
        return 50;
    }
    return 0;
}

/**
 * Chance
 * @param dice gewürfelte Augenzahlen, aufsteigend sortiert
 * @return Summe aller Augenzahlen
 */
static int chance(int[] dice) {
    return sum(dice);
}

static void main() {
    //Test
    
    int[] dice = {1, 1, 1, 1, 1};
    
    Arrays.sort(dice);

    System.out.println("Einser: " + aces(dice));
    System.out.println("Zweier: " + twos(dice));
    System.out.println("Dreier: " + threes(dice));
    System.out.println("Vierer: " + fours(dice));
    System.out.println("Fünfer: " + fives(dice));
    System.out.println("Sechser: " + sixes(dice));
    System.out.println("Dreierpasch: " + threeOfAKind(dice));
    System.out.println("Viererpasch: " + fourOfAKind(dice));
    System.out.println("Full House: " + fullHouse(dice));
    System.out.println("Kleine Straße: " + smallStraight(dice));
    System.out.println("Große Straße: " + largeStraight(dice));
    System.out.println("Kniffel: " + kniffel(dice));
    System.out.println("Chance: " + chance(dice));
}
