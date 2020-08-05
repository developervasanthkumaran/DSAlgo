package Arrays;

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



    public static void main(String[] args) {
        PracticeProblems pb = new PracticeProblems();
        int[] a={0, 0, 1, 0, 1, 0, 0 };
        for(int i=0;i<a.length;i++)if(a[i]==0)a[i]=-1;
        pb.maxSubArraySum(a,0);

    }

}
