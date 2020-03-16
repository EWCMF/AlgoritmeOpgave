public class SelectionSort {
    public static void main(String[] args) {
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100 + 1);
        }

        System.out.println("Datasættet i usorteret udgave:");
        for (int tal : data) {
            System.out.print(tal + " ");
        }
        System.out.println();

        // Variabel indført for at se nødvendige if-statements til sammenligning med bubble sort.
        int sammenligninger = 0;

        /* I selection sort går man igennem hele datasættet og 'trækker' det tal ud som er mindst.
        * Dette tal er nu ikke med i det næste loop og derfra kan det næste mindste tal findes.
        * Sådan fortsætter det indtil de mindste tal fra hver iteration er fundet,
        * og man kan stille alle de mindste tal fra hvert loop ved siden af hinanden og have en sorteret liste.*/
        for (int i = 0; i < data.length - 1; i++) {
            int minimumIndex = i;
            for (int j = i+1; j < data.length; j++) {
                sammenligninger++;
                if (data[j] < data[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            int temp = data[minimumIndex];
            data[minimumIndex] = data[i];
            data[i] = temp;
        }

        System.out.println("Efter selection sort algoritme med " + sammenligninger + " sammenligninger:");
        for (int tal : data) {
            System.out.print(tal + " ");
        }
    }
}
