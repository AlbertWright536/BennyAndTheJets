/**
* @author Leo Ureel
* A class that associates a key with a value.
*/
public class KeyValuePair< K, V extends Comparable< V > > {
    // -------------------------------------------------------------------
    // DATA MEMBERS WITH GETTER AND SETTERS
    // -------------------------------------------------------------------
    /**
    * The key
    */
    private K key = null;
    public K getKey( ) {
        return key;
    }
    public void setKey( K key ) {
        this.key = key;
    }
    /*
    * The value associated with the key
    */
    private V value = null;
    public V getValue( ) {
        return value;
    }
    public void setValue( V value ) {
        this.value = value;
    }
    // -------------------------------------------------------------------
    // METHODS
    // -------------------------------------------------------------------
    /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    public String toString( ) {
        return "<" + key + ", " + value + ">";
    }
    // -------------------------------------------------------------------
    // CONSTRUCTORS
    // -------------------------------------------------------------------
    /**
    * Constructor
    * @param key
    * @param value
    */
    public KeyValuePair ( K key, V value ) {
        setKey( key );
        setValue( value );
    }
}
// END OF CLASS KeyValuePair ===========================================