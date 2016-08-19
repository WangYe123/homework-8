public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = row == 0 ? 0 : matrix[0].length;
        int [][] height = new int [row][col + 1];
        int maxArea = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else{
                    height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
                }
            }
        }
        for (int i = 0; i < row; i++){
            int Area = maxAreaHelper(height[i]);
            maxArea = Math.max(maxArea, Area);
        }
        return maxArea;
    }
    private int maxAreaHelper (int[] height){
        Stack <Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int [] h = new int [height.length];
        h = Arrays.copyOf (height, height.length);
        while (i < h.length){
            if (stack.isEmpty() || h [stack.peek()] <= h[i]){
                stack.push(i++);
            }else{
                int tmp = stack.pop();
                maxArea = Math.max (maxArea, h[tmp] * (stack.isEmpty() ? i : i - stack.peek() - 1 ));
            }
        }
        return maxArea;
    }
}