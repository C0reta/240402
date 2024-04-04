package PointClass;

public class Point {
	private int x, y;

	// private의 값을 바깥에서 참조할 수 있도록 함
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 출력하기
	public void showPoint() {
		System.out.printf("(%d, %d)\n", this.x, this.y);
	}

}
