import java.lang.*;
import java.util.ArrayList;
import java.awt.*;
public class binarysearchtree {
	int count = 0;

 ArrayList<String> strlist = new ArrayList<String>();
	String [] a = new String[100];
	public static Node root;
	public binarysearchtree(){
		this.root = null;
	}
	public void insert(String text,String mean,ArrayList StrList){
		Node newNode = new Node(text,mean,null);
		if(root == null){
			root = newNode;
			return;
		}
		Node current = root ;
		Node parent = null;

		while(true){
			parent = current ;
			//if some thing similler it because "="
			if(text.compareTo(current.data)<0){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
				}else{
					current = current.right;
					if(current == null){
						parent.right= newNode;
						return;
					}
				}
				
			}

		}

	public void Display(Node root ){
		if(root!= null){
			Display(root.left);
			System.out.println(" "+root.data);
			Display(root.right);
		}
	}
	public static String search(String Stext){
		Node current = root;
		while (current != null){
			if(Stext.compareTo(current.data) ==0){
				return current.mean;
			}else if (Stext.compareTo(current.data)<0){
				current = current.left;

			}else{
				current = current.right;
			}
			
		}
		return "NOT FOUND";
	}
	

	public static boolean find(String Stext){
		Node current = root;
		while (current != null){
			if(Stext.compareTo(current.data) ==0){
				return true;
			}else if (Stext.compareTo(current.data)<0){
				current = current.left;

			}else{
				current = current.right;
			}
			
		}
		return false;
	}


public boolean delete(String text){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=text){
			parent = current;
			if((current.data).compareTo(text) > 0){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}
	
	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}

		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}



























	public String [] similler(String Stext){
		 int count = 0;
		Node current = root;
		
		
		while (current != null){
			
			if ((current.mean).equals(Stext)){
				
			}
			else{
			if(Stext.equals(current.data)){
				a[count] = (current.mean);
				current = current.right;
				count++;
			}
				else{
				current = current.left;
			}
		
			
		}
	}
	
	return a;
		
	
}

	public static void main(String[] args) {
		binarysearchtree bs = new binarysearchtree();
	 binarysearchtree mbs = new binarysearchtree();
	
		Input in = new Input();
		in.getinput(bs,mbs);
		System.out.println(bs.search("House"));
		
	}
	

}
//declare node
	class Node{
		String mean;
		String  hash_value;
		Node left;
		Node right;
		String data;
		ArrayList stringList ;
		public Node(String data,String mean,ArrayList stringList){
			left = null;
			right = null;
			this.data = data;
			this.mean = mean;
			this.stringList  = stringList;

		}

	}