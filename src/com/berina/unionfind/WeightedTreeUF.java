/**
 * 
 */
package com.berina.unionfind;

/**
 * @author berina
 *
 */
public class WeightedTreeUF {
	
	private int[] id;
	private int[]size;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public WeightedTreeUF(int n) {
		id = new int[n];
		for(int i=0; i<n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public void union(int p, int q) {
		int pRoot = root(p);
		int qRoot = root(q);
		if (pRoot == qRoot)
				return;
		if(size[pRoot] <= size[qRoot]) {
			id[pRoot] = qRoot;
			size[qRoot] = size[qRoot] + size[pRoot];
		} else {
			id[qRoot] = pRoot;
			size[pRoot] = size[qRoot] + size[pRoot];
		}
	}
	
	private int root(int p) {
		int root = p;
		while (root != id[root]) {
			root = id[root];
		}
		return root;
	}
	
	public int find(int p) {
		int i=p;
		
		return p;
	}
}
