package problemes.TP1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class probleme1971 {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graphe = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphe.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graphe.get(e[0]).add(e[1]);
            graphe.get(e[1]).add(e[0]);   
        }

        boolean[] visite = new boolean[n];
        Queue<Integer> file = new LinkedList<>();
        file.add(source);
        visite[source] = true;

        while (!file.isEmpty()) {
            int courant = file.remove();
            if (courant == destination) return true;

            for (int voisin : graphe.get(courant)) {
                if (!visite[voisin]) {
                    visite[voisin] = true;
                    file.add(voisin);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("n = 3, source = 0, destination = 2 : ");
        System.out.println("Chemin valide ? " + validPath(3, edges1, 0, 2));

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println("n = 6, source = 0, destination = 5 : ");
        System.out.println("Chemin valide ? " + validPath(6, edges2, 0, 5));
    }
}