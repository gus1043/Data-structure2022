//자료구조 과제#2 60211704 최지현
import java.util.NoSuchElementException;
public class SList < E extends Comparable < E >> {

    protected Node head; //연결 리스트의 첫 노드 가리킴
    private int size;

    public SList() { //연결 리스트 생성자
        head = null;
        size = 0;
    }
    public int search(E target) { //target을 탐색
        Node p = head;

        for (int k = 0; k < size; k++) {
            if (target == p.getItem()) return k;
            p = p.getNext();
        }
        return -1; //탐색을 실패한 경우 -1 리턴
    }
    //연결리스트 맨 앞에 새 노드 삽입
    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++;
    }
    //노드 p 바로 다음에 새 노드 삽입
    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }
    //리스트의 첫 노드 삭제
    public void deleteFront() {
        if (isEmpty())
            throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }
    public int size() {
        return size;
    }
    //리스트가 empty이면 true 리턴
    public boolean isEmpty() {
        return size == 0;
    }
    //p가 가리키는 노드의 다음 노드를 삭제
    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();

        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }
    public void print() {
        for (Node p = head; p != null; p = p.getNext()) {
            System.out.print(p.getItem() + "\t");
        }
        System.out.println();
    }
    public static SList mergeList(Node p1, Node p2)
    {
    	SList<Integer> result = new SList<Integer>();
        Node t1 = p1;
        Node t2 = p2;
        
        if((Integer)t1.getItem() > (Integer)t2.getItem())
        {
        	result.head = t2;
        	t2 = t2.getNext();
        }
        else
        {
        	result.head = t1;
        	t1 = t1.getNext();
        }
        
        Node tmp = result.head;

        while(t1 != null && t2 != null)
        {
            if((Integer)t1.getItem() > (Integer)t2.getItem())
            {
            	result.insertAfter((Integer)t2.getItem(), tmp);
            	t2 = t2.getNext();
            	tmp = tmp.getNext();
            }
            else
            {
            	result.insertAfter((Integer)t1.getItem(), tmp);
            	t1 = t1.getNext();
            	tmp = tmp.getNext();
            }
            
        }
        if (t1==null && t2 !=null) {
        	result.insertAfter((Integer)t2.getItem(), tmp);
        	t2 = t2.getNext();
        	tmp = tmp.getNext();
        }
        if (t2==null && t1 !=null) {
        	result.insertAfter((Integer)t1.getItem(), tmp);
        	t1 = t1.getNext();
        	tmp = tmp.getNext();
        }
        if (t1==null && t2==null) {
        	tmp.setNext(null);
        	
        }
        return result;
    }
        
    public static void splitList(Node p, int k, SList l1, SList l2)
    { 
        Node p1 = l1.head;
        Node p2 = l2.head;
        Node tmp = p;

        while(true)
        {
            if((Integer)tmp.getItem() <= (Integer)k)
            { 
            	if(p1 == null) 
            	{
            		l1.insertFront((Integer)tmp.getItem());
            		tmp = tmp.getNext();
            	}
            	else
            	{
            		l1.insertAfter((Integer)tmp.getItem(), p1.getNext());
            		p1 = p1.getNext();
            		tmp = tmp.getNext();
            	}
            }
            else
            {
            	if(p2 == null)
            	{
            		l2.insertFront((Integer)tmp.getItem());
            		tmp = tmp.getNext();
            	}
            	else
            	{
            		l2.insertAfter((Integer)tmp.getItem(), p2.getNext());
                    p2 = p2.getNext();
                    tmp = tmp.getNext();
            	}
            }
            
            if (tmp.getNext() == null) {
            	if((Integer)tmp.getItem() <= (Integer)k)
                { 
                	if(p1 == null) 
                	{
                		l1.insertFront((Integer)tmp.getItem());
                		tmp = tmp.getNext();
                	}
                	else
                	{
                		l1.insertAfter((Integer)tmp.getItem(), p1.getNext());
                		p1 = p1.getNext();
                		tmp = tmp.getNext();
                	}
                }
                else
                {
                	if(p2 == null)
                	{
                		l2.insertFront((Integer)tmp.getItem());
                		tmp = tmp.getNext();
                	}
                	else
                	{
                		l2.insertAfter((Integer)tmp.getItem(), p2.getNext());
                        p2 = p2.getNext();
                        tmp = tmp.getNext();
                	}
                } 
            	break;
            }
            
            
        } 
    }
}