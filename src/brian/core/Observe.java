package brian.core;

import java.util.Queue;

public class Observe implements Runnable {

	private Think think;
	private Queue<Task> tasks;
	private Queue<Message> messages;
	private boolean first = true;
	
	public Observe(Think think, Queue<Task> tasks, Queue<Message> messages) {
		this.think = think;
		this.tasks = tasks;
		this.messages = messages;
	}

	public void setThink(Think think) {
		this.think = think;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			
			if(first) {
				if(!tasks.isEmpty()) {
					think.executeTask(tasks.poll());
					first = false;
				}	
			}
			else if(!messages.isEmpty())
				consume(messages.poll());
		}

	}

	private void consume(Message message) {

		switch(message.getMessageType()) {
			
		case BEGIN_TASK: 
			System.out.println("Task started : " + message.getMessage()); 
			break;
		
		case END_TASK : 
			if (!tasks.isEmpty())
				think.executeTask(tasks.poll());
			System.out.println("Task ended : " + message.getMessage()); 
			break;
		
		}
		
	}
	

}
