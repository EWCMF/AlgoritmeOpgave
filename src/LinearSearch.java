import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearch {
    // array'et er statisk så metoderne bare kan ændre array'et uden at behøve at tage det som parameter.
    static ArrayList<Integer> data = new ArrayList<>();

    public static void main(String[] args) {
        /* datasættet fyldes med 10 tilfældige tal fra 1 til 10.
        Den lille rækkevidde af tal er for at gøre det mere sansynligt at man vælger et tal som er i array'et*/
        for (int i = 0; i < 10; i++) {
            data.add((int) (Math.random() * 10) + 1);
        }
        System.out.println("Listen af data indeholder 10 tal med en tilfældig værdi på 1 til 10");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vælg et tal mellem 1 og 10 og se om det er i datasættet." );
        boolean foundValidNumber = false;
        int num = 0;

        // Simpelt while loop så et ugyldigt tal ikke vælges.
        while (!foundValidNumber) {
            num = scanner.nextInt();
            if (num >= 1 && num <= 10) {
                foundValidNumber = true;
            }
            else {
                System.out.println("Ugyldigt tal");
            }
        }

        /* Boolean bestemmer hvilken besked der skal skrives i konsollen.
        Hvis tallet ikke findes giver det ikke mening at bruge findAlle metoden.*/
        if (find(num)) {
            System.out.println("Tallet findes i datasættet.");
            System.out.println("Tallet forekommer " + findAlle(num) + " gang(e) i datasættet");
        }
        else {
            System.out.println("Tallet findes ikke i datasættet");
        }
        System.out.println("Det største tal i datasættet er " + findMax());

        System.out.println("\nHer er datasættet:");
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i) + " ");
        }




    }

    public static boolean find(int x) {
        // I linear search kører man bare igennem hele datasættet indtil man finder tallet man søger. Hvis det ikke er der, får man false.
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == x) {
                return true;
            }
        }
        return false;
    }

    // Får at finde antallet skal man indføre en variabel der incrementerer med 1 hver gang if-statement'en er true.
    public static int findAlle(int x) {
        int antal = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == x) {
                antal++;
            }
        }
        return antal;
    }

    /* Igen løbes hele datasættet igennem fra starten.
    Det første tal anses for at være det største indtil det modsatte er bevist i en if-statement.
    Hvis det sker, overtager det højere tal derefter den gamles plads i max variablen.*/
    public static int findMax() {
        int max = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i) > max) {
                max = data.get(i);
            }
        }
        return max;
    }
}
