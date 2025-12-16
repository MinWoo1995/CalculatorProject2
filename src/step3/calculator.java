package step3;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class calculator<T extends Number> {
    //속성
    private List<Double> calculatorResult = new ArrayList<>();//연산 결과값 클래스에 캡슐화를 통한 저장
    //[문제]private List<T> calculatorResult = new ArrayList();<-기존 작성코드 Raw Type 사용으로 타입 안정성이 떨어진다.
    //[해결]private List<Double> calculatorResult = new ArrayList<>();<-수정으로 타입 안정성 향상 시키기

    //int result=0;//연산 결과값 저장
    private T gnumber;
    double gresult;//연산 결과값 저장

    //생성자
    public calculator(){

    }

    //메서드
    public void calculate(T number1, T number2, OperatorType calculationType){

        switch (calculationType) {//enum을 통한 정형화된 연산자를 통해 케이스 진행(코드 안정성 증가)
            case ADD:
                gresult = number1.doubleValue() + number2.doubleValue();//연산 진행
                calculatorResult.add(gresult);//결과값 저장
                displayLatestResult(gresult,number1,number2,calculationType);//연산결과 출력
                //System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                //System.out.println("");
                break;
            case SUBTRACT:
                gresult = number1.doubleValue() - number2.doubleValue();//연산 진행
                calculatorResult.add(gresult);//결과값 저장
                displayLatestResult(gresult,number1,number2,calculationType);//연산결과 출력
                //System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                //System.out.println("");
                break;
            case MULTIPLY:
                gresult = number1.doubleValue() * number2.doubleValue();//연산 진행
                calculatorResult.add(gresult);//결과값 저장
                displayLatestResult(gresult,number1,number2,calculationType);//연산결과 출력
                //System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                //System.out.println("");
                break;
            case DIVIDE:
                if (number2.doubleValue() == 0) {//나눌려는 수가 0이라면 오류문을 출력후 메서드를 종료
                    System.out.println("'/'연산시 0으로 나눌수 없습니다.");
                    break;
                    //[피드백]기존의 break;는 단순히 스위치문만 탈출하는 것으로 탈출후 맨아래 결과값은 리턴이 된다. 그렇게되면
                    //리턴값에 이전 결과값이 남아있을수 있기때문에 break;나 리턴으로 아예 탈출을 시켜버려야 맨아래 결과값 리턴되는일이 없음
                    //결국 메서드를 void 로 수정 리턴 필요없어짐 왜냐하면 저장도 여기서 하고 출력도 여기서 하기때문에 리턴할 필요가 없음.
                } else{//나눌려는 수가 0이 아니라면 연산을 진행
                    gresult = number1.doubleValue() / number2.doubleValue();//연산 진행
                    calculatorResult.add(gresult);//결과값 저장
                    displayLatestResult(gresult,number1,number2,calculationType);//연산결과 출력
                    //System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
                    //System.out.println("");
                    break;
                }

            default://케이스에 해당하지 않는 상황 발생시 오류문 출력후 프로그램 종료
                System.out.println("예상치 못한 오류가 발생하였습니다. 프로그램을 종료합니다.");
                //System.exit(0);
                //[피드백]
                //1.프로그램 종료에 대한 권한이 메서드에 있는것도 책임의 범위가 애매해진다.
                //2.메서드의 오류로 인해 서버를 종료한다는 관점에서도 프로그램 종료 선언은 맞지않다.
                //[결론] 메인으로 오류를 던저 예외를 처리하여 정상작동을 유지하거나, 판단에 종료하거나 책임을 위임!
                throw new ArithmeticException("calculate메서드 실행간 예기치 못한 오류가 발생하였습니다.");
        }
    }

    public void displayLatestResult(double gresult,T number1, T number2, OperatorType calculationType){
        System.out.println("결과 : " + number1.doubleValue()  + calculationType +  number2.doubleValue() + " = " + gresult);
        System.out.println("");
    }

    public List<Double> getResult() {
        return this.calculatorResult;//저장된 결과값을 리턴
    }
    public void setResult(List<Double> result) {
        this.calculatorResult = result;//결과값을 저장
    }
    public void removeResult() {
        if (this.calculatorResult.isEmpty()) { //안전성 체크 추가
            System.out.println("⚠️ 저장된 결과가 없어 삭제할 수 없습니다.");
            return; // 메서드를 안전하게 종료
        }
        this.calculatorResult.remove(0);//0번 인덱스의 결과값 삭제
        //[피드백] 인덱스값을 받아와서 삭제하는 구성의 경우 메인에서 어떤 인덱스를 넣어도 삭제를 한다는 의도이고, 그냥 맨 처음에 있는 값을
        //삭제 하는 내용이라면, 매개변수를 없애고, 메서드 원래 목적대로 인덱스를 0으로 픽스 하는게 의도와 설계가 맞다
        System.out.println("가장 먼저 저장된 결과값을 삭제 하였습니다.");
    }
    public T getGnumber() {
        return this.gnumber;
    }
    public void setGnumber(T gnumber) {
        this.gnumber = gnumber;
    }
}