package bitwise;

public class BitwiseOperations {

     int bitwiseAddition(int a,int b){
        int keep = (a & b) << 1;
        int r = a ^ b;
        if(keep == 0)return r;
        return bitwiseAddition(keep,r);
    }
     int bitwiseSubtraction(int a,int b){
        int k = (~a) & b << 1;
          a = a ^ b;
        if(k==0)return b;
        return bitwiseSubtraction(a,b);
    }

     int divisionWithoutOperator(int dividend,int divisor){
        int q = 0;
        int sign  = (dividend < 0) ^ (divisor < 0)?-1:1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend>=divisor){
            dividend -=divisor;
            q++;
        }
        return sign * q;
    }
    int multiplyWithoutOperator(int a,int b){
        int r = 0;
        int sign = ((a<0)^(b<0))?-1:1;
        //its a russian peasant algorithm, double a and halve b until b becomes 0
        //if b != 0  then add a to result
        a = Math.abs(a);
        b = Math.abs(b);
        while (b > 0){
            if((b & 1) !=0)r+=a;
            a<<=1;
            b>>=1;
        }
    return r*sign;
    }
    int setNthBitPosition(int n,int pos){
        return n | (1<<pos);
    }
    int UnSetNthBitPosition(int n,int pos){
        return n & (~(1<<pos));
    }
    int toggleNthBit(int n,int pos){
        return n^(1<<pos);
    }
    int getNthBitState(int n,int pos){
        return n&(1<<pos);
    }
    int unsetLowestBit(int n){
        return n & (n-1);
    }
    int getLowestSetBit(int n){
        return n & (-n);
    }
    int countNoOfSetBits(int n){
        int c=0;
        while (n > 0){
            c+= 1 & n;
            n = n>>1;
        }
    return c;
    }

    int clearAllBitsFromLsbToIthPos(int n,int i){
        return n & -((1 << i+1 ));
    }
    int clearAllBitsFromMsbToIthPos(int n,int i){
        return n & ((1 << i ) - 1);
    }
    char upperCaseToLowerCase(char c){
        return (char) (c|' ');
    }
    char lowerCaseToUpperCase(char c){
        return (char) (c&'_');
    }
    int findLogBase2(int n){
        int c=0;
        while (n>1){
            c++;
            n = n >>1;
        }
    return c;
    }

    boolean isPowerOf2(int n){
        return (n & (n-1)) == 0;
    }

    boolean isOddorEven(int n){
        //return true if n is even
        return (n & 1) == 0;
    }

    char invertCharacterCase(char c){
        return (char) (c ^ ' ');
    }
    boolean checkEitherOfNumIsNegative(int a,int b){
        return (a ^ b) < 0;
    }

    int addOneToNumber(int n){
        return -(~n);
    }

    void swapNumber(int a,int b){
        System.out.println("before swapping a: "+a+" b:"+b);
        a^=b;
        b^=a;
        a^=b;
        System.out.println("after swapping a: "+a+" b:"+b);
    }

     int toFindLetterPosition(char c){
        return c & 31;
    }

    int absOfN(int n){
        final int mask = n >> 31;
        return( n + mask ) ^ mask;
    }
      boolean checkBinaryOfNisPalindrome(int k){
        int rev=0,n=k;
        while (n!=0){
            rev = (rev << 1) | (n & 1);
            n = n >> 1;
        }
    return rev == k;
    }
}
