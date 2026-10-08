package problemes.TP1;

import java.util.LinkedList;

public class probleme234  {

    static boolean isPalindrome(LinkedList<Integer> list) {
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            if (!list.get(i).equals(list.get(j))) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(1);
        System.out.println("Liste 1 : ");
        System.out.println(list1);
        System.out.println("Est-ce un palindrome ? ");
        System.out.println(isPalindrome(list1));

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addLast(1);
        list2.addLast(2);
        System.out.println("Liste 2 : ");
        System.out.println(list2);
        System.out.println("Est-ce un palindrome ? ");
        System.out.println(isPalindrome(list2));

        LinkedList<Integer> list3 = new LinkedList<>();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(2);
        list3.addLast(1);
        System.out.println("Liste 3 : ");
        System.out.println(list3);
        System.out.println("Est-ce un palindrome ? ");
        System.out.println(isPalindrome(list3));
    }
}

