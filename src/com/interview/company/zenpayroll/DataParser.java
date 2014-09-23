package com.interview.company.zenpayroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//parser class to parse company information
public class DataParser implements IDataParser{	
	private static final String SEPARATOR = " <\\|> ";
	
	public Company parseCompanyInfo(String line) throws ParseException {
		String[] companyInfo = line.split(SEPARATOR);
		Company company = new Company();
		for (String info : companyInfo) {
			info = info.trim();
			String value = info.split(":")[1].trim();
			if (info.startsWith("Name")) {
				company.setName(parseName(value));
			} else if (info.startsWith("Id")) {
				company.setId(parseId(value));
			} else if (info.startsWith("Join date")) {
				company.setJoinDate(parseJoinDate(value));
			} else if (info.startsWith("Balance")) {
				company.setBalance(parseBalance(value));
			} else {
				throw new UnsupportedOperationException("don't know how to handle");
			}
		}
		
		return company;	
	}
	
	private String parseName(String info) {
		return info;
	}
	
	private int parseId(String info) {
		return Integer.parseInt(info);
	}
	
	private Calendar parseJoinDate(String info) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");		
		Date date = formatter.parse(info);
	    Calendar cal=Calendar.getInstance();
	    cal.setTime(date);
	    return cal;
	}
	
	private float parseBalance(String info) {
		info = info.substring(1).replace(",", "");
		return Float.parseFloat(info);
	}
}
