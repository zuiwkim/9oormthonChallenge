import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();  // 재료의 개수
        int[] tastes = new int[N];  // 재료의 맛 정도
        
        for (int i = 0; i < N; i++) {
            tastes[i] = scanner.nextInt();
        }
        
        int result = calculateBurgerTaste(tastes);
        System.out.println(result);
    }
    
    public static int calculateBurgerTaste(int[] tastes) {
        int maxTasteIdx = 0;
        for (int i = 1; i < tastes.length; i++) {
            if (tastes[i] > tastes[maxTasteIdx]) {
                maxTasteIdx = i;
            }
        }
        // 기준 재료보다 위쪽에 있는 재료의 맛이 감소하거나 같은지 확인
        for (int i = maxTasteIdx - 1; i >= 0; i--) {
            if (tastes[i] > tastes[i + 1]) {
                return 0;  // 완벽하지 않은 구름 햄버거이므로 0을 반환
            }
        }
        
        // 기준 재료보다 아래쪽에 있는 재료의 맛이 감소하거나 같은지 확인
        for (int i = maxTasteIdx + 1; i < tastes.length; i++) {
            if (tastes[i] > tastes[i - 1]) {
                return 0;  // 완벽하지 않은 구름 햄버거이므로 0을 반환
            }
        }
        
        int totalTaste = 0;
        for (int taste : tastes) {
            totalTaste += taste;
        }
        
        return totalTaste;  // 모든 조건을 만족하면 구름 햄버거의 맛을 반환
    }
}