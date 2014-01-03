package com.interview.sfdc.inventory;

import java.text.DecimalFormat;

public class InventoryUtil {
	public static double formatPrecision(double number) {
		DecimalFormat df = new DecimalFormat("#.##");
		String str = df.format(number);
		return Double.parseDouble(str);
	}
}
