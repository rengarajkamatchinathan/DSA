import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    public static void main(String[] args) {
        String startWord = "der"; 
        String targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };

        // 1. Queue with start word with list
        // 2. BFS With list's end word and push into Queue
        // 3. Maintain used words on level to prevent overflow

        Set<String> set = new HashSet<>();
        Queue<List<String>> q = new LinkedList<>();
        List<String> usedWordsForLevel =  new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        List<String> tmp = new ArrayList<>();
        tmp.add(startWord);
        q.add(tmp);
        usedWordsForLevel.add(startWord);
        int level = 0;

        //set initialize
        for(String str:wordList){
            set.add(str);
        }

        while (!q.isEmpty()) {
            List<String> tempList = q.poll();
            String start = tempList.get(tempList.size()-1);
            
            if(start.equals(targetWord)){
                res.add(tempList);
            }

            if(tempList.size()>level){
                level++;
                for(String i : usedWordsForLevel){
                    set.remove(i);
                }
            }

            for(int i=0;i<start.length();i++){
                char[] wordLis = start.toCharArray();
                for(char c='a';c<='z';c++){
                    wordLis[i]=c;
                    String str = new String(wordLis);
                    if(set.contains(str)){
                        List<String> tmpList = new ArrayList<>(tempList);
                        tmpList.add(str);
                        usedWordsForLevel.add(str);
                        q.add(tmpList);
                    }
                }
            }
        }

        for(List<String> str:res){
            System.out.println(str);
        }

        
    }
}