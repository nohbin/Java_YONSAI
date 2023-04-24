package nohbin.car;

public class CarVo {
	private String carNum;
	private String carName;
	private int carSize;
	private String carColor;
	private String carMaker;
	
	
	
public CarVo() {
		super();
	}
public CarVo(String carNum, String carName, int carSize, String carColor, String carMaker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.carSize = carSize;
		this.carColor = carColor;
		this.carMaker = carMaker;
	}
//	public CarVo(String carNum2, String carName2, int carSize2, String carColor2, String carMaker2) {
//		// TODO Auto-generated constructor stub
//	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarSize() {
		return carSize;
	}
	public void setCarSize(int carSize) {
		this.carSize = carSize;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getCarMaker() {
		return carMaker;
	}
	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}
}