package com.myservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myservice.bean.Custom;
import com.myservice.bean.Custom2;
import com.myservice.bean.CustomBind;

@Path("/testservice")
public class MyJerseyService {
	
	static int count = 0;
	
	@GET
//	@Produces("application/json;charset=utf-8")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Response getTestService() {
		
		System.out.println("Hit count: " + (count++));
		Custom custom = new Custom();
		custom.setDates(new ArrayList<Date>());
		custom.getDates().add(Calendar.getInstance().getTime());
		custom.getDates().add(Calendar.getInstance().getTime());
		custom.getDates().add(Calendar.getInstance().getTime());
		custom.getDates().add(Calendar.getInstance().getTime());
		custom.getDates().add(Calendar.getInstance().getTime());
		custom.getDates().add(Calendar.getInstance().getTime());
		
		custom.setAnotherDate(Calendar.getInstance().getTime());
		
		Custom2 custom2 = new Custom2();
		custom2.getDates().add(Calendar.getInstance().getTime());
		custom2.getDates().add(Calendar.getInstance().getTime());
		custom2.getDates().add(Calendar.getInstance().getTime());
		custom2.getDates().add(Calendar.getInstance().getTime());
		custom2.getDates().add(Calendar.getInstance().getTime());
		
		CustomBind bind = new CustomBind();
		bind.setCustom(custom);
		bind.setCustom2(custom2);
		System.out.println(custom);
		
		String format = "yyyy-MM-dd";
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(dateFormat);
		
		return Response.status(Status.OK).entity(bind).build();
		
	}
}
