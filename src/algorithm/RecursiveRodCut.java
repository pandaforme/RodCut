package algorithm;

import model.Price;
import model.Result;

public class RecursiveRodCut implements RodCut {

	@Override
	public Result cut(Price price, int rodLength) {
		Result result = new Result();
		int revenue = Integer.MIN_VALUE;
		for (int i = 1; i <= rodLength; i++) {
			Result remainderResult = cut(price, rodLength - i);
			int sum = price.getPrice(i) + remainderResult.revenue;
			if (sum > revenue) {
				revenue = sum;
				result.revenue = revenue;
				result.cutPoint.addAll(remainderResult.cutPoint);
				
				if (i == rodLength) {
					result.cutPoint.add(rodLength, 0);
				}
				else {
					result.cutPoint.add(rodLength, i);
				}
			}
		}

		return result;
	}
}
