package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 야구게임 결과를 저장하는 Model
 *
 * @author Inmook,Jeong
 */
public class BaseballCountTest {

	@Test
	@DisplayName("사용자의 숫자 1개가 컴퓨터의 숫자에 포함되어있고 위치까지 모두 일치하는지 확인")
	void isStrike() {
		BaseballCount baseballCount = new BaseballCount("159", "921");

		String computerNo = "159";
		assertThat(baseballCount.isStrike("1", 0)).isTrue();
		assertThat(baseballCount.isStrike("5", 1)).isTrue();
		assertThat(baseballCount.isStrike("9", 2)).isTrue();
	}
}
