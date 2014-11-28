package servlets;

public class testServlet {
	//http://www.youtube.com/watch?v=N5wzkQvzp4c
	
	static String url = "//http://www.youtube.com/watch?v=N5wzkQvzp4c";
	//String [] tokens = url.replaceAll(".", " ").replaceAll("/"," ").trim().split(" ");
	
	static String tokens = url.replaceAll(".", " ").replaceAll("/"," ").trim();
		
	public static void main(String[] args) {
		testServlet ts = new testServlet();

		System.out.println(tokens);
	}

}
