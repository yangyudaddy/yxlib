package yyl.utils;


/**
 * ——感觉自己萌萌哒——
 * +   /\_/\     +
 * + =( °w° )=   +
 * +   )   (  // +
 * + (__ __)//   +
 * +++++++++++++++
 * <p>
 * author: yangxiaoling
 * Create_Date:   2018/2/9 下午2:34
 * Package_NAME  yyl.utils
 * Describe:
 */

final class IDKey {
    private final Object value;
    private final int id;

    /**
     * Constructor for IDKey
     * @param _value The value
     */
    public IDKey(Object _value) {
        // This is the Object hashcode
        id = System.identityHashCode(_value);
        // There have been some cases (LANG-459) that return the
        // same identity hash code for different objects.  So
        // the value is also added to disambiguate these cases.
        value = _value;
    }

    /**
     * returns hashcode - i.e. the system identity hashcode.
     * @return the hashcode
     */
    public int hashCode() {
        return id;
    }

    /**
     * checks if instances are equal
     * @param other The other object to compare to
     * @return if the instances are for the same object
     */
    public boolean equals(Object other) {
        if (!(other instanceof IDKey)) {
            return false;
        }
        IDKey idKey = (IDKey) other;
        if (id != idKey.id) {
            return false;
        }
        // Note that identity equals is used.
        return value == idKey.value;
    }
}
