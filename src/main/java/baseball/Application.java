package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
        List<Integer> answer = makeThreeDigit();
        List<Integer> input = getNumber(args[0]);
        getResult(answer, input);
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

    public static List<Integer> getResult(List<Integer> answer, List<Integer> input) {

        List<Integer> result = new ArrayList<>();
        int strike = 0, ball = 0;
        result.add(strike);
        result.add(ball);

        for (int i = 0; i < 3; i++) {
            if (answer.contains(input.get(i))) {
                getBall(answer, input.get(i), strike, ball);
            }
        }
        return result;
    }

    public static void getBall(List<Integer> answer, int input, int strike, int ball) {
        if (answer.contains(input)) {
            if (getStrike(answer, input, strike) == false) {
                ball++;
            }
        }
    }

    public static boolean getStrike(List<Integer> answer, int input, int strike) {
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == input) {
                strike++;
                return true;
            }
        }
        return false;
    }
}
