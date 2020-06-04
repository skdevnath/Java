import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSumMain {
    /*
    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
     */
    static void main(String args[]) {
       FourSumMain solution = new FourSumMain();
       int[] nums = new int[]{1, 0, -1, 0, -2, 2};
       solution.fourSum(nums, 0);
    }

    public List<List> fourSum(int[] nums, int target) {
        List<List> res = new LinkedList<>();
        List r = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        if(nums.length==4){
            int isum=0;
            for(int i: nums){
                isum+=i;
            }
            if(isum==target){


                for(int i: nums){

                    r.add(i);

                }
                res.add(r);
                return res;
            }
        }

        for(int i=0; i<nums.length-1;i++){

            for(int j=i+1;j<nums.length;j++){
                int lo=j+1;
                int hi=nums.length -1;

                int sum = target-nums[i]-nums[j];
                while(lo<hi){
                    if(nums[lo]+nums[hi]  == sum ){
                        if(!res.contains((Arrays.asList(nums[i],nums[j],nums[lo],nums[hi])))){
                            res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                        }

                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;

                }
            }

        }

        return res;
    }
}
