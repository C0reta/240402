package Animal;
// Ŭ������ ��ü 3������ �ڵ庹��

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
		System.out.println("���� �Խ��ϴ�");
	}
	
	public void Sleep() {
		System.out.println("���� ��ϴ�");
	}
	

	public void Show() {
		System.out.println("�̸�: " + this.name);
		System.out.println("����: " + this.age);
		/*
		 * System.out.println("HP: "+this.hp); System.out.println("POWER: "+this.power);
		 * System.out.println("MONEY: "+this.money);
		 */
	}

}
