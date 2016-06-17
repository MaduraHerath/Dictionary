
import java.awt.EventQueue;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class gui extends JFrame {
    
JPanel mainpanel = new JPanel();
JTextArea textarea = new JTextArea(5,30);
JTextField  field1 = new JTextField();
JList list  = new JList();
JButton SearchBtn = new JButton("Search");
 
    

        public class event_SearchButton implements ActionListener {
            public void actionPerformed(ActionEvent e){
               String [] junk = {"sfsd","DFdfgfdg","dFGDFGDF","fgdgfdg","dfgdgdfgd","dfgwefsfe","yrterte","dfseefwq3f","srgerfs","ddfgdgdfgd","sdfs","sdfsd","sdfsfewf","sdf","efsf"};
        list  = new JList(junk);
        System.out.println("asd");


            }
        }


    public gui() {

        initUI();
    }

    private void initUI() {
       event_SearchButton bds = new event_SearchButton();
       SearchBtn.addActionListener(bds);
    	mainpanel.setLayout(null);
    	
    
    	 list.setBounds(10, 50, 150, 500);
    	 mainpanel.add(list);

    	
    	 textarea.setBounds(170, 50,300, 500);
    	  mainpanel.add(textarea);


    	
    	field1.setBounds(10, 10, 220, 30);
    	field1.setText("Type Here");
    	mainpanel.add(field1);
        SearchBtn.setBounds(240, 10, 100, 30);
         add(mainpanel);
      

        mainpanel.setBounds(800, 800, 200, 100);

        mainpanel.add(SearchBtn);
       
        setTitle("Madura Dictionary");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                gui ex = new gui();
                ex.setVisible(true);

            }
        });
    }
}