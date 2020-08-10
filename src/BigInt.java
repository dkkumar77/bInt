import java.util.ArrayList;

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
    private boolean negate = false;
    private boolean isBigIntNegative;

    private boolean solutionCharged = false;

    /*
        Creates an object 'BigInt' when passing in a String.
        The string is first passed into a Validator method
        that confirms that the String that is inputted
        only contains Integer values. Once the boolean value of
        that method returns back true, the storeContents method is
        then called in which. Each character of the array is stored
        into "list" which was the ArrayList of Integers.
     */
    public BigInt(String num) {
        if (num.charAt(0) == '-') {
            num = num.substring(1);
            isBigIntNegative = true;
        }
        if (stringValidity(num) == true) {
            /*
            Sets the string parameter equal to the String
            value of BigIntString while also setting the length
            of the String, to the lengthBigInt, which lets us
            keep track of the length of the local Big Int value.
             */

            this.BigIntString = num;
            this.lengthBigInt = num.length();
            storeContents(num);

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


    private boolean lengthEquality(int h, int k) {
        if (h == k) {
            return true;
        } else return false;

    }

    private boolean lengthInequality(int h, int k) {
        if (h > k) {
            return true;
        } else {
            return false;

        }
    }

    public int length() {
        return list.size();

    }

    private int length(String s) {
        if (stringValidity(s) == true) {
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

    private boolean stringValidity(String num) {
        String regex = "[0-9]+";
        if ((num.matches(regex))) {
            return true;

        }
        return false;
    }


    private void storeContents(String string) {
        for (int i = 0; i < lengthBigInt; i++) {
            list.add(Integer.parseInt(Character.toString(string.charAt(i))));

        }
    }

    private ArrayList<Integer> store(String s) {
        int length = s.length();
        ArrayList<Integer> temporaryContainer = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            temporaryContainer.add(Integer.parseInt(String.valueOf(s.charAt(i))));
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


    /*
    @Override
    public void subtract(String s1, String s2) {
        boolean[] tester = handleNegative(s1, s2);


        if (tester[0] == false && tester[1] == false) {
            if (stringValidity(s1) & stringValidity(s2)) {
                subtractAlgo(s1, s2);
            }
        } else if (tester[0] == true && tester[1] == true) {
            if (negativeStringValidity(s1.substring(1)) && negativeStringValidity(s2.substring(1))) {
                isBigIntNegative =true;
                subtractAlgo(s2.substring(1), s1.substring(1));
            }
        } else if (tester[0] == false && tester[1] == true) {
            if(negativeStringValidity(s2.substring(1)) && stringValidity(s1)){
                addAlgo(s1, s2.substring(1));
            }
        }
        else if(tester[0] == true && tester[1] == false){
            if(negativeStringValidity(s1.substring(1)) && stringValidity(s2)){
                isBigIntNegative = true;
                addAlgo(s1.substring(1), s2);

            }

        }

    }


     */
    private boolean negativeStringValidity(String s1) {

        if (stringValidity(s1)) {
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


    public void add(String one, String two) {


        boolean[] isNeg = handleNegative(one, two);

        if (isNeg[0] == false && isNeg[1] == false) {
            if (stringValidity(one) & stringValidity(two)) {
                addAlgo(one, two);
            }
        } else if (isNeg[0] == true && isNeg[1] == true) {
            // -A + -B
            if (negativeStringValidity(one.substring(1)) && negativeStringValidity(two.substring(1))) {
                isBigIntNegative = true;
                add(one.substring(1), two.substring(1));

            }
        } else if (isNeg[0] == false && isNeg[1] == true) {
            //A + -B
            if (negativeStringValidity(two.substring(1)) && stringValidity(one)) {
                subtractAlgo(store(one), store(two.substring(1)));
            }
        } else if (isNeg[0] == true && isNeg[1] == false) {
            // -A + B
            if (negativeStringValidity(one.substring(1)) && stringValidity(two)) {
                subtract(one.substring(1), two);


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
        boolean [] returnWhichAreNegative = handleNegative( one, two);

        if(returnWhichAreNegative[0] == false && returnWhichAreNegative[1] == false) {
            // If they both come as false. Both Strings one and two are positive.
            // Therefore, we can send it straight to the subtractAlgo Method
            if (stringValidity(one) && stringValidity(two)) { // this will check that both are valid Strings
                subtractAlgo(store(one), store(two));
            }
        }
        else if(returnWhichAreNegative[0] == true && returnWhichAreNegative[1] == false) {

            if (stringValidity(one.substring(1)) && stringValidity(two)) {
                isBigIntNegative = true;
                addAlgo(one.substring(1), two);


            }
        }
        else if(returnWhichAreNegative[0] == false && returnWhichAreNegative[1] == true){

            if(stringValidity(one) && stringValidity(two.substring(1))){
                addAlgo(one,two.substring(1));

            }


        }
    }

    public void subtractAlgo(ArrayList<Integer> one, ArrayList<Integer> two ) {
        ArrayList<Integer> solution = new ArrayList<>();

        boolean borrow = false;

        if (one.size() == two.size()) {
            ArrayList<Integer> reversed = reverseList(one);
            ArrayList<Integer> reversed2 = reverseList(two);

            int forLoopSize = reversed.size();


            for (int i = 0; i < forLoopSize; i++) {
                // 2 2 2
                // 3 3 0
                if (reversed.get(i) - reversed2.get(i) >= 0) {
                    if(borrow == false) {
                        solution.add(reversed.get(i) - reversed2.get(i));
                    }
                    else{
                        if(reversed.get(i) - reversed2.get(i) != 0) {
                            solution.add(reversed.get(i) - reversed2.get(i) - 1);
                            borrow = false;
                        }
                        else{
                            solution.add(reversed.get(i) - reversed2.get(i) - 1 + SUBBORROW);
                            borrow = true;
                        }

                    }

                }
                else{

                    if(borrow == false) {
                        solution.add(reversed.get(i) - reversed2.get(i) + SUBBORROW);
                        borrow = true;
                    }
                    else{
                        solution.add(reversed.get(i) - reversed2.get(i) + SUBBORROW -1 );


                    }

                }
            }

            }

        else if (lengthInequality(one.size(), two.size()) == true) {

                for (int var = two.size(); var < one.size(); var++) {
                    two.add(0, 0);
                }

                subtractAlgo(one, two);
            } else {

                for (int var = one.size(); var < two.size(); var++) {
                    one.add(0, 0);
                }


                isBigIntNegative = true;
                subtractAlgo(two, one);
            }


            toString(reverseList(solution));

        }




/*


 */

    public static void main(String[] args) {
        BigInt e = new BigInt();
        e.subtract("2345212341324345234123413241324123413457892349857294385729348579283457893247598234985723498579345345","34212342345872934589023475091323452345234533");


    }
}


/*

    public BigInt(int rand){
        Random r = new Random();
        int arbitraryLength = r.nextInt(350);
        String arbitraryBigInt = "";
        for(int i = 0; i<arbitraryLength; i++){
            arbitraryBigInt = arbitraryBigInt + r.nextInt(10);
        }

        this.BigIntString = arbitraryBigInt;
        this.lengthBigInt = arbitraryLength+1;
        storeContents(BigIntString);
    }


 */

    /*

    public void subtractAlgo(ArrayList<Integer<>> one, String two) {
        if (stringValidity(one) && stringValidity(two)) {
            ArrayList<Integer> e = reverseList(store(one));
            ArrayList<Integer> e2 = reverseList(store(two));
            ArrayList<Integer> temp = new ArrayList<>();


            if (lengthEquality(one.length(), two.length())) {
                int forSize = one.length();
                boolean takeAway = false;
                for (int i = 0; i < forSize; i++) {
                    // [ 1 , 2, 3 , 4 ]
                    // [ 2 , 2,  2, 2 ]

                    /*
                       4  3  2  1
                       2  2  2  2

                       1  1  1  1
                       9  9  9  9
                     */
    /*

                    if (e.get(i) - e2.get(i) < 0) {
                        if (takeAway == false) {
                            takeAway = true;
                            temp.add(Math.abs(e.get(i) - e2.get(i)));
                        } else if (takeAway == true) {
                            temp.add(Math.abs(e.get(i) + e2.get(i) - 1));


                        }
                    }
                    else{
                        if(takeAway == false) {
                            temp.add(e.get(i) - e2.get(i));
                        }
                        else if(takeAway == true){
                            temp.add(e.get(i) - e2.get(i) - 1);
                            takeAway = false;


                        }


                    }
                }
            }

            else if (lengthInequality(one.length(), two.length()) == true) {

                    // A - B where A is greater in length, solution will always be positive.
                    for (int var = two.length(); var < one.length(); var++) {
                        e2.add(0);
                    }

                    subtractAlgo(toStringReturn(reverseList(e)), toStringReturn(reverseList(e2)));
                } else {
                    subtractAlgo(toStringReturn(reverseList(e2)), toStringReturn(reverseList(e)));
                }

                toString(reverseList(temp));


            }


     */





  /*

  COMPLETE
      A+B
      A-(-B)
      -A-B
      -A- -B



      TO DO
      A+-B
      -A+B
      A-
   */