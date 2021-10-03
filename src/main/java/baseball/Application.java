package baseball;

import nextstep.utils.Randoms;
import utils.NumberUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        playBaseball();
    }

    // 숫자 야구 게임 시작(Start Point)
    public static void playBaseball() {
        // TODO 컴퓨터의 숫자
        String computerNumbers = "";
        while(computerNumbers.length() < 3) {
            int randomNo = Randoms.pickNumberInRange(1, 9);
            if(NumberUtil.isOneToNineNumeric(randomNo)) {
                computerNumbers += String.valueOf(randomNo);
            }
        }
        LOG.log(Level.INFO, "setComputerNumber is "+computerNumbers);
    }
}
