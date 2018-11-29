package com.thingtronics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thingtronics.dao.TrainDao;

//abvburl?a=12&
//abcburl/1/2/23
@RestController
@RequestMapping("/sns")
public class BasicController {

	@Autowired
	private TrainDao trainDao;

	@RequestMapping(value = "/{trainId}", method = RequestMethod.GET)
	public TrainInformation getTrainDetails(@PathVariable("trainId") String trainId) {

		return trainDao.getTrainData(trainId);

	}

}
