/**
 * 
 */
package com.berina.unionfind;

/**
 * @author berina
 *
 */
public class QuickUnionUF {

	private int[] elements;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public QuickUnionUF(int n) {
		elements = new int[n];
		for(int i=0; i<n; i++) {
			elements[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		elements[rootP] = rootQ;
	}
	
	private int root(int p) {
		int root = p;
		while (root != elements[root]) {
			root = elements[root];
		}
		return root;
	}

}
