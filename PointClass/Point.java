package PointClass;

public class Point {
	private int x, y;

	// private�� ���� �ٱ����� ������ �� �ֵ��� ��
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// ����ϱ�
	public void showPoint() {
		System.out.printf("(%d, %d)\n", this.x, this.y);
	}

}
