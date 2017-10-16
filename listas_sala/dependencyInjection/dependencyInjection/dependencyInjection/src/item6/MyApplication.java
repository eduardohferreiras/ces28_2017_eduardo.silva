package item6;

public class MyApplication implements iConsumer{

		private MessageService service;
		
		public MyApplication(MessageService service){
			this.service=service;
		}
		
		@Override
		public void processMessages(String message, String receiver){
			//do some msg validation, manipulation logic etc
			this.service.sendMessage(message, receiver);
		}

}
