package algorithm;

import java.util.HashMap;
import java.util.Map;

import model.Price;
import model.Result;

public class TopDownRodCut implements RodCut {
	private Map<Integer, Result>	results;

	public TopDownRodCut() {
		results = new HashMap<Integer, Result>();
	}

	@Override
	public Result cut(Price price, int rodLength) {
		if (results.containsKey(rodLength)) {
			return results.get(rodLength);
		}

		Result result = new Result();
		int revenue = Integer.MIN_VALUE;
		for (int i = 1; i <= rodLength; i++) {
			Result remainderResult = cut(price, rodLength - i);
			int sum = price.getPrice(i) + remainderResult.revenue;
			if (sum > revenue) {
				revenue = sum;
				result.revenue = sum;
				result.cutPoint.addAll(remainderResult.cutPoint);

				if (i == rodLength) {
					result.cutPoint.add(rodLength, 0);
				}
				else {
					result.cutPoint.add(rodLength, i);
				}				
			}
		}

		results.put(rodLength, result);
		
		return result;
	}

}
