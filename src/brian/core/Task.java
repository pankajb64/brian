package brian.core;

import java.util.concurrent.Callable;

public abstract class Task implements Callable {

	private String description = "";
	
	public Object process() throws Exception {
		
		return call();
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
