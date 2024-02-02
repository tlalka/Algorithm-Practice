public class Q5_7 {
    //flip odd and even bits in as few steps as possible
    //ex  abcd = badc
    //all even bits go left one
    //all odd bits go right one
    //assume 32 bit max


    public static int fliparoo(int num){
        int even = num & Integer.parseInt("010101010101010101010101010101", 2);
        int odd = num & Integer.parseInt("101010101010101010101010101010", 2);
        return (even << 1) | (odd >>> 1);
    }
    public static void main(String[] args){
        int b = Integer.parseInt("11001", 2);
        System.out.println("result is " + Integer.toString(fliparoo(b), 2));
    }

}
