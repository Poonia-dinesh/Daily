package problems;

import java.util.Arrays;

public class Koko {
//    Input: piles = [3,6,7,11], h = 8
//    Output: 4
    public  static  void main(String[] args){
        int [] piles = {3, 6, 7,11};
                int h = 8;
           int max = Arrays.stream(piles).max().getAsInt();
           int min = 1;
           int ans = max;
           while(min <= max){
            int mid = min+(max-min)/2;
            int cans = kokoeat(piles, mid);

            if(cans <= h){
                ans = mid;
                max  = mid-1;
            }
            else {
                min = mid+1;
            }
        }
        System.out.println("Minimum piles : " + ans );
    }

    public static int kokoeat(int[] arr, int mid)
    {
       int totaltime =0;
            for (int i = 0; i < arr.length; i++) {
                totaltime += Math.ceil((double) arr[i]/mid);
            }
        return totaltime;
    }
}
