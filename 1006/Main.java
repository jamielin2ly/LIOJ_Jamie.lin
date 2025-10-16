import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 讀取 N
            int N = Integer.parseInt(sc.nextLine().trim());  // 座位總數

            // 檢查數字範圍
            if (! (2 <= N && N <= 30)) {
                System.out.println("輸入數字 " + N + " 不符合範圍 [2, 30]！");
                System.exit(0);  // 程式結束
            }
            if (N % 2 != 0) {
                System.out.println("輸入數字 " + N + " 需為偶數！");
                System.exit(0);  // 程式結束
            }

            // 讀取 M
            int M = Integer.parseInt(sc.nextLine().trim());  // 被佔座位數

            // 檢查數字範圍
            if (! (0 <= M && M <= N)) {
                System.out.println("輸入數字 " + M + " 不符合範圍 [0, " + N + "]！");
                System.exit(0);  // 程式結束
            }

            // 座位狀態，False表示空，True表示已佔
            boolean[] seats = new boolean[N + 1];

            // 開始佔位
            for (int i = 0; i < M; i++) {
                int keepSeat = Integer.parseInt(sc.nextLine().trim());
                if (! (1 <= keepSeat && keepSeat <= N)) {
                    System.out.println("輸入座位 " + keepSeat + " 不在範圍內 [1, " + N + "]！");
                    System.exit(0);  // 程式結束
                }

                if (!seats[keepSeat]) {
                    seats[keepSeat] = true;
                } else {
                    System.out.println("輸入數字 " + keepSeat + " 重複輸入！");
                    System.exit(0);  // 程式結束
                }
            }

            int validPairs = 0;

            // 检查同一排内的相鄰座位（奇數排和偶數排分别检查）
            validPairs += checkSameRow(N, 1, seats);
            // System.out.println("V1="+checkSameRow(N, 1, seats));
            validPairs += checkSameRow(N, 2, seats);
            // System.out.println("V2="+checkSameRow(N, 2, seats));

            // 检查跨排的相鄰座位
            for (int i = 1; i <= N / 2; i ++) {
                if (! seats[2 * i - 1] && ! seats[2 * i]) {
                    validPairs++;
                }
            }
            // 输出结果
            System.out.println(validPairs);

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

    // 检查同一排内的相鄰座位
    private static int checkSameRow(int N, int firstSeat, boolean[] seats) {
        int validPairs = 0;

        // 检查奇數排從1開始檢查，EX. (1, 3), (3, 5), ...
        // 检查偶數排從2開始檢查，EX. (2, 4), (4, 6), ...
        for (int i = firstSeat; i < N; i += 2) {
            if ((i + 2) <= N && !seats[i] && !seats[i + 2]) {
                validPairs++;
            }
        }

        return validPairs;
    }
}