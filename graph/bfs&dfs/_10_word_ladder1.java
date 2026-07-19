import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _10_word_ladder1 {
    static class Pair{
        String word;
        int step;
        Pair(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    static int bfs(String start, String end, String[] words){
        Set<String> set = new HashSet<>();
        for(String s:words)set.add(s);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 1));

        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int step = queue.peek().step;
            queue.poll();

            if (word.equals(end)) {
                return step;
            }

            for(int i=0;i<word.length();i++){
                char[] tmp = word.toCharArray();
                for(char c='a';c<='z';c++){
                    tmp[i] = c;
                    String newWord = new String(tmp);
                    if (set.contains(newWord)) {
                        queue.add(new Pair(newWord, step+1));
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        
        //Output: 5
        //"hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long
        System.out.println(bfs(beginWord, endWord, wordList));
    }
}