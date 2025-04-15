package generic_utilities;

import java.util.Random;

public class Java_utility {
	/**
	 * this method used to avoid duplicate values
	 * @return
	 */
	public int getRandomNum() {
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	return ranNum;

}}
