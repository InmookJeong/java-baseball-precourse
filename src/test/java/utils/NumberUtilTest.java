package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

/**
 * 숫자 검증 Util
 * - 1. 인자로 전달된 값이 1~9인지 확인
 *
 * @author Inmook,Jeong
 */
public class NumberUtilTest {

	@Test
	@DisplayName("인자로 전달된 값이 1~9 사이의 숫자인지 확인")
	void isOneToNineNumeric() {
		assertThat(NumberUtil.isOneToNineNumeric(1)).isTrue();
		assertThat(NumberUtil.isOneToNineNumeric(5)).isTrue();
		assertThat(NumberUtil.isOneToNineNumeric(9)).isTrue();
		assertThat(NumberUtil.isOneToNineNumeric(0)).isFalse();
		assertThat(NumberUtil.isOneToNineNumeric(10)).isFalse();
	}

	@Test
	@DisplayName("사용자가 입력한 문자가 3자리 숫자인지 확인")
	void checkUserInputIsNumeric() {
		String numericRegExp = "^[0-9]{3}$";
		assertThat(NumberUtil.checkUserInputIsNumeric("123")).isTrue();
		assertThat(NumberUtil.checkUserInputIsNumeric("096")).isTrue();
		assertThat(NumberUtil.checkUserInputIsNumeric("1")).isFalse();
		assertThat(NumberUtil.checkUserInputIsNumeric("19")).isFalse();
		assertThat(NumberUtil.checkUserInputIsNumeric("1456")).isFalse();
		assertThat(NumberUtil.checkUserInputIsNumeric("abc")).isFalse();
		assertThat(NumberUtil.checkUserInputIsNumeric("1a3")).isFalse();
	}

	@Test
	@DisplayName("사용자의 숫자가 1~9 사이의 3자리 숫자로 구성되었는지 확인")
	void isOneToNineUserNumber() {
		assertThat(NumberUtil.isOneToNineUserNumeric("159")).isTrue();
		assertThat(NumberUtil.isOneToNineUserNumeric("059")).isFalse();
		assertThat(NumberUtil.isOneToNineUserNumeric("103")).isFalse();
	}

	@Test
	@DisplayName("중복된 숫자가 존재하는지 확인")
	void hasDuplicatedNumber() {
		assertThat(NumberUtil.hasDuplicatedNumber("", 1)).isFalse();
		assertThat(NumberUtil.hasDuplicatedNumber("15", 9)).isFalse();
		assertThat(NumberUtil.hasDuplicatedNumber("15", 5)).isTrue();
		assertThat(NumberUtil.hasDuplicatedNumber("137")).isFalse();
		assertThat(NumberUtil.hasDuplicatedNumber("464")).isTrue();
	}
}
