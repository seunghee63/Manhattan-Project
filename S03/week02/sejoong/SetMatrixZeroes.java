class Solution {
    //Runtime 23ms Beats 5.29% of users with Java
    //Memory 45.31 MB Beats 74.37% of users with Java
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> zeroXList = new ArrayList<>();
        ArrayList<Integer> zeroYList = new ArrayList<>();

        // 2차배열 matrix 순회
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 0인 x, y 위치 저장
                if (matrix[i][j] == 0) {
                    zeroXList.add(i);
                    zeroYList.add(j);
                }
            }
        }


        // 2차배열 matrix 순회
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 위에서 찾은 0의 x, y의 위치 값으로 0 변경
                if (zeroXList.contains(i) || zeroYList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
