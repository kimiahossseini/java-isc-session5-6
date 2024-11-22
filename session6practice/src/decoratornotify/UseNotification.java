package decoratornotify;

import java.util.List;

public class UseNotification {

	public static void main(String[] args) {
		//Ordinary use
				SMSNotifier sms = new SMSNotifier("09123046913");
				sms.sendMeeage();
				
				FacebookNotifier facebook = new FacebookNotifier("afattahi");
				facebook.sendMeeage();
				
				EmailNotifier email = new EmailNotifier("afattahi54@gmail.com");
				email.sendMeeage();
				
		System.err.println("using decorator design");		
		//With a decorator
				BaseNotifier base = new BaseNotifier( List.of(facebook,email,sms));
				base.sendMeeage();

	}

}
