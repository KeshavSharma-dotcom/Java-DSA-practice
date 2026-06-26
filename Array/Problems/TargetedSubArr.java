package Array.Problems;

import java.util.Arrays;

class Solution{
    static class Fenwick{
        int[] f;
        Fenwick(int n){
            this.f = new int[n+1];
        }
        int query(int j){
            int sum = 0;
            while(j > 0){
                sum += f[j];
                j -= j & -j;
            }
            return sum;
        }
        void update(int i,int x){
            while(i < f.length){
                f[i] += x;
                i += i & -i;
            }
        }
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int prefix = 0 , offset = nums.length + 1;
        long subs = 0;
        Fenwick f = new Fenwick(2*nums.length+10);
        f.update(offset , 1);
        for (int num : nums) {
            prefix += num == target ? 1 : -1;
            subs += f.query(prefix + offset -1);
            f.update(prefix + offset, 1);
        }
        return subs;
    }
}




