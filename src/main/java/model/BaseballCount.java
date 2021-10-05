package model;

/**
 * Baseball 게임의 Count를 저장하는 Model
 */
public class BaseballCount {
	private int strike;
	private int ball;
	private String computerNo;
	private String userNo;

	public BaseballCount(String computerNo, String userNo) {
		this.computerNo = computerNo;
		this.userNo = userNo;
	}

	// 사용자의 입력 숫자 하나만 가져와서 컴퓨터의 값과 위치가 일치하는지 확인 : Strike
	public boolean isStrike(String userNoChar, int index) {
		return computerNo.contains(userNoChar) && String.valueOf(computerNo.charAt(index)).equals(userNoChar);
	}

	// 사용자의 입력 숫자 하나만 가져와서 컴퓨터의 값이 같고 위치가 일치하는지 확인 : Ball
	public boolean isBall(String userNoChar, int index) {
		return computerNo.contains(userNoChar) && !String.valueOf(computerNo.charAt(index)).equals(userNoChar);
	}
}
