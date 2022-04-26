public class LongestSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 8, 2};
        int count = longestSubsequence(arr.length, arr);
        System.out.println(count);

    }

    static int longestSubsequence(int size, int a[])
    {
        // code here
        int count = longestSub(a, 1, 1, a[0]);
        System.out.println(count);
        return count;
    }

    static int longestSub(int[] a, int index, int count, int val ){
        System.out.println("index:" + index + " count:" + count + " val:" + val );
        if(index == a.length){
            return count;
        }
        for(int i = index; i < a.length; i++){
            if(val < a[i]) {
                count = Math.max(count , longestSub(a, i+1, count+1, a[i]));
            }else {
                count = Math.max(count , longestSub(a, i+1, count, a[i]));
            }
        }
        return count;
    }
}
