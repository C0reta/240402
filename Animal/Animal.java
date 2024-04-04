package Animal;
// 클래스와 객체 3페이지 코드복습

public class Animal {
	private String name;
	private int age;
	/* hp, power, money; */

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void Eat() {
		System.out.println("밥을 먹습니다");
	}
	
	public void Sleep() {
		System.out.println("잠을 잡니다");
	}
	

	public void Show() {
		System.out.println("이름: " + this.name);
		System.out.println("나이: " + this.age);
		/*
		 * System.out.println("HP: "+this.hp); System.out.println("POWER: "+this.power);
		 * System.out.println("MONEY: "+this.money);
		 */
	}

}
