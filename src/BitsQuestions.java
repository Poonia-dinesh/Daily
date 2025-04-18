public class BitsQuestions {

    public static void  main(String[] args){
        int n = 5;
        System.out.println(4>>1);
        System.out.println(4<<1);
        System.out.println(4<<2);
        // check odd and even  masking  a&1 ==0 even a&1 ==1 odd
        System.out.println(n&1);
        // Swap two number

        int a = 5;
        int b = 7;
       a = a^b;
       b = a^b;
       a = a^b;
        System.out.println(a+" " +b);

        // Ste ith bit

        // Check hom many set bits n&(n-1)
        int ans = 0;
        while (a !=0){
            a = a&(a-1);
            ans++;
        }
        System.out.println(ans);
        // two  non repeating element
        int[] arr = {1,2,3,4,1,2,4,5};
        int xorall =0;
        int la = 0;
        int rb =0;

        for (int i : arr){
            xorall= xorall^i;
        }

        int rightmostsetbit = xorall & -xorall;

        for(int i : arr){
            if((i&rightmostsetbit) ==0){
                la ^=i;
            }
            else{
                rb ^= i;
            }
        }

        System.out.println(la +" "+rb);

    }
}
