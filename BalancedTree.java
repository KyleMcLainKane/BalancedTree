/**
 * Program #4 BalancedTree
 * This is the balanced tree implementation of the data
 * CS310-01
 * 9-May-2019
 * @author Kyle McLain cssc 1497
 */

package data_structures;

import java.util.Iterator;
import java.util.TreeMap;

public class BalancedTree<K extends Comparable<K>, V extends Comparable<V>> implements DictionaryADT<K, V> {
	//A red/black tree implementation of the DictionaryADT, which uses the
	//Java API class java.util.TreeMap.
	//https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
	
	private TreeMap<K,V> redBlack;
	
	/**
	 * Constructor for the balanced tree (Red Black Tree)
	 */
	public BalancedTree() {
		redBlack = new TreeMap<K, V>();
	}
	
	/**
	 * Returns true if the dictionary has an object identified by key in it, otherwise false.
	 * @param key
	 * @return boolean
	 */
	@Override
	public boolean contains(K key) {
		return redBlack.containsKey(key);
	}

	/**
	 * Adds the given key/value pair to the dictionary. Returns false if the dictionary is full,
	 *  or if the key is a duplicate.Returns true if addition succeeded.
	 * @param key
	 * @param value
	 * @return boolean
	 */
	@Override
	public boolean add(K key, V value) {
		if(redBlack.containsKey(key) == true) return false;
		redBlack.put(key, value);
		return true;
	}

	/** 
	 * Deletes the key/value pair identified by the key parameter. Returns true if the key/value pair was found and removed, otherwise false.
	 * @param key
	 * @return boolean
	 */
	@Override
	public boolean delete(K key) {
		return redBlack.remove(key) != null;
	}

	/** 
	 * Returns the value associated with the parameter key. Returns null if the key is not found or the dictionary is empty.
	 * @param key
	 * @return V
	 */
	@Override
	public V getValue(K key) {
		return redBlack.get(key);
	}

	/** 
	 * Returns the key associated with the parameter value. Returns 
	 * null if the value is not found in the dictionary. If more than one key exists that matches the given value, returns the first one found
	 * @param value
	 * @return K
	 */
	@Override
	public K getKey(V value) {
		for(K key : redBlack.keySet()) {
			if(((Comparable<V>) redBlack.get(key)).compareTo(value) == 0)
				return key;
		}
		return null;
	}

	/** 
	 * Returns the number of key/value pairs currently stored in the dictionary
	  * @return int
	 */
	@Override
	public int size() {
		return redBlack.size();
	}

	/**
	 *  Returns true if the list is full, otherwise false
	  * @return boolean
	 */
	@Override
	public boolean isFull() {
		return false;
	}

	/** 
	 *  Returns true if the dictionary is at max capacity
	  * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return redBlack.isEmpty();
	}

	/**  
	 * Returns the Dictionary object to an empty state.
	 */
	@Override
	public void clear() {
		redBlack.clear();
	}

	/**
	 * Returns an Iterator of the keys in the dictionary, in ascending sorted order. The iterator must be fail-fast
	 */
	@Override
	public Iterator<K> keys() {
		return redBlack.keySet().iterator();
	}

	/** 
	 * Returns an Iterator of the values in the dictionary. The order of the values must match the order of the keys. 
	 * The iterator must be fail-fast
	 */
	@Override
	public Iterator<V> values() {
		return redBlack.values().iterator();
	}
	
}
