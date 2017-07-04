package rajTest;

import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; 

public class TestCase {
	public final static String swaggerServer = "http://nj3dccnjsdv02.it.savvis.net:10010";
	public final static String Token = "15065a29e896b01547dc55de92acaa1b";
	public static ArrayList<Integer> CompanyID;
	public static ArrayList<String> ClusterID;
	public static ArrayList<Integer> MachineID;
	public static ArrayList<Integer> StorageID;
	public static ArrayList<String> OrderID;
	public static String OsName;
	public static String OsID;
	public static ArrayList<Integer> ProductID;
	@SuppressWarnings("serial")
	public final static ArrayList<String> Type = new ArrayList<String>(){{
		
		add("os");
		add("compute");
		add("all");
		add("storage");
	}};
	public static void main(String[] args) {
		login();
		getSession();
		System.out.println("Run test: \n" +
				"1) getCompany \n");				
		System.out.println("Enter number: ");
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		if ( n == 1 ){
			int v = 0;
			getCompany();
			Scanner reader2 = new Scanner(System.in);
			int n2 = reader2.nextInt();
			while (v == 0)
			{
				System.out.println("Choose Test: \n"
						+ "2) getStorages \n"
						+ "3) getDataCenters \n"
						+ "4) getAvailIPs (Unavailable) \n"
						+ "5) getBillingSites \n"
						+ "6) getOrders\n"
						+ "7) getOrderProducts \n"
						+ "8) getMachineImages \n"
						+ "9) getDomain \n"
						+ "10) getClusters \n"
						+ "11) getClusterNetworkIntSeg \n"
						+ "12) getCluterCatalog \n"
						+ "13) getClusterMachineImages \n"
						+ "14) getClusterHosts \n"
						+ "15) getClusterStorage \n " );
				System.out.println("Enter number: ");			
				
				if ( n2 == 2 ){
					getStorages();

				}
				else if ( n2 == 3 ){
					getDataCenters();

				}
				else if ( n2 == 4 ){
					/*getAvailIPs();*/
			
				}
				else if ( n2 == 5 ){
					getBillingSites();

				}
				else if ( n2 == 6 ){
					getOrders();
				}
				else if ( n2 == 7 ){
					getOrderProducts();

				}
				else if ( n2 == 8 ){
					getMachineImages();

				}
				else if ( n2 == 9 ){
					getDomain();

				}
				else if ( n2 == 10 ){
					getClusters();

				}
				else if ( n2 == 11 ){
					getClusterNetworkIntSeg();

				}
				else if ( n2== 12){
					getCluterCatalog();

				}
				else if ( n2 == 13 ){
					getClusterMachineImages();

				}
				else if ( n2 == 14 ){
					getClusterHosts();

				}
				else if ( n2 == 15 ){
					getClusterStorage();

				}
				reader2.close();
			}	
			reader.close();
			}
			
	}
	/** public static void getToken() {		
		try 
		{
			URL obj = new URL(swaggerServer);
			URLConnection conn = obj.openConnection();
			System.out.println("Printing Response Header...\n");

			System.out.println("\nGetting Token ...\n");
			Token = conn.getHeaderField("Token");

			if (Token == null) {
				System.out.println("Key 'Token' is not found!");
			} else {
				System.out.println("Token - " + Token);
			}

			System.out.println("\n Done");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	
	}
	**/
	public static int login() {
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/login");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("POST");
			conn.setRequestProperty("auth-token", Token);
			conn.setRequestProperty("Content-Type", "application/json");						
			
			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());;
			wr.flush();
			wr.close();
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'POST' login request to URL: " + obj);
			System.out.println("Response Code : " + responseCode + "\n");
			
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			;
			in.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getSession(){
		int responseCode = 0;
		try 
		{
			URL obj = new URL(swaggerServer + "/session");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' session to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();			
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);

			};			
			System.out.println("Logged in");
			in.close();
			
		}
		catch(Exception e)
		{
			
		}
		return responseCode;
	}
	
	
	public static int getCompany(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Company: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getStorages(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/storages");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company Storages request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Company Storages: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/storages");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company Storages request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Company Storages: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
			}**/
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getDataCenters(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/dataCenters");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company Data Centers request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Data Centers: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/dataCenters");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company Data Centers request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Data Centers: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}

	
	/**public static int getAvailIPs(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/availableIps/?ipSpace=10.10.10.21%2F27&numberOfIpsNeeded=3");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company Available IPs request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Available IPs': \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			System.out.println(response);
			in.close();
			
			for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/availableIps");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company Available IPs request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Available IPs': \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}**/
	public static int getBillingSites(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/billingSites");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company billing Sites request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Billing Sites'': \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/billingSites");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company billing Sites request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Billing Sites'': \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
			
				}**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getOrders(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/orders");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company orders request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Orders: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/orders");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company orders request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Orders: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getOrderProducts(){
		int responseCode = 0 ; 
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/orders/" + "5784be6a6eaed0783558728c" + "/products" );
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company order products request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Order Products: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}			
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/orders/" + OrderID.get(i) + "/products" );
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company order products request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Order Products: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getMachineImages(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/machineImages");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company Machines request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));		
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Machines: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/machineImages");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company Machines request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));		
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Machines: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getDomain(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/domains");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company domains request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));				
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Domains: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/domains");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company domains request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));				
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Domains: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getClusters(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/clusters");
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company domains request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Clusters: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/clusters");
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company domains request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Clusters: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				System.out.println(response);
				in.close();
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getClusterNetworkIntSeg(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/clusters/" + "58b9ae92b95f761040cc1b5f" + "/catalogs/networks /internal/segments"  );
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company cluster segments request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Segments: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				for (int o = 0, len2 = ClusterID.size(); o < len2; i++){
					URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/clusters/" + ClusterID.get(o) + "/catalogs/networks /internal/segments"  );
					URLConnection conn = (URLConnection) obj.openConnection();
					((HttpURLConnection) conn).setRequestMethod("GET");
					conn.setRequestProperty("auth-token", Token);
					
					responseCode = ((HttpURLConnection) conn).getResponseCode();
					System.out.println("\nSending 'GET' Company cluster segments request to URL: " + obj);
					System.out.println("Response Code : " + responseCode);
					
					BufferedReader in = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					System.out.println("Segments: \n");
					while ((inputLine = in.readLine()) != null){
						response.append(inputLine);
					}
					System.out.println(response);
					in.close();
					}				
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getCluterCatalog(){
		int responseCode = 0 ;
		try
		{
			for ( int y = 0; y<4; y++){
				URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/clusters/" + "58b9ae92b95f761040cc1b5f" + "/catalogs/" + "?type=" + Type.get(y)  );
				URLConnection conn = (URLConnection) obj.openConnection();
				((HttpURLConnection) conn).setRequestMethod("GET");
				conn.setRequestProperty("auth-token", Token);
				
				responseCode = ((HttpURLConnection) conn).getResponseCode();
				System.out.println("\nSending 'GET' Company cluster catalogs request to URL: " + obj);
				System.out.println("Response Code : " + responseCode);
				
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				System.out.println("Catalogs: \n");
				while ((inputLine = in.readLine()) != null){
					response.append(inputLine);
				}
				in.close();
				}
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				for (int o = 0, len2 = ClusterID.size(); o < len2; i++){
					for ( int y = 0; y<4; y++){
						URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/clusters/" + ClusterID.get(o) + "/catalogs/" + "?type=" + Type.get(y)  );
						URLConnection conn = (URLConnection) obj.openConnection();
						((HttpURLConnection) conn).setRequestMethod("GET");
						conn.setRequestProperty("auth-token", Token);
						
						responseCode = ((HttpURLConnection) conn).getResponseCode();
						System.out.println("\nSending 'GET' Company cluster catalogs request to URL: " + obj);
						System.out.println("Response Code : " + responseCode);
						
						BufferedReader in = new BufferedReader(
								new InputStreamReader(conn.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();
						System.out.println("Catalogs: \n");
						while ((inputLine = in.readLine()) != null){
							response.append(inputLine);
						}
						System.out.println(response);
						in.close();
						}
					
					}				
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getClusterMachineImages(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/clusters/" + "58b9ae92b95f761040cc1b5f" + "/machines"  );
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company cluster machines request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Machines: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				for (int o = 0, len2 = ClusterID.size(); o < len2; i++){
					URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/clusters/" + ClusterID.get(o) + "/machines"  );
					URLConnection conn = (URLConnection) obj.openConnection();
					((HttpURLConnection) conn).setRequestMethod("GET");
					conn.setRequestProperty("auth-token", Token);
					
					responseCode = ((HttpURLConnection) conn).getResponseCode();
					System.out.println("\nSending 'GET' Company cluster machines request to URL: " + obj);
					System.out.println("Response Code : " + responseCode);
					
					BufferedReader in = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					System.out.println("Machines: \n");
					while ((inputLine = in.readLine()) != null){
						response.append(inputLine);
					}
					System.out.println(response);
					in.close();
					}				
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getClusterHosts(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/clusters/" + "58b9ae92b95f761040cc1b5f" + "/hosts"  );
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company cluster hosts request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Hosts: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				for (int o = 0, len2 = ClusterID.size(); o < len2; i++){
					URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/clusters/" + ClusterID.get(o) + "/hosts"  );
					URLConnection conn = (URLConnection) obj.openConnection();
					((HttpURLConnection) conn).setRequestMethod("GET");
					conn.setRequestProperty("auth-token", Token);
					
					responseCode = ((HttpURLConnection) conn).getResponseCode();
					System.out.println("\nSending 'GET' Company cluster hosts request to URL: " + obj);
					System.out.println("Response Code : " + responseCode);
					
					BufferedReader in = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					System.out.println("Hosts: \n");
					while ((inputLine = in.readLine()) != null){
						response.append(inputLine);
					}
					System.out.println(response);
					in.close();
					}				
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	public static int getClusterStorage(){
		int responseCode = 0;
		try
		{
			URL obj = new URL(swaggerServer + "/companies/" + 201514 + "/clusters/" + "58b9ae92b95f761040cc1b5f" + "/storages"  );
			URLConnection conn = (URLConnection) obj.openConnection();
			((HttpURLConnection) conn).setRequestMethod("GET");
			conn.setRequestProperty("auth-token", Token);
			
			responseCode = ((HttpURLConnection) conn).getResponseCode();
			System.out.println("\nSending 'GET' Company cluster storages request to URL: " + obj);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			System.out.println("Storages: \n");
			while ((inputLine = in.readLine()) != null){
				response.append(inputLine);
			}
			in.close();
			/**for (int i = 0, len = CompanyID.size(); i < len; i++){
				for (int o = 0, len2 = ClusterID.size(); o < len2; i++){
					URL obj = new URL(swaggerServer + "/companies/" + CompanyID.get(i) + "/clusters/" + ClusterID.get(o) + "/storages"  );
					URLConnection conn = (URLConnection) obj.openConnection();
					((HttpURLConnection) conn).setRequestMethod("GET");
					conn.setRequestProperty("auth-token", Token);
					
					responseCode = ((HttpURLConnection) conn).getResponseCode();
					System.out.println("\nSending 'GET' Company cluster storages request to URL: " + obj);
					System.out.println("Response Code : " + responseCode);
					
					BufferedReader in = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					System.out.println("Storages: \n");
					while ((inputLine = in.readLine()) != null){
						response.append(inputLine);
					}
					System.out.println(response);
					in.close();
					}				
				}
				**/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return responseCode;
	}
	
}


