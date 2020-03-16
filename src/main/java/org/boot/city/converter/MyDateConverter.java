package org.boot.city.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.converter.Converter;

public class MyDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String str) {
		// TODO Auto-generated method stub
		// 正则表达式解决多种日期格式
		SimpleDateFormat sd = getSimpleDateFormat(str);
		
		try {
				return sd.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private SimpleDateFormat getSimpleDateFormat(String str) {
		// TODO Auto-generated method stub
		SimpleDateFormat sf = new SimpleDateFormat();
		if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", str))
			sf = new SimpleDateFormat("yyyy-MM-dd");
		else if (Pattern.matches("^\\d{4}:\\d{2}:\\d{2}$", str))
			sf = new SimpleDateFormat("yyyy:MM:dd");
		else if (Pattern.matches("^\\d{4}\\d{2}\\d{2}$", str))
			sf = new SimpleDateFormat("yyyyMMdd");
		else
			throw new TypeMismatchException("", Date.class);
		return sf;
	}

}
