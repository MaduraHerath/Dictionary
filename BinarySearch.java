import java.lang.*;
public class BinarySearch {
	public static MNode root;
	public BinarySearch(){
		this.root = null;
	}
	public void insert(String text,String[] mean){
		MNode newNode = new MNode(text,mean);
		if(root == null){
			root = newNode;
			return;
		}
		MNode current = root ;
		MNode parent = null;

		while(true){
			parent = current ;
			//if some thing similler it because "="
			if(text.compareTo(current.hash)<0){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
				}
			else if(text.compareTo(current.hash) == 0){
				
				
			} 
				else{
					current = current.right;
					if(current == null){
						parent.right= newNode;
						return;
					}
				}
				
			}

		}

	public void Display(MNode root ){
		if(root!= null){
			Display(root.left);
			System.out.println(" "+root.hash);
			Display(root.right);
		}
	}
	public static String search(String Stext){
		MNode current = root;
		while (current != null){
			if(Stext.compareTo(current.hash) ==0){
				return current.hash;
			}else if (Stext.compareTo(current.hash)<0){
				current = current.left;

			}else{
				current = current.right;
			}
			
		}
		return "NOT FOUND";
	}
	public static void main(String[] args) {
	

		
		
		
	}

	

}
//declare MNode
	class MNode{
		String hash;
		String [] strArray;
		MNode left;
		MNode right;
		
		public MNode(String hash, String[] strArray){
			left = null;
			right = null;
			this.hash = hash;
			this.strArray = strArray;
			
		}

	}