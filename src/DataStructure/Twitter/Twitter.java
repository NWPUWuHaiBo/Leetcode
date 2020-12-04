package DataStructure.Twitter;

import java.util.*;

/**
 * @author haiboWu
 * @create 2020-06-29 21:01
 */
public class Twitter {
    private static int timestamp = 0;

    public class Tweet {
        private int id;
        private int time;
        public Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    public class User {
        private int id;
        public Set<Integer> followed;

        public Tweet head;

        public User(int userId) {
            this.id = userId;
            followed = new HashSet<>();
            this.head = null;
            //关注一下自己
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unFollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }

    }

    HashMap<Integer, User> userMap = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    /**
     * 返回该 user 关注的⼈（包括他⾃⼰） 最近的动态 id，
     * 最多 10 条， ⽽且这些动态必须按从新到旧的时间线顺序排列。
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;

        //关注列表的用户id
        User user = userMap.get(userId);
        Set<Integer> followed = user.followed;

        // ⾃动通过 time 属性从⼤到⼩排序， 容量为 users 的⼤⼩
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size(), (a, b) -> {
            return b.time - a.time;
        });

        //现将所有链表头结点插入优先队列
        for (Integer id : followed) {
            Tweet tweet = userMap.get(id).head;
            if (tweet == null) continue;
            pq.add(tweet);
        }

        while (!pq.isEmpty()) {
            if (res.size() == 10) break;

            Tweet twt = pq.poll();
            res.add(twt.id);
            if (twt.next != null) {
                pq.add(twt.next);
            }
        }
        return res;
    }

    /**
     * follower 关注 followee， 如果 Id 不存在则新建
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User user = userMap.get(followerId);
        user.follow(followeeId);
    }

    /**
     * follower 取关 followee， 如果 Id 不存在则什么都不做
     */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User flwer = userMap.get(followerId);
            flwer.unFollow(followeeId);
        }
    }
}
