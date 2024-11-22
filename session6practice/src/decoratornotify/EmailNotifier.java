package decoratornotify;

public class EmailNotifier implements Notifier {
	private String email;
	public EmailNotifier(String email) {
		this.email = email;
	}
	@Override
	public void sendMeeage() {
		System.out.println("A notification to email: " + email);

	}

}
