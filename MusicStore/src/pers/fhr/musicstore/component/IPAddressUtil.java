package pers.fhr.musicstore.component;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import pers.fhr.musicstore.models.IpAddress;

/**
 * ip地址查询类
 * 一开始使用的自定义缓存容器
 * 现在使用ehcache缓存框架，key为ip,value为IpAddress
 * @author fhr
 * @date 2017/04/08
 */
@Component
public class IPAddressUtil {
	  /**
	   * 新浪接口地址
	   */
	  private static final String SINAAPIURL="http://int.dpool.sina.com.cn/iplookup/iplookup.php";
	  /**
	   * 淘宝接口地址
	   */
	  private static final String TAOBAOAPIURL="http://ip.taobao.com/service/getIpInfo.php";
	  /**
	   * http组件
	   */
	  @Autowired
	  private HttpSimleRequest httpSimleRequest=null;
	  /**
	   * 自定义缓存容器，已经废除
	   */
	  // static final IPAddressCache IpAddressCache=new IPAddressCache();
	  
	  /**
	   * 通过新浪接口获取物理地址，与淘宝共享缓存
	   * @param ip
	   * @return
	   */
	  @Cacheable(value="ipCache",key="#ip")
	  public IpAddress getIpInfoBySina(String ip) {
		//IpAddress ipAddress = IpAddressCache.getAddress(ip);
		//if(ipAddress!=null){
		//	return ipAddress;
		//}
		IpAddress ipAddress=null;
		Map<String, Object> params = new HashMap<>();
		params.put("format", "json");
		params.put("ip", ip);
		String infoString = httpSimleRequest.sendGet(SINAAPIURL, params);
		if (!StringUtils.isBlank(infoString)) {
			JSONObject jsonObject = JSONObject.parseObject(infoString);
			if (jsonObject.getInteger("ret").equals(1)) {
				ipAddress = getIpAddressFromSinaJsonObject(jsonObject);
				//IpAddressCache.pushAddress(ip, ipAddress);
			}
		}
		return ipAddress;
	}
	/**
	 * 通过淘宝接口获取物理地址，与新浪共享缓存
	 * @param ip
	 * @return
	 */
	@Cacheable(value="ipCache",key="#ip")
	public  IpAddress getIpInfoByTaoBao(String ip){
		IpAddress ipAddress=null;
		Map<String, Object> params = new HashMap<>();
		params.put("ip", ip);
		String infoString = httpSimleRequest.sendGet(TAOBAOAPIURL, params);
		if (!StringUtils.isBlank(infoString)) {
			JSONObject allJsonObject = JSONObject.parseObject(infoString);
			if (allJsonObject.getInteger("code").equals(0)) {
				JSONObject infoJsonObject=allJsonObject.getJSONObject("data");
				 ipAddress = getIpAddressFromTaboBaoJsonObject(infoJsonObject);
			}
		}
		return ipAddress;
	}
	/**
	 * 根据http请求获取IP地址,也可以考虑缓存，暂时不加
	 * @param request
	 * @return
	 */
    public String getIpAddress(HttpServletRequest request){    
        String ip = request.getHeader("x-forwarded-for");    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("WL-Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_CLIENT_IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getRemoteAddr();    
        }    
        return ip;    
    }  
	/**
	 * 从sina的json对象中获取信息
	 * @param infoJsonObject
	 * @return
	 */
	private  IpAddress getIpAddressFromSinaJsonObject(JSONObject infoJsonObject) {
		 IpAddress ipAddress=new IpAddress();
		 ipAddress.setCountry(searchValue(infoJsonObject,"country"));
		 ipAddress.setProvince(searchValue(infoJsonObject,"province"));
		 ipAddress.setCity(searchValue(infoJsonObject,"city"));
		 ipAddress.setDistrict(searchValue(infoJsonObject,"district"));
		 ipAddress.setIsp(searchValue(infoJsonObject,"isp"));
		 ipAddress.setType(searchValue(infoJsonObject,"type"));
		 ipAddress.setDesc(searchValue(infoJsonObject,"desc"));
		return ipAddress;
	}
	/**
	 * 从taobao的json对象中获取信息
	 * @param infoJsonObject
	 * @return
	 */
	private  IpAddress getIpAddressFromTaboBaoJsonObject(JSONObject infoJsonObject) {
		 IpAddress ipAddress=new IpAddress();
		 ipAddress.setCountry(searchValue(infoJsonObject,"country"));
		 ipAddress.setArea(searchValue(infoJsonObject,"area"));
		 ipAddress.setProvince(searchValue(infoJsonObject,"region"));
		 ipAddress.setCity(searchValue(infoJsonObject,"city"));
		 ipAddress.setIsp(searchValue(infoJsonObject,"isp"));
		return ipAddress;
	}
	/**
	 * 从json对象中寻找字符串值
	 * 因为jsonobject已经对字符进行了中文编码
	 * 所以不需要进行任何编码转换
	 * @param jsonObject
	 * @param key
	 * @return
	 */
	private  String searchValue(JSONObject jsonObject, String key) {
		String value = jsonObject.getString(key);
		//if (StringUtils.isNotBlank(value)) {
		//	value = UnicodeUtil.decodeUnicode(value);
		//}
		return value;
	}
}
