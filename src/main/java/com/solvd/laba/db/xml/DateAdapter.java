package main.java.com.solvd.laba.db.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date unmarshal(String d) throws Exception {
		return formatter.parse(d);
	}

	@Override
	public String marshal(Date d) throws Exception {
		return formatter.format(d);
	}
}
