package algorithm;

import java.util.HashMap;
import java.util.Map;

import model.Price;
import model.Result;

public class BottomUpRodCut implements RodCut {
	private Map<Integer, Result>	results;

	public BottomUpRodCut() {
		results = new HashMap<Integer, Result>();
		results.put(0, new Result());
	}

	@Override
	public Result cut(Price price, int rodLength) {			
		for (int i = 1; i <= rodLength; i++) {
			Result result = new Result();
			int revenue = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				Result remainderResult = results.get(i - j);
				int sum = price.getPrice(j) + remainderResult.revenue;
				if (sum > revenue) {
					revenue = sum;
					result.revenue = sum;
					result.cutPoint.addAll(remainderResult.cutPoint);

					if (j == i) {
						result.cutPoint.add(i, 0);
					}
					else {
						result.cutPoint.add(i, j);
					}
				}
			}

			results.put(i, result);
		}

		return results.get(rodLength);
	}
}
