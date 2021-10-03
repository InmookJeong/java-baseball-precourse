package utils;

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
	public boolean isOneToNineNumeric(int randomNo) {
		if(randomNo >= 1 && randomNo <= 9) {
			return true;
		}
		return false;
	}
}
