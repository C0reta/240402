package PointClass;

public class ColorPoint extends Point {
	private String Color;

	public void setColor(String Color) {
		this.Color = Color;
	}

	public void showColorPoint() {
		System.out.print(this.Color);
		showPoint(); // Point Ŭ������ showPoint ȣ��
	}

}
