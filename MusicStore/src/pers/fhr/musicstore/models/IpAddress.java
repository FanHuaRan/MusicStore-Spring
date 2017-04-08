package pers.fhr.musicstore.models;
/**
 * ip物理地址模型
 * 新浪和淘宝通用
 * @author fhr
 * @date 2017/04/08
 */
public class IpAddress implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//国家
	private String country; 
	//区域 只限于淘宝接口
	private String area;
	//省份，淘宝接口叫做region
	private String province;
	//城市
    private String city;  
    private String district;  
    private String isp;  
    private String type;  
    private String desc;
    
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
