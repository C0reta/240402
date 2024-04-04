package FindBomb;

import java.util.Random;
import java.util.Scanner;

public class findBomb {
	public static Random rand = new Random();
	public static Scanner input = new Scanner(System.in);

	// === �غ���� ===
	// 0. �⺻ �Լ� �� ����
	// 1. �޴� ���̱� + ��� ����
	// 2. ���� �迭�ϱ�
	// === ���� ===
	// 3. ���� ����ϱ�

	public static void drawLine(char a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a);
		}
		System.out.println();
	}

	// ��Ʈ�� �� ��� ����
	public static void showMenu() {
		drawLine('#', 50);
		System.out.println("Find BOMB!");
		drawLine('#', 50);
		System.out.println("���̵��� �����ϼ��� >>>");
		drawLine('=', 40);
		System.out.println(" 1. 9x9 | 2. 16x16 | 3. 30x16 | 0. ����");
		drawLine('=', 40);
	}

	// ��� �� ���� ���� ����
	public static void inforMenu(int menuNum, int numBomb) {
		drawLine('=', 40);
		if (menuNum == 1) {
			System.out.println("Mode: EASY");
			System.out.println("������ ������ 10���Դϴ�.");
			numBomb = 10;

		} else if (menuNum == 2) {
			System.out.println("Mode: NORMAL");
			System.out.println("������ ������ 40���Դϴ�.");
			numBomb = 40;
		} else if (menuNum == 3) {
			System.out.println("Mode: HARD");
			System.out.println("������ ������ 99���Դϴ�.");
			numBomb = 99;
		}
		drawLine('=', 40);
	}

	// ���� ��ġ�ϱ� + �ߺ� üũ
	public static void sortBomb(int[][] bombArray, int numBomb) {
		int row, col;

		for (int i = 0; i < bombArray.length;) {
			row = rand.nextInt(bombArray.length);
			col = rand.nextInt(bombArray[i].length);

			if (bombArray[row][col] == 1)
				continue;
			bombArray[row][col] = 1;
			i++;
		}

	}

	// �Է� => �긦 ������ return�ؼ� exitNum�� �ο� => while���� �ݺ� ���� ����
	public static int checkBomb(int[][] bombArray, int rowNum, int colNum) {
		if ((rowNum < 0) || (rowNum > bombArray.length) || (colNum < 0) || (colNum > bombArray[0].length)) {
			return 1;
		}
		if (bombArray[rowNum][colNum] == 0) {
			bombArray[rowNum][colNum] = 2;
			return 1;
		} else if (bombArray[rowNum][colNum] == 2) {
			System.out.println("�̹� ������ ĭ�Դϴ�.");
			return 1;
		} else if (bombArray[rowNum][colNum] == 1) {
			System.out.println("���ڰ� �������ϴ�!");
			return 0;
		}
		return 1;
	}

	// �迭 ���� 0�̸� �� ��, 1�̸� ����, 2�� üũ�� �� [���� ���� �� ȣ��]
	public static void printBomb(int[][] bombArray) {
		for (int i = 0; i < bombArray.length; i++) {
			for (int j = 0; j < bombArray[i].length; j++) {
				if (bombArray[i][j] == 0) {
					System.out.print("��");
				} else if (bombArray[i][j] == 2) {
					System.out.print("��");
				} else
					System.out.print("��");
			}
			System.out.println();
		}
	}

	// ������ ĭ �����ֱ��
	public static void printFake(int[][] bombArray) {
		for (int i = 0; i < bombArray.length; i++) {
			for (int j = 0; j < bombArray[i].length; j++) {
				if ((bombArray[i][j] == 0) || (bombArray[i][j] == 1)) {
					System.out.print("��");
				} else if (bombArray[i][j] == 2) {
					System.out.print("��");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int menuNum;
		int numBomb = 0;
		int exitNum = 1;
		int rowNum, colNum;
		int[][] bombArray = new int[0][0];

		showMenu();
		menuNum = input.nextInt();
		inforMenu(menuNum, numBomb);

		switch (menuNum) {
		case 1:
			bombArray = new int[8][8];
			sortBomb(bombArray, numBomb);
			break;
		case 2:
			bombArray = new int[15][15];
			sortBomb(bombArray, numBomb);
			break;
		case 3:
			bombArray = new int[29][15];
			sortBomb(bombArray, numBomb);
			break;
		case 0:
			System.out.println("End");
			break;
		default:
			System.out.println("���� �޴��Դϴ�.");
		}

		while (exitNum != 0) {
			printFake(bombArray);
			System.out.println("���ϴ� ĭ�� ��� ���� �Է��ϼ���.");
			System.out.print("��(0~): ");
			rowNum = input.nextInt();
			System.out.print("��(0~): ");
			colNum = input.nextInt();
			exitNum = checkBomb(bombArray, rowNum, colNum);
		}
		printBomb(bombArray);

	}

}