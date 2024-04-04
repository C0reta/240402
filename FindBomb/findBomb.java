package FindBomb;

import java.util.Random;
import java.util.Scanner;

public class findBomb {
	public static Random rand = new Random();
	public static Scanner input = new Scanner(System.in);

	// === 준비과정 ===
	// 0. 기본 함수 몇 가지
	// 1. 메뉴 보이기 + 모드 선택
	// 2. 지뢰 배열하기
	// === 시작 ===
	// 3. 지뢰 출력하기

	public static void drawLine(char a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a);
		}
		System.out.println();
	}

	// 인트로 및 모드 선택
	public static void showMenu() {
		drawLine('#', 50);
		System.out.println("Find BOMB!");
		drawLine('#', 50);
		System.out.println("난이도를 선택하세요 >>>");
		drawLine('=', 40);
		System.out.println(" 1. 9x9 | 2. 16x16 | 3. 30x16 | 0. 종료");
		drawLine('=', 40);
	}

	// 모드 및 지뢰 개수 설정
	public static void inforMenu(int menuNum, int numBomb) {
		drawLine('=', 40);
		if (menuNum == 1) {
			System.out.println("Mode: EASY");
			System.out.println("지뢰의 개수는 10개입니다.");
			numBomb = 10;

		} else if (menuNum == 2) {
			System.out.println("Mode: NORMAL");
			System.out.println("지뢰의 개수는 40개입니다.");
			numBomb = 40;
		} else if (menuNum == 3) {
			System.out.println("Mode: HARD");
			System.out.println("지뢰의 개수는 99개입니다.");
			numBomb = 99;
		}
		drawLine('=', 40);
	}

	// 지뢰 배치하기 + 중복 체크
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

	// 입력 => 얘를 정수로 return해서 exitNum을 부여 => while문의 반복 조건 결정
	public static int checkBomb(int[][] bombArray, int rowNum, int colNum) {
		if ((rowNum < 0) || (rowNum > bombArray.length) || (colNum < 0) || (colNum > bombArray[0].length)) {
			return 1;
		}
		if (bombArray[rowNum][colNum] == 0) {
			bombArray[rowNum][colNum] = 2;
			return 1;
		} else if (bombArray[rowNum][colNum] == 2) {
			System.out.println("이미 선택한 칸입니다.");
			return 1;
		} else if (bombArray[rowNum][colNum] == 1) {
			System.out.println("지뢰가 터졌습니다!");
			return 0;
		}
		return 1;
	}

	// 배열 값이 0이면 빈 곳, 1이면 지뢰, 2면 체크한 곳 [게임 종료 시 호출]
	public static void printBomb(int[][] bombArray) {
		for (int i = 0; i < bombArray.length; i++) {
			for (int j = 0; j < bombArray[i].length; j++) {
				if (bombArray[i][j] == 0) {
					System.out.print("□");
				} else if (bombArray[i][j] == 2) {
					System.out.print("■");
				} else
					System.out.print("★");
			}
			System.out.println();
		}
	}

	// 선택한 칸 보여주기용
	public static void printFake(int[][] bombArray) {
		for (int i = 0; i < bombArray.length; i++) {
			for (int j = 0; j < bombArray[i].length; j++) {
				if ((bombArray[i][j] == 0) || (bombArray[i][j] == 1)) {
					System.out.print("□");
				} else if (bombArray[i][j] == 2) {
					System.out.print("■");
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
			System.out.println("없는 메뉴입니다.");
		}

		while (exitNum != 0) {
			printFake(bombArray);
			System.out.println("원하는 칸의 행과 열을 입력하세요.");
			System.out.print("행(0~): ");
			rowNum = input.nextInt();
			System.out.print("열(0~): ");
			colNum = input.nextInt();
			exitNum = checkBomb(bombArray, rowNum, colNum);
		}
		printBomb(bombArray);

	}

}