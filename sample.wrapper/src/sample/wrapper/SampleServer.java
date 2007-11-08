package sample.wrapper;

/**
 * 模拟一个服务器程序
 * 
 * @author Marshal Wu
 * 
 * $LastChangedBy$ <br />
 * $LastChangedDate$<br />
 * $Rev$<br />
 */
public class SampleServer implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("Sample Server running.");
			try {
				Thread.sleep(1000 * 5);
			} catch (InterruptedException e) {
			}
			// 取消下面的注释演示wrapper重启jvm
			// throw new RuntimeException("error happen!");
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new SampleServer());
		thread.start();
	}
}
