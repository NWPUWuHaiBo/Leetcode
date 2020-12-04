package sortByCategory.BFS;

import org.junit.Test;

import java.util.*;

/**
 * @author haiboWu
 * @create 2020-03-12 18:19
 */
public class No_127_WordLadder {

    @Test
    public void test() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        int i = ladderLength(beginWord, endWord, Arrays.asList(wordList));
        System.out.println(i);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return count;
                }
                //获取相邻节点
                List<String> ladderWords = getLadderWords(cur, wordList);
                for (String ladder : ladderWords) {
                    if (visited.contains(ladder)) {
                        continue;
                    }
                    queue.add(ladder);
                    visited.add(ladder);
                }
            }
            count++;
        }
        return count;
    }

    private List<String> getLadderWords(String cur, List<String> wordList) {
        List<String> res = new ArrayList<>();
        for (String list : wordList) {
            int count = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != list.charAt(i)) {
                    count++;
                }
            }
            if (count <= 1) {
                res.add(list);
            }
        }
        return res;
    }
}
