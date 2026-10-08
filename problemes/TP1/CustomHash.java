package problemes.TP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomHash {

    static final long P = 31;
    static final long M = 1_000_000_009L;

    // Hachage polynomial du mot trié : deux anagrammes ont le même hash
    static long hash(String mot) {
        char[] lettres = mot.toCharArray();
        Arrays.sort(lettres);
        long h = 0;
        for (char c : lettres) h = (h * P + c) % M;
        return h;
    }

    public static Collection<List<String>> grouperAnagrammes(List<String> mots) {
        Map<Long, List<String>> groupes = new HashMap<>();
        for (String mot : mots) {
            groupes.computeIfAbsent(hash(mot), k -> new ArrayList<>()).add(mot);
        }
        return groupes.values();
    }

    public static void main(String[] args) {
        List<String> mots = Arrays.asList("chien", "niche", "chine", "arbre", "barre", "noeud", "unode");
        for (List<String> groupe : grouperAnagrammes(mots)) {
            System.out.println(groupe);
        }
    }
}