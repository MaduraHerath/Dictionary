import java.lang.*;
import java.util.ArrayList;
import java.awt.*;
public class binarysearchtree {
	
	int count = 0;

 ArrayList<String> strlist = new ArrayList<String>();
	
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


 public void delete(String word) {
        Node parent = root;
        Node current = root;
        word = word;
        boolean rightChild = false;
      
      
        while (current != null && current.data.equals(word)==false) {
            parent = current;
            if (word.compareTo(current.data) > 0) {
                rightChild = true;
                current = current.right;
            } else {
                rightChild = false;
                current = current.left;
            }
            
        }
       
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
               
               
            }
            if (rightChild == true) {
                parent.right = null;
              
              
            } else {
                parent.left = null;
             
            }
        }else if(current.left == null){
            if (current == root) {
                root = current.right;
                
               
            }else if (rightChild){
                parent.right = current.right;
              
               
            }else{
                parent.left = current.right;
              
            
            }
        }else if(current.right == null){
            if (current == root) {
                root = current.left;
              
              
            }else if (rightChild){
                parent.right = current.left;
              
              
            }else{
                parent.left = current.left;
              
               
            }
        }else if(current.left != null && current.right != null){
            Node succ = findSuccessor(current);
            if (current == root) {
                root = succ;
            } else if (rightChild) {
                parent.right = succ;
            } else {
                parent.left = succ;
            }
            succ.right = current.right;
            
           
        }
    
    }
	

public void delete(String word,String Text) {
        Node parent = root;
        Node current = root;
        word = word;
        boolean rightChild = false;
      
      
        while (current != null && current.data.equals(word)==false) {
            parent = current;
            if (word.compareTo(current.data) > 0) {
                rightChild = true;
                current = current.right;
            } else {
                rightChild = false;
                current = current.left;
            }
            
        }
       
        
        if (current.left == null && current.right == null) {
            if (current == root && current.mean.equals(Text)) {
                root = null;
            
               
            }
            if (rightChild == true && parent.right.equals(Text)) {
                parent.right = null;
               
              
            } else if(parent.left.equals(Text)){
                parent.left = null;
               
               
            }
        }else if(current.left == null && current.left.equals(Text)){
            if (current == root) {
                root = current.right;
           
               
            }else if (rightChild){
                parent.right = current.right;
               
               
            }else{
                parent.left = current.right;
          
            
            }
        }else if(current.right == null){
            if (current == root) {
                root = current.left;
           
              
            }else if (rightChild){
                parent.right = current.left;
              
              
            }else{
                parent.left = current.left;
               
               
            }
        }else if(current.left != null && current.right != null){
            Node succ = findSuccessor(current);
            if (current == root) {
                root = succ;
            } else if (rightChild) {
                parent.right = succ;
            } else {
                parent.left = succ;
            }
            succ.right = current.right;
         
           
        }
    
    }
	


























	public String [] similler(String Stext){
		 int count = 0;
		Node current = root;
		String [] a = new String[100];
		
		while (current != null){
			
			if ((current.mean).equals(Stext)){
				
			}
			else{
			if(Stext.equals(current.data) || Stext.compareTo(current.data)>0){
				if(Stext.equals(current.data)){
				a[count] = (current.mean);
				
				count++;
			}
			current = current.right;
			}
				else{
				current = current.left;
			}
		
			
		}
	}
	
	return a;
		
	
}
public Node findSuccessor(Node node) {
        Node targ = null;
        Node targ_parent = null;
        Node current = node.left;
        while (current != null) {
            targ_parent = targ;
            targ = current;
            current = current.right;
        }
        if (targ != node.left) {
            targ_parent.right = targ.left;
            targ.left = node.left;
        }
        return targ;
    }
    public void  traversal(Node root){
		if(root!=null){
			traversal(root.left);
			Input filewrite = new Input();
			filewrite.writeinput(root.data,root.mean);
			traversal(root.right);
		}
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