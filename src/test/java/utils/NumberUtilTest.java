package utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
		NumberUtil numberUtil = new NumberUtil();
		assertThat(numberUtil.isOneToNineNumeric(1)).isTrue();
		assertThat(numberUtil.isOneToNineNumeric(5)).isTrue();
		assertThat(numberUtil.isOneToNineNumeric(9)).isTrue();
		assertThat(numberUtil.isOneToNineNumeric(0)).isFalse();
		assertThat(numberUtil.isOneToNineNumeric(10)).isFalse();
	}
}
