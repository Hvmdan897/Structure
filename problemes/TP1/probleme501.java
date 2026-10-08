package problemes.TP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class probleme501 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> frequences = new HashMap<>();
        compter(root, frequences);

        int max = 0;
        for (int f : frequences.values()) {
            if (f > max) max = f;
        }

        List<Integer> modes = new ArrayList<>();
        for (int valeur : frequences.keySet()) {
            if (frequences.get(valeur) == max) {
                modes.add(valeur);
            }
        }

        int[] resultat = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            resultat[i] = modes.get(i);
        }
        return resultat;
    }

    private static void compter(TreeNode noeud, HashMap<Integer, Integer> frequences) {
        if (noeud == null) return;

        frequences.put(noeud.val, frequences.getOrDefault(noeud.val, 0) + 1);
        compter(noeud.left, frequences);
        compter(noeud.right, frequences);
    }

    public static void main(String[] args) {

        TreeNode arbre1 = new TreeNode(1);
        arbre1.right = new TreeNode(2);
        arbre1.right.left = new TreeNode(2);

        System.out.println("Arbre [1,null,2,2] : ");
        System.out.println("Modes : " + Arrays.toString(findMode(arbre1)));

        TreeNode arbre2 = new TreeNode(0);

        System.out.println("Arbre [0] : ");
        System.out.println("Modes : " + Arrays.toString(findMode(arbre2)));

        TreeNode arbre3 = new TreeNode(1);
        arbre3.right = new TreeNode(2);

        System.out.println("Arbre [1,null,2] (égalité) : ");
        System.out.println("Modes : " + Arrays.toString(findMode(arbre3)));
    }
}