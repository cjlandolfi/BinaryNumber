//I pledge my honor that I have abided by the Stevens Honor System
//Chris J Landolfi
public class BinaryNumber {
	// Data Fields
	/** The binary number */
	private int[] data;
	/** Boolean expression for overflow */
	private boolean overflow;

	// constructors
	/**
	 * Construct a Binary Number of given length.
	 * 
	 * @param length
	 * 
	 *            the number of 0's in the number.
	 */
	public BinaryNumber(int length) {
		int[] binaryArray = new int[length];
		data = binaryArray;
	}

	/**
	 * Construct a Binary Number from a string.
	 * 
	 * @param str
	 *            the string representation of the number.
	 */
	public BinaryNumber(String str) {
		int[] binaryArray = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			binaryArray[i] = java.lang.Character.getNumericValue(str.charAt(i));
		}
		data = binaryArray;
	}

	// Operations
	/**
	 * Returns the length of the binary number.
	 * 
	 * @return length of binary number.
	 */
	public int getLength() {
		return data.length;
	}

	/**
	 * Returns a digit of a binary number at the given index.
	 * 
	 * @param index
	 *            the index of the digit disired.
	 * @return digit at given index.
	 */
	public int getDigit(int index) {
		if (index < 0 || index > data.length) {
			System.out.println("ERROR:Index exceeds length of current binary number");
			return -1; // Returns -1 if index is out of range
		} else {
			return data[index];
		}
	}

	/**
	 * Transforms a binary number to a decimal number.
	 * 
	 * @return number in decimal form.
	 */
	public int toDecimal() {
		int dec = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 1) {
				dec += Math.pow(2, i);
			}
		}
		return dec;
	}

	/**
	 * Shifts the Binary number the given amount to the right.
	 * 
	 * @param amount
	 *            the number of digits the number will be shifted to the right.
	 * @return The Binary number the given amount the right.
	 */
	public BinaryNumber shiftR(int amount) {
		BinaryNumber binaryShift = new BinaryNumber(data.length + amount);
		for (int i = amount; i < binaryShift.getLength(); i++) {
			binaryShift.data[i] = data[i - amount];
		}
		this.data = binaryShift.data;
		return this;
	}

	/**
	 * Adds the current Binary Number with a second BinaryNumber.
	 * 
	 * @param aBinaryNumber
	 *            the second Binary Number being added.
	 * @return The sum of the two Binary Numbers.
	 */
	public BinaryNumber add(BinaryNumber aBinaryNumber) {
		int Carry = 0;
		BinaryNumber binaryResult = new BinaryNumber(data.length);
		if (data.length != aBinaryNumber.getLength()) {
			System.out.println("ERROR:Binary numbers are not the same length");
		} else {
			for (int i = 0; i < data.length; i++)

				if (Carry + data[i] + aBinaryNumber.data[i] == 2) {
					Carry = 1;
					binaryResult.data[i] = 0;
				} else if (Carry + data[i] + aBinaryNumber.data[i] == 0) {
					Carry = 0;
					binaryResult.data[i] = 0;
				} else if (Carry + data[i] + aBinaryNumber.data[i] == 3) {
					Carry = 1;
					binaryResult.data[i] = 1;
				} else {
					Carry = 0;
					binaryResult.data[i] = 1;
				}
		}
		if (Carry == 1) {
			overflow = true;
			return binaryResult;
		} 
		else {
			return binaryResult;
		}
	}

	/**
	 * Sets the overflow flag to False.
	 * 
	 * @return Overflow as False.
	 */
	public void clearOverflow() {
		overflow = false;
	}

	/**
	 * Retrieves the information in a BinaryNumber object.
	 * 
	 * @return the object state as a string.
	 */
	public String toString() {
		if (overflow == true) {
			return "Overflow";
		} 
		else {
			String binaryString = "";
			for (int i = 0; i < data.length; i++) {
				binaryString += data[i];
			}
			return binaryString;
		}
	}

	public static void main(String[] args) {
	}
}

