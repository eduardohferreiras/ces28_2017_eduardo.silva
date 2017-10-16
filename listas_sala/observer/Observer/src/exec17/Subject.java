package exec17;

public class Subject {

	private PublishSubscriber pubSub_;
	
	public void setPubSub(PublishSubscriber pubSub)
	{
		pubSub_ = pubSub;
	}
	
	public void setValue(String msg) {
		value = msg;
		sendValue();
	}
	
	private void sendValue()
	{
		pubSub_.updateMsg(value);
	}

	private String value;
}
