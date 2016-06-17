import java.lang.*;
import java.util.ArrayList;
public class binarysearchtree {
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
			if(text.compareTo(current.data)<=0){
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
			System.out.println(" "+root.mean);
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