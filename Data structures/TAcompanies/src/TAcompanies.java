//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//import java.util.Scanner;
//
//public class TAcompanies {
//	static int numberOfCompanies = 0;
//
//	public static void main(String args[]) throws IOException {
//		int[][] mas = readFromFile();
//		boolean[][] flags = new boolean[1000][1000];
//		for (int i = 0; i < 1000; i++) {
//			for (int j = 0; j < 1000; j++) {
//				flags[i][j] = true;
//			}
//		}
//		//int[][] res = getPairs(mas, flags);
//		int[][] res = getCompanies(mas, flags);
//		showResultToConsole(res, "new func");
//		safeToFile(res);
//	}
//
//	public static void showResultToConsole(int[][] mas, String solution) {
//		System.out.println("Solution: " + solution);
//		for (int i = 0; i < numberOfCompanies; i++) {
//			for (int j = 0; j < numberOfCompanies; j++) {
//				if (mas[i][j] > 50 && i != j)
//					System.out.println((i + 1) + " " + (j + 1));
//			}
//		}
//	}
//
//	public static void printMatrix(int[][] mas) {
//		for (int i = 0; i < numberOfCompanies; i++) {
//			for (int j = 0; j < numberOfCompanies; j++) {
//				System.out.print(mas[i][j] + " ");
//				if (j == numberOfCompanies - 1)
//					System.out.println();
//			}
//		}
//	}
//
//	public static int[][] getPairs(int[][] mas, boolean[][] flags) {
//		for (int l = 0; l < numberOfCompanies; l++) {
//			for (int i = 0; i < numberOfCompanies; i++) {
//				for (int j = 0; j < numberOfCompanies; j++) {
//					if (mas[i][j] > 50 && i != j && flags[i][j] == true) {
//						flags[i][j] = false;
//						for (int k = 0; k < numberOfCompanies; k++) {
//							mas[i][k] += mas[j][k];
//						}
//					}
//				}
//			}
//		}
//		return mas;
//	}
//
//	public static int[][] getCompanies(int[][] mas, boolean[][] flags) {
//		for (int l = 0; l < numberOfCompanies; l++) {
//			for (int i = 0; i < numberOfCompanies; i++) {
//				for (int j = 0; j < numberOfCompanies; j++) {
//					if (mas[i][j] > 50 && i != j && flags[i][j] == true) {
//						flags[i][j] = false;
//						if (mas[j][i] > 50 && flags[j][i] == false) {
//							for (int k = 0; k < numberOfCompanies; k++) {
//								if (mas[i][k] == 0)
//									mas[i][k] += mas[j][k];
//								else
//									mas[i][k] += 0;
//							}
//						} else {
//							for (int k = 0; k < numberOfCompanies; k++) {
//								mas[i][k] += mas[j][k];
//							}
//						}
//					}
//				}
//
//			}
//
//		}
//		return mas;
//	}
//
//	public static void safeToFile(int[][] mas) throws IOException {
//		FileWriter outputFile = new FileWriter("output.txt");
//		for (int i = 0; i < numberOfCompanies; i++) {
//			for (int j = 0; j < numberOfCompanies; j++) {
//				if (mas[i][j] > 50 && i != j)
//					outputFile.write((i + 1) + " " + (j + 1) + "\n");
//			}
//		}
//		outputFile.close();
//	}
//
//	public static int[][] readFromFile() throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src//input.txt"));
//		int[][] mas = new int[1000][1000];
//		for (int i = 0; i < 1000; i++) {
//			for (int j = 0; j < 1000; j++) {
//				mas[i][j] = 0;
//			}
//		}
//		while (sc.hasNext()) {
//			int i = sc.nextInt();
//			int j = sc.nextInt();
//			int proc = sc.nextInt();
//			mas[i - 1][j - 1] = proc;
//			int n = Math.max(i, j);
//			if (numberOfCompanies < n)
//				numberOfCompanies = n;
//		}
//		return mas;
//	}
//}
