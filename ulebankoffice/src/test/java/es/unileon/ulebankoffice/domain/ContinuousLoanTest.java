package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContinuousLoanTest {
	private ContinuousLoan cl;
	
	@Before
	public void setUp() {
		this.cl = new ContinuousLoan(50000, 10, 2, 6, 2);
	}
	
	@Test
	public void testCalculateTable() {
		List<List<String>> table = this.cl.calculateTable();
		assertEquals(table.toString(), "[[0, , , , 50000.0], [1, 4550.4, 833.33, 3717.07, 46282.93], [2, 4565.57, 771.38, 3794.19, 42488.74], [3, 4580.79, 708.15, 3872.64, 38616.1], [4, 4596.06, 643.6, 3952.46, 34663.64], [5, 4611.38, 577.73, 4033.65, 30629.99], [6, 4626.75, 510.5, 4116.25, 26513.74], [7, 4642.17, 441.9, 4200.28, 22313.46], [8, 4657.65, 371.89, 4285.76, 18027.71], [9, 4673.17, 300.46, 4372.71, 13655.0], [10, 4688.75, 227.58, 4461.17, 9193.83], [11, 4704.38, 153.23, 4551.15, 4642.68], [12, 4720.06, 77.38, 4642.68, 0.0], [55617.13, 5617.13, 50000.0]]");
	}
	
	@Test
	public void testGetSetInitialCap() {
		this.cl.setInitialCap(0.3d);
		assertEquals(0.3d, this.cl.getInitialCap(), 0.0);
	}
	
	
	@Test
	public void testGetSetInterestRate() {
		this.cl.setInterestRate(0.3d);
		assertEquals(0.003d, this.cl.getInterestRate(), 0.0);
	}
	
	
	@Test
	public void testGetSetPeriods() {
		this.cl.setPeriods(3);
		assertEquals(3, this.cl.getPeriods(), 0.0);
	}
	
	
	@Test
	public void testGetSetPeriodType() {
		this.cl.setPeriodType(3);
		assertEquals(3, this.cl.getPeriodType(), 0.0);
	}
	
	
	@Test
	public void testGetSetRatio() {
		this.cl.setRatio(0.3d);
		assertEquals(0.3d, this.cl.getRatio(), 0.0);
	}
	
}
