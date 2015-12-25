package Thread;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	int taskNum;
	Task(int taskNum){
		this.taskNum = taskNum;
	}
	@Override
	public String call() throws Exception {
		System.out.println("task" + taskNum + " is start");
		Thread.sleep(1000);
		System.out.println("task" + taskNum + " is end");	
		return "[" + taskNum + "]";
	}
}