package multi.chapter5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//p.98　通过CyclicBarrierxie协调细胞自动衍生系统中的计算
public class CellularAutomata {

//	private final Board mainBoard;
//	
//	private final CyclicBarrier barrier;
//	
//	private final Work[] workers;
//	
//	public CellularAutomata(Board board){
//		this.mainBoard = board;
//		int count = Runtime.getRuntime().availableProcessors();
//		this.barrier = new CyclicBarrier(count,
//				new Runnable(){
//					public void run() {
//						mainBoard.commitNewValues();
//					}});
//		this.workers = new Work[count];
//		for(int i=0;i<count;i++){
//			workers[i] = new Worker(mainBoard.getSubBoard(count,i));
//		}
//	}
//	
//	private class Worker implements Runnable{
//		private final Board board;
//		public Worker(Board board){
//			this.board = board;
//		}
//		@Override
//		public void run() {
//	                  
//			while(!board.hasConveraged()){
//				
//				for(int x=0;x<board.getMaxX();x++){
//					for(int y=0;y<board.getMaxY();y++){
//						board.setNewValue(x,y,compute(x,y));			
//					}
//				}
//				
//				try {
//					barrier.await();
//				} catch (InterruptedException e) {
//					return;
//				} catch (BrokenBarrierException e) {
//					return;
//				}
//			}
//		}
//	}
//	
//	public void start(){
//		for(int i=0;i<workers.length;i++){
//			new Thread(workers[i]).start();
//		}
//		mainBoard.waitForConvergence();
//	}
}
