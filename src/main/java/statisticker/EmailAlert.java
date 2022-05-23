package statisticker;

public class EmailAlert {
 public boolean emailSent = false;
	
	public void emailSentTo(float max ,float ther) {
		if(max < ther ) {
			System.out.println("alert Sent");
			emailSent =true;
		}
	}
	
}
