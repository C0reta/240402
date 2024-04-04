package EwhaTheater;

import java.util.Scanner;

public class ewhaTheater {
	public static Scanner input = new Scanner(System.in);

	public static void drawLine(char a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a);
		}
		System.out.print("\n");
	}

	public static void show_Header() {
		drawLine('*', 30);
		System.out.println("   Welcome to Ewha Movie");
		drawLine('*', 30);
	}

	// ��� 1: ��� ����� | �Ϸ�
	public static void show_Welcome() {
		drawLine('#', 50);
		System.out.println(" 1. �����ϱ� | 2. ����ϱ� | 3. �¼� ���̱� | 0. �׸��ϱ�");
		drawLine('#', 50);
		System.out.print("input: ");
	}

	// ��� 2: �����ϱ�
	public static void makeReserve(int[][] theaterArray) {
		int rowNum, colNum;

		System.out.println("== �¼��� �����մϴ�! ==");
		System.out.print("���� �Է��ϼ���(0-9): ");
		rowNum = input.nextInt();
		System.out.print("���� �Է��ϼ���(1-10): ");
		colNum = input.nextInt();

		if ((rowNum < 0) || (rowNum > 9) || (colNum < 1) || (colNum > 10)) {
			System.out.println("�������� �ʴ� �¼� ��ȣ�Դϴ�!");
		} else {
			theaterArray[rowNum][colNum - 1] = 1;
			System.out.println(rowNum + "�� " + colNum + "�� �¼��� ����Ǿ����ϴ�!");
		}

	}

	// ��� 3: ����ϱ�
	public static void drawReserve(int[][] theaterArray) {
		int rowNum, colNum;

		System.out.println("== �¼��� ����մϴ�! ==");
		System.out.print("���� �Է��ϼ���(0-9): ");
		rowNum = input.nextInt();
		System.out.print("���� �Է��ϼ���(1-10): ");
		colNum = input.nextInt();

		if ((rowNum < 0) || (rowNum > 9) || (colNum < 1) || (colNum > 10)) {
			System.out.println("�������� �ʴ� �¼� ��ȣ�Դϴ�!");
		} else if (theaterArray[rowNum][colNum - 1] == 0) {
			System.out.println("���� ������ ���� �¼��Դϴ�. ");
		} else {
			theaterArray[rowNum][colNum - 1] = 0;
			System.out.println(rowNum + "�� " + colNum + "�� �¼��� ��ҵǾ����ϴ�!");
		}

	}

	// ��� 4: �¼� ���̱�
	public static void showSeat(int[][] theaterArray) {
		for (int i = 0; i < theaterArray.length; i++) {
			System.out.printf("[%02d��]  ", i);
			for (int j = 0; j < theaterArray[i].length; j++) {
				if (theaterArray[i][j] == 0) {
					System.out.print("��");
				} else
					System.out.print("��");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int inputNum = 1;
		int[][] theaterArray = new int[10][10];

		show_Header();

		while (inputNum != 0) {
			show_Welcome();
			inputNum = input.nextInt();

			switch (inputNum) {
			case 0:
				break;
			case 1:
				makeReserve(theaterArray);
				break;
			case 2:
				drawReserve(theaterArray);
				break;
			case 3:
				showSeat(theaterArray);
				break;

			default:
				System.out.println("�߸��� ��ȣ�Դϴ�! �ùٸ� �޴��� ������ �ּ���.");
				break;

			}

		}
		drawLine('=', 50);
		System.out.println("���� ���� ���񽺸� �����մϴ�.");
		System.out.println("��ȭ������ �̿��� �ּż� �����մϴ�.");

	}

}
