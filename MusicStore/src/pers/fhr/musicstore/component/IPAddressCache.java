package pers.fhr.musicstore.component;

import java.util.HashMap;
import java.util.Map;

import pers.fhr.musicstore.models.IpAddress;
/**
 * ip地址自定义缓存容器
 * @author fhr
 * @date 2017/04/08
 */
public class IPAddressCache {
	private Map<String, IpAddress> ipAddressMap = new HashMap<>();
	private int maxCount = 1000;

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public Map<String, IpAddress> getIpAddressCache() {
		return ipAddressMap;
	}

	public IpAddress getAddress(String ip) {
		return ipAddressMap.get(ip);
	}
	
	//线程同步安全
	public synchronized void pushAddress(String ip,IpAddress IpAddress){
		if(ipAddressMap.size()>maxCount){
			String removedKey=ipAddressMap.entrySet().stream().findFirst().get().getKey();
			ipAddressMap.remove(removedKey);
		}
		ipAddressMap.put(ip, IpAddress);
	}
}
