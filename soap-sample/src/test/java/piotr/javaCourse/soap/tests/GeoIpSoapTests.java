package piotr.javaCourse.soap.tests;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GeoIpSoapTests {

  @Test
  public void testMyIp() {
    GeoIPService geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.77.96.206");
    assertEquals(geoIP.getGeoIPServiceSoap().getLocation(),"POL");
  }

  @Test
  public void testInvalidIp() {
    GeoIPService geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.77.96.206");
    assertEquals(geoIP.getGeoIPServiceSoap().getLocation(), "POL");

  }
}
