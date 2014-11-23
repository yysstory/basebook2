package servlets;

public class testServlet {

	
	String url = "http://youtu.be/1WRuSEPKS0I";
	String [] tokens = url.split("/");
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testServlet ts = new testServlet();
		for(int i=1;i<ts.tokens.length;i++){
		System.out.println(ts.tokens[i]);
		}
	}

}
