package statisticker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import statisticker.Stats;

public class Statistics 
{
    
	public static Stats getStatistics(List<Float> numbers) {
        //implement the computation of statistics here
		Stats stats = new Stats();
		int n = numbers.size();
		float total = 0;
		if (numbers.size() > 0) {
			for (float num : numbers) {
				total += num;
			}
		float average = total / n;
		List<Float> sortedlist = new ArrayList<>(numbers);
        Collections.sort(sortedlist);
        stats.setAverage(average);
        stats.setMax((sortedlist.get(n-1)));
        stats.setMin(sortedlist.get(0));
        
		}
		else {
			stats.setAverage(Float.NaN);
			stats.setMax(Float.NaN);
			stats.setMin(Float.NaN);
		}
		return stats;
    }
}
