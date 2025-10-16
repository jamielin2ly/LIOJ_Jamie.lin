import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> results = new ArrayList<>(); // 用來儲存結果
        int count = 0;  // 記錄已輸入的數字數量

        try {
            while (true) {
                // 讀取 M
                int M = Integer.parseInt(sc.nextLine());

                // M=0代表輸入結束
                if (M == 0) {
                    break;
                }

                // 檢查是否超過 100 個數字
                count++;
                if (count > 100) {
                    System.out.println("錯誤：輸入的數字超過 100 個！");
                    System.exit(0);  // 程式結束
                }

                // 檢查數字範圍
                if (! (2 <= M && M <= 100000)) {
                    System.out.println("輸入數字 " + M + " 不符合範圍 [2, 100000]！");
                    System.exit(0);  // 程式結束
                }

                // 判斷相親數
                Integer sfOfM = sumOfFac(M);
                Integer sfOfMf = sumOfFac(sfOfM);

                // System.out.println(sfOfM);
                // System.out.println(sfOfMf);

                // 若是沒有相親數輸出 QQ
                if (M == sfOfMf) {
                    // System.out.println(sfOfMf);
                    results.add(sfOfM.toString());
                } else {
                    results.add("QQ");
                }
            }

            // 一次性輸出所有結果
            for (String result : results) {
                System.out.println(result);
            }

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

    // 取得正因數之合
    static Integer sumOfFac(int M) {
        Integer facnum = 0;
        // System.out.println("M= " + M + " ！");
        for (int i = 1; i < M; i++) {
            if (M % i == 0) {
                facnum += i;
                // System.out.println("i= " + i + " ！");
            }
        }
        // System.out.println("facnum= " + facnum + " ！");
        return facnum;
    }
}