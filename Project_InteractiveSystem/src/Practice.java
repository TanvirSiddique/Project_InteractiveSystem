public class Practice {

    public static int getSum(int number) {
        int sum = 0;
        for (int index = 1; index <=number; index = index + 1) {
            sum = sum + index;
        }
        return sum;
    }

    public static boolean isOk(int base, int power) {
        if (base <=0 || power <0) { //base 10, power 4, f || f = f
            return false;
        }
        return true;
    }

    public static int getPower(int base, int power) {
        if(!isOk(base, power)) { //!true
            return -1; // default result
        }
        int result = 1;
        for (int index = 0; index < power; index = index + 1) {
            result = result * base;
        }
        return result;
    }


    //pow
    public static int getEqual (int base, int power) {
        int value = 1;
        for (int index = 0; index < power; index = index + 1) {
            value = value * base;
        }
        return value;
    }


    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s);
            System.out.println(s.length());
            System.out.println("--------");
        }

        System.out.println(getEqual(2,2));
        System.out.println(Math.pow(2,2));

        //Same as the getEqual method above....
        int base = 2;
        int power = 2;
        int value = 1;
        for (int index = 0; index < power; index = index + 1) {
            value = value * base;
            //System.out.println(value);
        }
        System.out.println(value);

        //int [] a, b;
        //int[] a = new int[8];
        //System.out.println(a);
        //a = new int[8];
        //System.out.println(a);
/*

       int[] a = null;
       System.out.println(a);
       a = new int[8];
       //int a = new int[8];
       System.out.println(a);
       int[] b = a;
       System.out.println(b);

       // a -> 0 1 2 3 4 5 6 7
            // ^
       // b -> |

       for (int index = 0; index < 8; index = index + 1) {
           System.out.println(a[index]);
       }
*/

        String[] sArray = null;
        System.out.println(sArray);
        sArray = new String[8];
        System.out.println(sArray);

        for (int index = 0; index < 8; index = index + 1) {
            // System.out.println(sArray[index]);
            sArray[index] = new String();
            System.out.println(sArray[index]);
        }

        for (int index = 7; index >= 0; index = index - 1) {
            // System.out.println(sArray[index]);
            sArray[index] = new String();
            System.out.println(sArray[index]);
        }

/*
       int number = 50;
       int sum = 0;
       for (int index = 1; index <=50; index = index + 1) {
           sum = sum + index;
       }


*/
        System.out.println(getPower(10,4));
        // main -> println -> getPower -> isOk
    }


/*
    //CSC8011 Classes - car example

    public class CarClassExample {
        //fields
        String make;
        String model;
        String colour;
        int age;
        //constructor
        public CarClassExample(String make, String model, String colour, int age) {
            this.make = make;
            this.model = model;
            this.colour = colour;
            this.age = age;
        }
    //CSC8011 Classes – constructors: Bank account example
      No Input yet


    }
 */


}
