// Runtime 1ms Beats 64.15% of users with Java
// Memory 41.00MB Beats 14.10% of users with Java
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> repeats = new HashSet<>();

        while (n != 1 && !repeats.contains(n)) {
            repeats.add(n);

            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }

            n = sum;
        }

        return n == 1;
    }
}
