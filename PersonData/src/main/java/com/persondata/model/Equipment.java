package com.persondata.model;

import java.util.Date;

public class Equipment {
	private Integer equipmentId;
    private String deviceprovidedby;
    private String devicetype;
    private String modelname;
    private String serialnumber;
    private Date supplydate;
    private Integer employeeId;
	public Equipment() {
	}
	public Equipment(Integer equipmentId, String deviceprovidedby, String devicetype, String modelname,
			String serialnumber, Date supplydate, Integer employeeId) {
		super();
		this.equipmentId = equipmentId;
		this.deviceprovidedby = deviceprovidedby;
		this.devicetype = devicetype;
		this.modelname = modelname;
		this.serialnumber = serialnumber;
		this.supplydate = supplydate;
		this.employeeId = employeeId;
	}
	public Integer getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getDeviceprovidedby() {
		return deviceprovidedby;
	}
	public void setDeviceprovidedby(String deviceprovidedby) {
		this.deviceprovidedby = deviceprovidedby;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public Date getSupplydate() {
		return supplydate;
	}
	public void setSupplydate(Date supplydate) {
		this.supplydate = supplydate;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", deviceprovidedby=" + deviceprovidedby + ", devicetype="
				+ devicetype + ", modelname=" + modelname + ", serialnumber=" + serialnumber + ", employeeId="
				+ employeeId + "]";
	}
	
}
