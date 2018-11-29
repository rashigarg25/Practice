package com.thingtronics.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.thingtronics.TrainInformation;
import com.thingtronics.mapper.TrainExtractor;

@Component
public class TrainDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private TrainExtractor trainExtractor;

	public TrainInformation getTrainData(String trainNumber) {

		TrainInformation ti = jdbcTemplate.query("SELECT * FROM all_train_details where train_no=" + trainNumber,
				trainExtractor);

		return ti;
	}

}
