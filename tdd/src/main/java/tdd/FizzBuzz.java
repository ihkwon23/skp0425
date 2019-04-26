package tdd;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static String say(int number) {
        String result = "";

        if ( number % 3 == 0)
            result += FIZZ;
        if ( number % 5 == 0 )
            result += BUZZ;
        if ( result.isEmpty() )
            return String.valueOf(number);
        return result;
    }

    public static String sayOld(int number) {
        if ( number % 15 == 0 )
            return FIZZ + BUZZ;
        if ( number % 5 == 0 )
            return BUZZ;
        if (number % 3 == 0)
            return FIZZ;
        return String.valueOf(number);
    }
}
