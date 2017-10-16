package item4;

public class MainClass {
	public static void main(String[] args) {
		
		EmailService emailS = new EmailService();
		MyApplication app = new MyApplication(emailS);
		app.processMessages("Hello, World!", "eduardo.hferreiras@gmail.com");
	}

}
