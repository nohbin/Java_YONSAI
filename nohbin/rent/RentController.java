package nohbin.rent;

import java.util.List;

public interface RentController {
	public List<RentVo> listRent();
	public List<RentVo> listRent(String index , String search);
	
	public void insertRent(RentVo rent);
	
	public void updateRent(RentVo rent);
	
	public void deleteRent(RentVo rent);

}
