package chapter8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SequentialPuzzleSolverTest {

	//串行的谜题解答器
	class SequentialPuzzleSolver<P,M>{
		
		private final Puzzle<P,M> puzzle;
		private final Set<P> seen = new HashSet<P>();
		
		public SequentialPuzzleSolver(Puzzle<P,M> puzzle){
			this.puzzle = puzzle;
		}
		
		public List<M> solve(){
			P pos = puzzle.initialPosition();
			return search(new Node<P,M>(pos,null,null));
		}
		
		private List<M> search(Node<P,M> node){
			if(!seen.contains(node.pos)){
				seen.add(node.pos);
				if(puzzle.isGoal(node.pos)){
					return node.asMoveList();
				}
			}
			return null;
		}
	}

	//p.165 程序清单8-14  用于谜题解决框架的链表节点
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
}

// p.165 程序清单8-13 P:位置类       M:移动类
interface Puzzle<P,M>{
	
	P initialPosition();
	boolean isGoal(P position);
	Set<M> legalMoves(P position);
	P move(P position, M move);
}

