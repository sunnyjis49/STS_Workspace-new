package com.sun.springcore.standalone.collections;

import java.util.List;
import java.util.Map;

class Person {
 private List<String> friends;
 private Map<String, Integer> feestructure;

/**
 * @return the friends
 */
public List<String> getFriends() {
	return friends;
}

/**
 * @param friends the friends to set
 */
public void setFriends(List<String> friends) {
	this.friends = friends;
}


/**
 * @return the feestructure
 */
public Map<String, Integer> getFeestructure() {
	return feestructure;
}

/**
 * @param feestructure the feestructure to set
 */
public void setFeestructure(Map<String, Integer> feestructure) {
	this.feestructure = feestructure;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Person [friends=" + friends + ", feestructure=" + feestructure + "]";
}


 
 
}
