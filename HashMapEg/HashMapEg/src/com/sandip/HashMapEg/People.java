package com.sandip.HashMapEg;

public class People {
	String firstName;
	String middleName;
	String lastName;

	public People(String fn, String mn, String ln) {
		this.firstName = fn;
		this.middleName = mn;
		this.lastName = ln;
	}
	public int hashCode() {
		int hashcode = 0;
		hashcode += firstName.hashCode();
		hashcode += middleName.hashCode();
		hashcode += lastName.hashCode();
		return hashcode;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		// Object must be People type, typecast it
		People pRight = (People) obj;
		if ((this.firstName == pRight.firstName) ||
				((this.firstName != null) && this.firstName.equals(pRight.firstName))) {
			// Check middle name too
			if ((this.middleName == pRight.middleName) ||
					((this.middleName != null) && (this.middleName.equals(pRight.middleName)))) {
			    // Check last name too
				if ((this.lastName == pRight.lastName) ||
						((this.lastName != null) && (this.lastName.equals(pRight.lastName)))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return this.firstName + " " + this.middleName + " " + this.lastName;
	}
}