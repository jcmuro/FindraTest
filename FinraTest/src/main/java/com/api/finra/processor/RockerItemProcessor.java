package com.api.finra.processor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.api.finra.vo.RockersVO;




public class RockerItemProcessor implements ItemProcessor<RockersVO, RockersVO> {
	
	
	private static final Logger log = LoggerFactory.getLogger(RockerItemProcessor.class);
	
	
	@Override
    public RockersVO process(final RockersVO rocker) throws Exception{
		
		//Names/Last Name first letter uppercase, country upper case
		final String name = StringUtils.capitalize(rocker.getName());
		final String lastName = StringUtils.capitalize(rocker.getLastName());
		final String country = StringUtils.upperCase(rocker.getCountry());
		
		final RockersVO transformed = new RockersVO();
		
		transformed.setName(name);
		transformed.setLastName(lastName);
		transformed.setCountry(country);
		
		log.info("Converting: " + rocker.toString() + " to " + transformed.toString());
		
		return transformed;
	}
	

}
