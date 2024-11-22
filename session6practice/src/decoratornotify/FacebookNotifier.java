package decoratornotify;

public class FacebookNotifier implements Notifier {
	private String faceaccount;
	public FacebookNotifier(String faceaccount) {
		this.faceaccount = faceaccount;
	}
	@Override
	public void sendMeeage() {
		System.out.println("A notification to face account: " + faceaccount);

	}

}
