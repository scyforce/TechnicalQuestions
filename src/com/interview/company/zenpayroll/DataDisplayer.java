package com.interview.company.zenpayroll;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.PriorityQueue;


public class DataDisplayer {
	PriorityQueue<Company> results = new PriorityQueue<Company>(2000, new Comparator<Company>() {		
		@Override
		public int compare(Company c1, Company c2) {
			int month1 = c1.getJoinDate().get(Calendar.MONTH);
			int year1 = c1.getJoinDate().get(Calendar.YEAR);
			
			int month2 = c2.getJoinDate().get(Calendar.MONTH);
			int year2 = c2.getJoinDate().get(Calendar.YEAR);
			
			if (year1 > year2) {
				return 1;
			} else if (year1 < year2){
				return -1;
			} else {
				if (month1 > month2) {
					return 1;
				} else if (month1 < month2){
					return -1;
				} else {
					if (c1.getBalance()>c2.getBalance()) {
						return -1;
					} else if (c1.getBalance()<c2.getBalance()) {
						return 1;
					} else {
						return c1.getName().compareTo(c2.getName());
					}
				}
			}
		}
	});
	
	//add company to priority queue
	public void addCompany(Company company) {
		results.offer(company);
	}
	
	//return aggregated results
	public String getResults() {
		StringBuilder result = new StringBuilder();
		
		if (!results.isEmpty()) {
			Company current = results.poll();
			Calendar previousDate = current.getJoinDate();
			result.append(String.format("%s %d: %d", (new SimpleDateFormat("MMMMM").format(previousDate.getTime())), previousDate.get(Calendar.YEAR), current.getId()));
			
			while (!results.isEmpty()) {
				current = results.poll();
				Calendar currentDate = current.getJoinDate();
				if (currentDate.get(Calendar.YEAR) != previousDate.get(Calendar.YEAR)) {
					result.append("\n");
					result.append(String.format("%s %d: %d", (new SimpleDateFormat("MMMMM").format(currentDate.getTime())), currentDate.get(Calendar.YEAR), current.getId()));
					previousDate = currentDate;
				} else if (currentDate.get(Calendar.MONTH) != previousDate.get(Calendar.MONTH)) {
					result.append("\n");
					result.append(String.format("%s %d: %d", (new SimpleDateFormat("MMMMM").format(currentDate.getTime())), currentDate.get(Calendar.YEAR), current.getId()));
					previousDate = currentDate;
				} else {
					result.append(", " + current.getId());
				}			
			}		
		}		
		return result.toString();
	}
}
