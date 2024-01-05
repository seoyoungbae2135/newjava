package Liked;  //20240103 

public class linkedList {
	
	static int cnt=0;
	private node head=null; //링크드리스트에서 맨앞의 노드를 head라고한다
	private node tail=null; //링크드리스트에서 맨뒤의 노드를 tail 이라고한다

	//데이터추가
	public void add(String name) {
		node temp = new node(name); //새로운 노드생성
		temp.index=cnt;
		cnt++;
		
		if(head == null) {  // 헤드가 비었을때 다음노드의 주소
			head=temp; // 헤드에 새로 생성된 노드주소 저장
			tail=temp; // 
		}else {
			tail.setNext(temp); //setNext는 node.java에서 만든 메서드 새로운노드가생성되고 헤드에 주소가 저장되어있으므로 현재테일에 새로생성된 노드주소저장
			tail=temp;  // 
		}
	}
	//데이터출력
	public node get(int index) {
		node find = head; //링크드리스트 첫번째노드부터시작
		while(find!=null) {
			if(find.index == index) {
				return find;
			}
			find = find.getNext(); //현재노드에서 다음노드로이동
		}
		return null;
	}
	//데이터삭제
	public boolean remove(int index) {
		
		node find = head; //첫번째노드부터 시작
		
		if(head.index == index) { //첫번째노드삭제
			head = head.getNext();
			reindex();
			cnt--;
		}else {
		
			while( find.getNext() !=null ) {   //두번째부터 삭제 index와 일치하는 index 반복 검색
				if(find.getNext().index == index ) {
					node del = find.getNext(); //삭제할 노드 del에 저장
					find.setNext( del.getNext() ); //del의 next를 앞쪽 node next에 저장
					reindex();
					cnt--;
					return true;
				}
				find = find.getNext(); // 다음노드 검색
			}
		}
		return false;
	}
	//데이터삽입
	public void add(int index, String name) {
		
		node temp = new node(name); // 새로운 노드 
		cnt++;  // 새로운 노드가 생성되므로 cnt 1증가
		
		node find = head; //첫번째 노드부터 시작
		
		if(index == 0) {  //링크리스트 맨앞에 추가삽입한다면 
			temp.setNext( head );
			head=temp;
		}else {
			// 다음 주석설명은 만약 4번째위치에 새노드 삽입한다면 에 대한 설명
			while(find.getNext() !=null) {
				if( find.getNext().index == index) { //find는 3번째노드이다
					temp.setNext(find.getNext());
					// 새로운노드의 next에 3번째노드의 next(4번째)를 저장한다
					find.setNext(temp);
					// 3번째노드의 next에 새노드의 주소를 저장한다
					break;
				}
				find = find.getNext();
			}
		}
		reindex();
	}
	
	private void reindex() { // 노드 삭제와 삽입으로 인하여 인덱스 0부터 재정렬
		node location = head;
		// 첫번째 노드부터 시작해서 인덱스 0부터 재 설정
		int i = 0;
		while( location !=null ) {
			location.index= i++;
			location = location.getNext(); //다음노드이동
		}
	}
	
	//링크드리스트 전체출력
	@Override
	public String toString() {
		String out="[";
		node move = head; //링크드리스트의 첫번째노드,헤드의 내용이 변경되지않도록
		
		while(move!=null) {  // 마지막노드의 next는 null이므로 마지막에 종료
			out += move.getName() +"\n";  //노드의 값을  out에 저장
			move = move.getNext();  //현재노드에서 다음노드로 이동
		}
			
		out +="]";
		return out;
	}
}
