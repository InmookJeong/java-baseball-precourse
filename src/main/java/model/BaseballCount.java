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
		setBaseballCount();
		printBaseballCount();
	}
	
	// Baseball 게임 카운트 세팅
	public void setBaseballCount() {
		for(int i=0; i<userNo.length(); i++) {
			addBallCount(String.valueOf(userNo.charAt(i)), i);
		}
	}

	// 스트라이크 또는 볼의 갯수 더하기
	public void addBallCount(String userNoChar, int index) {
		if(isStrike(userNoChar, index)) {
			strike += 1;
		}
		if(isBall(userNoChar, index)) {
			ball +=1;
		}
	}

	// 사용자의 입력 숫자 하나만 가져와서 컴퓨터의 값과 위치가 일치하는지 확인 : Strike
	public boolean isStrike(String userNoChar, int index) {
		return computerNo.contains(userNoChar) && String.valueOf(computerNo.charAt(index)).equals(userNoChar);
	}

	// 사용자의 입력 숫자 하나만 가져와서 컴퓨터의 값이 같고 위치가 일치하는지 확인 : Ball
	public boolean isBall(String userNoChar, int index) {
		return computerNo.contains(userNoChar) && !String.valueOf(computerNo.charAt(index)).equals(userNoChar);
	}

	public void printBaseballCount() {
		if(strike > 0 && ball > 0) {
			printStrikeAndBallCount();
			return;
		}
		printStrikeOrBallCount();
	}

	public void printStrikeAndBallCount() {
		System.out.println(strike+"스트라이크 "+ball+"볼");
	}

	public void printStrikeOrBallCount() {
		String target = "볼";
		int targetCount = ball;
		if(strike>0) {
			target = "스트라이크";
			targetCount = strike;
		}
		System.out.println(targetCount+target);
	}

	public boolean isGameOver() {
		return (strike == 3);
	}
}
