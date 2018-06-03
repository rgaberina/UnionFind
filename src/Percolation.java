import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * @author berina
 *
 */
public class Percolation {
	
	private int openSites;
	private WeightedQuickUnionUF uf;
	private int size;
	private int[][] id;
	

	/* create n-by-n grid, with all sites blocked */
	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n cannot be less than 0");
		openSites = 0;
		uf = new WeightedQuickUnionUF((n*n)+2);
		size = n;
		id = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				id[i][j] = 1;	// All the sites are full
			}
		}
		// connect the virtual top (0) with the top row and virtual bottom (size*size+1) to the last row
		for (int i = 1; i <= n; i++) {
			uf.union(0, i);
			uf.union((size*size)+1, size*(size-1)+i);
		}
	}
	
	/* Convert the 2D array index to 1D */
	private int getIndex(int row, int col) {
		return ((row-1)*size)+col;
	}
	
	/* Check if the indices are valid */
	private void checkIndices(int row, int col) {
		if (row > size || col > size || row <= 0 || col <= 0)
			throw new IllegalArgumentException("Row number and Column number should be in between 1 and " 
					+ size);
	}

	/* open site (row, col) if it is not open already */
	public void open(int row, int col) {
		checkIndices(row, col);
		if (id[row-1][col-1] == 1) {
			id[row-1][col-1] = 0;
			openSites++;
			int index = getIndex(row, col);
			if ((row != 1) && isOpen(row-1, col))
				uf.union(index, getIndex(row-1, col));
			if (row != size && isOpen(row+1, col))
				uf.union(index, getIndex(row+1, col));
			if (col != 1 && isOpen(row, col-1))
				uf.union(index, getIndex(row, col-1));
			if (col != size && isOpen(row, col+1))
				uf.union(index, getIndex(row, col+1));
		}
	}

	/* is site (row, col) open? */
	public boolean isOpen(int row, int col) {
		checkIndices(row, col);
		if (id[row-1][col-1] == 0)
			return true;
		return false;
	}

	/* is site (row, col) full? */
	public boolean isFull(int row, int col) {
		checkIndices(row, col);
		if(isOpen(row,col) && uf.connected(0, getIndex(row, col)))
			return true;
		return false;
	}

	/* number of open sites */
	public int numberOfOpenSites() {
		return openSites;
	}

	/* does the system percolate? */
	public boolean percolates() {
		return uf.connected(0, (size*size)+1);
	}

	/* test client (optional) */
	public static void main(String[] args) {

	}
}