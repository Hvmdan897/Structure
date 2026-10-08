package problemes.TP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class probleme210 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graphe = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graphe.add(new ArrayList<>());
        }

        int[] entrants = new int[numCourses];
        for (int[] p : prerequisites) {
            graphe.get(p[1]).add(p[0]);
            entrants[p[0]]++;
        }

        Queue<Integer> file = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (entrants[i] == 0) {
                file.add(i);
            }
        }

        int[] ordre = new int[numCourses];
        int position = 0;

        while (!file.isEmpty()) {
            int cours = file.remove();
            ordre[position] = cours;
            position++;

            for (int suivant : graphe.get(cours)) {
                entrants[suivant]--;
                if (entrants[suivant] == 0) {
                    file.add(suivant);
                }
            }
        }

        if (position != numCourses) {
            return new int[0];
        }
        return ordre;
    }

    public static void main(String[] args) {
        int[][] prereq1 = {{1, 0}};
        System.out.println("numCourses = 2, prerequisites = [[1,0]] : ");
        System.out.println("Ordre : " + Arrays.toString(findOrder(2, prereq1)));

        int[][] prereq2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]] : ");
        System.out.println("Ordre : " + Arrays.toString(findOrder(4, prereq2)));

        int[][] prereq3 = {};
        System.out.println("numCourses = 1, prerequisites = [] : ");
        System.out.println("Ordre : " + Arrays.toString(findOrder(1, prereq3)));

        int[][] prereq4 = {{1, 0}, {0, 1}};
        System.out.println("numCourses = 2, prerequisites = [[1,0],[0,1]] (cycle) : ");
        System.out.println("Ordre : " + Arrays.toString(findOrder(2, prereq4)));
    }
}