public class toString {

    public static String printBinary(double num){
        if (num >= 1 || num <= 0){
            return "ERROR";
        }

        StringBuilder binary  = new StringBuilder();
        binary.append(".");
        double frac = .5;
        while (num > 0){
            if (binary.length() >= 32){
                return "ERROR";
            }

            if (num >= frac){
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }

            frac = frac / 2;

            /*
            double r = num * 2;
            if (r >= 1){
                binary.append(1);
            } else {
                binary.append(0);
                num = r;
            }
            */
        }
        return binary.toString();
    }

    public static void Main(String [] args){
        System.out.println(printBinary(.72));
    }

}
