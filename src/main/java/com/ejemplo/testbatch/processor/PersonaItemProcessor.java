package com.ejemplo.testbatch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.ejemplo.testbatch.modelo.PersonaBatch;

public class PersonaItemProcessor implements ItemProcessor<PersonaBatch, PersonaBatch>{
	
	private static final Logger LOG = LoggerFactory.getLogger(PersonaItemProcessor.class);
	
	@Override
	public PersonaBatch process(PersonaBatch item) throws Exception {
		int id = item.getId();
		String nombre = item.getNombre().toUpperCase();
		String apepat = item.getApepat().toUpperCase();
		String tel = item.getTel().toUpperCase();
		
		PersonaBatch persona = new PersonaBatch(id,nombre,apepat,tel);
		
		LOG.info("Convirtiendo ( " + item + " ) a ( " + persona + " )");
		
		return persona;
	}
	

}
