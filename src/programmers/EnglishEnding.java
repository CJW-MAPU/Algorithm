package programmers;

import java.util.HashSet;
import java.util.Set;

public class EnglishEnding {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {
//                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
//                "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"
                "hello", "one", "even", "never", "now", "world", "draw"
        };

        int[] a = solution(n, words);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int[] solution(int n, String[] words) {

        int allRoundNumber = (int) Math.ceil((double) words.length / n);

        String[][] word = new String[allRoundNumber][n];

        int index = 0;

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i].length; j++) {
                if (index == words.length) {
                    break;
                } else {
                    word[i][j] = words[index++];
                }
            }
        }

        char lastCharacter = word[0][0].charAt(0);

        Set<String> set = new HashSet<>();
        int setSize = 0;

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i].length; j++) {
                if (lastCharacter != word[i][j].charAt(0)) {
                    return new int[] {j + 1, i + 1};
                } else {
                    lastCharacter = word[i][j].charAt(word[i][j].length() - 1);

                    set.add(word[i][j]);

                    if (setSize == set.size()) {
                        return new int[] {j + 1, i + 1};
                    } else {
                        setSize++;
                    }
                }
            }
        }


        return new int[] {0, 0};
    }
}
