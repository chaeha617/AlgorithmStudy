class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health - attacks[0][1];

        if (currentHealth <= 0) {
            return -1;
        }

        for (int i = 1; i < attacks.length; i++) {
            int timeBetweenAttacks = attacks[i][0] - attacks[i - 1][0] - 1;

            currentHealth += bandage[1] * timeBetweenAttacks + (timeBetweenAttacks / bandage[0]) * bandage[2];

            if (currentHealth > health) {
                currentHealth = health;
            }

            currentHealth -= attacks[i][1];

            if (currentHealth <= 0) {
                return -1;
            }
        }

        return currentHealth;
    }
}