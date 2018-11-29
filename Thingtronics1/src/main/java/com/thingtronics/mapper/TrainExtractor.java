package com.thingtronics.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.thingtronics.TrainInformation;

public class TrainExtractor implements ResultSetExtractor<TrainInformation> {

	@Override
	public TrainInformation extractData(ResultSet rs) throws SQLException, DataAccessException {
		TrainInformation ti = new TrainInformation();
		ti.setName(rs.getString("train_name"));
		ti.setNumber(rs.getInt("train_no"));
		ti.setStarts(rs.getString("starts"));
		return ti;
	}

}
