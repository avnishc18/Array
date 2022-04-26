public class PlayGameOfNumbers {
    public static void main(String[] args) {
        int[] nums = {12,13,14,15,16,17};
        System.out.println("wining player:" + play(nums));
    }

    private static int play(int[] a) {
        int previous = a[0];
        int p1 = a[0],p2=0;
        boolean play = false;
        int i = 1, j = a.length -1;
        while(i<j) {
            if(play){
                if(previous % 2 == 1){
                    previous = a[j--];
                }else{
                    previous = a[i++];
                }
                p1+=previous;
                play = false;
            }else{
                if(previous % 2 == 1){
                    previous = a[j--];
                }else{
                    previous = a[i++];
                }
                p2+=previous;
                play = true;
            }
        }
        if(p1 == p2){
            return -1;
        }else if( p1 < p2){
            return p2;
        }else {
            return p1;
        }
    }
}
