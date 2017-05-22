package multi.chapter8;

import java.util.List;
import java.util.concurrent.Executor;

import javax.lang.model.element.Element;

// p.163 8-10 将串行转换为并行执行   （如果串行的任务操作是独立的，那么可以并行化）
public class ParallelTest {

	//串行
	void processSequentially(List<Element> elements){
		for(Element e : elements){
			process(e);
		}
	}
	//并行执行
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
