package Animal;

public class Cat extends Animal {
	private String type = "cute";

	public void CatSleep() {
		for (int i = 0; i < 5; i++) {
			Sleep();
		}
	}

	public void showCat() {
		Show();
		System.out.println(this.type);
		CatSleep();
	}
}
