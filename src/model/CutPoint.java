package model;

import java.util.HashMap;
import java.util.Map;

public class CutPoint {
	private Map<Integer, Integer>	cutPoints;

	public CutPoint() {
		cutPoints = new HashMap<Integer, Integer>();
	}

	public void add(int rodLength, int cutPoint) {
		cutPoints.put(rodLength, cutPoint);
	}

	public void addAll(CutPoint cutPoint) {
		cutPoints.putAll(cutPoint.cutPoints);
	}

	public int getCutPoint(int rodLength) {
		return cutPoints.get(rodLength);
	}
}
