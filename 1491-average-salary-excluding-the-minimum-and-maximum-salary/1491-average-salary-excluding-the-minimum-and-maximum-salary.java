class Solution {
    public double average(int[] salary) {
        double sum = 0,average = 0;
        int n = salary.length;
        int min = salary[0],max =0;
        for(int sal:salary){
            max = Math.max(max,sal);
            min = Math.min(min , sal);
        }
        for(int sal: salary){
            sum+= sal;
        }
        sum -= min+max;

        return sum/(n-2);
        
    }
}