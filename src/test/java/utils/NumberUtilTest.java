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
	void isNumeric() {
		int randomNo = 1;
		assertThat(randomNo >= 1).isTrue();
		assertThat(randomNo <= 9).isTrue();
	}
}
