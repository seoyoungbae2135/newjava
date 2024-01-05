package stackandqueue; //20240104

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class queue_test {

	public static void main(String[] args) {
		// 선형 Queue
		Queue q = new LinkedList(); // Queue는 인터페이스이므로 LinkedList()를 사용해야한다
		
		q.add("김민수");  //queue는 add와 offer두가지로 입력가능
		q.offer("노재홍");
		q.offer("서종우");
		q.offer("박종권");
		
		System.out.println( q );
		System.out.println( q.remove() ); // 데이터 꺼내오기, 꺼낼값이없을경우 오류
		System.out.println( q.poll() ); //데이터 꺼내오기, 꺼낼값이없을경우 null값 출력
		System.out.println( q.peek() ); // 그다음 꺼내올 데이터는 어떤것인지 확인
		System.out.println( q.isEmpty() ); // queue가 비어있는지 확인 비어있지않으면 false출력
		
		//우선순위 Queue
		Queue<Integer> pq = new PriorityQueue<Integer>(); //
		
		pq.offer(20);
		pq.offer(5);
		pq.offer(1);
		pq.offer(11);
		pq.offer(8);
		
		System.out.println( pq );
		System.out.println( pq.poll() ); // 입력순서에 관계없이 낮은값이 우선순위가 높다( 낮은값먼저 꺼내게된다) 문자는 사전순서
		System.out.println( pq.poll());
		
		Queue<String> pqq = new PriorityQueue<String>();
		
		pqq.add("라디오");
		pqq.add("하마");
		pqq.add("나비");
		pqq.add("Boy");
		pqq.add("가방");
		
		System.out.println( pqq );
		System.out.println( pqq.poll() ); // 문자는 영어우선, 사전적 순서로 꺼내게 된다
		System.out.println( pqq.poll());
		
		// Deque - 이중 queue (입출이 이중으로 되어있는 큐) stack처럼사용할 수도있고 queue처럼사용할 수도있다(메서드가 2종류이다) 
		
		Deque<Integer> dq = new ArrayDeque<>(); 
		dq.addFirst(10);
		dq.offerFirst(20);
		
		dq.addLast(5); // add메서드실행과 동일
		dq.offerLast(11); // offer 메서드 실행과 동일
		
		// removeFirst, pollFirst, removeLast, pollLast 메서드가 있다
		
		//Deque를 스택으로 사용한다면
		// push, pop 메서드 사용가능
		dq.push(111);
	}

}

// queue - 선입선출, FIFO(처음들어온값이 첫번째로 출력된다.)
// 윈도우에서 가장최근에 사용한파일 목록이 queue가 적용된것이며 20개까지 저장가능하다. 이후 선입선출로 삭제하고 신규저장된다