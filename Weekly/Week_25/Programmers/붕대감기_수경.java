class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int s_health = health;
        for (int i = 0; i < attacks.length; i++) {
            int term = (i == 0) ? (attacks[i][0] - 1) : (attacks[i][0] - attacks[i - 1][0] - 1);
            if (term > 0) {
                health += term * bandage[1]; // 공격받지 않은 시간동안 1초당 회복량
                if (term >= bandage[0]) { // 공격텀이 회복 시전시간(추가회복량 받을 수 있는 시간)보다 클 때
                    health += ((term / bandage[0]) * bandage[2]); // 체력 += 공격텀 / 시전시간 * 추가회복량
                }
                health = Math.min(health, s_health); // 체력이 최대체력을 넘을경우 최대체력으로
            }
            health -= attacks[i][1]; // 공격받고 체력감소
            if (health <= 0) { // 체력이 0 이하로 내려갈 경우
                return -1;
            }
        }
        return health;
    }
}