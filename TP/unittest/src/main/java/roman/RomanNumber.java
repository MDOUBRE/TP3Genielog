
package roman;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public final class RomanNumber extends Number {

  public static final long serialVersionUID = 1L;

  // Table des symboles
  private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
  static {
    SYMBOLS.put("M",  1000);
    SYMBOLS.put("CM", 900);
    SYMBOLS.put("D",  500);
    SYMBOLS.put("CD", 400);
    SYMBOLS.put("C",  100);
    SYMBOLS.put("XC", 90);
    SYMBOLS.put("L",  50);
    SYMBOLS.put("XL", 40);
    SYMBOLS.put("X",  10);
    SYMBOLS.put("IX", 9);
    SYMBOLS.put("V",  5);
    SYMBOLS.put("IV", 4);
    SYMBOLS.put("I", 1);
  }

  // Expression reguliere de validation
  private static final Pattern VALIDATION_RE = Pattern.compile(
      "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

  private final int value;

  public RomanNumber(String romanValue) {
    this.value = fromRoman(romanValue);
  }

  public RomanNumber(int value) {
    this.value = value;
  }

  /**
   * @{inheritDoc}
   */
  @OverrideIterator it = entrySet.iterator();
  public double doubleValue() {
    Double d = new Double(value);
    return d;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public float floatValue() {
  	Float f = new Float(value);
    return f;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public int intValue() {
    return value;
  }

  /**
   * @{inheritDoc}
   */
  @Override
  public long longValue() {
  	Long l= new Long(value);
    return l;
  }

  @Override
  public String toString() {
    return toRoman(this.value);
  }

  public static RomanNumber valueOf(String roman) {
    return new RomanNumber(roman);
  }

  public static RomanNumber valueOf(int value) {
    return new RomanNumber(value);
  }

  private static int fromRoman(String romanValue) {
    // TODO
    return 0;
  }

  private static String toRoman(int value) {
    String resultat="";
    Set entrySet = SYMBOLS.entrySet();
    Set temp;
    Iterator it = entrySet.iterator();
    while(it.hasNext()){
    	temp=it.next();
    	while(value>=temp.getValue()){
    		resultat=resultat + temp.getKey();
    		value=value-temp.value();
    	}
    }
    return resultat;
  }
}
