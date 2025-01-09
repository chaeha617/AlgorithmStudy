class 퍼즐게임챌린지_주희 {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculate(mid, diffs, times) <= limit) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long calculate(int level, int[] diffs, int[] times) {
        long totalTime = 0;
        int n = diffs.length;

        for (int i = 0; i < n; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                int d = diffs[i] - level;
                totalTime += (long) d * (times[i] + (i > 0 ? times[i - 1] : 0)) + times[i];
            }
            if (totalTime > Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        }

        return totalTime;
    }
}
