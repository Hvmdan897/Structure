package problemes.TP1;

import java.util.LinkedList;

public class probleme203 {

    static void removeElements(LinkedList<Integer> list, int val) {
        while (list.remove(Integer.valueOf(val))) {
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(6);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        System.out.println("Liste de départ : ");
        System.out.println(list);

        removeElements(list, 6);
        System.out.println("Liste après avoir supprimé tous les 6 : ");
        System.out.println(list);

        LinkedList<Integer> vide = new LinkedList<>();
        removeElements(vide, 1);
        System.out.println("Liste vide après avoir supprimé les 1 : ");
        System.out.println(vide);

        LinkedList<Integer> sept = new LinkedList<>();
        sept.addLast(7);
        sept.addLast(7);
        sept.addLast(7);
        sept.addLast(7);
        removeElements(sept, 7);
        System.out.println("Liste [7, 7, 7, 7] après avoir supprimé tous les 7 : ");
        System.out.println(sept);
    }
}