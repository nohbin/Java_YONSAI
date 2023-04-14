package day0412;

public class ThreadEx9 {
	public static void main(String[] args) {
		
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup group1 = new ThreadGroup("Group1");
		ThreadGroup group2 = new ThreadGroup("Group2");
		// new ThreadGroup(super Threadgroup,String name);
		ThreadGroup subGroup1 = new ThreadGroup(group1,"subGroup1");
		group1.setMaxPriority(3);
		Runnable r = new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
			}
		};
		Thread t1 = new Thread(group1,		r,	"t1");
		Thread t2 = new Thread(subGroup1,	r,	"t2");
		Thread t3 = new Thread(group2,		r,	"t3");
		t1.start();
		t2.start();
		t3.start();
		System.out.println("List of ThreadGroup : "+ main.getName() 
						   + ", ActiveGroupCount : " + main.activeGroupCount()
						   + ", ActiveThread : " + main.activeCount());
		main.list();
		
	}
	
}
