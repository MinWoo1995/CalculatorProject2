package step3;

import step3.calculator;//복붙과정에 step2.으로 설정되어있어, 오류가 발생[문제]
//step3으로 수정하여 문제를 해결 [해결]

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String num1;//첫번째 변수 입력값
        Double num11;//첫번째 검증이 끝난 입력값
        String num2;//두번째 변수 입력값
        Double num22;//두번째 검증이 끝난 입력값
        String intype;//사칙연산 부호
        String calculationType;//검증이 끝난 연산 부호 저장
        double result = 0;//결과값 저장

        Scanner sc = new Scanner(System.in);//스캐너 활용을 위한 객체 선언

        calculator calculator = new calculator();//연산을 담당하는 클래스 인스턴스화
        calculator<Double> doubleNum1 = new calculator();//연산을 담당하는 클래스 및 제네릭 활용을 위한 인스턴스화
        calculator<Double> doubleNum2 = new calculator();//연산을 담당하는 클래스 및 제네릭 활용을 위한 인스턴스화


        List<Double> resultList = new ArrayList<>();//결과를 저장하는 배열
        List<Double> resultReceive = new ArrayList<>();//저장된 결과를 저장하는 배열
        OperatorType op = null;//객체화가 필요가 없다.[이미 정의된 상수 객체이기때문에][문제]


        while(true){
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
                num1 = sc.nextLine();//첫번재 양의 정수를 입력받는다.

                boolean condition = true;//입력값 검증상태를 저장하기 위해서
                int dotCount = 0;//'.'이 2개이상 입력될수 없는 검증을 위해서

                if (num1.equals(".")) {
                    condition = false;//첫번째 자리에 . 이 입력되는 경우 잘못된 입력으로 처리
                } else {
                    for (int i = 0; i < num1.length(); i++) {
                        char a = num1.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                        if (a >= '0' && a <= '9') {
                            continue;//입력값이 0부터 9사이 숫자면 통과
                        } else if (a == '.') {
                            dotCount++;//'.'갯수 체크
                            if (dotCount >= 2) {//소수점이 2개 이상이면 오류 출력
                                condition = false;
                                break;//오류문구 출력하러 가기!
                            }
                        }
                    }
                }
                if (condition == true) {
                    //number1 = Integer.parseInt(num1);
                    num11 = Double.parseDouble(num1);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                    doubleNum1.setGnumber(num11);
                    break;
                } else {//컨디션이 트루가 아니라면 오류문을 출력하고 다시 재입력을 시작함
                    System.out.println("0을 포함한 실수만 입력하세요!!!");
                    System.out.println(".은 한개만 입력가능하며 - 단독입력 불가합니다.");
                }
            }

            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
                intype = sc.nextLine();//입력받은 사칙연산 기호를 저장

                try{
                    op = OperatorType.getOperator(intype);//입력받은 타입을 getOperator()메서드를 통해 정형화된 값으로 변환된 값을 저장
                    break;
                }catch(IllegalArgumentException e){//에러 발생시 오류문 출력후 처음으로 돌아가 연산부호를 다시 입력하도록함
                    System.out.println("유효하지 않은 연산자 입니다. 다시 입력해주세요!"+e.getMessage());
                }

//                if (intype.equals("+") || intype.equals("-") || intype.equals("*") || intype.equals("/")) {
//                    calculationType = intype;
//                    break;//올바른 연산자 입력시 while 탈출
//                } else {
//                    System.out.println("(+, -, *, /)중에서 연산자를 입력해주세요.");
//                }
            }


            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
                num2 = sc.nextLine();//두번재 양의 정수를 입력받는다.

                boolean condition = true;//입력값 검증상태를 저장하기 위해서
                int dotCount = 0;//'.'이 2개이상 입력될수 없는 검증을 위해서

                if (num2.equals(".")) {
                    condition = false;//첫번째 자리에 . 이 입력되는 경우 잘못된 입력으로 처리
                } else {
                    for (int i = 0; i < num2.length(); i++) {
                        char a = num2.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                        if (a >= '0' && a <= '9') {
                            continue;//입력값이 0부터 9사이 숫자면 통과
                        } else if (a == '.') {
                            dotCount++;//'.'갯수 체크
                            if (dotCount >= 2) {//소수점이 2개 이상이면 오류 출력
                                condition = false;
                                break;//오류문구 출력하러 가기!
                            }
                        }
                    }
                }
                if (condition == true) {
                    //number1 = Integer.parseInt(num1);
                    num22 = Double.parseDouble(num2);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                    doubleNum2.setGnumber(num22);
                    break;
                } else {//컨디션이 트루가 아니라면 오류문을 출력하고 다시 재입력을 시작함
                    System.out.println("0을 포함한 실수만 입력하세요!!!");
                    System.out.println(".은 한개만 입력가능하며 - 단독입력 불가합니다.");
                }
            }




            result=calculator.calculate(num11, num22, op);//해당 기능의 메서드 활용후 리턴값 저장
            resultList.add(result);// 결과값을 배열에 저장
            calculator.setResult(resultList);//객체에 결과 배열을 저장
            System.out.println("결과값을 저장 하였습니다.");//저장되었다는 안내문 출력
            resultReceive=calculator.getResult();//객체에 저장된 결과값을 불러온다.
            System.out.println("저장된 결과값 : "+resultReceive+" 입니다.");//저장된 결과값 출력

            while(true){
                System.out.println("가장 먼저 저장된 결과값을 삭제 하시겠습니까? (Y/y or N/n)");
                String answer = sc.nextLine();//답변을 입력받음
                if (answer.equals("Y")) {//입력받은 답변에 따른 처리구문들
                    calculator.removeResult(0);//removeResult()메서드를 통해 첫번째 인덱스 결과값 삭제
                    System.out.println("저장된 결과값 : "+resultReceive+" 입니다.");//삭제후 남은 저장값 출력
                    break;//해당 반복문을 탈출하여, 입력값보다 큰 저장값 찾기로 넘어감
                } else if (answer.equals("y")) {//입력받은 답변에 따른 처리구문들
                    calculator.removeResult(0);//removeResult()메서드를 통해 첫번째 인덱스 결과값 삭제
                    System.out.println("저장된 결과값 : "+resultReceive+" 입니다.");//삭제후 남은 저장값 출력
                    break;//해당 반복문을 탈출하여, 입력값보다 큰 저장값 찾기로 넘어감
                } else if (answer.equals("N")) {//삭제를 원하지 않는다면, 계산을 할지말지로 넘어감
                    break;//해당 반복문을 탈출하여, 입력값보다 큰 저장값 찾기로 넘어감
                } else if (answer.equals("n")) {//삭제를 원하지 않는다면, 계산을 할지말지로 넘어감
                    break;//해당 반복문을 탈출하여, 입력값보다 큰 저장값 찾기로 넘어감
                } else {//위에 조건에 만족하지 않는 값이 입력시 오류문을 출력하고 재입력을 받도록함
                    System.out.println("잘못 입력 하셨습니다. (Y/y) 또는 (N/n) 만 입력해주세요");
                }

            }

            while(true){
                System.out.println("입력한 값보다 큰 저장된 값을 찾으시겠습니까? (Y/y) 또는 (N/n)");
                String answer1 = sc.nextLine();//답변을 입력받음
                if (answer1.equals("Y")) {//입력받은 답변에 따른 처리구문들
                    System.out.print("기준이 될 실수를 입력하세요: ");
                    String answer2 = sc.nextLine();//답변을 입력받음
                    try{
                        Double a = Double.parseDouble(answer2);//입력값을 더블로 변환
                        System.out.print("기준 값"+a+"보다 큰 저장된 결과값");
                        resultReceive.stream()
                                .filter(result1->result1 > a)
                                .forEach(result1 -> System.out.println(result1));
                        break;//해당 반복문을 탈출하여, 계속 계산을 할지말지 결정문으로 넘어감
                    }catch(NumberFormatException e){
                        System.out.println("잘못 입력 하셨습니다. 실수만 입력해주세요");
                    }
                } else if (answer1.equals("y")) {//입력받은 답변에 따른 처리구문들
                    System.out.print("기준이 될 실수를 입력하세요: ");
                    String answer2 = sc.nextLine();//답변을 입력받음
                    try{
                        Double a = Double.parseDouble(answer2);//입력값을 더블로 변환
                        System.out.println("기준 값"+a+"보다 큰 저장된 결과값");
                        resultReceive.stream()//준비단계
                                .filter(result1->result1 > a)//입력기준값보다 큰 저장값
                                .forEach(result1 -> System.out.println(result1));//출력
                        break;//해당 반복문을 탈출하여, 계속 계산을 할지말지 결정문으로 넘어감
                    }catch(NumberFormatException e){
                        System.out.println("잘못 입력 하셨습니다. 실수만 입력해주세요");
                    }
                    break;//해당 반복문을 탈출하여, 계속 계산을 할지말지 결정문으로 넘어감
                } else if (answer1.equals("N")) {//삭제를 원하지 않는다면, 계산을 할지말지로 넘어감
                    break;//해당 반복문을 탈출하여, 계속 계산을 할지말지 결정문으로 넘어감
                } else if (answer1.equals("n")) {//삭제를 원하지 않는다면, 계산을 할지말지로 넘어감
                    break;//해당 반복문을 탈출하여, 계속 계산을 할지말지 결정문으로 넘어감
                } else {//위에 조건에 만족하지 않는 값이 입력시 오류문을 출력하고 재입력을 받도록함
                    System.out.println("잘못 입력 하셨습니다. (Y/y) 또는 (N/n) 만 입력해주세요");
                }
            }


            while (true) {
                System.out.println("계속 계산하시겠습니까? (Y/y)또는(exit 입력 시 종료)");
                String answer = sc.nextLine();//답변을 입력받음
                if (answer.equals("Y")) {//계속 계산을 원한다면, 해당 반목문을 탈출하여 처음으로 돌아감
                    break;
                } else if (answer.equals("y")) {//계속 계산을 원한다면, 해당 반목문을 탈출하여 처음으로 돌아감
                    break;
                } else if (answer.equals("exit")) {//프로그램 종료를 원하는경우 프로그램 종료
                    System.exit(0);
                } else {//위에 조건에 만족하지 않는 값이 입력시 오류문을 출력하고 재입력을 받도록함
                    System.out.println("잘못 입력 하셨습니다. (Y/y) 또는 (대소분자를 구분한 exit 입력 시 종료)");
                }
            }

        }
    }
}
//실행시 인트형 변환 오류가 발생하여 오류 분석과 수정으로 1시간 이상을 소요[문제]
//인텔리제이 실행시 타켓 메인이 스탭2 메인을 돌리는 것으로 스탭3 메인 실행시 오류가 발생한것
//스탭3 메인으로 실행을 진행시 전혀 문제 없이 정상 작동[해결]
