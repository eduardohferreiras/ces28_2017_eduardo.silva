package item10;

public class MainClass {
	public static void main(String[] args) {
		String msg = "Olar";
		String email = "guima.guima@guima.guima";
		String phone = "19191919";
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);
	}

}
