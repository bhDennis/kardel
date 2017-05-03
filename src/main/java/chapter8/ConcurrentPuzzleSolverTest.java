package chapter8;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentPuzzleSolverTest {

}

// �����嵥8-18 p.169 �ڽ�������Ҳ������
class PuzzleSolver<P,M> extends ConcurrentPuzzleSolver<P,M>{
	
	public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
		super(puzzle, exec, seen);
	}

	private final AtomicInteger taskCount = new AtomicInteger(0);
	
	protected Runnable newTask(P p,M m,Node<P,M> n){
		
		return new CountingSolverTask(p,m,n);
	}
	
	class CountingSolverTask extends SolverTask{

		CountingSolverTask(P pos, M move, me.aihuishou.multi.chapter8.ConcurrentPuzzleSolver.Node<P, M> prev) {
			super(pos, move, prev);
			taskCount.incrementAndGet();
		}
		
		public void run(){
			try {
				super.run();
			} finally {
				if(taskCount.decrementAndGet() == 0)
					solution.setValue(null);
			}
		}
		
	}
	
}

//�����嵥8-16 p.167 ��������������
class ConcurrentPuzzleSolver<P,M>{
	
	private final Puzzle<P,M> puzzle;
	private final ExecutorService exec;
	private final ConcurrentMap<P,Boolean> seen;
	final ValueLatch<Node<P,M>> solution = new ValueLatch<Node<P,M>>();

	public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
		super();
		this.puzzle = puzzle;
		this.exec = exec;
		this.seen = seen;
	}
	
	public List<M> solve() throws InterruptedException{
		try {
			P p = puzzle.initialPosition();
			exec.execute(newTask(p, null, null));
			//����ֱ���ҵ����
			Node<P, M> solnNode = solution.getValue();
			return (solnNode == null) ? null : solnNode.asMoveList();
		} finally {
			exec.shutdown();
		}
	}
	
	protected Runnable newTask(P p,M m,Node<P,M> n){
		return new SolverTask(p,m,n);
	}
	
	class SolverTask extends Node<P,M> implements Runnable{

		SolverTask(P pos, M move, Node<P, M> prev) {
			super(pos, move, prev);
		}

		@Override
		public void run() {
		
			if(solution.isSet() || seen.putIfAbsent(pos,true) != null){
				return ;//�Ѿ��ҵ��˽������Ѿ����������λ��
			}
			if(puzzle.isGoal(pos)){
				solution.setValue(this);
			}else{
				for(M m : puzzle.legalMoves(pos)){
					exec.execute(newTask(puzzle.move(pos,m),m,this));
				}
			}
			
		}
	}
	
	static class Node<P,M>{
		final P pos;
		final M move;
		final Node<P,M> prev;
		
		Node(P pos,M move,Node<P,M> prev){
			this.pos = pos;
			this.move = move;
			this.prev = prev;
		}
		
		List<M> asMoveList(){
			List<M> solution = new LinkedList<M>();
			for(Node<P,M> n = this; n.move != null; n= n.prev){
				solution.add(0,n.move);
			}
			return solution;
		}
	}
	
	// �����嵥8-17 p.168 Я������ı���
	class ValueLatch<T>{	
	 
	  private T t = null;
	  private final CountDownLatch done = new CountDownLatch(1);
	  T getValue() throws InterruptedException{
		  done.await();
		  synchronized(this){
			  return t;
		  }
	  }
	  
	  public synchronized void setValue(T t){
		  if(!isSet()){
			  this.t = t;
			  done.countDown();
		  }
	  }
	  
	  boolean isSet(){
		  return (done.getCount() == 0);
	  }
	}
	
}
