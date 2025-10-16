import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 讀 n
            int n = Integer.parseInt(sc.nextLine().trim());
            /*
            int n = sc.nextInt();
            sc.nextLine(); // 清除換行
             */
            // 檢查數字範圍
            if (! (1 <= n && n <= 100)) {
                System.out.println("輸入數字 " + n + " 不符合範圍 [1, 100]！");
                System.exit(0);  // 程式結束
            }

            // 讀 n 行字串並合併
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                sb.append(line);
            }
            String S = sb.toString();

            // 讀 m
            int m = Integer.parseInt(sc.nextLine().trim());
            /*
            int m = sc.nextInt();
            sc.nextLine(); // 清除換行
             */
            // 檢查數字範圍
            if (! (1 <= m && m <= S.length())) {
                System.out.println("輸入數字 " + m + " 不符合範圍 [1, " + S.length() + "]！");
                System.exit(0);  // 程式結束
            }

            // 讀 m 個位置，取字元並組合
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m; i++) {
                int pos = sc.nextInt();

                if(0 < pos && pos <= S.length()) {
                    // pos 是從1開始，所以要減1
                    char ch = S.charAt(pos - 1);
                    result.append(ch);
                } else {
                    break;
                }
            }

            // 輸出結果
            System.out.println(result.toString());

            // } catch (InputMismatchException e) {
        } catch (NumberFormatException e) {
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