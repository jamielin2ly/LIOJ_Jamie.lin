import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> results = new ArrayList<>(); // 用來儲存結果

        try {
            // 讀 m
            int m = Integer.parseInt(sc.nextLine().trim());

            // 讀 m 行字串
            for (int i = 0; i < m; i++) {
                String line = sc.nextLine().trim();
                // 用空格分隔
                String[] tokens = line.split("\\s+");

                // 確保有三個數字
                if (tokens.length != 3) {
                    System.out.println("輸入格式錯誤，請確保每行有三個數字。");
                    System.exit(0);  // 程式結束
                }

                try {
                    // 決定A,B,K
                    BigInteger A = new BigInteger(tokens[0]);
                    BigInteger B = new BigInteger(tokens[1]);
                    int K = Integer.parseInt(tokens[2]);

                    // 比較 A, B
                    results.add(compare(A, B, K));

                } catch (NumberFormatException e) {
                    System.out.println("輸入格式錯誤，請確保A, B, K是有效的整數。");
                    System.exit(0);  // 程式結束
                } catch (Exception e) {
                    System.out.println("發生未知錯誤：" + e.getMessage());
                    System.exit(1);  // 程式結束
                }
            }

            // 一次性輸出所有結果
            for (String result : results) {
                System.out.println(result);
            }

        } catch (NumberFormatException e) {
            System.out.println("輸入格式錯誤，請輸入有效的整數。");
            System.exit(0);  // 程式結束
        } catch (Exception e) {
            System.out.println("發生未知錯誤：" + e.getMessage());
            System.exit(1);  // 程式結束
        } finally {
            sc.close();
        }
    }

    // 使用 BigInteger 的 compareTo 進行比較
    private static String compare(BigInteger A, BigInteger B, int K) {
        if (! (K == 1 || K == -1)) {
            System.out.println("K值有誤，請輸入1或-1。");
            System.exit(0);  // 程式結束
        }

        int a2b = A.compareTo(B);
        if (K == 1) {
            if (a2b > 0) return "A";
            if (a2b < 0) return "B";
        } else if (K == -1) {
            if (a2b < 0) return "A";
            if (a2b > 0) return "B";
        }

        return "DRAW";

    }
}