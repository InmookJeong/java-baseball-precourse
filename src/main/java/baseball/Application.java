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
        
        // 사용자로부터 숫자 입력 받기
        String userInuptNumbers = getInputUserNumbers();
        System.out.println("userInuptNumbers : " + userInuptNumbers);
    }

    // 숫자 야구 게임 시작(Start Point)
    public static void playBaseball() {
        // 컴퓨터의 숫자 세팅
        String computerNumbers = "";
        while(computerNumbers.length() < 3) {
            int randomNo = Randoms.pickNumberInRange(1, 9);
            if(NumberUtil.isOneToNineNumeric(randomNo)) {
                computerNumbers += String.valueOf(randomNo);
            }
        }
    }
    
    // 사용자 입력 숫자 가져오기
    public static String getInputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumbers = Console.readLine();
        if(NumberUtil.checkUserInputIsNumeric(userInputNumbers)
            && NumberUtil.isOneToNineUserNumeric(userInputNumbers)) {
            return userInputNumbers;
        }
        System.out.println("[ERROR] 1에서 9사이의 3자리 숫자만 입력 가능합니다.");
        return getInputUserNumbers();
    }
}
