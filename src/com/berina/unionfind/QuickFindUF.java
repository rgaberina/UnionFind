/**
 * 
 */
package com.berina.unionfind;

/**
 * @author berina
 *
 */
public class QuickFindUF {
	
	public static void main(String[] args) {
		
	}
	
	private int[] elements;
	
	public QuickFindUF(int n) {
		elements = new int[n];
		for(int i=0; i<n; i++) {
			elements[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return (elements[p] == elements[q]);
	}
	
	public void union(int p, int q) {
		int r = elements[q];
		int s = elements[p];
		for(int i=0; i<elements.length; i++) {
			if(elements[i] == r)
				elements[i] = s;
		}
	}

}
