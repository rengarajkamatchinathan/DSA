import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _11_word_ladder2 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        
        //Output:
        // ["hit","hot","dot","dog","cog"],
        // ["hit","hot","lot","log","cog"]

        List<List<String>> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Map<String, Integer> hMap = new HashMap<>();
        hMap.put(beginWord, 1);

        Set<String> set = new HashSet<>();
        for(String s:wordList)set.add(s);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = hMap.get(word);

            if (word.equals(endWord)) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                char tmp[] = word.toCharArray();
                for(char c='a';c<='z';c++){
                    tmp[i] = c;
                    String newWord = new String(tmp);
                    if (set.contains(newWord)) {
                        queue.add(newWord);
                        set.remove(newWord);
                        hMap.put(newWord, level+1);
                    }
                }
            }
        }

        List<String> tmp = new ArrayList<>();
        tmp.add(endWord);
        dfs(endWord, beginWord, res, tmp, hMap);

        for(List<String> t:res){
            System.out.println(t);
        }
    }

    static void dfs(String end, String start, List<List<String>> res, 
        List<String> tmp, Map<String, Integer> hMap)
        {
            if (end.equals(start)) {
                List<String> tmp_res = new ArrayList<>(tmp);
                Collections.reverse(tmp_res);
                res.add(tmp_res);
                return;
            }

            for (int i = 0; i < end.length(); i++) {
                char tmpchars[] = end.toCharArray();
                for(char c='a';c<='z';c++){
                    tmpchars[i] = c;
                    String newWord = new String(tmpchars);
                    if (hMap.containsKey(newWord) && hMap.get(end)-1 == hMap.get(newWord)) {
                        tmp.add(newWord);
                        dfs(newWord, start, res, tmp, hMap);
                        tmp.remove(tmp.size()-1);
                    }
                }
            }
        }
    }