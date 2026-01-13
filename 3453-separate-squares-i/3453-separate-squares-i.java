class Solution {
    public double separateSquares(int[][] squares) {

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] sq : squares) {
            low = Math.min(low, sq[1]);
            high = Math.max(high, sq[1] + sq[2]);
        }

        for (int iter = 0; iter < 100; iter++) { 
            double mid = (low + high) / 2.0;

            double below = 0, above = 0;

            for (int[] sq : squares) {
                double y = sq[1];
                double s = sq[2];
                double top = y + s;
                double area = s * s;

                if (mid <= y) {
                    above += area;
                } else if (mid >= top) {
                    below += area;
                } else {
                    double part = (mid - y) * s;
                    below += part;
                    above += area - part;
                }
            }

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (low + high) / 2.0;
    }
}
