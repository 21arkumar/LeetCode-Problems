class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair pair = q.poll();
                
                if(image[pair.x][pair.y] == color) continue;

                for(int[] arr : dir){
                    int row = pair.x + arr[0];
                    int col = pair.y + arr[1];
                    if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != image[pair.x][pair.y] || image[row][col] == color) continue;
                    
                    q.add(new Pair(row, col));
                }
                image[pair.x][pair.y] = color;
            }
        }

        return image;
    }
}