/**
 * 
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
/**
 * @author berina
 *
 */
public class PercolationStats {

	private int size;
	private double[] results;
	private double mean;
	private double stddev;
	private double confidenceHi;
	private double confidenceLow;

	/* perform trials independent experiments on an n-by-n grid */
	public PercolationStats(int n, int trials) {
		if (n <= 0)
			throw new IllegalArgumentException("Size of the field should be greater than 0");
		if (trials <= 0)
			throw new IllegalArgumentException("Number of trials should be greater than 0");
		size = n;
		results = new double[trials];
		for (int i = 0; i < trials; i++) {
			runTrial(i);
		}
		mean = StdStats.mean(results);
		stddev = StdStats.stddev(results);
		confidenceHi = mean + ((1.96 * stddev) / Math.sqrt(trials));
		confidenceLow = mean - ((1.96 * stddev) / Math.sqrt(trials));
	}
	
	private void runTrial(int trial) {
		Percolation percolation = new Percolation(size);
		while (!percolation.percolates()) {
			int randomRow = StdRandom.uniform(1, size+1);
			int randomColumn = StdRandom.uniform(1, size+1);
			percolation.open(randomRow, randomColumn);
		}
		results[trial] = (double) (percolation.numberOfOpenSites())/(size*size);
	}

	/* sample mean of percolation threshold */
	public double mean() {
		return mean;
	}

	/* sample standard deviation of percolation threshold */
	public double stddev() {
		return stddev;
	}

	/* low  endpoint of 95% confidence interval */
	public double confidenceLo() {
		return confidenceLow;
	}

	/* high endpoint of 95% confidence interval */
	public double confidenceHi() {
		return confidenceHi;
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(size, trials);
		System.out.println("mean			= " + ps.mean());
		System.out.println("stddev			= " + ps.stddev());
		System.out.println("95% confidence interval	= [" + ps.confidenceLo() +", "
				+ ps.confidenceHi() + "]");
	}
}