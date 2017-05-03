package multi.chapter8;

import java.util.List;
import java.util.concurrent.Executor;

import javax.lang.model.element.Element;

// p.163 8-10 ������ת��Ϊ����ִ��   ��������е���������Ƕ����ģ���ô���Բ��л���
public class ParallelTest {

	//����
	void processSequentially(List<Element> elements){
		for(Element e : elements){
			process(e);
		}
	}
	
	//����ִ��
	void processInParallel(Executor exec,List<Element> elements){
		for(final Element e: elements){
			exec.execute(new Runnable(){

				@Override
				public void run() {
				   process(e);				
				}				
			});
		}
	}

	private void process(Element e) {
		
	}
}
