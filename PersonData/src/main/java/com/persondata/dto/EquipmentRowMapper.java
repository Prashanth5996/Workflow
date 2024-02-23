package com.persondata.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.persondata.model.Equipment;

public class EquipmentRowMapper implements RowMapper<Equipment>{

	@Override
	public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
	    Equipment equipment = new Equipment();
	    equipment.setDeviceprovidedby(rs.getString("deviceProvidedBy"));
	    equipment.setDevicetype(rs.getString("devicetype"));
	    equipment.setModelname(rs.getString("modelname"));
	    equipment.setSerialnumber(rs.getString("serialnumber"));
	    equipment.setSupplydate(rs.getDate("supplydate"));
	    equipment.setEmployeeId(rs.getInt("employeeId"));
	    return equipment;
	}

}

