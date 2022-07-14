package com.ejemplo.testbatch.joblistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ejemplo.testbatch.modelo.PersonaBatch;

@Component
public class JobListener extends JobExecutionListenerSupport{
	
	private static final Logger LOG = LoggerFactory.getLogger(JobListener.class);
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobListener(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override 
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			LOG.info("FINALIZO EL JOB!! VERIFICA RESULTADOS..");
			jdbcTemplate.query("SELECT ID,NOMBRE,APEPAT,TEL FROM PERSONABATCH", 
			(rs,row) -> new PersonaBatch(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4)))
			.forEach(persona->LOG.info("REGISTRO<" + persona + ">"));
		}
	}
	
}