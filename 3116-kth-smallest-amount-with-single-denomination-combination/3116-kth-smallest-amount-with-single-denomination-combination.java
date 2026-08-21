class Solution {

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        List<Integer> list = new ArrayList<>();
        for (int coin : coins) {
            boolean redundant = false;
            for (int x : list) {
                if (coin % x == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) {
                list.add(coin);
            }
        }

        int m = list.size();
        long low = 1;
        long high = (long) list.get(0) * k;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(mid, list) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long count(long x, List<Integer> coins) {
        int m = coins.size();
        long result = 0;
        for (int mask = 1; mask < (1 << m); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    long g = gcd(lcm, coins.get(i));
                    lcm = lcm / g * coins.get(i);
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) {
                continue;
            }
            long multiples = x / lcm;
            if (bits % 2 == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }
        return result;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}