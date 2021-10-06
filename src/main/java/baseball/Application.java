package baseball;

import model.BaseballCount;
import nextstep.utils.Console;
import nextstep.utils.Randoms;
import utils.NumberUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        // 야구 게임 시작
        playBaseball();
    }

    // 숫자 야구 게임 시작(Start Point)
    public static boolean playBaseball() {
        String computerNumbers = setComputerNumbers();
        boolean isGameOver = false;
        while(!isGameOver) {
            isGameOver = checkResultByUserInput(computerNumbers);
        }
        return restartBaseball();
    }

    // 컴퓨터의 숫자 세팅
    public static String setComputerNumbers() {
        String computerNumbers = "";
        while(computerNumbers.length() < 3) {
            computerNumbers = getValidComputerNumbers(computerNumbers, Randoms.pickNumberInRange(1, 9));
        }
        return computerNumbers;
    }

    // 숫자 검증 후 ComputerNumber에 추가하기
    public static String getValidComputerNumbers(String computerNo, int numberToAdd) {
        if(NumberUtil.isOneToNineNumeric(numberToAdd)
            && !NumberUtil.hasDuplicatedNumber(computerNo, numberToAdd)) {
            computerNo += String.valueOf(numberToAdd);
        }
        return computerNo;
    }

    // 사용자가 값을 입력한 후 결과 확인하기
    public static boolean checkResultByUserInput(String computerNumbers) {
        // 사용자로부터 숫자 입력 받기
        String userInuptNumbers = getInputUserNumbers();
        if(isNothing(computerNumbers, userInuptNumbers)) {
            System.out.println("낫싱");
            return false;
        }
        return viewResult(computerNumbers, userInuptNumbers);
    }
    
    // 사용자 입력 숫자 가져오기
    public static String getInputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumbers = Console.readLine();
        if(NumberUtil.checkUserInputIsNumeric(userInputNumbers)
            && NumberUtil.isOneToNineUserNumeric(userInputNumbers)
            && !NumberUtil.hasDuplicatedNumber(userInputNumbers)) {
            return userInputNumbers;
        }
        System.out.println("[ERROR] 1에서 9사이의 중복되지 않는 3자리 숫자만 입력 가능합니다.");
        return getInputUserNumbers();
    }

    // 사용자 입력 값이 컴퓨터의 값 중 하나도 일치하지 않는지 확인
    public static boolean isNothing(String computerNo, String userInputNo) {
        boolean containNumber = false;
        int i = 0;
        while (i < userInputNo.length() && !containNumber) {
            containNumber = computerNo.contains(String.valueOf(userInputNo.charAt(i)));
            i++;
        }
        return !containNumber;
    }
    
    // 사용자의 입력값이 컴퓨터와 얼마나 일치하는지 확인
    public static boolean viewResult(String computerNo, String userInputNo) {
        BaseballCount baseballCount = new BaseballCount(computerNo, userInputNo);
        return baseballCount.isGameOver();
    }

    // 게임을 재시작할 것인지 확인
    public static boolean restartBaseball() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        if(restart.equals("1")) {
            playBaseball();
        }
        return false;
    }
}
