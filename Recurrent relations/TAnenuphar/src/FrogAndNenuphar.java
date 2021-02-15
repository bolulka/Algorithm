import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FrogAndNenuphar {

	public static int[] getAllMosquito() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src//input.txt"));
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int el = sc.nextInt();
			arr[i] = el;
		}
		return arr;
	}

	public static void safeToFile(int result) throws IOException {
		FileWriter outputFile = new FileWriter("output.txt");
		outputFile.write(result + "");
		outputFile.close();

	}

	public static int getMaxEatenMosquito(int[] arr, int[] a) {
		int n = arr.length;
		if (n == 2)
			return -1;
		else {
			int[] sum = new int[n];
			sum[0] = arr[0];
			for (int i = 0; i < n - 2; i++) {
				if (i != 1) {
					if (i + 2 < n) {
						sum[i + 2] = Math.max(sum[i + 2], a[i + 2] + sum[i]);
					}
					if (i + 3 < n) {
						sum[i + 3] = Math.max(sum[i + 3], a[i + 3] + sum[i]);
					}
				}
			}
			return sum[n - 1];
		}
	}
	
	public static int getMaxEatenMosquitoDPBack(int[] arr, int[] a) {
		int n = arr.length;
		if(n==1) {
			return arr[0];
		}
		if (n == 2)
			return -1;
		else {
			int[] sum = new int[n];
			sum[0]=arr[0];
			sum[1]=Integer.MIN_VALUE;
			sum[2]=arr[2] + a[0];
			for (int i = 3; i < n; i++) {
					if (i - 3 >=0) {
						sum[i] = Math.max(sum[i - 2], sum[i-3])+ a[i];
				}
			}
			return sum[n - 1];
		}
	}

	public static void main(String[] args) throws IOException {
		int[] arr = getAllMosquito();
		int res = getMaxEatenMosquito(arr, arr);
		safeToFile(res);
		System.out.println(res);
		int secondVariant = getMaxEatenMosquitoDPBack(arr,arr);
		System.out.print(secondVariant);
	}
}
