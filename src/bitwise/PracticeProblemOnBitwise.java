package bitwise;

import java.util.Arrays;
import java.util.Deque;


public class PracticeProblemOnBitwise {

    int countSetBitsUsing_BrianKernighan_Algo(int n){
       int c=0;
        while(n!=0){
            n = n & n-1;
            c++;
        }
    return c;
    }

    int nextHigherPowerOf2(int n){
        n = n-1;
        n |=(n >> 1);
        n |=(n >> 2);
        n |=(n >> 4);
        n |=(n >> 8);
        n |=(n >> 16);
        return n + 1;
    }
    int previousHigherPowerOf2(int n){
        n = n-1;
        n |=(n >> 1);
        n |=(n >> 2);
        n |=(n >> 4);
        n |=(n >> 8);
        n |=(n >> 16);
        return n - (n >> 1) ;
    }
    boolean findParity(int x){
        //counts no of set bits, even parity if set bits is even else odd parity
        x ^= x >> 16;
        x ^= x >> 8;
        x ^= x >> 4;
        x ^= x >> 2;
        x ^= x >> 1;
        return (x & 1) == 0;
    }

    int findMin(int x,int y){
        return y + ((x-y)& (x-y) >> 31);
    }

    int findMax(int x,int y){
        return x - ((x-y)& (x-y) >> 31);
    }

    int oddOccuringElements(int[] arr){
        int r = 0;
        for (int i = 0; i <arr.length ; i++) {
            r ^=arr[i];
        }
    return r;
    }

    int[] twoOddlyOccuringElement(int[] a){
        int r=0;
        for (int value : a) {
            r ^= value;
        }
        int k = (int) (Math.log(r & -r)/Math.log(2));
        int x=0,y=0;
        for(int i:a){
            if((i & (1<<k))!=0){
                x^=i;
            }
            else y^=i;
        }
    return new int[]{x,y};
    }

    void powerSetOfGivenSet(int[] a, Deque<Integer> q,int i){
        if(i < 0){
            System.out.println(q);
            return;
        }
        q.addLast(a[i]);
        powerSetOfGivenSet(a,q,i-1);
        q.pollLast();
        while (i > 0 && a[i] ==a[i-1])i--;
        powerSetOfGivenSet(a,q,i-1);
    }
    int findMissingElement(int[] a){
       int xor=0;
        for(int i:a)xor^=i;
        for(int i=1;i<=a.length+1;i++)xor^=i;
        return xor;
    }
    public static void main(String[] args) {
        PracticeProblemOnBitwise pr = new PracticeProblemOnBitwise();
        int[] a  = {1,3,4};
        System.out.println(4 & -4);
    }
}
