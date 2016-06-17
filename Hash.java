

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.security.MessageDigest;
import java.security.*;
import java.math.BigInteger;



public class Hash {
	 ArrayList Hash_list = new ArrayList();

 public static void main(String[] args) {

System.out.println(hash_function("SDFSFS"));

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

 class HashNode{
String mean ;
String [] reference ;
public HashNode(String mean,String[] reference){
	this.mean = mean;
	this.reference = reference;

}

}
