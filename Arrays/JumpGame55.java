public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If the current index is beyond the maximum reachable index, return false
            }
            maxReach = Math.max(maxReach, i + nums[i]); // Update the maximum reachable index
        }
        return true; // If we can reach the end of the array, return true
    }
}
