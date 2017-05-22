package multi.chapter7;

//程序清单 7-23 p.147 处理非正常的线程终止    如下是一种主动方法来解决为检查的异常
public class ThreadPoolTest {

	//典型的工作者线程结构
	public void run(){
		Throwable thrown = null;
		try {
			while(!isInterrupted()){
				runTask(getTaskFromWorkQueue());
			}
		} catch (Exception e) {
			thrown = e;
		} finally {
			threadExited(this,thrown);
		}
	}

	private void threadExited(ThreadPoolTest threadPoolTest, Throwable thrown) {
		
	}

	private void runTask(Object taskFromWorkQueue) {
		
	}

	private Object getTaskFromWorkQueue() {
		return null;
	}

	private boolean isInterrupted() {
		return false;
	}
}
