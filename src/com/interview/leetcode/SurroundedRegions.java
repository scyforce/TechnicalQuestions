package com.interview.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**

	Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
	
	A region is captured by flipping all 'O's into 'X's in that surrounded region.
	
	For example,
	X X X X
	X O O X
	X X O X
	X O X X
	
	After running your function, the board should be:	
	X X X X
	X X X X
	X X X X
	X O X X

 * @author shuchun.yang
 *
 */
public class SurroundedRegions {    
    public static void main(String[] args) {
    	SurroundedRegions s = new SurroundedRegions();
    	char[][] board = {{'X', 'X', 'X', 'X'},
    			          {'X', 'O', 'O', 'X'},
    			          {'X', 'X', 'X', 'X'},
    					  {'X', 'O', 'X', 'X'}};
    	
    	s.solve(board);
    	
    	for (char[] b : board) {
    		System.out.println(Arrays.toString(b));
    	}
    }
	
	
    /**
     * Core idea: start from the O on the board line, use BFS search, if find O then no need to replace, otherwise replace
     * 
     * For leetcode, please replace integer with an object
     * @param board
     */
    public void solve(char[][] board) {  
        if (board == null || board.length <= 0) {  
            return;  
        }  
  
        int m = board.length;  
        int n = board[0].length;  
        
        Queue<Integer> queue = new LinkedList<Integer>();  
        
        
        for (int i = 0; i < m; i++) { 
        	//first line;
            if (board[i][0] == 'O') {  
                queue.add(i*m+0);  
                bfs(queue, board);  
            }  
            //last line;
            if (board[i][n - 1] == 'O') {  
                queue.add(i*m+(n-1));  
                bfs(queue, board);  
            }  
        }  
        for (int j = 1; j < n - 1; j++) {
        	//first column
            if (board[0][j] == 'O') {  
                queue.add(0*m+j);  
                bfs(queue, board);  
            }  
            //last column
            if (board[m - 1][j] == 'O') {  
                queue.add((m-1)*m+1);  
                bfs(queue, board);  
            }  
        }  
        
        //replace with X if still O
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (board[i][j] == 'O') {  
                    board[i][j] = 'X';  
                } else if (board[i][j] == '#') {  
                    board[i][j] = 'O';  
                }  
            }  
        }  
    }  
  
    private void bfs(Queue<Integer> queue, char[][] board) {  
    	int m = board.length;
    	int n = board[0].length;
        while (!queue.isEmpty()) {  
            int curr = queue.poll();  
            int i = curr/m;
            int j = curr%m;
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X') {  
                continue;  
            }  
            board[i][j] = '#';  
            queue.add((i-1)*m+j);  
            queue.add((i+1)*m+j);  
            queue.add(i*m+(j+1));  
            queue.add(i*m+(j-1));  
        }  
    }  
}
