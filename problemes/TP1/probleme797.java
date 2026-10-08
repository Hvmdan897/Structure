package problemes.TP1;

import java.util.ArrayList;
import java.util.List;

public class probleme797 {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resultat = new ArrayList<>();
        List<Integer> chemin = new ArrayList<>();
        chemin.add(0);  

        dfs(graph, 0, chemin, resultat);
        return resultat;
    }

    private static void dfs(int[][] graph, int noeud, List<Integer> chemin, List<List<Integer>> resultat) {
        // On est arrivé au dernier noeud : on garde une COPIE du chemin
        if (noeud == graph.length - 1) {
            resultat.add(new ArrayList<>(chemin));
            return;
        }

        for (int voisin : graph[noeud]) {
            chemin.add(voisin);                      
            dfs(graph, voisin, chemin, resultat);
            chemin.remove(chemin.size() - 1);          
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {3}, {3}, {}};
        System.out.println("graph = [[1,2],[3],[3],[]] : ");
        System.out.println("Chemins : " + allPathsSourceTarget(graph1));

        int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println("graph = [[4,3,1],[3,2,4],[3],[4],[]] : ");
        System.out.println("Chemins : " + allPathsSourceTarget(graph2));
    }
}