import java.util.ArrayList;
import java.util.Random;


/*
Project Name: Big Integer
Description: The practical application of arbitrarily long integers. As everyone knows
the maximum & minimum values that can be used within the Java language is -2,146,483,658
and it's negative counterpart. However, the purpose of this project is to play around
with much larger numbers, numbers that can theoretically be infinite in length. Java
has it's own Big Integer library. That can be used, however, the purpose of this project
is to understand how one can create their own class that can potentially be used. Some
of the methods that are used within this class, are similar to Java's built in BigInteger
class. For Instance, when creating a Big Integer class, what are some potential methods
that you would want to use?
The programmer must be able to handle negative & positive Big Integer values. Which means
that once a String is inputted, the program should distinguish positive and negative values.
Also, the Big Integer program must be able to add two Big Integers together. In order to accomplish
this, I stored both Big Integers into an arraylist, while also reversing the arraylist, I would use
a standard for loop to loop through and add each of the indexes together, while also taking note
of needing to carry the ONE value if the solution to adding the numbers within a certain index
surpasses value TEN. Along with this, I also made sure to pad each number with zeroes prior to
the for loop, to avoid any solutions that come out null, or any arraylists that don't have an
existing indice to add.



Author: Deepak Kumar
Date: July 28th, 2020



 */
/*

Coverage:


 */
public class BigInt implements BigIntInterface {

    // when calling to the constructor, the parameter string value is store
    // into BigIntString;
    private String BigIntString;

    //var lengthBigInt represents the current length of the BigInteger.
    private int lengthBigInt;

    //ArrayList container for the BigInteger.
    private ArrayList<Integer> list = new ArrayList<>();

    // ADDCAP is a final var that is deemed as the threshold point when it comes to adding
    // any results that pass ADDCAP, ADDCARRY will be added to the solution in the next
    // iteration of the for loop.
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
                subtract(BigIntegerTwo, BigIntegerOne.substring(1));


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


    public void multiply(String one, String two){
        boolean [] negHandler = handleNegative(one, two);

        if((negHandler[0] == negHandler[1]){
            if(negativeStringValidity()){



        }

    }
    }
    public void multiplyAlgo(){

    }
    public static void main(String[] args) {


    }


}



