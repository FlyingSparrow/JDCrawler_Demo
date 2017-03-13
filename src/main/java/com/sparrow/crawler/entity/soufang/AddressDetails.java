package com.sparrow.crawler.entity.soufang;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * <p>Title: AddressDetails</p>
 * <p>Description: 房源详细信息实体类</p>
 * @author wjc
 * @date 2017年3月10日
 */
@Entity
@Table(name = "t_soufang_address_details")
public class AddressDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3790457953654365252L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "address_id", unique = false, nullable = false)
	private String addressId;//房源id
	@Column(name = "title", unique = false, nullable = false)
	private String title;//房源标题
	@Column(name = "publish_time", unique = false, nullable = false)
	private String publishTime;//发布时间
	@Column(name = "price", unique = false, nullable = true)
	private String price;//总价/价格
	@Column(name = "house_type", unique = false, nullable = true)
	private String houseType;//户型
	@Column(name = "acreage", unique = false, nullable = true)
	private String acreage;//面积（建筑面积）
	@Column(name = "use_acreage", unique = false, nullable = true)
	private String useAcreage;//使用面积（使用面积=建筑面积X（1-0.23），计算结果为估算值，不是精确值）
	@Column(name = "years", unique = false, nullable = true)
	private String years;//年代
	@Column(name = "orientation", unique = false, nullable = true)
	private String orientation;//朝向
	@Column(name = "floor", unique = false, nullable = true)
	private String floor;//楼层
	@Column(name = "structure", unique = false, nullable = true)
	private String structure;//建筑结构
	@Column(name = "decoration", unique = false, nullable = true)
	private String decoration;//装修情况
	@Column(name = "type", unique = false, nullable = true)
	private String type;//住宅类型
	@Column(name = "building_type", unique = false, nullable = true)
	private String buildingType;//建筑类型
	@Column(name = "property_right", unique = false, nullable = true)
	private String propertyRight;//产权性质
	@Column(name = "estate", unique = false, nullable = true)
	private String estate;//房地产开发商
	@Column(name = "school", unique = false, nullable = true)
	private String school;//学校
	@Column(name = "facilities", unique = false, nullable = true)
	private String facilities;//房屋设施/配套设施

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getAcreage() {
		return acreage;
	}

	public void setAcreage(String acreage) {
		this.acreage = acreage;
	}

	public String getUseAcreage() {
		return useAcreage;
	}

	public void setUseAcreage(String useAcreage) {
		this.useAcreage = useAcreage;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getPropertyRight() {
		return propertyRight;
	}

	public void setPropertyRight(String propertyRight) {
		this.propertyRight = propertyRight;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
