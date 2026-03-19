public class Test {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        // SIMPLE IF
        if (a > 5) {
            System.out.println("Big number");
        }

        // IF - ELSE IF - ELSE
        if (a > b) {
            System.out.println("a bigger");
        } else if (a == b) {
            System.out.println("equal");
        } else {
            System.out.println("b bigger");
        }

        // LOGICAL OPERATORS
        if (a > 5 && b < 30 || a == 10) {
            System.out.println("Complex condition");
        }

        // FOR LOOP
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // WHILE LOOP
        int i = 0;
        while (i < 3) {
            i++;
        }

        // SWITCH CASE
        switch (a) {
            case 1:
                System.out.println("One");
                break;
            case 10:
                System.out.println("Ten");
                break;
            default:
                System.out.println("Other");
        }

        // NESTED IF
        if (a > 0) {
            if (b > 0) {
                System.out.println("Both positive");
            }
        }

        // STRING (SHOULD NOT COUNT)
        String text = "if (a > 5) this should not count";

        // COMMENT (SHOULD NOT COUNT)
        // if (a == 100) { }

        // MULTI-LINE COMMENT (SHOULD NOT COUNT)
        /*
        if (a > 50) {
            System.out.println("This should NOT be counted");
        }
        */
        int x = 0;
        /* if (x > 0) */ if (x == 0) {
            System.out.println("test");
        }

    }
}