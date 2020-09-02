package arrays;

import java.util.*;

public class PracticeProblems {

    long maxAbsDiff(int[] arr){
        //It is also used to find Maximum profit for n stock prices
        // with only one transactions
        long max  = arr[arr.length-1],maxAbs = 0;
        for (int i = arr.length-2; i >-1 ; i--) {
            maxAbs = Math.max(maxAbs,max - arr[i]);
            max = Math.max(max,arr[i]);
        }
    return maxAbs;
    }

    long maxStockProfitWithTwoTransaction(int[] arr){
        int s = arr.length;
        int[] profit = new int[s];
        int max  = arr[s-1];
        for (int i = s-2; i > -1 ; i--) {
            profit[i] = Math.max(profit[i+1],max - arr[i]);
            max = Math.max(max,arr[i]);
        }
        max = arr[0];for(int j:profit) System.out.print(j+" ");

        for (int i = 1; i < s; i++) {
            profit[i] = Math.max(profit[i-1],(arr[i] - max)+profit[i]);
            max = Math.min(max,arr[i]);
        }
        for(int j:profit) System.out.print(j+" ");

        return profit[s-1];
    }
    int maxProfit(int[] price, int k)
    {
        int n = price.length;
        int[][] profit = new int[k+1][n];
        //o(days * k)
        //worst case days == k then o(days ^ 2)
        for (int i = 1; i <=k ; i++) {
            int maxDiff = -price[0];
            for (int j = 1; j < n ; j++) {
                    profit[i][j] = Math.max(profit[i][j-1],price[j] + maxDiff);
                    maxDiff = Math.max(maxDiff,profit[i-1][j] - price[j]);
            }
        }
        return profit[k][n-1];
    }

    int coinChangeRecursive(int[] coin,int n,int k){
    //reaching here means we fulfilled balance
        if(k == 0)return 1;
        //reaching here means we cant fulfill balance
        if(k < 0 || n < 0)return 0;
        //either we can include or exclude the coins to fulfill balance
        //this solution leads to exponential since it recursively calls for
        //all n-1 coins
        return coinChangeRecursive(coin,n,k - coin[n])
                + coinChangeRecursive(coin,n-1,k);
}
    int coinChangeDp(int[] coins,int k){
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i:coins){
            for(int j=i;j<=k;j++){
                dp[j] += dp[j - i];
            }
        }
    return dp[k];
    }
    public static void main(String[] args) {
        PracticeProblems pb = new PracticeProblems();
    }

}
