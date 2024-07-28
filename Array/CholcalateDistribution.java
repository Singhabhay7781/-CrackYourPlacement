class Solution
{
    public long findMinDiff(ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        
        int i = 0;
        int j = n-1;
        
        int size = m;
        int minDiff = a.get(j) - a.get(i);
        
        while(size > m){
            if(size-2 >=m){
                i++; j--;
                size = size-2;
            } 
            else if((a.get(j-1) - a.get(i)) < (a.get(j) - a.get(i+1))){
                j--;
                size--;
            } else {
                i++;
                size--;
            }
        }
        return a.get(j) - a.get(i);
    }
}