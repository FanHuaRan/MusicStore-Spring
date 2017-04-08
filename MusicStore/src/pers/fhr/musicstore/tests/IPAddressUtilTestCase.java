package pers.fhr.musicstore.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import pers.fhr.musicstore.component.IPAddressUtil;
import pers.fhr.musicstore.models.IpAddress;
/**
 * ip地址测试类
 * @author fhr
 * @date 2017/04/08 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)    
//@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class IPAddressUtilTestCase {
	@Autowired
	private IPAddressUtil ipAddressUtil=null;
	@Test
	public void testGetIpInfoBySina() {
		String ip="125.70.11.136";
		IpAddress address=ipAddressUtil.getIpInfoBySina(ip);
		assertNotNull(address);
	}

	@Test
	public void testGetIpInfoByTaoBao() {
		String ip="125.70.11.136";
		IpAddress address=ipAddressUtil.getIpInfoByTaoBao(ip);
		assertNotNull(address);
	}

}
