package decoratornotify;

public class SMSNotifier implements Notifier {
	private String phonNumber;
	public SMSNotifier(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	@Override
	public void sendMeeage() {
		System.out.println("A notification to phon number: " + phonNumber);

	}

}
