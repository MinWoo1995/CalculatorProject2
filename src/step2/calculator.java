package step2;

public class calculator {
    //속성
    int result = 0;//연산 결과값 저장

    //생성자
    public calculator(){

    }

    //메서드
    public int calculate(int number1, int number2, String calculationType){

        switch (calculationType) {
            case "+":
                result = number1 + number2;
                System.out.println("결과 : " + number1  + calculationType +  number2 + " = " + result);
                System.out.println("");
                break;
            case "-":
                result = number1 - number2;
                System.out.println("결과 : " + number1  + calculationType +  number2 + " = " + result);
                System.out.println("");
                break;
            case "*":
                result = number1 * number2;
                System.out.println("결과 : " + number1  + calculationType +  number2 + " = " + result);
                System.out.println("");
                break;
            case "/":
                if (number2 == 0) {
                    System.out.println("'/'연산시 0으로 나눌수 없습니다.");
                    break;
                } else if (true) {
                    result = number1 / number2;
                    System.out.println("결과 : " + number1  + calculationType +  number2 + " = " + result);
                    System.out.println("");
                    break;
                }

            default:
                System.out.println("예상치 못한 오류가 발생하였습니다. 프로그램을 종료합니다.");
                System.exit(0);
        }
        return result;
    }

}

