package item6;

public class MainClass {
	public static void main(String[] args) {
		
		EmailService emailS = new EmailService();
		SMSService smsS = new SMSService();
		
		MyApplication app = new MyApplication (emailS);
		app.processMessages("Hello, World!", "eduardo.hferreiras@gmail.com");
	
		System.out.println("\n");
		
		app = new MyApplication (smsS);
		app.processMessages("Hello, World!", "eduardo.hferreiras@gmail.com");
	}
	

}
