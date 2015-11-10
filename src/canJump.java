public class canJump {
    /**
     * @param A : A list of integers
     * @return: The boolean answer
     */
    public static boolean canJump(int[] A) {
        if (A[0] == 0) {
            return false;
        }
        int index = 0;
        int start = 0;
        int end = A[index];
        boolean continuee = true;
        while (continuee) {
            continuee = false;
            for (int i = start; i < A.length && i < end; i++) {
                if (end < i + A[i]) {
                    start = i;
                    end = i + A[i];
                    continuee = true;
                }
                if (end >= A.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{4, 3, 5, 8, 3, 7, 10, 2, 5, 5, 2, 0, 5, 8, 5, 2, 6, 2, 6, 8}));
        // System.out.println(canJump(new int[] { 5, 8, 3, 0, 6, 7, 9, 6, 3, 4,
        // 5, 2, 0, 6, 2, 6, 7, 10, 8, 0 }));
    }
}
