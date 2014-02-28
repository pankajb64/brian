package brian.tasks;

import brian.core.Task;

public class Add2NumsTask extends Task {

	private int a, b;
	
	public Add2NumsTask(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public Object call() throws Exception {
		
		return a + b;
	}

}
