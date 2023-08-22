import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); 
        scanner.nextLine(); // to consume newline left by nextInt()
        String Word = scanner.nextLine();

        List<String[]> wordList = new ArrayList<>();
        Set<String> Score = new HashSet<>();

        // 위치를 2개 정하는 모든 조합 구하기
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String first = Word.substring(0, i);
                String second = Word.substring(i, j);
                String third = Word.substring(j);
                wordList.add(new String[]{first, second, third});
                Score.add(first);
                Score.add(second);
                Score.add(third);
            }
        }

        List<String> tempScoreList = new ArrayList<>(Score);
        Collections.sort(tempScoreList);

        Map<String, Integer> wordScore = new HashMap<>();
        for (int i = 0; i < tempScoreList.size(); i++) {
            wordScore.put(tempScoreList.get(i), i + 1);
        }

        int maxScore = -1;
        for (String[] words : wordList) {
            int tempScore = 0;
            for (String word : words) {
                tempScore += wordScore.get(word);
            }
            maxScore = Math.max(maxScore, tempScore);
        }
        
        System.out.println(maxScore);
    }
}