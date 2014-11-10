package algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import model.Price;
import model.Result;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RodCutTest {
	private final int	rodLength	= 7;
	private Price		price;
	private RodCut		rodCut;

	public RodCutTest(RodCut rodCut) {
		this.rodCut = rodCut;
	}

	@Before
	public void setUp() throws Exception {
		price = new Price();
		price.add(1, 1);
		price.add(2, 5);
		price.add(3, 8);
		price.add(4, 9);
		price.add(5, 10);
		price.add(6, 17);
		price.add(7, 17);
		price.add(8, 20);
		price.add(9, 24);
		price.add(10, 30);
	}

	@Test
	public void testRodCut() throws Exception {
		Result result = rodCut.cut(price, rodLength);
		assertEquals(18, result.revenue);
		assertEquals(1, result.cutPoint.getCutPoint(rodLength));
	}

	@Parameterized.Parameters(name= "{index}: {0}")
	public static Collection<Object[]> instancesToTest() {
		return Arrays.asList(new Object[] { new RecursiveRodCut() }, new Object[] { new BottomUpRodCut() }, new Object[] { new TopDownRodCut() });
	}
}
