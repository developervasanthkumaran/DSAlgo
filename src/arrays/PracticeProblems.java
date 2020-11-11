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
        max = arr[0];
        for(int j:profit) System.out.print(j+" ");

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
        return coinChangeRecursive(coin,n,k - coin[n]) + coinChangeRecursive(coin,n-1,k);
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
    int minCoinRequired(int[] coins,int k){
            int[] dp = new int[k+1];
            dp[0] = 0;
        for (int i = 1; i <=k ; i++) {
            dp[i]  = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;
            for(int coin:coins){

                if(i  - coin >=0){
                    res = dp[i - coin];
                }
                if(res!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],res+1);
                }
            }
        }
//        for(int j:dp) System.out.print(j+" ");
//        System.out.println();
    return dp[k];
    }


    int util(int[] arr,int start,int end,int flag,int[][] lookup){
        if(start>=arr.length){
            return 0;
        }
        if(lookup[start][flag] == 0){
            int res = 0;
            for (int i = start; i <=end; i++) {
                if(flag == 1 && arr[i-1] <= arr[i]){
                    res = Math.max(res,1+util(arr,i+1,end,0,lookup));
                }
                else if(flag == 0 && arr[i-1] >= arr[i-1] ){
                    res = Math.max(res,1+util(arr,i+1,end,1,lookup));
                }
                else res = Math.max(res,util(arr,i+1,end,flag,lookup));
            }
        lookup[start][flag] = res;
        }
    return lookup[start][flag];
    }
    int longestAlternateSequence(int[] arr){
        int[][] lookup = new int[arr.length][2];
        return 1+Math.max(util(arr,1, arr.length-1,1,lookup),
                util(arr,1, arr.length-1,0,lookup));
    }

    int longestAltSequenceOptimized(int[] arr){
        int[][] lookup = new int[arr.length][2];
        int res = Integer.MIN_VALUE;
        lookup[0][0]=lookup[0][1] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i-1] <=arr[i]){
                    lookup[i][0] = Math.max(lookup[i][0],lookup[j][1]+1);
                }
                if(arr[i-1] >=arr[i]){
                    lookup[i][1] = Math.max(lookup[i][1],lookup[j][0]+1);
                }
                res = Math.max(lookup[i][0],lookup[i][1]);
            }
        }
        return res;
     }

    int bSearch(int[] keySet,int r,int key){
        int l = -1;
        while (r-l > 1){
            int mid = l + (r-l)/2;
            if(keySet[mid] >= key){
                r = mid;
            }
            else l = mid;
        }
    return r;
    }


    int longestIncreasingSubsequence(int[] arr) {
        int[] tail = new int[arr.length];
        tail[0] = arr[0];
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] <= tail[0] ){
                tail[0] = arr[i];
            }
            else if(arr[i] > tail[len-1]){
                tail[len++] = arr[i];
            }
            else {
                int index = bSearch(tail,len-1,arr[i]);
                tail[index] = arr[i];
            }
        }
        return len;
    }


    int rodCutting(int[] prices,int k,int[] lookup) {
        if(k == 0)return 0;
        int max = Integer.MIN_VALUE;
        if(lookup[k] == 0) {
            for (int i = 1; i <= k; i++) {
                int c = prices[i - 1] + rodCutting(prices, k - i, lookup);
                max = Math.max(max, c);

            }
            lookup[k] = max;
        }
        return lookup[k];
    }
    int rodCuttingDp(int[] prices,int n){
        int[] lookup = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                lookup[i]  = Math.max(lookup[i],prices[j-1]+lookup[i-j]);
            }
        }
   return lookup[n];
    }

    boolean twoPartitions(int[] arr,int n,int k){
        if(k < 0 || n < 0 )return false;
        if(k == 0)return true;
        boolean inc = twoPartitions(arr,n-1,k - arr[n]);
        if(inc)return true;
        return twoPartitions(arr,n-1,k);
    }

    boolean twoPartitions(int[] arr){
        int sum  = 0;
        for (int j : arr) {
            sum += j;
        }
        return (sum & 1) != 1 && twoPartitions(arr, arr.length - 1, sum / 2);
    }

    boolean threePartitions(int[] arr,int n,int a,int b,int c,boolean[][][] lookup){
        if(a == 0 && b == 0 && c == 0)return true;
        if(a < 0 || b < 0 || c < 0 )return false;
        if(n < 0)return false;

        if(!lookup[a][b][c]){
            boolean s1  = threePartitions(arr,n-1,a - arr[n],b,c,lookup);

            boolean s2  = threePartitions(arr,n-1,a - arr[n],b - arr[n-1],c,lookup);

            boolean s3  = threePartitions(arr,n-1,a - arr[n],b - arr[n-1],c - arr[n-1],lookup);

            lookup[a][b][c] = s1 || s2 || s3;
        }

        return lookup[a][b][c];
    }

    boolean threePartitions(int[] arr){
        int sum = 0 ;
        for(int j:arr)sum+=j;

        int size = arr.length;

        boolean[][][] lookup = new boolean[sum+1][sum+1][sum+1];
        return sum%3 == 0 && threePartitions(arr,size-1,sum/3,sum/3,sum/3,lookup);
    }


    public static void main(String[] args) {
        PracticeProblems pb = new PracticeProblems();
        int[] price = {1,5,8,9,10,17,17,20};
        int[] length  = {1,2,3,4,5,6,7,8};
        int[] lookup = new int[5];
        System.out.println(pb.threePartitions(new int[]{ 7, 3, 2, 1, 5, 4, 8 }));
    }

}
