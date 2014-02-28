package brian.core;

public class Message<T> {

	private T message;
	private MessageType messageType;
	
	public Message(MessageType messageType, T message) {
		this.messageType = messageType;
		this.message = message;
	}
	
	public T getMessage() {
		return message;
	}
	
	public MessageType getMessageType() {
		return messageType;
	}
	
}
