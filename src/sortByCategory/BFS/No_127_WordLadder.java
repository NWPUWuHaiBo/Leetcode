package sortByCategory.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author haiboWu
 * @create 2020-03-12 18:19
 */
public class No_127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        while (end < n && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end==n){
            return 0;//beginWord equals endWord
        }
        List<Integer>[]graphic=buildGraphic(wordList);
        return getShortestPath(graphic,start,end);
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue=new LinkedList<>();
        boolean []marked=new boolean[graphic.length+1];
        queue.add(start);
        marked[start]=true;
        int path=1;
        while (!queue.isEmpty()){
            int size=queue.size();
            path++;
            while (size-->0){
                int cur=queue.poll();
                for (Integer next : graphic[cur]) {
                    if(next==end){
                        return path;
                    }
                    if(marked[next]){
                        continue;
                    }
                    marked[next]=true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int n=wordList.size();
        List<Integer>[] graphic=new List[n];
        for (int i = 0; i < n; i++) {
            graphic[i]=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if(isConnected(wordList.get(i),wordList.get(j))){
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private boolean isConnected(String s, String s1) {
        int diffCnt=0;
        for (int i = 0; i < s.length()&&diffCnt<2; i++) {
            if(s.charAt(i)!=s1.charAt(i)){
                diffCnt++;
            }
        }
        return diffCnt==1;
    }

}
