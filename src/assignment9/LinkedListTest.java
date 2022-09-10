package assignment9;

import java.util.LinkedList;
import java.util.Stack;

public class LinkedListTest {

    public Node head;
    
    public Node getHead() {
	return head;
    }
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	//UniqueEleInSortedLL(node);
	LinkedListTest obj = new LinkedListTest();
	//obj.TestRunner();
	/*obj.insert(1);
	obj.insert(1);
	obj.insert(1);
	obj.insert(1);
	obj.insert(1);
	obj.insert(1);
	obj.insert(1);
	obj.insert(1);
	obj.insert(2);
	obj.insert(3);
	obj.insert(3);
	obj.insert(4);
	obj.insert(4);
	obj.insert(5);
	obj.insert(1);
	obj.insert(2);
	obj.insert(3);
	obj.insert(4);
	obj.insert(5);
	Node rev =  null;
	int[] noOfNodes=new int[1];
	Node l1 = obj.head;
	rev = obj.reverseIterV1(l1,noOfNodes);
	printLL(rev);
	System.out.println("noOfNodes :"+noOfNodes[0]);
	printLL(l1);*/
	/*obj.insert(2);
	obj.insert(4);
	obj.insert(3);
	Node h1 = obj.head; 
	
	System.out.print("h1:=>");printLL(h1);
	obj.head =null;
	obj.insert(9);
	obj.insert(6);
	Node h2 = obj.head;
	System.out.print("h2:=>");printLL(h2);
	
	Node retSum = add2NumsAsList2(h1, h2);
	printLL(retSum);*/
	//obj.printLL(obj.getHead());
	/*Node removeDup = obj.removeDuplicatesInSortedLL(obj.head);
	obj.printLL(removeDup);
	Node unique = obj.PrintUniqueEleInSortedLL(obj.getHead());
	obj.printLL(unique);*/
	//Node deleteDup = obj.getUniqueEleInSortedLL(obj.head);
	//
	/*LinkedListTest obj1 = new LinkedListTest();
	obj1.insert(1);
	obj1.insert(0);
	obj1.insert(0);
	obj1.insert(1);
	obj1.insert(1);
	obj1.insert(0);
	obj1.insert(1);
	obj1.insert(1);
	 //obj1.insert(6); 
	 //obj1.insert(16); obj1.insert(4); obj1.insert(10);
	
	LinkedListTest obj2 = new LinkedListTest();
	obj2.insert(6);
	obj2.insert(11);
	obj2.insert(15);
	obj2.insert(23);
	obj2.insert(29);
	Node merg = mergeLL(obj1.getHead(),obj2.getHead());
	//obj.printLL(merg);
	printLL(obj1.getHead());
	//Node mid = findLLMid(obj1.getHead());
	//System.out.println("mid : "+mid.data);
	//printLL(mid);
	
	
	//printLL(kthMiddile);
	//System.out.println("kthMiddile : "+kthMiddile);
	//Node deletFroNth = deleteNthFromEnd(obj1.getHead(),2);
	//obj.printLL(deletFroNth);
	//int res = isPalindromicLL(obj1.getHead());
	//System.out.println("palindromic : "+res);
	Node binarySorted = sortBinaryLL(obj1.getHead());
	System.out.println("print binary sorted ");
	printLL(binarySorted);*/
	//TestRunner2();
	//TestRunner3();
	TestRunner4();
    }
    
    public static void TestRunner3() {
   	LinkedListTest list = new LinkedListTest();
   	list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next=list.head.next.next.next.next;
       // printLL(list.head);
        Node res = LLCycle2(list.head);
        
        System.out.println("res : "+ res);
    }
    
    public static void TestRunner4() {
	Node mid = null;
	Node res = null;
	LinkedListTest list = new LinkedListTest();
   	list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
	list.head.next.next.next.next = new Node(5);
	list.head.next.next.next.next.next = new Node(6);
	 //list.head.next.next.next.next.next.next = new Node(7);
	 //list.head.next.next.next.next.next.next.next = new Node(8);
	///list.head.next.next.next.next.next.next.next.next = new Node(9);
        printLL(list.head);
        //res = deleteNthFromEnd(list.getHead(),2);
       // int kthMiddile = deleteKthFromMiddle(list.getHead(),1);
        //System.out.println("kthMiddile: "+kthMiddile);
        //mid = findLLMid(list.head, false);
        //System.out.println("mid : "+mid);
       // res = rotateRightByKPlaces(list.head, 3);
        //res = K_ReversedLLV2(list.head, 2);
        //res = K_ReversedRec(list.head,2);
       res = reOrderLL(list.head);
      // res = reversedAlternateKNodes(list.head, 2);
      //res = evenPositionReverseLL(list.head);
       // res = oddEvenList(list.head);
       res= sortLL();
        System.out.print("result :");printLL(res);
    }
    
    public static Node oddEvenList(Node head) {
        if(head==null) return null;
        if(head.next ==null) return head;
        Node odd = head;
        Node temp = head.next;
        Node even = temp;
        //1>3->  2->4->5
        Node  firstHalfLast = null;
        
        while(odd!=null && even!=null){
            odd.next = even.next;
            if(odd.next!=null){
                even.next = odd.next.next;
                even = even.next;
                odd = odd.next;
            }else{
                even = null;
            }
            firstHalfLast = odd;
        }
       firstHalfLast.next = temp;
        
    return head;
    }
    public static Node sortLL() {
	LinkedListTest list = new LinkedListTest();
	list.head = new Node(4);
        list.head.next = new Node(2);
        list.head.next.next = new Node(1);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next = new Node(-1);
        Node slow = list.head;
	Node fast = list.head;
	Node prev =null;
	while(fast!=null && fast.next!=null) {
	    prev = slow;
	    slow = slow.next;
	    fast = fast.next.next;
	}
	System.out.println("first-half");
	prev.next = null; 
	printLL(slow);
        Node node2 = slow.next;
        slow.next = null;
        Node node1 =  slow;
        printLL(node1);
	Node merge = mergeLL(node1,node2);
	return merge;
    }
    public static void TestRunner2() {
	LinkedListTest list = new LinkedListTest();
	list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        printLL(list.head);
	Node res = null;
	res = reverseLLBetween(list.head,1,2);
	//res = reverseLLFromMtoN(list.head,1,2);
	printLL(res);
    }
    public  static void TestRunner() {
	LinkedListTest list = new LinkedListTest();
	list.head = new Node(9);
        list.head.next = new Node(9);
        list.head.next.next = new Node(1);
        System.out.print("First List is ");
        Node h1 = list.head;
        printLL(h1);
        list.head = null;
        list.head = new Node(1);
        //list.head.next = new Node(6);
        //list.head.next.next = new Node(4);
        //list.head.next = new Node(6);
        //list.head.next.next = new Node(4);
        Node h2 = list.head;
        System.out.print("second List is ");
        printLL(h2);
        System.out.println("stack List is ");
       Node ans= add2NumsAsList5(h1,h2);
       printLL(ans);
        
    }
    
   public void insert( int data) {
	Node newNode = new Node(data);
	if(head==null) {
		head = newNode;
	}else {
		Node temp =  head;
		while(temp.next!=null) {
		    temp =  temp.next;
		}
		temp.next = newNode;
	}
}

    public Node removeDuplicatesInSortedLL(Node head) {
	if (head == null || head.next == null) return head;
	// 1-> 1-> 2-> 3-> 3-> 4-> 4-> 5->
	Node curr = head;
	while (curr != null) {
	    if (curr.next != null && curr.data == curr.next.data) {
		curr.next = curr.next.next;
	    } else {
		curr = curr.next;
	    }
	}
	return curr;
    }
   
   public  Node PrintUniqueEleInSortedLL(Node head) {
       if(head==null || head.next==null) return head;
       //1-> 1-> 2-> 3-> 3-> 4-> 4-> 5->
       Node dummy = new Node(0);
       Node prev =dummy, curr = head;
       dummy.next = head;
       while(curr!=null) {
	   
	   if(curr.next!=null && curr.data ==curr.next.data) {
	       
	       while(curr.data == prev.next.data) {
		   curr = curr.next;
	       }
	       prev.next = curr;
	   }else {
	       prev = curr;
	       curr= curr.next;
	   }
	   
       }
       return dummy.next;
   }
   public  Node getUniqueEleInSortedLL(Node head) {
       if(head==null || head.next==null) return head;
       //1-> 1-> 2-> 3-> 3-> 4-> 4-> 5->
       Node dummy = new Node(0);
       Node prev =dummy, curr = head;
       dummy.next = head;
       while(curr!=null) {
	   
	   if(curr.next!=null && curr.data ==curr.next.data) {
	       
	       while((curr!=null && prev.next!=null) && curr.data == prev.next.data) {
		   curr = curr.next;
	       }
	       prev.next = curr;
	   }else {
	       prev = curr;
	       curr= curr.next;
	   }
	   
       }
       return dummy.next;
   }
   
    public  static void printLL(Node head) {
        if(head!=null) {
    		Node curr = head;
    		
    		while(curr!=null) {
    		    System.out.print(curr.data+"-> ");
    		    curr = curr.next;
    		}
        }else {
            System.out.println("Empty List!!");
            return;
        }
        System.out.println();
    }
    
    public static Node mergeLL(Node h1, Node h2) {
	if(h1==null ) return h2;
	if(h2==null ) return h1;
	//prev-> 5 -> 8 -> 20 
	  //6 -> 11 -> 15
	Node dummy = new Node(0);
	Node prev = dummy;
	while(h1!=null && h2!=null) {
	    if(h1.data<=h2.data) {
		prev.next = h1;
		h1 = h1.next;
	    }else {
		prev.next = h2;
		h2 = h2.next;
	    }
	    prev = prev.next;
	}
	if(h1!=null) prev.next= h1;
	if(h2!=null) prev.next= h2;
	return dummy.next;
    }
    
 public int getKthMiddleNodeTowardsBegining(Node head, int b) {
        int n = getCount(head);
        int reqNode = ((n / 2)+1) - b;
 
        if(reqNode <= 0)
            return -1;
        else
        {
            Node current = head;
            int count = 1,ans = 0;
            while (current != null)
            {
                if (count == reqNode)
                {
                    ans = current.data;
                    break;
                }
                count++;
                current = current.next;
            }
            return ans;
        }
 }
    public static Node deleteNthFromEnd(Node head,int n) {
	//1-> 2-> 3-> 4-> 5-> 
	//3-> 4-> 5-> 
	 Node first = head;
	 Node second = head;
	 for(int i = 0; i<n; i++) {
	     if (second.next == null) {
	                // If count = N i.e. delete the head node
	            if (i == n - 1) {
	                 head = head.next;
	                 return head;
	            }
	          // System.out.println(head.next.data);
	            //return head;
	            if(head!=null) {
	        	 head = head.next;
	        	 return head;
	            }
	      
	       }
	       second = second.next;
	 }
	 //printLL(second);
	 
	 while (second!=null && second.next != null) {
	            first = first.next;
	            second = second.next;
	        }
	        // First must be pointing to the
	        // Nth node from the end by now
	        // So, delete the node first is pointing to
	 if(first!=null && first.next!=null)     
	 first.next = first.next.next;
	      return head;  
    }
    
    /** Here Mid is (n/2 +1)**/
    private static Node findLLMid(Node head) {
	if(head==null || head.next==null) return head;
	Node slow = head;
	Node fast = head;
	Node prev =null;
	while(fast!=null && fast.next!=null) {
	    prev = slow;
	    slow = slow.next;
	    fast = fast.next.next;
	}
	System.out.println("mid : "+slow.data);
	return slow;
    }
    
    public static int deleteKthFromMiddle(Node head, int b) {
   	//1-> 2-> 3-> 4-> 5-> 6-> 
   	//4-> 5-> 6-> 
	//1 > 2 > 3
   	 Node first = head;
   	 Node mid = findLLMid(head);
   	 Node prev = null;
   	 //while (mid!=null && mid.next != null) {
   	    for(int i = 0; i< b; i++) {
   		if(mid==null ) return -1;
   	     	prev = first;
   	     	first = first.next;
   	        mid = mid.next;
   	  }
   	    printLL(head);
   	  return first.data;  
       } 
    
    public static int getCount(Node start)
    {
        Node temp = start;
        int cnt = 0;
        while(temp != null)
        {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
   
    
    public static int isPalindromicLL(Node head) {
	
	Node fast = head;
	Node slow = head;
	
	while(fast!=null && fast.next!=null) {
	    slow = slow.next;
	    fast = fast.next.next;
	}
	Node mid = slow;
	Node rev =  reverse(mid);
	
	Node first= head;
	Node next = rev;
	while(first!=null && next!=null) {
	    	if(first.data!=next.data) {
	    	   return 0;
	    	}
	    	first = first.next;
	    	next = next.next;
	}
	return 1;
    }
    
    public static Node reverse(Node head) {
	//1 > 2 > 3 > 4 > 8
	if(head==null || head.next==null) return head;
	Node rHead = reverse(head.next);
	head.next.next = head;
	head.next=null;
	return rHead;
    }
    
    
    public static Node reverseIter(Node node) {
	
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) { // 	24-N => 200-N =>
        	next = current.next;
        	current.next = prev;
        	prev= current;//track for next node
        	current = next; //incremental loop
        }
        return prev;
}
    
public static Node reverseIterV1(Node node, int[] count) {
    Node prev = null;
    Node current = node;
    Node next = null;
    int cnt = 0;
    while (current != null) { // 24-N => 200-N =>
	next = current.next;
	current.next = prev;
	prev = current;// track for next node
	current = next; // incremental loop
	cnt++;
    }
    count[0] = cnt;
    return prev;
}
 
    
    public static Node sortBinaryLL(Node head) {
	
	Node fast = head;
	Node slow = head;
	int zeroesCnt = 0;
	int onesCnt = 0;
	while(fast!=null && fast.next!=null) {
	    if(slow.data==0) zeroesCnt++;
	    if(slow.data==1) onesCnt++;
	    slow = slow.next;
	    fast = fast.next.next;
	}
	while(slow!=null) {
	    if(slow.data==0) zeroesCnt++;
	    if(slow.data==1) onesCnt++;
	    slow = slow.next;
	}
	//System.out.println("zeroesCnt : "+zeroesCnt +", onesCnt = "+onesCnt);
	Node curr = head;
	for(int i= 0; i<zeroesCnt;i++) {
	    curr.data =0;
	    if(curr!=null) curr = curr.next;
	}
	//printLL(head);
	while(curr!=null) {
	    curr.data =1;
	    if(curr!=null) curr = curr.next;
	}
	return head;
    }
    
    public static Node add2NumsAsList(Node h1, Node h2) {
	 String num ="";
	 Node currnt = null;
	 Node h1rev  = reverse(h1);
	 Node h2rev  = reverse(h2);
	 if(h2==null) {
        	 currnt = h1rev;
        	 while(currnt!=null) {
        	     num  = num+currnt.data;
        	     currnt = currnt.next;
        	 }
	 }else if(h1==null) {
	     currnt = h2rev;
	     while(currnt!=null) {
    	     	num  = num+currnt.data;
    	     	currnt = currnt.next;
    	 	}
	     //return num;
	 }
	return null;
    }
    public static Node add2NumsAsList2(Node h1, Node h2) {
	 int cntArr1[]=new int[1];
	 int cntArr2[]=new int[1];
	 int cnt1 = 0;
	 int cnt2 = 0;
	 
	 Node h1rev = reverseIterV1(h1, cntArr1);
	 cnt1 = cntArr1[0];
	 if(h2==null) return h1rev;
	 
	 Node h2rev  = reverseIterV1(h2, cntArr2);
	 cnt2 = cntArr2[0];
	 if(h1==null)  return h2rev;
	 
	 Node head= null; //1264
	 		 //   78
	 //-----------------123
	 if(cnt1 > cnt2) {
	     int diff = cnt1-cnt2;
	     if(h1rev!=null && h2rev!=null) {
		int it=0;
		int carry=0;
		Node curr1 = h1rev;
		Node curr2 = h2rev;
		 while (curr1.next!=null && curr2.next!=null && cnt1!=it+1) {
		    int res = 0;
		    res = res+h1rev.data;
		    if(diff>it) {
			res = res+h2rev.data;
			curr2 = h2rev.next;
		    }
		    if(carry==1) res = res+ carry;
		    
		    if (res >9) {
			res = (10-res);
			carry = 1;
		    }else carry=0;
		    
		    Node newNode = new Node(res);
			if(head==null) {
				head = newNode;
			}else {
				Node temp =  head;
				while(temp.next!=null) {
				    temp =  temp.next;
				}
				temp.next = newNode;
			}
			it++;
			curr1= h1rev.next;
		}
		    
		 
	     }
	 }
	
	return head;
   }
    
    public static Node add2NumsAsList3(Node h1, Node h2) {
	Stack<Node> stTemp1 = new Stack<Node>();
	Stack<Node> stTemp2 = new Stack<Node>();
	Stack<Node> s3 = new Stack<Node>();
	
	while(h1!=null) {
	    stTemp1.add(h1);
	    h1 = h1.next;
	}
	while(h2!=null) {
	    stTemp2.add(h2);
	    h2 = h2.next;
	}
	
	int sz1 = stTemp1.size();int sz2 = stTemp2.size();  
	if(sz1!=sz2) {
    	if(sz1> sz2) {
    	    for(int i = 0; i< sz1-sz2; i++) stTemp2.push(new Node(0));
    	}
	
	if(sz2> sz1) {
	    for(int i = 0; i< sz2-sz1; i++) stTemp1.push(new Node(0));
	}
	
	}
	System.out.println("stTemp1 : "+stTemp1);
	System.out.println("stTemp2 : "+stTemp2);
	
	Stack<Node> s1 = new Stack<Node>();
	Stack<Node> s2 = new Stack<Node>();
	while(!stTemp1.isEmpty()) {
	    s1.add(stTemp1.pop());
	    s2.add(stTemp2.pop());
	}
	
	System.out.println("s1 : "+s1);
	System.out.println("s2 : "+s2);
	int carry= 0;
	
	LinkedListTest  obj = new LinkedListTest();
	obj.head =null;
	while(!s1.isEmpty()) {
	    int res =0;
	    res = s1.pop().data+s2.pop().data+carry;
	    if (res > 9) carry=1;
		else carry=0;
	    res =  res%10;
	    obj.insert(res);
	}
	
	/*while(!stTemp1.isEmpty()) {
	    int res =0;
	    res = stTemp1.pop().data+carry;
	    if (res > 9) carry=1;
		else carry=0;
	    res =  res%10;
	    s3.add(new Node(res));
	}
	while(!stTemp2.isEmpty()) {
	    int res =0;
	    res = stTemp2.pop().data+carry;
	    if (res > 9) carry=1;
		else carry=0;
	    res =  res%10;
	    s3.add(new Node(res));
	}*/
	if(carry==1) obj.insert(carry);
	printLL(obj.head);
	System.out.println("s3: "+ s3);
	
	
	/*
	while(!s1.empty()) {
	  int res =0;
	  res = s1.pop().data+s2.pop().data;
	  if (res > 9) {
	      if(carry ==1 ) res = res+carry;
	      res = res%10;
	      carry =1;
	  }else carry=0;
	  s3.add(new Node(res));
	}
	 if(carry==1) s3.add(new Node(carry));
	System.out.println("s3 : "+s3);*/
	
	/*Stack<Node> revAns = new Stack<Node>();
	while(!s3.isEmpty()) 
	    revAns.add(s3.pop());
	while(!revAns.isEmpty())
	    obj.insert(revAns.pop().data); 
	printLL(obj.head);*/
	return obj.head;
    }
    
    
    public static Node add2NumsAsList4(Node h1, Node h2) {
	
	
 	LinkedList<Node> stTemp1 = new LinkedList<Node>();
 	LinkedList<Node> stTemp2 = new LinkedList<Node>();
 	
 	while(h1!=null) {
 	    stTemp1.add(h1);
 	    h1 = h1.next;
 	}
 	while(h2!=null) {
 	    stTemp2.add(h2);
 	    h2 = h2.next;
 	}
 	
 	int sz1 = stTemp1.size();int sz2 = stTemp2.size();  
 	if(sz1!=sz2) {
     	if(sz1> sz2) {
     	    for(int i = 0; i< sz1-sz2; i++) stTemp2.add(new Node(0));
     	}
 	
 	if(sz2> sz1) {
 	    for(int i = 0; i< sz2-sz1; i++) stTemp1.add(new Node(0));
 	}
 	
 	}
 	System.out.println("stTemp1 : "+stTemp1);
 	System.out.println("stTemp2 : "+stTemp2);
 	
 	Stack<Node> s1 = new Stack<Node>();
 	Stack<Node> s2 = new Stack<Node>();
 	/*while(!stTemp1.isEmpty()) {
 	    s1.add(stTemp1.pop());
 	    s2.add(stTemp2.pop());
 	}*/
 	
 	System.out.println("s1 : "+s1);
 	System.out.println("s2 : "+s2);
 	int carry= 0;
 	
 	LinkedListTest  obj = new LinkedListTest();
 	obj.head =null;
 	while(!stTemp1.isEmpty()) {
 	    int res =0;
 	    res = stTemp1.pop().data+stTemp2.pop().data+carry;
 	    if (res > 9) carry=1;
 		else carry=0;
 	    res =  res%10;
 	    obj.insert(res);
 	}
 	if(carry==1) obj.insert(carry);
 	return obj.head;
     }
    
     
    public static Node add2NumsAsList5(Node h1, Node h2) {
	//Efficient
	Node dummy= new Node(0);
 	Node res = dummy;
 	int carry = 0;
 	while(h1!=null || h2!=null) {
 	    int h1_val = (h1!=null)?h1.data:0;
 	    int h2_val = (h2!=null)?h2.data:0;
 	    
 	    int sum = h1_val + h2_val+carry;
 	    carry = sum/10;
 	    int last_digt = sum%10;
 	    Node newNode = new Node(last_digt);
 	    res.next= newNode;
 	    
 	    if(h1!=null) h1 = h1.next;
 	    if(h2!=null) h2 = h2.next;
 	    res= res.next;
 	}
 	
 	if(carry>0) {
 	   Node nw_node = new Node(carry);
 	   res.next= nw_node;
 	   res = res.next;
 	}
 	return dummy.next;
    }
    
    public static Node reverseLLFromMtoN(Node h1, int m, int n) {
	int low=1; //1->2->3->4->5->NULL
	Node firstPart = h1;
	if(firstPart ==null) return firstPart;
	Node firsPartPrev =null;
    	while( low < m && firstPart!=null) {
    	    low++;
    	    firsPartPrev = firstPart;
    	    firstPart = firstPart.next;
    	}
	
	System.out.println("firstpart head : "+firstPart.data);
	printLL(firstPart);
	 Node prev = null;
         Node current = firstPart;
         Node next = null;
         int cnt = 1;
         while (cnt<n && current != null) { // 	24-N => 200-N =>
     		cnt ++;
         	next = current.next;
         	current.next = prev;
         	prev= current;//track for next node
         	current = next; //incremental loop
         }
         System.out.println("reversed part : head : "+prev.data);
         printLL(prev); 
         System.out.println("reversed part : tail : "+prev.next.data);
         prev.next = next;
        firstPart.next = current;
         
         
         return h1;
    }
    
    public Node reverseIter(Node node, int tillIndex) {
            Node prev = null;
            Node current = node;
            Node next = null;
            int cnt = 1;
            while (cnt<=tillIndex && current != null) { // 	24-N => 200-N =>
        	cnt ++;
            	next = current.next;
            	current.next = prev;
            	prev= current;//track for next node
            	current = next; //incremental loop
            }
            return prev;
    }
    public static Node reverseLLBetween(Node head, int m, int n) {
	if(head==null || head.next==null) return head;
	Node firstHalfPrev = null; //1 > 2 > 3 > 4 > 5
	Node current = head;
	while( m > 1 ) {
	    firstHalfPrev = current;
	    current = current.next;
	    m--;
	    n--;
	}
	System.out.println("till m: "+current.data);
	printLL(firstHalfPrev);
	Node tail = current;
	Node tmp = null;
	Node prev =null;
	
	while(n>0) {
	    tmp = current.next;
	    current.next = prev;
	    prev= current;
	    current = tmp;
	    n--;
	}
	System.out.println("reversed m>n: ");
	printLL(prev);
	if(firstHalfPrev!=null ) {
	    firstHalfPrev.next = prev;
	}else {
	    head = prev;
	}
	tail.next = current;
	return head;
    }
    
    public static Node LLCycle(Node head) {
	if( head == null || head.next==null) return null;
	Node slow = head;
	Node fast = head.next;
	while(fast!=slow) {
	    if(fast== null || fast.next==null) return null;
	    slow = slow.next;
	    fast = fast.next.next;
	}
	
	return slow;
    }
    public static Node LLCycle2(Node head) {
	if( head == null || head.next==null) return null;
	Node slow = head;
	Node fast = head;
	while(fast!=null) {
	    if(fast.next== null || fast.next.next==null) return null;
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow==fast) break;
	}
	slow = head;
	
	while(slow!=fast) {
	    slow = slow.next;
	    fast = fast.next;  
	}
	return slow;
    }
    
    public static Node rotateRightByKPlaces(Node head, int k) {
        if(head==null || head.next==null || k==0) return head; 
	Node temp = head;
        int cnt = 0;
        Node lastBefore =null;
        while(temp != null){
        lastBefore = temp; 
    	temp = temp.next;
            cnt++;
        }
        int range= 0;
        
        if(k > cnt) range = cnt- k%cnt;
        else range = cnt-k;
        if(k==cnt || range ==cnt) return head;
        System.out.println("total range : "+range +", node : "+lastBefore.next);
	Node current =head;
	Node tmpPrev =null;
	
	for(int i=0; i<(range); i++) {	//1->2->3-> 4->5->null
	    tmpPrev = current;
	    current = current.next; 	//4->5->1->2->3->null
	}
	lastBefore.next = head;
	System.out.println("current : "+current+ ", node : "+lastBefore.next);
	tmpPrev.next = null;
	return current;
    }
    /** Here Mid is (n/2 +1)**/
    private static Node findLLMid(Node head, boolean lower) {
	if(head==null || head.next==null) return head;
	Node slow = head;
	Node fast = head;
	Node prev =null;
	while(fast!=null && fast.next!=null) {
	    prev = slow;
	    slow = slow.next;
	    fast = fast.next.next;
	}
	if(lower && fast==null) return prev;
	System.out.println("mid : "+slow.data);
	return slow;
    }
    
    private static Node K_ReversedLL(Node head, int k) {
	if(head ==null || head.next==null) return head;
	if(k<2) return head;    //1 -> 2 -> 3 -> 4 -> 5 -> 6
				//3 -> 2 -> 1 -> 6 -> 5 -> 4
	int n = getLength(head);
	int remainLen= 0;
	Node current = head;
	Node prev = null;
	Node next = null;
	 
	while(current!=null) {
	    int cnt = 0;
	    prev = null;
	    next = null;
	    n = n-remainLen;
    	     while (cnt<k && current != null) {
    		next = current.next;
    	        current.next = prev;
    	        prev= current;
    	        current = next;
    	        System.out.println("iter : "+cnt+", current : "+current);
    	        cnt++;
    	        remainLen++;
    	    	}
    	    printLL(prev);
    	     if(current!=null)
	    current = next;
	}
	return current;
	
    }
    
    private static Node K_ReversedLLV1(Node head, int k) {//failed
	if(head ==null || head.next==null) return head;
	if(k<2) return head;    //1 -> 2 -> 3 -> 4 -> 5 -> 6
				//3 -> 2 -> 1 -> 6 -> 5 -> 4
	int n = getLength(head);
	Node dummy = new Node(0);
	dummy.next = head;
	Node current = head;
	Node prev = head;
	Node next = head;
	 
	while(n>=k) {
	    current = prev;
	    next  = current;
    	     for(int i =1; i<k; i++) {
    		next = current.next;
    	        current.next = prev;
    	        prev= current;
    	        current = next;
    	        printLL(current);
    	        current = null;
    	    	}
    	    prev = current;
    	    n = n-k;
    	     
	}
	return dummy.next;
	
    }
    //https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
    //https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/
    //https://www.youtube.com/watch?v=Of0HPkk3JgI
    /***Find n'th Node from the End of a Linked List ***/
    /*** https://www.educative.io/courses/coderust-hacking-the-coding-interview/mryR**/
    private static Node K_ReversedLLV2(Node head, int k) {
	if(head ==null || head.next==null) return head;
	if(k<2) return head;    //1 -> 2 -> 3 -> 4 -> 5 -> 6
				//3 -> 2 -> 1 -> 6 -> 5 -> 4
	int n = getLength(head);
	Node dummy = new Node(0);
	dummy.next = head;
	Node current = dummy;
	Node prev = dummy;
	Node next = dummy;
	 
	while(n>=k) {
	    current = prev.next;
	    next  = current.next;
    	     for(int i =1; i<k; i++) {
    		current.next =next.next;
    		next.next = prev.next;
    	        prev.next = next;
    	        next = current.next;
    	    	}
    	    prev = current;
    	    n = n-k;
    	     
	}
	return dummy.next;
    }
    
    private static Node K_ReversedRec(Node node, int k) {
   	if(node ==null || node.next==null) return node;
   	Node current = node;
   	Node prev = null;
   	Node next = null;
   	int cnt = 0;
   	while(current!=null && cnt<k) {
   	    next = current.next;
   	    current.next= prev;
   	    prev = current;
   	    current = next;
   	    cnt++;
   	}
   	printLL(prev);
   	if(next!=null) 
   	    node.next = K_ReversedRec(next, k);
   	return prev;
      }
    
    private static int getLength(Node head) {
	int len = 0; 
	if(head!=null) {
	    Node curr = head;
	    while(curr!=null) {
		curr = curr.next;
		len++;
	    }
	}
	return len;
    }
    
    private static Node reOrderLL(Node head) {
	if (head == null || head.next == null)
	    return null;
	Node slow = head;
	Node fast = head;
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	}
	Node prev = null;
	Node node1 = head;
	
	Node current = slow.next;
	slow.next=null;
	System.out.print("firstHalf: ");printLL(node1);
	Node next = null;
	while (current != null) { 
	    next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;
	}
	Node node2 = prev;
	System.out.print("reverse Half: ");printLL(node2);
	current = new Node(0);
	/*while(node1!=null || node2!=null) {
	    
	    if(node1!=null) {
		current.next=node1;
		current = current.next;
		node1= node1.next;
	    }
	    if(node2!=null) {
		current.next=node2;
		current = current.next;
		node2= node2.next;
	    }
	}*/
	// 1-> 8-> 2-> 7-> 3-> 6-> 4-> 5-> 
	while(node2!=null ) {
	    Node temp = node2.next;
	    node2.next =node1.next;
	    node1.next = node2;
	    node1 = node1.next.next;
	    node2 = temp;
	    printLL(head);
	}
	return head;
    }
    
    private static Node reversedAlternateKNodes(Node head, int k) {
   	if(head ==null || head.next==null) return head;
   	//if(k<2) return head;  //1 -> 2 -> 3 -> 4 -> 5 -> 6 ->7 -> 8 -> 9
   				//3 -> 2 -> 1 -> 4 -> 5 -> 6 ->9 -> 8 -> 7
   	Node current = head;
   	Node prev = null;
   	Node newHead = null;
   	Node temp = null;
   	Node tail = null;
   	Node join = null;
   	int t = 0; 
   	while(current!=null) {
   	    t=k;
   	    join = current;
   	    prev = null;
   	    while(current!=null && t-->0) {
   		temp = current.next;
   		current.next = prev;
   		prev = current;
   		current = temp;
   	    }
   	    printLL(prev);
   	    if(newHead==null) newHead = prev;
   	    
   	    if (tail != null)
   		tail.next = prev;
   	    
   	    tail =  join;
   	    tail.next = current;
   	    t= k;
   	    
   	    while(current!=null && t-->0) {
   		prev = current;
   		current = current.next;
   	    }
   	    System.out.print("skipnext"); printLL(prev);
       	    tail = prev;
   	}
   	return newHead;
      }
    
    private static Node evenPositionReverseLL(Node node) {
   	if(node ==null || node.next==null || node.next.next==null) return node;
   	Node odd = node; //1 -> 2 -> 3 -> 4 -> 5 -> 6 ->7->8->9
   	Node even = null;
   	Node tmp = null;
   	
   	while(odd!=null && odd.next!=null) {
   	    tmp = odd.next;
   	    odd.next=tmp.next;
   	    tmp.next = even;
   	    even = tmp;
   	    odd= odd.next;
   	}
   	odd = node;
   	printLL(even);
   	printLL(odd);
   	while(even!=null) {
   	    tmp = even.next;
   	    even.next = odd.next;
   	    odd.next = even;
   	    odd = odd.next.next;
   	    even = tmp;
   	}
   	
   	return node;
      }
}
