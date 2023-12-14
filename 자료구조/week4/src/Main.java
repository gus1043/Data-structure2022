//자료구조 과제#2 60211704 최지현
public class Main {

   public static void main(String[] args) {
      SList<Integer> s = new SList<Integer>();//연결 리스트 객체 s 생성
      SList<Integer> SL = new SList<Integer>();//연결 리스트 객체 SL 생성
      SList<Integer> l1 = new SList<Integer>();//연결 리스트 객체 l1 생성
      SList<Integer> l2 = new SList<Integer>();//연결 리스트 객체 l2 생성
      
      
      s.insertFront(50); 
      s.insertFront(40);
      s.insertFront(30);
      s.insertFront(20);
      s.insertFront(10);
      System.out.print("Sorted List 1: ");
      s.print();      
      
      
      SList<Integer> t=new SList<Integer>();
      t.insertFront(55); t.insertFront(18);
      t.insertAfter(37, t.head);
      t.insertFront(15);
      t.insertAfter(35, t.head.getNext());
      System.out.print("Sorted List 2: ");
      t.print();
      
      SList<Integer> result = new SList<Integer>();
      result = SList.mergeList(s.head, t.head);
      System.out.print("Merged List: "); result.print();
      System.out.println("--------------------------------------");
      
      
      SL.insertFront(45); SL.insertFront(17);
      SL.insertFront(20); SL.insertFront(50);
      SL.insertFront(57); SL.insertFront(35);
      SL.insertFront(10); SL.insertFront(15);
      SL.insertFront(90); SL.insertFront(10);
      
      SList.splitList(SL.head,20,l1,l2);
      System.out.print("Single List: ");
      SL.print();
      System.out.println("k=20을 기준으로 두 개의 리스트로 분리:");
      System.out.print("List1(<=20): ");
      l1.print();
      System.out.print("List2(<=20): ");
      l2.print();
 
   }
}