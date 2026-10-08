package problemes.TP1;

import java.util.HashSet;

public class probleme217 {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> vus = new HashSet<>();

        for (int n : nums) {
            if (vus.contains(n)) {
                return true;
            }
            vus.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Tableau [1, 2, 3, 1] : ");
        System.out.println("Contient un doublon ? " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Tableau [1, 2, 3, 4] : ");
        System.out.println("Contient un doublon ? " + containsDuplicate(nums2));

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Tableau [1, 1, 1, 3, 3, 4, 3, 2, 4, 2] : ");
        System.out.println("Contient un doublon ? " + containsDuplicate(nums3));
    }
}