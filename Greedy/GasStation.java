class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff = 0;
        int start = 0;
        int currentFuel = 0;

        for(int i=0;i<gas.length;i++){
           int diff = gas[i] - cost[i];
           totalDiff += diff;
           currentFuel += diff;

           if(currentFuel < 0){
            start =  i+1;
            currentFuel = 0;
           }
        }
        return totalDiff < 0 ? -1 : start;
    }
}