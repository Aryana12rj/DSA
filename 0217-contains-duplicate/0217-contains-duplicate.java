class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seennumber=new HashSet<>();

        for(int num:nums){
            if(seennumber.contains(num)){
                return true;
            }
            seennumber.add(num);
        }
        return false;
    }
}