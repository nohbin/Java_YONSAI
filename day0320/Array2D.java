package day0320;

public class Array2D {
	public static void main(String[] args) {
		
		double score[][] = { 
				{ 3.3, 3.4 }, // 1학년 1, 2학기 평점
				{ 3.5, 3.6 }, // 2학년 1, 2학기 평점
				{ 3.7, 4.0 }, // 3학년 1, 2학기 평점
				{ 4.1, 4.2 } // 4학년 1, 2학기 평점
		};

		double sum = 0.0;
		double avg = 0.0;
		double total = 0.0;
		for (int i = 0; i < score.length; i++) {
			double[] temp = score[i];
			sum = 0.0;
			for (int j = 0; j < score[i].length; j++) {
				sum += temp[j];
			}
			avg = sum / temp.length;
			total += avg;
			System.out.printf("%d 학년의 평균은 %.2f 입니다.\n",i+1, avg);
		}
		System.out.printf("총 학년의 평균은 %.2f 입니다.",total/score.length);
	}
}
