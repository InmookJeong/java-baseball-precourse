package utils;

import java.util.regex.Pattern;

/**
 * 숫자 검증 Util
 * @author Inmook,Jeong
 */
public class NumberUtil {

	/**
	 * 전달받은 값이 1~9 사이의 숫자인지 확인
	 * @param randomNo
	 * @return true/false
	 */
	public static boolean isOneToNineNumeric(int randomNo) {
		if(randomNo >= 1 && randomNo <= 9) {
			return true;
		}
		return false;
	}

	/**
	 * 사용자가 입력한 문자가 3자리 숫자인지 확인
	 * @param userInputNo
	 * @return 3자리 숫자면 treu, 아니면 false
	 */
	public static boolean checkUserInputIsNumeric(String userInputNo) {
		String numericRegExp = "^[0-9]{3}$";
		return Pattern.matches(numericRegExp, userInputNo);
	}

	/**
	 * 사용자가 입력한 문자가 1~9 사이의 숫자로 구성되어 있는지 확인
	 * @param userInputNo
	 * @return
	 */
	public static boolean isOneToNineUserNumeric(String userInputNo) {
		boolean isOneToNineNumber = true;
		int i = 0;
		while(i<userInputNo.length() && isOneToNineNumber) {
			String noChar = String.valueOf(userInputNo.charAt(i));
			isOneToNineNumber = isOneToNineNumeric(Integer.parseInt(noChar));
			i++;
		}
		return isOneToNineNumber;
	}
}
