package com.interview.leetcode;

/**

	Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	
	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	
	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
	
	In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 * @author shuchun.yang
 *
 */
/*
 * 这题不好想，还是看了答案才明白。中心思路是：每个bar头顶能接多少水，取决于它两边有木有比自己高的两个木板，有的话自己上方就被trap住了，trap的volumn是（两边比自己高的那两个模板中的短板-自己的高度）×1。
然后就要考虑怎么求在每个木板i，他的左边最高板和右边最高板的值呢？用dp一试就出来了。这个就是因为很熟练LIS了，所以一下就做出来了。这种接水题也是，现在觉得难，多做几道思路就清晰了吧。
 */
public class TrappingRainWater {
	public static void main(String[] args) {
		System.out.println("sss".charAt(0));
		
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		TrappingRainWater t = new TrappingRainWater();
		t.trap(A);
	}
	
	public int trap(int[] A) {
		int[] left = new int[A.length];
	    int[] right = new int[A.length];
	    for (int i = 0; i < A.length; i++) {
	        left[i] = i > 0 ? Math.max(left[i - 1], A[i]) : A[i];
	    }
	    for (int i = A.length - 1; i >= 0; i--) {
	        right[i] = i < A.length - 1 ? Math.max(right[i + 1], A[i]) : A[i];
	    }
	    int result = 0;
	    for (int i = 1; i < A.length - 1; i++) { //two edges can't trap anything
	        int lowBar = Math.min(left[i - 1], right[i + 1]);
	        if (lowBar > A[i])
	        	result += lowBar - A[i];
	    }
	    return result;
    }
}
