class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] subBoxes = new int[3][9];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                int rVal = (board[i][j]) - '1';
                int cVal = (board[j][i]) - '1';

                if (board[i][j] == '.') {

                } else {

                    rows[rVal]++;
                    if (rows[rVal] > 1) {
                        return false;
                    }

                    if (j < 3) {
                        subBoxes[0][rVal]++;
                        if (subBoxes[0][rVal] > 1) {
                            return false;
                        }
                    }
                    else if (j < 6) {
                        subBoxes[1][rVal]++;
                        if (subBoxes[1][rVal] > 1) {
                            return false;
                        }
                    }
                    else {
                        subBoxes[2][rVal]++;
                        if (subBoxes[2][rVal] > 1) {
                            return false;
                        }
                    }
                }

                if (board[j][i] == '.') {

                } else {
                    cols[cVal]++;
                    if (cols[cVal] > 1) {
                        return false;
                    }
                }

            }
            rows = new int[9];
            cols = new int[9];
            if (((i + 1) % 3) == 0) {
                subBoxes = new int[3][9];
            }

        }
        return true;
    }
}