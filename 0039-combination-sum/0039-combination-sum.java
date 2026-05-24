class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result,new ArrayList<>(),candidates,target,0);
        return result;
        }
        public void backtrack(List<List<Integer>> result,List<Integer> templist,int[] candidates,int remain,int start){
            if(remain<0){
                return;
            }
            else if(remain==0) {
            result.add(new ArrayList<>(templist));
            }else {
                for(int i=start;i<candidates.length;i++){
                    templist.add(candidates[i]);
                    backtrack(result,templist,candidates,remain-candidates[i],i);
                    templist.remove(templist.size()-1);
                }
            }
        
        }
    }
