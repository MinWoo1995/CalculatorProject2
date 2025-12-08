package step3;

import java.util.List;
import java.util.ArrayList;

public class calculator<T> {
    //속성
    private List<Double> calculatorResult = new ArrayList();//연산 결과값 클래스에 캡슐화를 통한 저장
    //int result=0;//연산 결과값 저장
    private T gnumber;
    double gresult;//연산 결과값 저장

    //생성자
    public calculator(){

    }

    //메서드
    public <T extends Number> double calculate(T number1, T number2, OperatorType calculationType){

        switch (calculationType) {//enum을 통한 정형화된 연산자를 통해 케이스 진행(코드 안정성 증가)
            case ADD:
                gresult = number1.doubleValue() + number2.doubleValue();//연산 진행
                System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                System.out.println("");
                break;
            case SUBTRACT:
                gresult = number1.doubleValue() - number2.doubleValue();//연산 진행
                System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                System.out.println("");
                break;
            case MULTIPLY:
                gresult = number1.doubleValue() * number2.doubleValue();//연산 진행
                System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                System.out.println("");
                break;
            case DIVIDE:
                if (number2.doubleValue() == 0) {//나눌려는 수가 0이라면 오류문을 출력후 메서드를 종료
                    System.out.println("'/'연산시 0으로 나눌수 없습니다.");
                    break;
                } else if (true) {//나눌려는 수가 0이 아니라면 연산을 진행
                    gresult = number1.doubleValue() / number2.doubleValue();//연산 진행
                    System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                    System.out.println("");
                    break;
                }

            default://케이스에 해당하지 않는 상황 발생시 오류문 출력후 프로그램 종료
                System.out.println("예상치 못한 오류가 발생하였습니다. 프로그램을 종료합니다.");
                System.exit(0);
        }
        return gresult;//연산이 완료된 결과값을 메인으로 리턴
    }

    public List<Double> getResult() {
        return this.calculatorResult;//저장된 결과값을 리턴
    }
    public void setResult(List<Double> result) {
        this.calculatorResult = result;//결과값을 저장
    }
    public void removeResult(int i) {
        this.calculatorResult.remove(i);//i번 인덱스의 결과값 삭제
        System.out.println("가장 먼저 저장된 결과값을 삭제 하였습니다.");
    }
    public T getGnumber() {
        return this.gnumber;
    }
    public void setGnumber(T gnumber) {
        this.gnumber = gnumber;
    }


}