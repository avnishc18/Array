import java.util.Map;

public class DecimalToBaseNine {

    public static void main(String[] args) {

        System.out.println(ninthBase(2567));
    }

    static long ninthBase(int number){
        int base = 9;
        int r = number % base;
        int result = number / base;
        String st = "";
        while( result > 0 || r > 0 ) {
            st = String.valueOf(r)+st;
            r = result % base;
            result = result / base;
        }
        return Long.valueOf(st);
    }
}



