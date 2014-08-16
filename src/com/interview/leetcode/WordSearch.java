package com.interview.leetcode;

/**

	Given a 2D board and a word, find if the word exists in the grid.
	
	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
	
	For example,
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.

 * @author shuchun.yang
 *
 */
public class WordSearch {
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}
				         ,{'S','F','C','S'}
				         ,{'A','D','E','E'}
				//,{'A','B','C','E'}
		};
		
		WordSearch search = new WordSearch();
		System.out.println(search.exist(board, "ABCCED"));
		System.out.println(search.exist(board, "SEE"));
		System.out.println(search.exist(board, "ABCB"));
	}
	
	public boolean exists1(char[][] board, String word) {
		if (board==null||word==null) {
			return false;
		}
		
		if (word.isEmpty()) {
			return true;
		}
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int row=0; row<board.length; row++) {
			for (int column=0; column<board[0].length; column++) {
				if (exists1(board, row, column, 0, word, visited)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean exists1(char[][] board, int row, int column, int level, String word, boolean[][] visited) {
		if (row<0||row>=board.length||column<0||column>=board[0].length) {
			return false;
		}
		
		
		if (visited[row][column]) {
			return false;
		}
		
		if (level==word.length()-1) {
			return board[row][column] == word.charAt(level);
		}
		
		if (board[row][column]!=word.charAt(level)) {
			return false;
		}
		
		visited[row][column] = true;
		boolean existed = exists1(board, row+1, column, level+1, word, visited) ||
				exists1(board, row-1, column, level+1, word, visited) ||
				exists1(board, row, column+1, level+1, word, visited) ||
				exists1(board, row, column-1, level+1, word, visited);
		visited[row][column] = false;
		return existed;
	}
	
	
	
	
	
	
	
	
	public boolean exist(char[][] board, String word) {
        if (board==null || word==null) {
        	return false;
        }
		
        if (word.isEmpty()) {
        	return true;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row=0; row<board.length; row++) {
        	for (int column=0; column<board[row].length; column++) {
        		if (exist(board, word, 0, row, column, visited)) {
        			return true;
        		}
        	}
        }
      
        return false;
    }
	
	public boolean exist(char[][] board, String word, int level, int row, int column, boolean[][] visited) {
		if (row<0||row>=board.length||column<0||column>=board[0].length) {
			return false;
		}
		
		if (visited[row][column]) {
			return false;
		}
		
		//if it is the last char in word, no need to go further
		if (level==word.length()-1) {
			return board[row][column] == word.charAt(level);
		}
		
		if (board[row][column]!=word.charAt(level)) {
			return false;
		}
		
		visited[row][column] = true;
		//check all possible directions
		boolean result = exist(board, word, level+1, row+1, column, visited) ||
				exist(board, word, level+1, row, column+1, visited) ||
				exist(board, word, level+1, row-1, column, visited) ||
				exist(board, word, level+1, row, column-1, visited);
		visited[row][column] = false;
		return result;
	}
}
