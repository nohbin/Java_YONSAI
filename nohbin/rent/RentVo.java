package nohbin.rent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentVo {
	private String rent_no;
	public String getRent_no() {
		return rent_no;
	}
	public void setRent_no(String rent_no) {
		this.rent_no = rent_no;
	}
	public int getStart_date() {
		return start_date;
	}
	public void setStart_date(int start_date) {
		this.start_date = start_date;
	}
	public int getEnd_date() {
		return end_date;
	}
	public void setEnd_date(int end_date) {
		this.end_date = end_date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice() {
		DateFormat f = new SimpleDateFormat("yyMMdd");
		try {
			Date sDate = f.parse(String.valueOf(start_date));
			Date eDate = f.parse(String.valueOf(end_date));
			
			long diff = eDate.getTime() - sDate.getTime();
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			
			this.price = diffDays * 100000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private int start_date;
	private int end_date;
	private int price;
	private String carNum;
	private String id;
}