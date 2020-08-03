import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class BigInt implements BigIntInterface  {

    /*
     / OPERATOR
     * add
     * subtract
     * multiply
     * divide

     */

    private boolean negative = false;

    private String BigIntString;

    private int lengthBigInt;

    private ArrayList<Integer> list = new ArrayList<>();

    private static final int ADDCAP = 10;
    private static final int ADDCARRY = 1;


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

        }


        // System.out.println(length());
    }
    /*
    This constructor will do something. I dont know what yet.
     */
    public BigInt(int temp){


    }

        /* Creates a random BigInt value of a size that ranges from 0-350.
           Using the random iterator it will produce random number values 1-9
           continuously until it reaches the randomly generated size.
           Soon after, if this constructor is called for. The values of BigIntString
           and lengthBigInt will be set to the physical value itself, and the size
           of the number, respectively.

         */
    public BigInt(){
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

    /*
        Prints out the size of the local "list value".
     */
    public int length(){
        return list.size();

    }

    /*
        First checks that the String is indeed valid to
        be a Big Int, then it returns the size;
        If Invalid, it will return 0;
     */
    public int length(String s){
        if(stringValidity(s) == true){
            return s.length();
        }
        else{
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

    private boolean stringValidity(String num){
        String regex = "[0-9]+";
        if((num.matches(regex))){
            return true;

        }
        return false;
    }

    private void storeContents(String string){
        for(int i = 0; i < lengthBigInt; i++){
            list.add(Integer.parseInt(Character.toString(string.charAt(i))));

        }



    }

    /*
        toString() returns the list
     */

    public String toString(){

        for (int set = 0; set < list.size(); set++){
            System.out.print(list.get(set));

        }
        return null;
    }

    public void toString(ArrayList<Integer> number){

        for(int i = 0; i < number.size();i++){
            System.out.print(number.get(i));
        }

    }


    public String toModifiedString(ArrayList<Integer> list){
        String s = "";

        for(int i = 0; i< list.size();i++){
            s = s + list.get(i);


        }
        return s;

    }
    /*

     */
    private ArrayList<Integer> store(String s){

        int length = s.length();
        ArrayList<Integer> temporaryContainer = new ArrayList<>(s.length());

        for(int i = 0; i< s.length(); i++){
            temporaryContainer.add(Integer.parseInt(String.valueOf(s.charAt(i))));


        }
        return temporaryContainer;

    }
    @Override
    public void add(String s1, String s2) {
        ArrayList<Integer> container1 = store(s1);
        ArrayList<Integer> container2 = store(s2);
        if(!(lengthEquality(s1.length(),s2.length()))){
            if(lengthEquality(s1.length(),s2.length()) == true){
                additiveAlgorithm(container2,container1);
            }
            else{
                additiveAlgorithm(container1, container2);
            }
        }
        else{
                additiveAlgorithm(container1, container2);
        }

    }

    public String additiveAlgorithm(ArrayList<Integer> topAddend, ArrayList<Integer> bottomAddend){
        topAddend = reverseList(topAddend);
        bottomAddend = reverseList(bottomAddend);

        System.out.println(topAddend.toString());
        System.out.println(bottomAddend.toString());


        return "hi";

    }

    public void addAlgo(String one, String two){
        ArrayList<Integer> intList1 = reverseList(store(one));
        ArrayList<Integer> intList2 = reverseList(store(two));
        boolean handleOneUp = false;
        ArrayList<Integer> solution = new ArrayList<>();


        if(intList1.size() == intList2.size()){



            for(int i = 0; i< intList1.size(); i++){
                if((intList1.get(i)+intList2.get(i) < ADDCAP)){
                    if(handleOneUp == false) {
                        solution.add(intList1.get(i) + intList2.get(i));
                    }
                    else{

                        if(intList1.get(i) + intList2.get(i) == 9 && (handleOneUp == true)){
                            solution.add(0);
                            handleOneUp = true;
                        }
                        else {
                            solution.add(intList1.get(i) + intList2.get(i) + ADDCARRY);
                            handleOneUp = false;
                        }

                    }
                }
                else{
                    if(handleOneUp == true){
                        solution.add(intList1.get(i) + intList2.get(i) - ADDCAP + 1);
                    }
                    else {
                        solution.add(intList1.get(i) + intList2.get(i) - ADDCAP);
                    }
                    handleOneUp =(true);

                }

            }


        }
        else if(intList1.size() > intList2.size()){
            additiveLengthSeperation(store(one), store(two));

        }
        else{
            additiveLengthSeperation(store(two), store(one));

        }



        toString(reverseList(solution));

    }

    public void additiveLengthSeperation(ArrayList<Integer> larger, ArrayList<Integer> smaller){


        for(int i= smaller.size(); i<larger.size(); i++){
            smaller.add(0,0);
        }
        addAlgo(toModifiedString(larger),toModifiedString(smaller));

    }




    private ArrayList<Integer> reverseList(ArrayList<Integer> rList){
        int tempSize = rList.size();
        ArrayList<Integer> temporaryContainer = new ArrayList<>(tempSize);
        for(int i = rList.size()-1; i > -1; i--){
            temporaryContainer.add(rList.get(i));

        }

        return temporaryContainer;


    }


    private boolean lengthEquality(int h, int k){
        if(h == k){
            return true;
        }
        else return false;

    }

    private boolean lengthInequality(int h, int k){
        if(h<k){
            return true;
        }
        else{
            return false;

        }
    }
    @Override
    public void subtract(String s1, String s2) {

    }


    public static void main(String[] args) {
        BigInt e = new BigInt(2);
        e.addAlgo("12345674123","123456");


    }

}
