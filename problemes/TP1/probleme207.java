package problemes.TP1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class probleme207 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int coursTermines = 0;
        while (!file.isEmpty()) {
            int cours = file.remove();
            coursTermines++;

            for (int suivant : graphe.get(cours)) {
                entrants[suivant]--;
                if (entrants[suivant] == 0) {
                    file.add(suivant);
                }
            }
        }

        return coursTermines == numCourses;
    }

    public static void main(String[] args) {
        int[][] prereq1 = {{1, 0}};
        System.out.println("numCourses = 2, prerequisites = [[1,0]] : ");
        System.out.println("Peut tout finir ? " + canFinish(2, prereq1));

        int[][] prereq2 = {{1, 0}, {0, 1}};
        System.out.println("numCourses = 2, prerequisites = [[1,0],[0,1]] : ");
        System.out.println("Peut tout finir ? " + canFinish(2, prereq2));
    }
}