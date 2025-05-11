package daima;

public class binary_search {
    public int search(int[] nums, int target) {
        int left=0;
        int length=nums.length;
        int right=length;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        binary_search bs=new binary_search();
        int [] nums={-1,0,3,5,9,12};
        int target=9;
        System.out.println(bs.search(nums,target));
    }
}
