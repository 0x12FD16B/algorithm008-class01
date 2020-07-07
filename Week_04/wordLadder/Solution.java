package wordLadder;

import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * @author David Liu
 */
public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();
        Map<String, List<String>> wordDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);
                List<String> transformations = wordDict.getOrDefault(newWord, new LinkedList<>());
                transformations.add(word);
                wordDict.put(newWord, transformations);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, l);

                for (String adWord : wordDict.getOrDefault(newWord, new LinkedList<>())) {
                    if (adWord.equals(endWord)) return level + 1;
                    if (!visited.containsKey(adWord)) {
                        visited.put(adWord, true);
                        queue.offer(new Pair<>(adWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
