package heap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter{
    Map<Integer, Set<Integer>> following;
    Map<Integer, List<int[]>> tweets;
    int time;
    Twitter(){
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    void postTweet(int userId, int tweetId){
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }

    void follow(int followerId, int followeeId){
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    void unfollow(int followerId, int followeeId){
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    List<Integer> getNewsFeed(int userId){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        //Add own tweets
        if (tweets.containsKey(userId)) {
            for(int tweet[]:tweets.get(userId)){
                pq.offer(tweet);
                if(pq.size()>10){
                    pq.poll();
                }
            }
        }

        //Followings tweets
        if (following.containsKey(userId)) {
            for(int followings:following.get(userId)){
                if (tweets.containsKey(followings)) {
                    for(int tweet[]:tweets.get(followings)){
                        pq.offer(tweet);
                        if(pq.size()>10){
                            pq.poll();
                        }
                    }
                }
            }
        }

        List<Integer> res= new ArrayList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll()[1]);
        }

        return res;
    }
}
public class _1_design_twitter {
    public static void main(String[] args) {
        
    }
}
