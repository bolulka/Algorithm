import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TArecursion {

	public static int calc(int[][] arr, int[] fines, String a, String b) {
		int x = fines[0];
		int y = fines[1];
		int z = fines[2];
		int lenA = a.length();
		int lenB = b.length();
		for (int i = 1; i < lenA + 1; i++) {
			for (int j = 1; j < lenB + 1; j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					arr[i][j] = arr[i - 1][j - 1];
					continue;
				}
				arr[i][j] = Math.min(arr[i - 1][j - 1] + z, Math.min(arr[i - 1][j] + x,
						arr[i][j - 1] + y));
			}
		}

		return arr[lenA][lenB];
	}
	
	public static int[][] createArray(int x, int y, int lenA, int lenB){
		int[][] arr = new int[lenA+1][lenB+1];
		for (int i = 0; i < lenB + 1; i++) {
			arr[0][i] = i * y;
		}
		for (int i = 0; i < lenA + 1; i++) {
			arr[i][0] = i * x;
		}
		return arr;
	}
	
	public static void showArray(int[][] arr, int lenA, int lenB) {
		for (int i = 0; i < lenA; i++) {
			for (int j = 0; j < lenB; j++) {
				System.out.print(arr[i][j] +" ");
				if(j==lenB-1) System.out.println();
			}
			
			}
	}
	
	public static void safeToFile(int result) throws IOException {
		FileWriter outputFile = new FileWriter("out.txt");
		outputFile.write(result+"");
		outputFile.close();
	}
	
	public static void main(String[] args) throws IOException {
		String a = "" ,b = "";
		int [] fines = new int[3];
		Scanner sc = new Scanner(new File("src//in.txt"));
		for (int i = 0; i < 3; i++) {
			int el = sc.nextInt();
			fines[i] = el;
		}
		String temp =sc.nextLine();
		a = sc.nextLine();
		b = sc.nextLine();
		int[][] arr = createArray(fines[0],fines[1],a.length(),b.length());
		safeToFile(calc(arr,fines,a,b));
	}
}
