class Tweet{
    int time;
    int tweetId;
    Tweet(int t, int id ){
        time = t;
        tweetId = id;
    }
}
class Twitter {
    int timeStamp = 0;
    Map<Integer, Set<Integer>> followings = new HashMap<>();
    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    
    public Twitter() {
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(++timeStamp, tweetId);
        tweets.putIfAbsent(userId, new ArrayList<>());
        List<Tweet> userTweets = tweets.get(userId);
        userTweets.add(tweet); 
    }
    
   public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        if (followings.containsKey(userId)) {
            for (Integer followedId : followings.get(userId)) {
                if (tweets.containsKey(followedId)) {
                    pq.addAll(tweets.get(followedId));
                }
            }
        }

        int count = 0;
        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < 10) {
            Tweet currTweet = pq.poll();
            feed.add(currTweet.tweetId);
        }
        
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followings.putIfAbsent(followerId, new HashSet<>());
        followings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followings.containsKey(followerId)) {
            followings.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */