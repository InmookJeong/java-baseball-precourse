package baseball;

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
    public static void playBaseball() {
        String computerNumbers = setComputerNumbers();
        System.out.println("computerNumbers : " + computerNumbers);
        // 사용자로부터 숫자 입력 받기
        String userInuptNumbers = getInputUserNumbers();
        System.out.println("userInuptNumbers : " + userInuptNumbers);
    }

    // 컴퓨터의 숫자 세팅
    public static String setComputerNumbers() {
        String computerNumbers = "";
        while(computerNumbers.length() < 3) {
            int randomNo = Randoms.pickNumberInRange(1, 9);
            computerNumbers = getValidComputerNumbers(computerNumbers, randomNo);
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
}
