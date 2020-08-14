package arrays;

import java.util.*;

public class PracticeProblems {

    int[] findTargettedSum(int[] a,int target){
        HashSet<Integer> set=new HashSet<>();
        for(int i:a){
            if(set.contains(target-i))return new int[]{i,target-i};
            else set.add(i);
        }
        return new int[]{-1};
    }

    void subArraySumZero(int[] a){
        HashMap<Integer, List<Integer>>map=new HashMap<>();
        int s=0,size=a.length;
        List<Integer> li = new ArrayList<>();
        li.add(-1);
        map.put(0,li);
        for(int i=0;i<size;i++){
            s+=a[i];

            if(map.containsKey(s)){
                System.out.println(map.get(s));
                for(Integer k:map.get(s))
                System.out.println((k+1)+" "+i);
            }
        if(!map.containsKey(s)){
            map.put(s,new ArrayList<>());
        }
        map.get(s).add(i);
        }
    }

    void sortBinaryArray(int[] a){
        int z=0,o=0;
        for (int value : a) {
            if (value == 0) z++;
            else o++;
        }
            int s=z+o;
        for(int i=0;i<s;i++){
            if(z > 0){
                System.out.println(0);
                z--;
            }
            else {
                System.out.println(1);
                o--;
            }
        }
    }

     void dutchNationalFlag(int[] a){
        int z=0,o=0,t=0;
        for (int value : a) {
            if (value == 0) z++;else if(value ==1) o++;
            else t++;
        }
        int s=z+o+t;
        for(int i=0;i<s;i++){
            if(z > 0){
                System.out.println(0);
                z--;
            }
            else if(o > 0) {
                System.out.println(1);
                o--;
            }
            else {
                System.out.println(2);t--;
            }
        }
    }

    void maxSubArraySum(int[] a,int target){
       HashMap<Integer,Integer> map = new HashMap<>();
       int sum=0;
       int ei=-1,len=0;
       map.put(0,-1);
       for(int i=0;i<a.length;i++){
           sum +=a[i];
           map.putIfAbsent(sum,i);
           if(map.containsKey(sum-target) && len < i-map.get(sum-target)){
               len = i - map.get(sum-target);
               ei=i;
           }
       }
        System.out.println(ei-len+1+" "+ei);
    }

    void findDuplicateElement(int[] a){
        //it can also be done with xor but it finds only one duplicate element
        HashSet<Integer> set = new HashSet<>();
        for(int i:a) {
            if (set.contains(i))
                System.out.println(i);
            set.add(i);
        }
    }

    int kadaneAlgorithm(int[] a){
        int maxSoFar = 0;
        int max=0;
        for(int i:a){
            max +=i;
            max = Math.max(max,0);
            maxSoFar = Math.max(maxSoFar,max);
        }
    return  maxSoFar;
    }

    void inPlaceMergeArrayInSorted(int[] a,int[] b){
        int m=a.length,n=b.length;
        for(int i=0;i<m;i++){
            if(a[i]>b[0]){
                a[i]^=b[0];
                b[0]^=a[i];
                a[i]^=b[0];
                int f = b[0],k;
                for(k=1;k<n && b[k]<f;k++){
                    b[k-1] = b[k];
                }
                b[k-1] = f;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void main(String[] args) {
        PracticeProblems pb = new PracticeProblems();
        int[] a={1,4,7,8,10};
        int[] b={2,3,6};
            pb.inPlaceMergeArrayInSorted(a,b);

    }

}
