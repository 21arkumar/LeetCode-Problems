class AuthenticationManager {
    Map<String, Integer> liveToken = new HashMap<>();
    int ttl = 0;
    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        liveToken.putIfAbsent(tokenId, currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(liveToken.containsKey(tokenId)){
            if((liveToken.get(tokenId) + ttl) > currentTime){
                liveToken.put(tokenId, currentTime);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(Map.Entry<String, Integer> tok : liveToken.entrySet()){
            if((tok.getValue() + ttl) > currentTime){
                count++;
            }
        }

        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */