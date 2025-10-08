class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n];
        TreeSet<Integer> drylake = new TreeSet<>();
        
        for(int i = 0; i < n; i++){
            if(rains[i] == 0){
                ans[i] = 1;
                drylake.add(i);
            }else{
                ans[i] = -1;
                int lake = rains[i];
                if (map.containsKey(lake)) {
                    Integer dryDay = drylake.higher(map.get(lake));
                    if (dryDay == null) return new int[0]; // flood!
                    ans[dryDay] = lake; // dry this lake on that day
                    drylake.remove(dryDay);
                }
                map.put(lake, i);    
            }
        }

        return ans;
    }
}