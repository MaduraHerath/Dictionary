import java.io.*;
import java.util.*;
class Input extends Dictionary{

	
	public void getinput(binarysearchtree bs,binarysearchtree mbs ){
		int count = 0;
		boolean flag = false;
		 BufferedReader reader = null;
		
		
        try {
         String currentLine;
            reader = new BufferedReader(new FileReader("input.txt"));
			
            while  ((currentLine = reader.readLine()) != null) {
           	count++;
                
                String [] strlist = currentLine.split(":");
                Node n = new Node(strlist[0].trim(),strlist[1],null);
                bs.insert(n.data.trim().toUpperCase(),n.mean,n.stringList);
               
                mbs.insert(hash_function(n.mean),n.data,n.stringList);
                System.out.println(n.data +" "+hash_function(n.mean));
            

	

		}
		}
	catch(IOException e){
	System.out.print(e);
	
	}

	finally{
	try {
		reader.close();
	
	}
	catch(Exception r)
	{
	System.out.println(r);
	

	}
	}
}

public void writeinput(String text1,String text2){
		BufferedWriter writer = null;
        try {
			writer = new BufferedWriter(new FileWriter("input.txt",true));
           
         		  writer.newLine();
               writer.write(text1+":"+text2);
		}
	catch(IOException e){
	System.out.print(e);
	
	}

	finally{
	try {
	
		writer.close();
	}
	catch(Exception r)
	{
	System.out.println(r);
	

	}
	}
}

}