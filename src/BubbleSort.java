public class BubbleSort {
    public static void main(String[] args) {
        // Et simpelt array initialiseres med 10 pladser.
        int[] data = new int[10];

        // Array'et fyldes med tilfældige tal fra 1 til 100 gennem et for-loop.
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 100 + 1);
        }

        System.out.println("Datasættet i usorteret udgave:");
        for (int tal : data) {
            System.out.print(tal + " ");
        }

        System.out.println();
        bubbleSort(data);

        System.out.println("Datasættet efter sortering i stigende rækkefølge:");
        for (int tal : data) {
            System.out.print(tal + " ");
        }
    }

    private static void bubbleSort(int[] data) {
        // Variabel her er nødvendig for nemt at bytte plads mellem to tal i array.
        int temp;

        // Indført så man kan se antallet af if-statements, for sammenligning med selection sort.
        int sammenligninger = 0;

        for (int i = 0; i < data.length; i++) {

            /* Ved hver iteration bliver sorteret sat til true således at hvis ingen sortering sker for gældende index,
            så bryder den looped uden at behøve at fortsætte.*/
            boolean sorteret = true;

            for (int j = 1; j < (data.length - i); j++) {
                sammenligninger++;
                if (data[j - 1] > data[j]) {
                    /* temp er nødvendig da
                    data[j - 1] = data[j]
                    data[j] = data[j - 1]
                    selfølgelig bare giver samme tal i stedet for at bytte plads som er hensigten.
                     */
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                    sorteret = false;
                }
            }

            if (sorteret) {
                break;
            }
        }
        System.out.println("Sorteret med " + sammenligninger + " sammenligninger");
    }
}
