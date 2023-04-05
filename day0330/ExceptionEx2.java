package day0330;
class SpaceException extends Exception{
	public SpaceException(String message) {
		super(message);
	}
}
class MemoryException extends Exception{
	public MemoryException(String message) {
		super(message);
	}
}

public class ExceptionEx2 {
	static void copyFiles() {}
	static void deleteTempFiles() {}
	static boolean enoughSpace() {
		return false;
	}
	static boolean enoughMemory() {
		return true;
	}
	static void startInstall() throws SpaceException , MemoryException{
		if(!enoughSpace()) {
			throw new SpaceException("설치공간이 부족합니다.");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
		}
		System.out.println("설치가 진행됩니다.");
	}
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException | MemoryException e) {
			e.printStackTrace();
		}finally {
			deleteTempFiles();
			System.out.println("설치 종료");
		}
	}
}
