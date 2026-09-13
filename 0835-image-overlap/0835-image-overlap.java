class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> A = new ArrayList<>();
        List<int[]> B = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) A.add(new int[]{i, j});
                if (img2[i][j] == 1) B.add(new int[]{i, j});
            }
        }
            HashMap<String, Integer> cnt = new HashMap<>();
        int best = 0;

        for (int[] a : A) {
            for (int[] b : B) {
                int dx = b[0] - a[0];
                int dy = b[1] - a[1];
                String key = dx + "," + dy;
                int updated = cnt.getOrDefault(key, 0) + 1;
                cnt.put(key, updated);
                best = Math.max(best, updated);
            }
        }
        return best;
    }
}