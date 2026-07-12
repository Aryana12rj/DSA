class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int [] temp= Arrays.copyOf(arr,arr.length);
        Arrays.sort(temp);
        int rank=1;
        HashMap <Integer,Integer> map=new HashMap<>();

        for(int ele : temp){
            if(!map.containsKey(ele)){
                map.put(ele, rank++);
            }
        }

        for(int i=0 ; i<arr.length ; i++){
            arr[i]= map.get(arr[i]);
        }
        return arr;
    }
}