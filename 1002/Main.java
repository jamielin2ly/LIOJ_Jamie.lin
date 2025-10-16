import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> results = new ArrayList<>(); // 用來儲存結果

        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                String line = sc.nextLine().trim(); // 讀取每一行
                // 用空格分隔每一行，並將其轉換為數字
                String[] tokens = line.split("\\s+"); // 正則表達式 "\\s+" 匹配一個或多個空白字符

                // 確保有2個數字
                if (tokens.length != 2) {
                    System.out.println("輸入格式錯誤，請確保每行有兩個數字。");
                    System.exit(0);  // 程式結束
                }

                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[1]);

                // 檢查數字範圍
                if (! (0 <= a && a <= (Math.pow(2, 31) - 1))) {
                    System.out.println("輸入數字 " + a + " 不符合範圍 [0, 2^31 - 1]！");
                    System.exit(0);  // 程式結束
                }
                if (! (0 <= b && b <= (Math.pow(2, 31) - 1))) {
                    System.out.println("輸入數字 " + a + " 不符合範圍 [0, 2^31 - 1]！");
                    System.exit(0);  // 程式結束
                }

                // 當 a 和 b 都是 0 時結束
                if (a == 0 && b == 0) {
                    break;
                }

                // 儲存較大的數字
                results.add(Math.max(a, b));
            }

            // 一次性輸出所有結果
            for (int result : results) {
                System.out.println(result);
            }

        } catch (NumberFormatException e) {
            System.out.println("錯誤：請輸入有效的數字！");
            System.exit(0);  // 程式結束
        } catch (Exception e) {
            System.out.println("發生未知錯誤：" + e.getMessage());
            System.exit(1);  // 程式結束
        }/* finally {
            sc.close();
        }
          */
    }
}