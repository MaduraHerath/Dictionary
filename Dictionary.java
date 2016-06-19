//import java classes
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.security.MessageDigest;
import java.security.*;
import java.math.BigInteger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
//main class with exten jframe
public class Dictionary extends JFrame {
	private static binarysearchtree bs = new binarysearchtree();
	private static binarysearchtree mbs = new binarysearchtree();
//create gui objects and public variables
	
ArrayList<String> insertStrList = new ArrayList<String>();
JPanel mainpanel = new JPanel();
JTextArea textarea = new JTextArea(); 
JTextField  field1 = new JTextField();
JLabel mainlabel = new JLabel("Welcome to my Dictionary");
JButton SearchBtn = new JButton("Search");
JButton InsertBtn = new JButton("Insert");
JButton DeleteBtn = new JButton("Delete");
String [] StrList ;
String searchStr ;
String insertStr ;
String insertStrmean;

 DefaultListModel listModel = new DefaultListModel();
    	int btncount = 0;
    	 String [] StringArray = new String[100];
    	//implementing Search button event
        public class event_SearchButton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
            	 String [] StringArray = new String[100];
            	listModel.removeAllElements();
            	btncount++;
               searchStr = field1.getText().trim().toUpperCase();
            //find whether there is that node existing   
     		if(	bs.find(searchStr)==false){
     			mainlabel.setText( "Can not find definition for " + searchStr);
     		}


		

		String displayStr = bs.search(searchStr);
		textarea.setText(displayStr);
		StringArray = mbs.similler(hash_function(displayStr));

		int i = 0;
		while(StringArray[i]!=null)
			{
			System.out.println(StringArray[i]);
			listModel.addElement(StringArray[i]);
			i++;
					}
		       }
        }
        	//implementing Delete button event
         public class event_DeleteButton implements ActionListener {
            public void actionPerformed(ActionEvent e){ 
            String text = field1.getText();	
            String s1 = field1.getText().trim().toUpperCase();
            String 	s2 = textarea.getText()	;
            if(bs.find(s1)==true){
            	bs.delete(s1);
            	//mbs.delete(hash_function(s2),text);
            		System.out.println("Succsesfully deleted");
            		listModel.clear();
            		textarea.setText("");
            		mainlabel.setText( "Delete existing "+ text);
            	}
            else{
            	mainlabel.setText("Can not find "+ text +" in Library please chech your word ");
            }
            
            }
        }






        //implementing Insert button event
        public class event_InsertButton implements ActionListener {
            public void actionPerformed(ActionEvent e){
            	String insertText  = field1.getText().trim();
               insertStr = field1.getText().trim().toUpperCase();
               insertStrmean = textarea.getText();
            	listModel.clear();

     			Node node = new Node(insertStr,insertStrmean,null);
     			if(bs.find(insertStr)==true){
     					bs.delete(insertStr);

     			}
     			
     			bs.insert(node.data,node.mean,null);
     			String ne = new String(node.data);
     		
     			
     			 mbs.insert(hash_function(node.mean),node.data,null);
     			

     			Input input  = new Input();
     			input.writeinput(insertText,insertStrmean);
     		
     			
     			/* String []h = new String[insertStrList.size()];

     		//	System.out.println(hash_function(insertStr));
     			 h = insertStrList.toArray(h);
      			for (int i = 0;i <insertStrList.size() ;i++ ) {
      			
      				listModel.addElement(h[i]);
      				
      			}
      			*/


		
			
		

        

            }
        }



 //Dictionary constructor
    public Dictionary() {

        initUI();
    }

    public  void initUI() {
    	
    	mainpanel.setLayout(null);
    
    	
    	
    	JList list = new JList(listModel);
    	 list.setBounds(10, 50, 150, 200);
    	 mainpanel.add(list);
    	 

    	
    	textarea.setBounds(170, 50,500, 200);
    	textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
    	 
     	mainlabel.setBounds(10,280,600,15);
    	mainpanel.add(textarea);
    	mainpanel.add(mainlabel);
    	 

    	field1 = new JTextField();
    	field1.setBounds(10, 10, 220, 30);
    	field1.setText("");
    	field1.getDocument().addDocumentListener(new DocumentListener() {
  public void changedUpdate(DocumentEvent e) {
    warn();
  }
  public void removeUpdate(DocumentEvent e) {
    warn();
  }
  public void insertUpdate(DocumentEvent e) {
    warn();
  }

  public void warn() {
  	textarea.setText("");
  	listModel.removeAllElements();
  	listModel.clear();
  	 String [] StringArray = new String[100];
  	 mainlabel.setText("Welcome to my Dictionary");
  }
});

    	

    	mainpanel.add(field1);
        SearchBtn.setBounds(240, 10, 100, 30);
        InsertBtn.setBounds(350,10,100,30);
        DeleteBtn.setBounds(460,10,100,30);
        add(mainpanel);
      

       mainpanel.setBounds(800, 800, 200, 100);

       mainpanel.add(SearchBtn);
       mainpanel.add(InsertBtn);
       mainpanel.add(DeleteBtn);
       
       setTitle("Madura Dictionary");
       setSize(700, 350);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);

        event_DeleteButton edb =new event_DeleteButton();
        DeleteBtn.addActionListener(edb);
         event_SearchButton bds = new event_SearchButton();
       SearchBtn.addActionListener(bds);
       event_InsertButton eib  = new event_InsertButton();
       InsertBtn.addActionListener(eib);




    }
    //main method
    public static void main(String[] args) {

    	//create input class object
		Input in = new Input();
		in.getinput(bs,mbs);

        EventQueue.invokeLater(new Runnable() {
        
          
            public void run() {
                Dictionary ex = new Dictionary();
                ex.setVisible(true);

            }

             });
      
            
           
            



       
    }

//hashin method
    //i used hash function for hash meaning and i stored it in another BST
public static String  hash_function(String mean){
	   String ss;
        ss = mean;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(ss.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            ss = bigInt.toString(16);
        } catch (Exception e) {
            ss = null;
        } finally{
            return ss;
        }
        

 

 }




}