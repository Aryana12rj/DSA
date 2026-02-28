class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int bottledrunk=numBottles;
        int emptybottles=numBottles;

        while(emptybottles>=numExchange){
            emptybottles-=numExchange;
            numExchange++;
            bottledrunk++;
            emptybottles++;
        }
        return bottledrunk;
    }
}