package wordLadder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * word ladder test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit", endWord = "cog";
        int expect = 5;
        int actual = solution.ladderLength(beginWord, endWord, wordList);
        Assert.assertEquals(actual, expect);
    }
}
