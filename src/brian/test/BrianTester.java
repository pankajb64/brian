package brian.test;

import brian.core.Brian;
import brian.tasks.Add2NumsTask;

public class BrianTester {

	public static void main(String[] args) {
		
		Brian b = new Brian();
		b.addTask(new Add2NumsTask(2, 2));
	}
}
