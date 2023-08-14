import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double weight = Double.parseDouble(st.nextToken());
        double r = Double.parseDouble(st.nextToken());
		int result = (int)(weight * (1 + (r/30)));

		System.out.println(result);
	}
}