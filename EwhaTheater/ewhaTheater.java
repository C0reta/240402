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

	// 기능 1: 헤더 만들기 | 완료
	public static void show_Welcome() {
		drawLine('#', 50);
		System.out.println(" 1. 예약하기 | 2. 취소하기 | 3. 좌석 보이기 | 0. 그만하기");
		drawLine('#', 50);
		System.out.print("input: ");
	}

	// 기능 2: 예약하기
	public static void makeReserve(int[][] theaterArray) {
		int rowNum, colNum;

		System.out.println("== 좌석을 예약합니다! ==");
		System.out.print("행을 입력하세요(0-9): ");
		rowNum = input.nextInt();
		System.out.print("열을 입력하세요(1-10): ");
		colNum = input.nextInt();

		if ((rowNum < 0) || (rowNum > 9) || (colNum < 1) || (colNum > 10)) {
			System.out.println("존재하지 않는 좌석 번호입니다!");
		} else {
			theaterArray[rowNum][colNum - 1] = 1;
			System.out.println(rowNum + "행 " + colNum + "번 좌석이 예약되었습니다!");
		}

	}

	// 기능 3: 취소하기
	public static void drawReserve(int[][] theaterArray) {
		int rowNum, colNum;

		System.out.println("== 좌석을 취소합니다! ==");
		System.out.print("행을 입력하세요(0-9): ");
		rowNum = input.nextInt();
		System.out.print("열을 입력하세요(1-10): ");
		colNum = input.nextInt();

		if ((rowNum < 0) || (rowNum > 9) || (colNum < 1) || (colNum > 10)) {
			System.out.println("존재하지 않는 좌석 번호입니다!");
		} else if (theaterArray[rowNum][colNum - 1] == 0) {
			System.out.println("예약 내역이 없는 좌석입니다. ");
		} else {
			theaterArray[rowNum][colNum - 1] = 0;
			System.out.println(rowNum + "행 " + colNum + "번 좌석이 취소되었습니다!");
		}

	}

	// 기능 4: 좌석 보이기
	public static void showSeat(int[][] theaterArray) {
		for (int i = 0; i < theaterArray.length; i++) {
			System.out.printf("[%02d행]  ", i);
			for (int j = 0; j < theaterArray[i].length; j++) {
				if (theaterArray[i][j] == 0) {
					System.out.print("□");
				} else
					System.out.print("■");
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
				System.out.println("잘못된 번호입니다! 올바른 메뉴를 선택해 주세요.");
				break;

			}

		}
		drawLine('=', 50);
		System.out.println("극장 예약 서비스를 종료합니다.");
		System.out.println("이화극장을 이용해 주셔서 감사합니다.");

	}

}
