package statisticker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatsChecker {
	
	private float ther;
	
	private EmailAlert em;
	
	private LEDAlert le;
	
	public StatsChecker(float ther , EmailAlert em, LEDAlert le) {
		this.ther = ther;
		this.em = em;
		this.le = le;
		
	}

	public void checkAndAlert(List<Float> numberList2) {
		// TODO Auto-generated method stub
		List<Float> numberList = new ArrayList<Float>(numberList2);
		float maxValue = numberList.get(numberList.size()-1);
		em.emailSentTo(maxValue, ther);
		le.ledGlowsTo(maxValue, ther);
		
		
	}
}
