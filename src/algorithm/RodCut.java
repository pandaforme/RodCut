package algorithm;
import model.Price;
import model.Result;

public interface RodCut {
	public Result cut(Price price, int rodLength);
}
