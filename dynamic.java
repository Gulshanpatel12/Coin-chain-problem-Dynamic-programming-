import java.util.*;

public class dynamic {

      public static void main(String[] args) {
            int a[] = { 1, 7, 5 };
            int n = 18;

            int dp[] = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            int ans = mincoin(n, a, dp);
            System.out.println(ans);
            for (int x : dp) {
                  System.out.print(x + " ");

            }
      }

      static int mincoin(int n, int a[], int dp[]) {
            if (n == 0)
                  return 0;
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                  if (n - a[i] >= 0) {
                        int subans = 0;
                        if (dp[n - a[i]] != -1) {
                              subans = dp[n - a[i]];
                        } else {
                              subans = mincoin(n - a[i], a, dp);
                        }
                        if (subans != Integer.MIN_VALUE && subans + 1 < ans) {
                              ans = subans + 1;

                        }
                  }
            }

            return dp[n] = ans;
      }
}