package javaset; // 20240104-6

import java.util.TreeSet;

public class set_study2 {

	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		do {
			int num = (int)(Math.random()*50)+1;
			tree.add( num );
			//System.out.println( num );
		}while( tree.size()<10 );
		
		System.out.println( tree );
		
		// 검색
		System.out.println( tree.floor(30) ); // 검색 메서드 floor -> 일치하는값을 출력. 없으면 작은값중에 가장 가까운값 출력, 그래도 없으면 null출력
		System.out.println( tree.headSet(25) ); // 범위검색메서드 headSet -> 지정한 값보다 작은값을 출력
		System.out.println( tree.tailSet(25) ); // 지정항 값보다 큰값 전체 출력
		System.out.println( tree.higher(40)); //지정한값보다 큰값중 가장가까운값 출력
		System.out.println( tree.lower(36) ); // 지정한값보다 작은값중 가장가까운값 출력
		System.out.println( tree.subSet(10,  30) ); // 지정한값(from, to) 범위이내 값 출력, to(30)는 포함하지않는다
	}

}

//2진 tree 
// 하위노드를 2개만 갖을 수 있다
//   암호화에 사용한다
// 트리에서 첫번째노드를 root 라고 한다
