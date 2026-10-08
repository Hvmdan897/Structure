package problemes.TP1;

import java.util.LinkedList;

public class probleme1290 {

    static int getDecimalValue(LinkedList<Integer> list) {
        int resultat = 0;

        for (int bit : list) {
            resultat = resultat * 2 + bit;
        }

        return resultat;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(0);
        list.addLast(1);
        System.out.println("Liste binaire : ");
        System.out.println(list);
        System.out.println("Valeur décimale : ");
        System.out.println(getDecimalValue(list));
    }
}