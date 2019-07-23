package com.test.myproject.services.sample_service;

import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("timers")
@Stateless
public class MyBean {
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Resource
	private TimerService timerService;
	
	@GET
	@Path("start-timer")
	public void start() {
		LOGGER.info("Timers: " + timerService.getTimers().stream().map(timer -> timer.getInfo())
		        .collect(Collectors.toList()).toString());
		LOGGER.info("All Timers: " + timerService.getAllTimers().stream().map(timer -> timer.getInfo())
		        .collect(Collectors.toList()).toString());
		timerService.createIntervalTimer(1000, 10000, new TimerConfig(System.currentTimeMillis(), true));
	}
	
	@Timeout
	public void ejbTimeout(Timer timer) {
		LOGGER.info("Timing out. " + timer.getInfo());
		LOGGER.info("Timers: "
		        + timerService.getTimers().stream().map(t -> t.getInfo()).collect(Collectors.toList()).toString());
		LOGGER.info("All Timers: "
		        + timerService.getAllTimers().stream().map(t -> t.getInfo()).collect(Collectors.toList()).toString());
	}
}
