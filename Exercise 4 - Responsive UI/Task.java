import java.util.*;

public class Task implements Runnable {
	
	private int duration;
	private int taskIndex;
	
	public Task(int index, int duration) {
		this.taskIndex = index;
		this.duration = duration;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println("Enter the duration (in ms) of task " + i + ":");
			String str = System.console().readLine();
			Runnable newTask = new Task(i, Integer.parseInt(str));
			Thread t = new Thread(newTask);
			t.start();
		}
	}
	
	public void run() {
		countTask();
		try {
			Thread.sleep(duration);
		} catch (InterruptedException ex) {
			// Nothing happens...
		}
	}
}