package statisticker;

public class LEDAlert {
	public boolean ledGlows =false;
	public void ledGlowsTo(float max ,float ther) {
		if( max < ther) {
			ledGlows = true;
		}
	}
}
