public class StringPractice {
  /* returns true if c is a punctuation mark or false otherwise
   * 
   * Punctuation mark is defined as:
   * apostrophe '
   * comma ,
   * period .
   * semicolon ;
   * colon :
   * exclamation point !
   * question mark ? 
   * 
   * (You don't have to worry about any others)
   */
  public static boolean isPunct(char c) 
  {
	if(c == '\'' || c == ',' || c == '.'|| c == ';' || c == ':' || c == '!' || c == '?')
	{
		return true;
	}
	else 
		{
		return false;
		}
  }

  /*
   * returns the number of punctuation marks
   * found in s.
   *
   * call your isPunct( ) method. Do not compy and paste
   * the same logic into this function */
  public static int numPunct(String s) {
	  int counter = 0;
	  for(int i = 0; i < s.length(); i++)
	  {
		  char c = s.charAt(i);
		  if(isPunct(c))
		  {
			  counter++;
		  } 
	  }
    return counter;
  }
  
  /*
   * returns the number of punctuation marks
   * found in s starting at the given index.
   *
   * call your isPunct( ) method. Do not compy and paste
   * the same logic into this function */
  public static int numPunct(String s, int startIndex) {
	  int counter = 0;
	  String slice;
	  try
	  {
		  slice = s.substring(startIndex);
	  }
	  catch(IndexOutOfBoundsException e)
	  {
		  return 0; 
	  }
	  char[] string_array = slice.toCharArray();
	  for(int i = 0; i < string_array.length; i++)
	  {
		  if(isPunct(string_array[i]))
		  {
			  count++; 
		  }
	  }
	  
    return count;
  }

  /*
   * returns the index of the first occurrence
   * of a punctuation mark in s starting
   * from index startPosition or -1 if there are
   * none at index startPosition or later.
   *
   * When implementing this function, call your isPunct( ) method.
   * Do not simply copy and paste the body of isPunct( ) into this method.
   */
  public static int indexOfFirstPunct(String s, int startPosition) {
	  String slice;
	  try 
	  {
		  slice = s.substring(startPosition)
	  }
	  catch(IndexOutOfBoundsException e)
	  {
		  return -1; 
	  }
	  char[] string_array = sliced.toCharArray();
	  for(int i = 0; i < string_array.length; i++)
	  {
		  if(isPunct(string_array[i]))
		  {
			  return i + startPostion;
		  }
	  }
	  return -1;
  }

  /*
   * returns the index of the first punctuation mark in s or
   * -1 if s contains no punctuation marks
   *
   * use your solution to indexOfFirstPunct(String s, int startPosition)
   * in this function. Do not repeat the same logic.
   * 
   * Notice that this method has the same name as the
   * previous one, but that it takes a different number of arguments. This is
   * perfectly legal in Java. It's called "method overloading"
   *
   */
  public static int indexOfFirstPunct(String s) {
	  
	  char[] string_array = s.toCharArray();
	  for(int i = 0; i < string_array.length; i++)
	  {
		 if(isPunct(string_array[i]))
		 {
			 return i;
		 }
		   
	  }
	  
	  
    return -1;
  
  }

  /*
   * returns the index of the last occurrence of a punctuation
   * mark in s or -1 if s contains no punctuation
   * 
   * When implementing this function, call your isPunct( ) method.
   * Do not simply copy and paste the body of isPunct( ) into this method.
   */
  public static int indexOfLastPunct(String s) {
	  char[] string_array = s.toCharArray();
	  for(int i = string_array.length - 1; i >= 0; i--)
	  {
		  if(isPunct(string_array[i]))
		  {
			  return i;
		  }
	  }
	  
    return -1;
  }

  /*
   * returns a new String which is the same as s but with
   * each instance of oldChar replaced with newChar
   */
  public static String substitute(String s, char oldChar, char newChar) {
	  char[] string_array = s.toCharArray();
	  for(int i = 0; i < string_array.length; i++)
	  {
		  if(string_array[i] == oldChar)
		  {
			  string_array[i] = newChar; 
		  }
	  }
    return new String(string_array);
  }

  /*
   * returns a new String which is the same as s, but
   * with each instance of a punctuation mark replaced
   * with a single space character
   *
   * Use at least one of your other functions in your
   * solution to this.
   *
   */
  public static String substitutePunct(String s) {
	  char[] string_array = s.toCharArray();
	  for(int i = 0; i < string_array.length; i++)
	  {
		  if(isPunct(string_array[i]))
		  {
			  string_array[i] = ''; 
		  }
	  }
	  
    return new String(string_array);
  }
  
  /*
   * returns a new String which is the same as s,
   * but with all of the punctuation
   * marks removed.
   *
   * Use at least one of your other functions
   * in your solution to this one.
   * 
   */
  public static String withoutPunct(String s) {
	  char[] string_array = s.toCharArray(); 
	  StringBuilder sb = new StringBuilder(); 
	  for(int i = 0; i < string_array.length; i++)
	  {
		  if(!isPunct(string_array[i]))
		  {
			  sb.append(string_array[i]);
		  }
	  }
    return sb.toString();
  }

  /* returns true if c is found in s or false otherwise */
  public static boolean foundIn(String s, char c) {
	  char[] string_array = s.toCharArray(); 
	  for(int i = 0; i < string_array.length; i++)
	  {
		  if(string_array[i] == c)
		  {
			  return true; 
		  }
	  }
    return false;
  }

  /*
   * Returns true of s contains none of the characters
   * found in chars or false otherwise.
   */
  public static boolean containsNone(String s, String chars) {
	  char[] string_array = s.toCharArray();
      char[] chars_array = chars.toCharArray();
      for (int i = 0; i < string_array.length; i++) {
          for (int j = 0; j < chars_array.length; j++) {
              if (string_array[i] == chars_array[j]) {
                  return false;
              }
          }
      }
      return true;
  }
  
  /*
   * Returns true of s is comprised of only punctuation or
   * false otherwise
   *
   * Use at least one of your other
   * functions in this one.
   */
  public static boolean onlyPunct(String s) {
	  char[] string_array = s.toCharArray();
      for (int i = 0; i < string_array.length; i++) {
          if (!isPunct(string_array[i])) {
              return false;
          }
      }
      return true;
  }

  /*
   * Returns true of s contains no punctuation or
   * false otherwise
   *
   * Use at least one of your other
   * functions in this one.
   */
  public static boolean noPunct(String s) {
	  char[] string_array = s.toCharArray();
      for (int i = 0; i < string_array.length; i++) {
          if (isPunct(string_array[i])) {
              return false;
          }
      }
      return true;
  }

  /*
   * returns true if s has two punctuation marks
   * right next to each other or false otherwise
   *
   * use at least one of your other methods
   * in your solution to this method
   */
  public static boolean consecutivePuncts(String s) {
	  char[] string_array = s.toCharArray();
      int j = 0;
      for (int i = 1; i < string_array.length; i++) {
          if (isPunct(string_array[j]) && isPunct(string_array[i])) {
              return true;
          }
          j++;
      }
      return false;
  }
}
