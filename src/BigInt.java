import java.util.ArrayList;
import java.util.Random;

/*

Coverage:

A+B where A and B are both positive Integers.
A-B where A and B are both positive Integers.

Need to Do

Handle Negative Cases
A+B where A or B are negative

 */
public class BigInt implements BigIntInterface {

    private String BigIntString;

    private int lengthBigInt;

    private ArrayList<Integer> list = new ArrayList<>();

    private static final int ADDCAP = 10;
    private static final int ADDCARRY = 1;

    private static final int SUBBORROW = 10;
    private boolean isBigIntNegative;

    private boolean isSolutionCharged = false;


    /*
        Creates an object 'BigInt' when passing in a String.
        The string is first passed into a Validator method
        that confirms that the String that is inputted
        only contains Integer values. Once the boolean value of
        that method returns back true, the storeContents method is
        then called in which. Each character of the array is stored
        into "list" which was the ArrayList of Integers.
     */
    public BigInt(String BigInteger) {
        if (BigInteger.charAt(0) == '-') {
            BigInteger = BigInteger.substring(1);
            isBigIntNegative = true;
        }
        if (validifyInput(BigInteger) == true) {
            /*
            Sets the string parameter equal to the String
            value of BigIntString while also setting the length
            of the String, to the lengthBigInt, which lets us
            keep track of the length of the local Big Int value.
             */

            this.BigIntString = BigInteger;
            this.lengthBigInt = BigInteger.length();
            storeBigInt(BigInteger);

        } else {
            /*
                Else Branch will return invalid input
                if value Big Int contains anything other than
                numbers 0-9
             */
            System.out.println("Invalid Input");
            System.exit(0);


        }


        // System.out.println(length());
    }


    public BigInt() {


    }


    public BigInt(int rand){
        Random r = new Random();
        int arbitraryLength = r.nextInt(350);
        String arbitraryBigInt = "";
        for(int i = 0; i<arbitraryLength; i++){
            arbitraryBigInt = arbitraryBigInt + r.nextInt(10);
        }

        this.BigIntString = arbitraryBigInt;
        this.lengthBigInt = arbitraryLength+1;
        store(BigIntString);
    }

    private boolean lengthEquality(int h, int k) {
        if (h == k) {
            return true;
        } else return false;

    }

    private boolean unequalLengthSolver(int h, int k) {
        if (h > k) {
            return true;
        } else {
            return false;

        }
    }

    private int length(String s) {
        if (validifyInput(s) == true) {
            //if the Big Integer only contains numbers, it will return the length.
            return s.length();
        } else {
            return 0;
        }
    }


    /*
        stringValidity takes in a String 'num',
        and returns true if every single character
        with in the String matches ASCII values of
        0-9. If number contains anything other, then
        it will return false.
     */

    private boolean validifyInput(String BigInt) {
        String regex = "[0-9]+";
        if ((BigInt.matches(regex))) {
            return true;

        }
        return false;
    }


    private void storeBigInt(String BigInteger) {
        for (int i = 0; i < lengthBigInt; i++) {
            list.add(Integer.parseInt(Character.toString(BigInteger.charAt(i))));

        }
    }

    private ArrayList<Integer> store(String BigInteger) {
        int length = BigInteger.length();
        ArrayList<Integer> temporaryContainer = new ArrayList<>(BigInteger.length());
        for (int i = 0; i < BigInteger.length(); i++) {
            temporaryContainer.add(Integer.parseInt(String.valueOf(BigInteger.charAt(i))));
        }
        return temporaryContainer;
    }


    private ArrayList<Integer> reverseList(ArrayList<Integer> rList) {
        int tempSize = rList.size();
        ArrayList<Integer> temporaryContainer = new ArrayList<>(tempSize);
        for (int i = rList.size() - 1; i > -1; i--) {
            temporaryContainer.add(rList.get(i));

        }

        return temporaryContainer;


    }

    public void toStrings() {

        if (isBigIntNegative == true) {
            System.out.print("-");
        }
        for (int set = 0; set < list.size(); set++) {
            System.out.print(list.get(set));

        }
    }

    public String toString() {
        String s = "";
        if (isBigIntNegative == true) {
            s = s + "-";
        }
        for (int set = 0; set < list.size(); set++) {
            s = s + list.get(set);
        }
        return s;
    }

    /*
       toString(ArrayList<Integer> e) takes in an Integer array, and displays it
       This method has no return type, rather it should be used to view the String.
     */
    private void toString(ArrayList<Integer> number) {
        if (isBigIntNegative == true) {
            System.out.print("-");
        }
        for (int i = 0; i < number.size(); i++) {
            System.out.print(number.get(i));
        }
        isBigIntNegative = false;
    }

    /*
     toModi
     */
    private String toStringReturn(ArrayList<Integer> list) {
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s = s + list.get(i);
        }
        return s;
    }



    private boolean negativeStringValidity(String s1) {

        if (validifyInput(s1)) {
            return true;
        } else {
            return false;

        }


    }

    private boolean[] handleNegative(String s1, String s2) {
        boolean[] temp = new boolean[2];
        if (s1.charAt(0) == '-') {
            temp[0] = true;

        } else {
            temp[0] = false;
        }

        if (s2.charAt(0) == '-') {
            temp[1] = true;

        } else {
            temp[1] = false;
        }
        return temp;
    }


    public void add(String BigIntegerOne, String BigIntegerTwo) {


        boolean[] isNeg = handleNegative(BigIntegerOne, BigIntegerTwo);


        if (isNeg[0] == false && isNeg[1] == false) {
            if (validifyInput(BigIntegerOne) & validifyInput(BigIntegerTwo)) {
                addAlgo(BigIntegerOne, BigIntegerTwo);
            }
        } else if (isNeg[0] == true && isNeg[1] == true) {
            // -A + -B
            if (negativeStringValidity(BigIntegerOne.substring(1)) && negativeStringValidity(BigIntegerTwo.substring(1))) {
                isBigIntNegative = true;
                add(BigIntegerOne.substring(1), BigIntegerTwo.substring(1));

            }
        } else if (isNeg[0] == false && isNeg[1] == true) {
            //A + -B
            if (negativeStringValidity(BigIntegerTwo.substring(1)) && validifyInput(BigIntegerOne)) {
                subtractAlgo(store(BigIntegerOne), store(BigIntegerTwo.substring(1)));
            }
        } else if (isNeg[0] == true && isNeg[1] == false) {
            // -A + B
            if (negativeStringValidity(BigIntegerOne.substring(1)) && validifyInput(BigIntegerTwo)) {
                subtract(BigIntegerOne.substring(1), BigIntegerTwo);


            }

        }


    }

    public void addAlgo(String one, String two) {

        //Takes two Strings, then puts them in an arraylist of integers.

        ArrayList<Integer> intList1 = reverseList(store(one));
        ArrayList<Integer> intList2 = reverseList(store(two));

        //handleOneUp is only true, if there needs to be a carry.
        boolean handleOneUp = false;
        //solution is stored in this arraylist.
        ArrayList<Integer> solution = new ArrayList<>();

        //first it checks the size of the two arraylists. if they are equal it continues

        if (intList1.size() == intList2.size()) {


            for (int i = 0; i < intList1.size(); i++) {
                if ((intList1.get(i) + intList2.get(i) < ADDCAP)) {
                    if (handleOneUp == false) {
                        solution.add(intList1.get(i) + intList2.get(i));
                    } else {

                        if (intList1.get(i) + intList2.get(i) == 9 && (handleOneUp == true)) {
                            solution.add(0);
                            handleOneUp = true;
                        } else {
                            solution.add(intList1.get(i) + intList2.get(i) + ADDCARRY);
                            handleOneUp = false;
                        }
                    }
                } else {
                    if (handleOneUp == true) {
                        solution.add(intList1.get(i) + intList2.get(i) - ADDCAP + 1);
                    } else {
                        solution.add(intList1.get(i) + intList2.get(i) - ADDCAP);
                    }
                    handleOneUp = (true);

                }
            }
        } else if (intList1.size() < intList2.size()) {
            additiveLengthSeperation(store(two), store(one));

        } else {
            additiveLengthSeperation(store(one), store(two));

        }
        toString(reverseList(solution));

    }


    private void additiveLengthSeperation(ArrayList<Integer> larger, ArrayList<Integer> smaller) {
        for (int i = smaller.size(); i < larger.size(); i++) {
            smaller.add(0, 0);
        }
        addAlgo(toStringReturn(larger), toStringReturn(smaller));
    }


    public void subtract(String one, String two) {
        boolean[] returnWhichAreNegative = handleNegative(one, two);


        if (returnWhichAreNegative[0] == false && returnWhichAreNegative[1] == false) {
            // If they both come as false. Both Strings one and two are positive.
            // Therefore, we can send it straight to the subtractAlgo Method
            if (validifyInput(one) && validifyInput(two)) { // this will check that both are valid Strings
                subtractAlgo(store(one), store(two));
            }
        } else if (returnWhichAreNegative[0] == true && returnWhichAreNegative[1] == false) {

            if (validifyInput(one.substring(1)) && validifyInput(two)) {
                isBigIntNegative = true;
                addAlgo(one.substring(1), two);


            }
        } else if (returnWhichAreNegative[0] == false && returnWhichAreNegative[1] == true) {

            if (validifyInput(one) && validifyInput(two.substring(1))) {
                addAlgo(one, two.substring(1));

            }


        }
    }

    public void subtractAlgo(ArrayList<Integer> BigIntOne, ArrayList<Integer> BigIntTwo) {
        ArrayList<Integer> answer = new ArrayList<>();

        boolean takeOne = false;

        if (BigIntOne.size() == BigIntTwo.size()) {
            ArrayList<Integer> reversedBigIntOne = reverseList(BigIntOne);
            ArrayList<Integer> reverseBigIntTwo = reverseList(BigIntTwo);

            int maxForLoopSize = reversedBigIntOne.size();


            for (int i = 0; i < maxForLoopSize; i++) {
                // 2 2 2
                // 3 3 0
                if (reversedBigIntOne.get(i) - reverseBigIntTwo.get(i) >= 0) {
                    if (takeOne == false) {
                        answer.add(reversedBigIntOne.get(i) - reverseBigIntTwo.get(i));
                    } else {
                        if (reversedBigIntOne.get(i) - reverseBigIntTwo.get(i) != 0) {
                            answer.add(reversedBigIntOne.get(i) - reverseBigIntTwo.get(i) - 1);
                            takeOne = false;
                        } else {
                            answer.add(reversedBigIntOne.get(i) - reverseBigIntTwo.get(i) - 1 + SUBBORROW);
                            takeOne = true;
                        }
                    }
                } else {
                    if (takeOne == false) {
                        answer.add(reversedBigIntOne.get(i) - reverseBigIntTwo.get(i) + SUBBORROW);
                        takeOne = true;
                    } else {
                        answer.add(reversedBigIntOne.get(i) - reverseBigIntTwo.get(i) + SUBBORROW - 1);
                    }
                }
            }
        } else if (unequalLengthSolver(BigIntOne.size(), BigIntTwo.size()) == true) {
            for (int var = BigIntTwo.size(); var < BigIntOne.size(); var++) {
                BigIntTwo.add(0, 0);
            }
            subtractAlgo(BigIntOne, BigIntTwo);
        } else {
            for (int var = BigIntOne.size(); var < BigIntTwo.size(); var++) {
                BigIntOne.add(0, 0);
            }
            isBigIntNegative = true;
            subtractAlgo(BigIntTwo, BigIntOne);
        }
        toString(reverseList(answer));

    }

    public static void main(String[] args) {
        BigInt e = new BigInt();
        e.subtract("111", "222");
        System.out.println();
        e.subtract("222", "111");


    }

}



