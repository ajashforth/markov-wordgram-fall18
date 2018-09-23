/**
 * WordGram objects represent a k-gram of strings/words.
 * 
 * @author YOUR-NAME
 *
 */

public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int k = 0; k < size; k++) {
			myWords[k] = source[start + k];
		}
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
	    if(this.myWords.length != wg.myWords.length) {
	    	return false;
	    }
		return true;
	}

	@Override
	public int hashCode(){
		if(this.myHash == 0) {
			this.myHash = this.myWords.toString().hashCode();
		}
		return this.myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		String[] theseWords = new String[myWords.length];
		for(int k = 1; k < myWords.length; k++) {
			theseWords[k-1] = myWords[k];
		}
		theseWords[myWords.length - 1] = last;
		WordGram wg = new WordGram(theseWords,0,myWords.length);
		return wg;
	}

	@Override
	public String toString(){
		if(myToString == null) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
