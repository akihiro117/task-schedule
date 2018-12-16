package com.webapp.taskschedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.webapp.taskschedule.mapper")
public class TaskScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskScheduleApplication.class, args);
	}
}
