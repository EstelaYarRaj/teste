package rajTest;

import java.net.URL;
import java.net.URLConnection;


public class TestCase {
	
	public static void main(String[] args) {
		
		try 
		{
			URL obj = new URL("'http://nj3dccnjsdv02.it.savvis.net:10010'");
			URLConnection conn = obj.openConnection();
			System.out.println("Printing Response Header...\n");

			System.out.println("\nGetting Token ...\n");
			String Token = conn.getHeaderField("Token");

			if (Token == null) {
				System.out.println("Key 'Token' is not found!");
			} else {
				System.out.println("Toen - " + Token);
			}

			System.out.println("\n Done");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
	}
}


