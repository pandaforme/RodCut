import model.CutPoint;
import model.Price;
import model.Result;
import algorithm.RecursiveRodCut;
import algorithm.RodCut;

public class Run {
	private static Price		price;
	private static final int	rodLength	= 7;

	static {
		initialPrice();
	}

	private static void initialPrice() {
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

	public static void main(String[] args) {
		RodCut rodCut = new RecursiveRodCut();
		Result result = rodCut.cut(price, rodLength);		
		printRevenue(result.revenue);
		printCutPoint(result.cutPoint);
	}

	private static void printRevenue(int revenue) {
		System.out.println(String.format("The optimal revenue: %s", revenue));
	}

	private static void printCutPoint(CutPoint cutPoint) {
		int tmp = rodLength;

		while (cutPoint.getCutPoint(tmp) > 0) {
			System.out.println(String.format("The optimal cutpoint: %s", cutPoint.getCutPoint(tmp)));
			tmp = tmp - cutPoint.getCutPoint(tmp);
		}
	}
}
