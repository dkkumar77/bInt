import java.util.ArrayList;


public class BigInt implements BigIntInterface  {

    /*
     / OPERATOR
     * add
     * subtract
     * multiply
     * divide


     /MISC
     * length
     * setIntoArrayList
     * BigIntToString
     * absoluteVal
     * greaterThan
     * sqrtRoot
     * logicalShiftLeft
     * logicalShiftRight
     * power
     * negate
     * max
     * min
     * modulus
     * probablePrime
     */

    private String BigIntString;

    private int lengthBigInt;

    private ArrayList<Integer> list = new ArrayList<>();



    public BigInt(String num) {

        if (stringValidity(num) == true) {
            this.BigIntString = num;
            this.lengthBigInt = num.length();
            storeContents(num);

        }
        else{
            System.out.println("BigInt Invalid");

        }

    }

    private boolean stringValidity(String num){
        if(!(num.contains("[a-zA-Z]+"))){
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

    @Override
    public void add(String s1, String s2) {

    }

    @Override
    public void subtract(String s1, String s2) {

    }



}
