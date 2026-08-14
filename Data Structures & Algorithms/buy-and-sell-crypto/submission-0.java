//so the only time we can make profit is if we are growing
//we need to find each range that is growing
class Solution {
    public int maxProfit(int[] prices) {
        //the max profit is gonna be while the cash is actually gonna grow
        //so the most profit is gonna be the most we can grow from j-k
        int head = 0;
        int currentProf = 0;
        int maxProf = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[head] >= prices[i]){
                head = i;
                if(currentProf > maxProf){
                    maxProf = currentProf;
                }
                currentProf = 0;
            }
            else {
                if((prices[i] - prices[head]) > currentProf){
                    currentProf = (prices[i] - prices[head]);
                    if(currentProf > maxProf){
                    maxProf = currentProf;
                }
                }
            }
        }

        return maxProf;
    }     
}
