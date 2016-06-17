import java.lang.*;
class test{
	private static binarysearchtree bs = new binarysearchtree();
	private static binarysearchtree mbs = new binarysearchtree();
	public static void main(String[] args) {
		Input in = new Input();
		in.getinput(bs,mbs);
		System.out.println(bs.left.data);
	}
}