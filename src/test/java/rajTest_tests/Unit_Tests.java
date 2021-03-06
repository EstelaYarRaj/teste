package rajTest_tests;

import static org.junit.Assert.*;
import org.junit.Test;
import rajTest.TestCase;

public class Unit_Tests {

	@Test
	public void logintest(){
		assertEquals(TestCase.login(), 200);
		int code = TestCase.login();
		fail("Error code: " + code);
	}
	@Test
	public void getCompanyTest(){
		assertEquals(TestCase.getCompany(), 200);
		int code = TestCase.getCompany();
		fail("Error code: " + code);
	}
	
	@Test
	public void getDataCentersTest(){
		assertEquals(TestCase.getDataCenters(), 200);
		int code = TestCase.getDataCenters();
		fail("Error code: " + code);
	}
	/**@Test
	public void getAvailIPsTest(){
		assertEquals(TestCase.getAvailIPs(), 200);
		int code = TestCase.getAvailIPs();
		fail("Error code: " + code);
	}**/
	@Test
	public void getBillingSitesTest(){
		assertEquals(TestCase.getBillingSites(), 200);
		int code = TestCase.getBillingSites();
		fail("Error code: " + code);
	}
	
	@Test
	public void getOrderProductsTest(){
		assertEquals(TestCase.getOrderProducts(), 200);
		int code = TestCase.getOrderProducts();
		fail("Error code: " + code);
	}
	@Test
	public void getMachineImagesTest(){
		assertEquals(TestCase.getMachineImages(), 200);
		int code = TestCase.getMachineImages();
		fail("Error code: " + code);
	}
	@Test
	public void getDomainTest(){
		assertEquals(TestCase.getDomain(), 200);
		int code = TestCase.getDomain();
		fail("Error code: " + code);
	}
	@Test
	public void getClustersTest(){
		assertEquals(TestCase.getClusters(), 200);
		int code = TestCase.getClusters();
		fail("Error code: " + code);
	}
	@Test
	public void getClusterNetworkIntSegTest(){
		assertEquals(TestCase.getClusterNetworkIntSeg(), 200);
		int code = TestCase.getClusterNetworkIntSeg();
		fail("Error code: " + code);
	}
	@Test
	public void getCluterCatalogTest(){
		assertEquals(TestCase.getCluterCatalog(), 200);
		int code = TestCase.getCluterCatalog();
		fail("Error code: " + code);
	}
	@Test
	public void getClusterMachineImagesTest(){
		assertEquals(TestCase.getClusterMachineImages(), 200);
		int code = TestCase.getClusterMachineImages();
		fail("Error code: " + code);
	}
	@Test
	public void getClusterHostsTest(){
		assertEquals(TestCase.getClusterHosts(), 200);
		int code = TestCase.getClusterHosts();
		fail("Error code: " + code);
	}
	@Test
	public void getClusterStorageTest(){
		assertEquals(TestCase.getClusterStorage(), 200);
		int code = TestCase.getClusterStorage();
		fail("Error code: " + code);
	}
	@Test
	public void getOrdersTest(){
		assertEquals(TestCase.getOrders(), 200);
		int code = TestCase.getOrders();
		fail("Error code: " + code);
	}
}
