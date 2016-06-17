
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

public class Dictionary extends JFrame {
	private static binarysearchtree bs = new binarysearchtree();
	private static binarysearchtree mbs = new binarysearchtree();

	
 ArrayList<String> insertStrList = new ArrayList<String>();
JPanel mainpanel = new JPanel();
JTextArea textarea = new JTextArea(); 
JTextField  field1 = new JTextField();
JList list  = new JList();
JButton SearchBtn = new JButton("Search");
JButton InsertBtn = new JButton("Insert");
 String [] StrList ;
String searchStr ;
String insertStr ;
 String insertStrmean;
 String [] ass;
 DefaultListModel listModel = new DefaultListModel();
    
        public class event_SearchButton implements ActionListener {
            public void actionPerformed(ActionEvent e) {
               searchStr = field1.getText().trim().toUpperCase();
               
     


		

		String displayStr = bs.search(searchStr);
		textarea.setText(displayStr);
		//String [] ass = new  String[bs.similler("BOOK").size()];
			//System.out.println(ass[0]);
			
	
       

            }
        }

        public class event_InsertButton implements ActionListener {
            public void actionPerformed(ActionEvent e){
               insertStr = field1.getText().trim().toUpperCase();
               insertStrmean = textarea.getText();
            

     			Node node = new Node(insertStr,insertStrmean,null);
     			bs.insert(node.data,node.mean,null);
     			String ne = new String(node.data);
     		
     			if(mbs.find(hash_function(node.mean)) ){
     					insertStrList.add(ne);
     			}
     			
     			 mbs.insert(hash_function(node.mean),null,insertStrList);
     			
     			
     			
     			 String []h = new String[insertStrList.size()];

     		//	System.out.println(hash_function(insertStr));
     			 h = insertStrList.toArray(h);
      			for (int i = 0;i <insertStrList.size() ;i++ ) {
      			
      				listModel.addElement(h[i]);
      				
      			}
      			


		
			
		

        

            }
        }




    public Dictionary() {

        initUI();
    }

    public  void initUI() {
    	
    	mainpanel.setLayout(null);
    
    	
    	
    		JList list = new JList(listModel);
    	 list.setBounds(10, 50, 150, 200);
    	 mainpanel.add(list);

    	
    	 textarea.setBounds(170, 50,500, 200);
    	
    	
     
    	  mainpanel.add(textarea);

    	 

    	 field1 = new JTextField();
    	field1.setBounds(10, 10, 220, 30);
    	field1.setText("");
    	mainpanel.add(field1);
        SearchBtn.setBounds(240, 10, 100, 30);
        InsertBtn.setBounds(350,10,100,30);
         add(mainpanel);
      

        mainpanel.setBounds(800, 800, 200, 100);

        mainpanel.add(SearchBtn);
       mainpanel.add(InsertBtn);
        setTitle("Madura Dictionary");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


         event_SearchButton bds = new event_SearchButton();
       SearchBtn.addActionListener(bds);
       event_InsertButton eib  = new event_InsertButton();
       InsertBtn.addActionListener(eib);




    }

    public static void main(String[] args) {
    	
		Input in = new Input();
		in.getinput(bs,mbs);

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                Dictionary ex = new Dictionary();
                ex.setVisible(true);

            }

             });
        System.out.println(bs);
      
            
           
            



       
    }


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