package LinkedList;

import LinkedList.LinkedList.Node;

public class Test {
    public  static  void main(String[] args ){
        LinkedList linkedList = new LinkedList("hello");
        linkedList.addNode("how");
        linkedList.addNode("are");
        linkedList.addNode("you");
        linkedList.addNode("today");
        linkedList.addNode("man");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.length);
//        System.out.println(linkedList.indexOf(4).name);
//        linkedList.delNode(1); //删除指定位置的Node
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.length);
//        linkedList.delNode(1); //删除指定位置的Node
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.length);
//        linkedList.removeAfter(3);
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.length);
        Node insertNode =linkedList.new Node("haha");
        Node insertNode2 =linkedList.new Node("tada");
        
        linkedList.insert(insertNode, 4);
        linkedList.insert(insertNode2, linkedList.length);
        
        System.out.println(linkedList.toString());
        System.out.println(linkedList.length);
        
    }
}
