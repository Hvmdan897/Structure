package problemes.TP1;

import java.util.LinkedList;

public class probleme2 {

    static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> resultat = new LinkedList<>();
        int carry = 0;
        int i = 0;

        while (i < l1.size() || i < l2.size() || carry != 0) {
            int sum = carry;
            if (i < l1.size()) sum += l1.get(i);
            if (i < l2.size()) sum += l2.get(i);

            resultat.addLast(sum % 10);
            carry = sum / 10;
            i++;
        }
        return resultat;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.addLast(10);
        l1.addLast(9);
        l1.addLast(2);
        System.out.println("Liste 1 (2910) : ");
        System.out.println(l1);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.addLast(9);
        l2.addLast(3);
        l2.addLast(9);
        System.out.println("Liste 2 (939) : ");
        System.out.println(l2);

        System.out.println("Résultat de l'addition (1239) : ");
        System.out.println(addTwoNumbers(l1, l2));
    }
}