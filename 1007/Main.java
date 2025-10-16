import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();

        try {
            // 讀取 M
            int M = Integer.parseInt(sc.nextLine().trim());  // 組數

            // 檢查數字範圍
            if (! (1 <= M && M <= 50)) {
                System.out.println("輸入數字 " + M + " 不符合範圍 [1, 50]！");
                System.exit(0);  // 程式結束
            }

            // 讀 M 行字串
            for (int i = 0; i < M; i++) {
                String line = sc.nextLine().trim(); // 清理行首行尾的空白字符
                // 用空格分隔
                String[] tokens = line.split("\\s+");

                // 確保有兩組輸入
                if (tokens.length != 2) {
                    System.out.println("輸入格式錯誤，請確保每行格式符合：人名+一個空白+好感度。");
                    System.exit(0);  // 程式結束
                }

                // 檢查人名
                String N = tokens[0];
                if (! N.matches("[A-Za-z]+")) {
                    System.out.println("輸入格式錯誤，人名 " + N + " 需由大小寫英文字母組成。");
                    System.exit(0);  // 程式結束
                }
                if (! (1 <= N.length() && N.length() <= 20)) {
                    System.out.println("輸入格式錯誤，人名 " + N + " 長度不符合範圍 [1, 20]！");
                    System.exit(0);  // 程式結束
                }

                // 檢查好感度
                int S = Integer.parseInt(tokens[1]);
                if (! (0 <= S && S <= 100)) {
                    System.out.println("輸入格式錯誤，好感度 " + S + " 不符合範圍 [0, 100]！");
                    System.exit(0);  // 程式結束
                }

                names.add(N);
                scores.add(S);
            }

            // 找出最大好感度
            int maxScore = Collections.max(scores);

            // 輸出所有好感度等於最大值的人
            for (int i = 0; i < M; i++) {
                if (scores.get(i) == maxScore) {
                    System.out.println(names.get(i));
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("錯誤：請輸入有效的數字！");
            System.exit(0);  // 程式結束
        } catch (Exception e) {
            System.out.println("發生未知錯誤：" + e.getMessage());
            System.exit(1);  // 程式結束
        } finally {
            sc.close();
        }
    }
}