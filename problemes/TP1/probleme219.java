package problemes.TP1;

import java.util.HashMap;

public class probleme219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> dernierePosition = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (dernierePosition.containsKey(nums[i])) {
                if (i - dernierePosition.get(nums[i]) <= k) {
                    return true;
                }
            }
            dernierePosition.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Tableau [1, 2, 3, 1], k = 3 : ");
        System.out.println("Doublon proche ? " + containsNearbyDuplicate(nums1, 3));

        int[] nums2 = {1, 0, 1, 1};
        System.out.println("Tableau [1, 0, 1, 1], k = 1 : ");
        System.out.println("Doublon proche ? " + containsNearbyDuplicate(nums2, 1));

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        System.out.println("Tableau [1, 2, 3, 1, 2, 3], k = 2 : ");
        System.out.println("Doublon proche ? " + containsNearbyDuplicate(nums3, 2));
    }
}