package com.interview.company.zenpayroll;

import java.text.ParseException;

public interface IDataParser {
	public Company parseCompanyInfo(String line) throws ParseException;
}
