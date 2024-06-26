package PointClass;

public class ColorPointExample {
	public static void main(String[] args) {
		Point p = new Point();
		p.set(1, 2);
		p.showPoint();

		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);
		cp.setColor("Red");
		cp.showPoint();
		System.out.println("=====");
		cp.showColorPoint();
		
		cp.setColor("Blue");
		cp.showColorPoint();
	}

}
