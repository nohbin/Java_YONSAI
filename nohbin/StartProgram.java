package nohbin;

/*
 * 참여자 : 성노빈 , 오동근 , 조하은 , 성보경
 * 주 제 	: 렌트카 관리 프로그램
 * 
 * 
 * 04/25 : 기본 CRUD 구성 완료
 * 
 * 04/26 : MAIN WINDOW 에서 table 클릭으로 차량 번호 조회 기능 추가 - 조하은
 * 		   MAIN WINDOW retn 현황 end_date 지난 list 제외 기능 추가 - 오동근
 * 		   rent 조회 중 전체 list 및 지난 내역 list 분리 - 오동근
 * 		   MAIN 조회 시 오름차순 정렬 기능 추가 - 성노빈
 * 
 * 04/27 : 조회 시 대소문자 구별 X 및 와일드카드 기능 추가 - 성노빈
 * 		   rent price 가격 계산 후 DB 저장 기능 추가 - 성보경
 * 		   
 * 
 * 
 */

public class StartProgram {
	public static void main(String[] args) {
		MainWindow main = new MainWindow();
	}
}
