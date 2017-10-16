package item4;

public class MyApplication {
	private EmailService email = null;
	
	public MyApplication(EmailService service){
		this.email=service;
	}
	
	public void processMessages(String message, String receiver){
		//do some msg validation, manipulation logic etc
		this.email.sendEmail(message, receiver);
	}
}
