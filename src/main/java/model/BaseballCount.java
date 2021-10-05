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
}
