/**
 * 
 */
package com.berina.unionfind;

/**
 * @author berina
 *
 */
public class SuccessorWitDelete {
	
	private int[] id;
	
	public SuccessorWitDelete(int n) {
		id = new int[n];
		for(int i=0; i<n; i++) {
			id[i] = i;
		}
	}
	
	public int delete(int p) {
		id[p] = -1;
		for(int i=p+1; i<id.length; i++)
			if (id[i] != -1)
				return i;
		return -1;
	}

}
