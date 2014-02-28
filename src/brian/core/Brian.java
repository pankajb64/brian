package brian.core;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class Brian {

	private Thread observer;
	private Queue<Task> tasks;
	private Queue<Message> messages;
	private static int limit = 100;
	
	public Brian() {
		
		tasks = new ArrayBlockingQueue<Task>(limit);
		messages = new ArrayBlockingQueue<Message>(limit);
		
		Think think = new Think( messages);
		Observe observe = new Observe(think, tasks, messages);
		
		observer = new Thread(observe);
		observer.start();
	}
	
	public void addTask(Task t) {
		tasks.add(t);
	}
}
