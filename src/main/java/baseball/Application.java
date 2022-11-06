package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
        List<Integer> answer = makeThreeDigit();
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static List<Integer> makeThreeDigit() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static List<Integer> getNumber(String num) {
        System.out.println("숫자를 입력해주세요 : ");
        List<Integer> input = new ArrayList<>();
        if (num.length() > 3) {
            occurError();
        }
        for (int i = 0; i < 3; i++){
            input.add(Integer.parseInt(String.valueOf(num.charAt(i))));
        }
        return input;

    }

    public static Exception occurError() {
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
