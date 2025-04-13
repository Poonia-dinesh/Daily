public class ArrayQuestions {
    public static void main(String[] args){
        int[] arr = {1,1,2,2,6,3,3,4,4,5,5};
        int ans =0;
        // Unique element from an Array
        for(int i : arr)
        {
            ans= ans^i;
        }
        System.out.println(ans);
    }
}
