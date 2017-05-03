package chapter7;

//�����嵥 7-23 p.147 ������������߳���ֹ    ������һ���������������Ϊ�����쳣
public class ThreadPoolTest {

	//���͵Ĺ������߳̽ṹ
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
