import java.io.*;
import java.util.*;
class Input{

	
	public void getinput(binarysearchtree bs,binarysearchtree mbs ){
		int count = 0;
		 BufferedReader reader = null;
		
		BufferedWriter writer = null;
        try {
         String currentLine;
            reader = new BufferedReader(new FileReader("input.txt"));
			writer = new BufferedWriter(new FileWriter("output.txt"));
            while  ((currentLine = reader.readLine()) != null) {
           	count++;
                
                String [] strlist = currentLine.split("_");
                Node n = new Node(strlist[0],strlist[1],null);
                bs.insert(n.data.trim().toUpperCase(),n.mean,n.stringList);


	

		}
          }
	catch(IOException e){
	System.out.print(e);
	
	}

	finally{
	try {
		reader.close();
		writer.close();
	}
	catch(Exception r)
	{
	System.out.println(r);
	

	}
	}
}
}