import java.util.*;
import java.util.ArrayList;
import java.security.*;
import java.math.BigInteger;
class test2{
	public static void main(String[] args) {
		 Hash_Node [] Hash_list =  new Hash_Node[5]; 
		 String [] s = {"Home","House"};
		 Hash_Node h1 = new Hash_Node("sdfsds",s);
		 Hash_Node h2 = new Hash_Node("DFGDG",s);
		 Hash_Node h3 = new Hash_Node("dbdfbfbd",s);
		 Hash_Node h4 = new  Hash_Node("RGDRGDGdvd",s);
		 Hash_Node h5 = new  Hash_Node("DFRGDRgdrGDR",s);
		Hash_list[0] = h1;
		Hash_list[1] = h2;
		Hash_list[2] = h3;
		Hash_list[3] = h4;
		Hash_list[4] = h5;
		
ArrayList Hash_List = new ArrayList();

Hash_List.add(getMD5("SDFSDF"));

 
 	System.out.println(getMD5("ASD"));
	}

    public static String getMD5(String txt){
        String ss;
        ss = txt;
        try {
            MessageDigest m = MessageDigest.getInstance("MD4");
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
class Hash_Node{
	String mean ;
	String  [] reference ;
	public Hash_Node(String mean,String  [] reference){
	this.mean = mean;
	this.reference = reference;
	
}
}