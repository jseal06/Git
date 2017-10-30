//2nd_C
import java.util.*;

/**
 * A StringAnalyser can perform various analyses for several Strings
 * that have been added to it before. In this sense, a StringAnalyser
 * is an "intelligent container" for Strings.
 *
 * The analysis results do not depend on the order in which the Strings
 * have been added since object creation or the last call to the reset()
 * method (if any). Added null elements are ignored by the analyses.
 * Repeated occurrences of the same/equal Strings are allowed.
 *
 * @author TO DO: please enter your name here : James Seal
 */
public class StringAnalyser {

    // TO DO: add and document instance variable(s)
    private ArrayList<String> analyser = new ArrayList<>();
    public ArrayList<String> group = new ArrayList<>();
    public ArrayList<String> list = new ArrayList<>();

    /**
     * Constructs a new StringAnalyser without any Strings.
     */
    public StringAnalyser() {
        // TO DO: write constructor
        analyser.add(null);       
    }

    /**
     * Constructs a new StringAnalyser containing the non-null Strings in
     * strings. The strings array may be modified by the caller afterwards
     * without affecting this StringAnalyser, and it will not be modified by
     * this constructor.
     *
     * @param strings  must not be null; non-null elements are added to the
     *  constructed StringAnalyser
     */
    public StringAnalyser(String[] strings) {
        // 
        //!= null
        strings = strings;
        for(int i = 0; i < strings.length ; i++){
            //non null to be added to constuctor
            String word = strings[i];
            if (word != null){
                //add word
                analyser.add(word);
            }
        }
    }

    /**
     * Adds a String s to this StringAnalyser if s is not null;
     * does not modify this StringAnalyser otherwise.
     *
     * @param s  to be added to this StringAnalyser
     * @return true if s is not null, false otherwise
     */
    public boolean add(String s) {
        // TO DO: write proper method body
        s = s;
        //add non null string to analyser and return true;
        if(s != null){
            analyser.add(s);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Adds all non-null Strings in strings to this StringAnalyser.
     *
     * @param strings  contains the String objects to be added to
     *  this StringAnalyser; must not be null (but may contain null)
     * @return true if at least one element of strings is non-null;
     *  false otherwise
     */
    public boolean addAll(String[] strings) {
        // TO DO: write proper method body
        //return flag true if one element is not null.
        strings = strings;
        boolean flag = false;
        for(int i = 0 ; i < strings.length ; i++){
            String word = strings[i];
            if (word != null){
                analyser.add(word);
                flag = true;
            }
        }
        if (flag == true){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Resets this StringAnalyser to a StringAnalyser that contains 0 Strings.
     */
    public void reset() {
        // clears all for anaylser
        analyser.clear();
    }

    /**
     * Returns how many non-null Strings this StringAnalyser contains.
     *
     * @return how many non-null Strings this StringAnalyser contains
     */
    public int numberOfStrings() {
        // TO DO: write proper method body
        int count = 0;
        for(String word : analyser){
            if(word != null){
                count++;
            }
        }
        return count;
    }

    /**
     * Returns how many distinct non-null Strings this StringAnalyser
     * contains. We say that two non-null Strings x and y are
     * <i>distinct</i> if x.equals(y) evaluates to false.
     *
     * @return how many distinct non-null Strings this StringAnalyser contains
     */
    public int numberOfUniqueStrings() {
        // TO DO: write proper method body
        //boolean flag = false;
        
        int distinct = 0;
        
        if(analyser.size()>0){
            for(int i = 0 ; i < analyser.size(); i++){
                String mm = analyser.get(i);
                if((analyser.get(i) != null) && (analyser.get(i) != "")){
                    for(int k = 0 ; k < analyser.size(); k++){
                        String kk = analyser.get(k);
                        if((analyser.get(k) != null) && (analyser.get(k) != "")){
                            
                          
                            if (analyser.get(i).equals(analyser.get(k))){
                                // contains method not working on list must change
                                if(list.contains(analyser.get(i))){
                                    list.add(analyser.get(i));
                                    
                                    distinct++;
                                }
                            }
                            
                        }
                        
                    }
                    
                }
                
            }
        }
        /*
        int count = 0;
         for (int i = 0 ; i < analyser.size(); i++){
            String word1 = analyser.get(i);
            for (int j = 1; j < analyser.size(); j++){
                String word2 = analyser.get(j);
                if((word1 != null)&&(word1.equals(word2))){
                    group.add(word1);
                    //flag = true;
                }else{
                    group.add(word1);
                }
            }
            if(group.size()>0){
                count++;
                //if (i == analyser.size()){
                //    break;
                //}
            }
        }
        */
        
        /*
        for (int i = 0 ; i < analyser.size(); i++){
            String word1 = analyser.get(i);
            for (int j = 1; j < analyser.size(); j++){
                String word2 = analyser.get(j);
                if((word1 != null)&&(word1.equals(word2))){
                    flag = true;
                }
            }
            if(flag == true){
                count++;
                if (i == analyser.size()){
                    break;
                }
            }
        }
        */
        //return count;
        return distinct;
    }

    /**
     * Returns the sum of the lengths of all (non-null) Strings in this StringAnalyser.
     *
     * @return the sum of the lengths of all (non-null) Strings in this StringAnalyser
     */
    public int totalLength() {
        // TO DO: write proper method body
        int totalLength = 0;
        for (int i = 0 ; i < analyser.size(); i++){
            //for (String i : analyser){
            //totalLength = totalLength + i.length();
            String n = analyser.get(i);
            if (n != null){
                totalLength = totalLength + n.length();
            }
        }
        return totalLength;
    }


    /**
     * Class method to return the sum of all String lengths in all elements
     * of analysers. For example, if analysers contains two StringAnalysers,
     * one with the contents "Alice" and "Bob" and one with the contents
     * "George", the result will be (5 + 3) + 6 = 14.
     *
     * Entries of the array analysers may be null, and these entries should be
     * ignored in the computation. So if in the above example we had an
     * additional third array entry null, the result would be exactly
     * the same.
     *
     * @param analysers  must not be null, but may contain null
     * @return the sum of all (non-null) String lengths in all elements of analysers
     */
    public static int totalLength(StringAnalyser[] analysers) {
        // TO DO: write proper method body
        analysers = analysers;
        String names = "";
        int total = 0;
        for (int i = 0; i < analysers.length; i++){
            if (analysers[i] != null){
                names += analysers[i];
                total += names.length();               
                }
            }
        return total;
    }

    /**
     * Returns the average length of the (non-null) Strings in this StringAnalyser.
     * In case there is no String in this StringAnalyser, -1.0 is returned.
     *
     * For example, if this StringAnalyser has the contents "A" and "Bc",
     * the result is 1.5.
     *
     * @return the average length of the Strings in this StringAnalyser,
     *  or -1.0 if there is no such String.
     */
    public double averageLength() {
        // TO DO: write proper method body
        //total/numberOfItems
        double totalLength = 0.0;
        int count = 0;
        double t = 0.0;
        if(analyser.size() == 0){
            return -1.0;
        }else{
            for(int i = 0 ; i < analyser.size() ; i++ ){
                if (analyser.get(i) != null){
                    String n = analyser.get(i);
                    totalLength += n.length();
                    count++;
                }
            }
            t = totalLength/count;
        }
        if (t > 0.0){
            return t;
        }else{
            return - 1.0;
        }
    }

    /**
     * Returns how many of the Strings in this StringAnalyser contain
     * at least one upper-case character.
     *
     * For example, if this StringAnalyser contains "a", "bC", and
     * "DEfGH", the result is 2 ("a" is not counted because it does
     * not contain an upper-case character, but the other two Strings
     * contain at least one upper-case character each, so they are both
     * counted).
     *
     * @return the number of Strings in this StringAnalyser that
     *  contain at least one upper-case character, as determined by
     *  the class method boolean isUpperCase(char c) of the class Character
     */
    public int numberOfStringsWithUpperCaseChars() {
        // TO DO: write proper method body
        boolean flag = false;
        int count = 0;
        for(int i = 0; i < analyser.size(); i++){
            String word = analyser.get(i);
            if(word != null){
                for (int k = 0; k < word.length(); k++){
                    
                        char ch = word.charAt(k);
                        if (Character.isUpperCase(ch)){
                            flag = true;
                        }
                    }
            }
            if (flag == true){
                count++;
                flag = false;
            }
        }
        return count;
    }

    /**
     * Returns the greatest String in this StringAnalyser with respect
     * to the "natural ordering" of String, which is induced by the
     * instance method boolean compareTo(String s) of the class String.
     *
     * @return the greatest String in this StringAnalyser, where "greatest"
     *  is defined with respect to String.compareTo(String s); null if this
     *  StringAnalyser contains no String objects.
     */
    public String getGreatest() {
        // TO DO: write proper method body
        /*int count = 0;
        String greatest = "";
        //int greatestNo = 0;
        if(analyser != null){
            for (int i = 0 ; i < analyser.size(); i++){
                String word1 = analyser.get(i);
                for (int j = 1; j < analyser.size(); j++){
                    String word2 = analyser.get(j);
                    if(word1 != null ){
                        System.out.println(word1.compareTo(word2));
                        int n = (word1.compareTo(word2));
                        System.out.println("this is 1 : "+ word1 + " this is 2 : "+word2);
                        if (n > greatest.length()){
                            greatest = word1;
                        }
                        //flag = true;
                    }else {
                        return null;
                        //System.out.println("***2**");
                    }
                }
            }
            System.out.println("***"+greatest+"**");
            return greatest;
        }else{
            return null;
        }
        */
        return null;
        }
        
        
    

    /**
     * Returns a String representation for the contents of this
     * StringAnalyser.
     *
     * The String representation starts with a "[" and ends with a "]".
     * The Strings are separated by ", ". The order of the Strings from
     * this StringAnalysis in its String representation is
     * implementation-specific (i.e., it does not matter, and callers
     * should not rely on any particular order).
     *
     * For example, if this StringAnalyser contains the Strings
     * "Alice", "Bob", and "Alice", the three possible valid
     * results are "[Alice, Bob, Alice]" or "[Alice, Alice, Bob]"
     * or "[Bob, Alice, Alice]".
     *
     * @return a String representation of the Strings that have been added
     *  to this in the constructor or via the add/addAll methods
     *  since object construction or since the last reset() (if any) 
     */
    public String toString() {
        // TO DO: write proper method body
        String c = "[";
        int count = 0;
        // int i = 0;
        if(analyser.size()>0){
            for(int i = 0 ; i < analyser.size(); i++){
                if((analyser.get(i) != null) && (analyser.get(i) != "")){
                    //String mm = analyser.get(i);
                    if (count == 0){
                        c += analyser.get(i);
                        count++;
                    }else{
                        c += ", "+analyser.get(i);
                    }
                }
            }
        }
        c += "]";
        return c;
    }
}




















