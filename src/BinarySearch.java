import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        /*Genskabning af hint datasættet da binary search forventer en sorteret liste.
        Man kunne også bruge Collections.sort() metoden men hvis man bruger et array med tilfældige tal,
        så kan det samme tal opstå to gange og binary search, i denne implementering, giver kun indekset på en.*/
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            data.add(i);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vælg et tal mellem 1 og 20");
        int num = scanner.nextInt();
        int resultat = findTalIArrayBinarySearch(num, data);
        if (resultat != -1) {
            System.out.println("Tallet har index " + resultat + " i datasættet.");
        }

    }

    /*I binary search starter man i det midterste index i et sorteret array, dvs. det midterste tal.
    * Hvis det midterste tal passer med tallet man søger efter så returnes dets index.
    * Hvis ikke, så ved man om man skal frasortere alle tal til venstre eller til højre for midten,
    * udfra relationen mellem det midterste tal og det tal man søger.
    * Er det midterste tal højere så ved man at det tal man søger ikke kan være i indeks højere end midten.
    * Man gentager derefter processen med en mindre liste indtil det midterste tal endelig er lig med tallet man søger.*/
    public static int findTalIArrayBinarySearch(int tal, ArrayList<Integer> data) {
        int mindre = 0, stoerre = data.get(data.size() - 1);
        int antalLoop = 0;
        while (mindre <= stoerre) {
            antalLoop++;
            int midten = (mindre + stoerre) / 2;
            if (data.get(midten) == tal) {
                System.out.println("Tal fundet efter " + antalLoop + " loops");
                return midten;
            }

            if (data.get(midten) < tal) {
                mindre = midten + 1;
            }

            if (data.get(midten) > tal) {
                stoerre = midten - 1;
            }
        }

        return -1;
    }
}
