class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        //key-players value=count of losses

        Map<Integer,Integer> lost_map=new HashMap<>();

        for(int i=0;i<matches.length;i++){
            int loser=matches[i][1];

            lost_map.put(loser,lost_map.getOrDefault(loser,0)+1);
        }
        //ensure your winner are tracked
        for(int i=0;i<matches.length;i++){
            int winner=matches[i][0];
            if(!lost_map.containsKey(winner)){
                lost_map.put(winner,0);
            }
        }
        //prepare result list
        List<Integer> notlost=new ArrayList<>();
        List<Integer> lostonce=new ArrayList<>();

        //categorize players
        for(Map.Entry<Integer,Integer> entry : lost_map.entrySet()){
            int player=entry.getKey();
            int losses=entry.getValue();

            if(losses==0){
                notlost.add(player);
            }else if(losses==1){
                lostonce.add(player);
            }
        }
        //sort
        Collections.sort(notlost);
        Collections.sort(lostonce);

        //final answer
        List<List<Integer>> answer=new ArrayList<>(2);
        answer.add(notlost);
        answer.add(lostonce);

        return answer;


    }
}