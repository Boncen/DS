package LinkedList;   
public class LinkedList {
    int length = 0;    //链表的长度
    private Node  last=null;
    private  Node first = null;
    private StringBuffer sb = new StringBuffer();
    public   class  Node{
        String name;
        Node next;

        public Node() {
        }
        public  Node(String name){
            this.name = name;
        }
    }
    public  LinkedList(){
      first=  last = new Node();
        last.name ="firstNode";
        last.next = null;
        length++;
    }
    public LinkedList(String nodename) {
    	 first=  last = new Node(nodename);
        
         last.next = null;
         length++;
    }
    /*
 	添加节点
     */
    public  void addNode(String name){
        Node  node = new Node(name);
        node.next = null;
        last.next = node;
        last = node;
        length++;
    }

    /* 
    删除指定位置的节点
     */
    public void delNode(int index) {
        if (index<1) return;
        if (index == 1) {
            first = first.next;
            length--;
            return;
//            first.next =null;
        }
        Node lastOne = indexOf(index - 1);
        Node targetNode = indexOf(index);
        lastOne.next = targetNode.next;
        targetNode.next = null;
        length--;
    }
    /*
    返回指定位置的节点
     */
    public Node indexOf(int index) {
        int i = 1;
        Node res = first;
        if (index ==1){
            return res;
        }
        if (index>length){
            System.out.println("索引值超过链表长度!");
            return  null;
        }
        boolean a =true;
        while (a) {
            res = res.next;
            i++;
            if (i==index){
                return res;
            }
        }
        return res;
    }
    @Override
    public String toString() {
        String target =printList(first);
        sb.setLength(0);   //娓呯┖stringBuffer,鍥犱负娌℃湁clear鏂规硶
        return target;
    }
    private  String printList(Node first){
        sb.append(" "+first.name +"  ");
        if ( first.next!=null){
            sb.append("-->");
            printList(first.next);
        }
//        sb.deleteCharAt(sb.length()-1);  鏈夐棶棰�
        return  sb.toString();
    }
    
    public void removeAfter(int index) {
    	Node node  = indexOf(index);
    	if (node==null) {
			return;
		}
    	node.next = null;
    	 length  = 1;
    	length =countLength(first);
    }
	private int countLength(Node node) {
		
		if (node.next!=null) {
			length++;
			countLength(node.next);
		}
		
		return length;
	}
	
	public void insert(Node node,int index) {
		Node n = indexOf(index);
		Node n2 = index>=length?null:indexOf(index+1);
		n.next = node;
		node.next = n2;
		length++;
	}
}
