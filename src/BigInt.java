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


    public BigInt(String num) {

        if (stringValidity(num) == true) {
            this.BigIntString = num;
            this.lengthBigInt = num.length();
            storeContents(num);

        } else {
            System.out.println("Invalid Input");

        }


        System.out.println(length());
    }


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


    private int length(){
        return list.size();

    }

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

    public String toString(){

        for (int set = 0; set < list.size(); set++){
            System.out.print(list.get(set));

        }
        return null;
    }


    private ArrayList<Integer> store(String s){
        ArrayList<Integer> temporaryContainer = new ArrayList<>();

        for(int i = 0; i< s.length(); i++){
            temporaryContainer.add(Integer.parseInt(Character.toString(toString().charAt(i))));
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

    private ArrayList<Integer> reverseList(ArrayList<Integer> rList){
        ArrayList<Integer> temporaryContainer = new ArrayList<>(rList.size());
        for(int i = rList.size(); i  > 0; i--){
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
        BigInt e = new BigInt("123");
        e.add("12345","12345");
    }

}
