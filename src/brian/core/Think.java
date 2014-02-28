package brian.core;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Think  {

	private Queue<Message> messages;
	private static int limit = 100;
	
	public Think(Queue<Message> messages) {
		this.messages = messages;
	}


	public void executeTask(Task t) {

		messages.add(new Message<String>(MessageType.BEGIN_TASK, t.getDescription()));

		try {

			Object result = t.call();

			messages.add(new Message<String>(MessageType.END_TASK, t.getDescription() + " result - " + result.toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			messages.add(new Message<String>(MessageType.END_TASK, t.getDescription() + "\n with error - " + e.getMessage()));
		}
	}
	
}
