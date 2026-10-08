package problemes.TP1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CombineStacks {

    // Retourne un stack trié : le sommet est le plus petit élément
    public static Deque<Integer> combine_stacks(Deque<Integer> stack1, Deque<Integer> stack2) {
        List<Integer> tous = new ArrayList<>(stack1);
        tous.addAll(stack2);
        tous.sort(Collections.reverseOrder());

        Deque<Integer> resultat = new LinkedList<>();
        for (int x : tous) resultat.push(x);
        return resultat;
    }

    public static void main(String[] args) {
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        s1.push(5); s1.push(1); s1.push(9);
        s2.push(4); s2.push(7); s2.push(2);

        Deque<Integer> r = combine_stacks(s1, s2);
        while (!r.isEmpty()) System.out.print(r.pop() + " ");
        System.out.println();
    }
}