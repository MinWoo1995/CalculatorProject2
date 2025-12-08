package step2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
        public static void main(String[] args) {

            String num1;//첫번째 변수 입력값
            int number1;//검증이 끝난 첫번째 변수값
            String num2;//두번째 변수 입력값
            int number2;//검증이 끝난 두번째 변수값
            String intype;//사칙연산 부호
            String calculationType;//검증이 끝난 연산 부호 저장
            int result = 0;//결과값 저장

            Scanner sc = new Scanner(System.in);

            calculator calculator = new calculator();//연산을 담당하는 클래스 인스턴스화
            List<Integer> resultList = new ArrayList<>();//결과를 저장하는 배열
            List<Integer> resultReceive = new ArrayList<>();//저장된 결과를 저장하는 배열

            while(true){
                while (true) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                    //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
                    num1 = sc.nextLine();//첫번재 양의 정수를 입력받는다.

                    boolean condition = true;//입력값 검증상태를 저장하기 위해서
                    int dotCount = 0;//'.'이 2개이상 입력될수 없는 검증을 위해서

                    if (num1.equals("-") || num1.equals(".")) {
                        condition = false;//첫번째 자리에 -나 . 이 입력되는 경우 잘못된 입력으로 처리
                    } else {
                        for (int i = 0; i < num1.length(); i++) {
                            char a = num1.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                            if (a >= '0' && a <= '9') {
                                continue;//입력값이 0부터 9사이 숫자면 통과
                            } else if (a == '.') {
                                dotCount++;//'.'갯수 체크
                                if (dotCount > 1) {//소수점이 2개 이상이면 오류 출력
                                    condition = false;
                                    break;//오류문구 출력하러 가기!
                                }
                            } else if (a == '-') {//맨앞에 '-'를 입력할수없다->음수 입력불가
                                if (i != 0) {
                                    condition = false;
                                    break;
                                }
                            } else {
                                condition = false; //숫자,'.','-' 외 문자 입력시 오류 출력
                                break;
                            }
                        }
                    }
                    if (condition == true) {
                        number1 = Integer.parseInt(num1);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                        break;
                    } else {
                        System.out.println("0을 포함한 정수만 입력하세요!!!");
                        System.out.println(".은 한개만 입력가능하며 - 단독입력 불가합니다.");
                    }
                }

                while (true) {
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
                    intype = sc.nextLine();

                    if (intype.equals("+") || intype.equals("-") || intype.equals("*") || intype.equals("/")) {
                        calculationType = intype;
                        break;//올바른 연산자 입력시 while 탈출
                    } else {
                        System.out.println("(+, -, *, /)중에서 연산자를 입력해주세요.");
                    }
                }


                while (true) {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                    //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
                    num2 = sc.nextLine();//첫번재 양의 정수를 입력받는다.

                    boolean condition = true;//입력값 검증상태를 저장하기 위해서
                    int dotCount = 0;//'.'이 2개이상 입력될수 없는 검증을 위해서

                    if (num2.equals("-") || num2.equals(".")) {
                        condition = false;//첫번째 자리에 -나 . 이 입력되는 경우 잘못된 입력으로 처리
                    } else {
                        for (int i = 0; i < num2.length(); i++) {
                            char a = num2.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                            if (a >= '0' && a <= '9') {
                                continue;//입력값이 0부터 9사이 숫자면 통과
                            } else if (a == '.') {
                                dotCount++;//'.'갯수 체크
                                if (dotCount > 1) {//소수점이 2개 이상이면 오류 출력
                                    condition = false;
                                    break;//오류문구 출력하러 가기!
                                }
                            } else if (a == '-') {//맨앞에 '-'를 입력할수없다->음수 입력불가
                                if (i != 0) {
                                    condition = false;
                                    break;
                                }
                            } else {
                                condition = false; //숫자,'.','-' 외 문자 입력시 오류 출력
                                break;
                            }
                        }
                    }
                    if (condition == true) {
                        number2 = Integer.parseInt(num2);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                        break;
                    } else {
                        System.out.println("0을 포함한 정수만 입력하세요!!!");
                        System.out.println(".은 한개만 입력가능하며 - 단독입력 불가합니다.");
                    }
                }




                result=calculator.calculate(number1, number2, calculationType);//해당 기능의 메서드 활용후 리턴값 저장
                resultList.add(result);
                calculator.setResult(resultList);
                System.out.println("결과값을 저장 하였습니다.");
                resultReceive=calculator.getResult();
                System.out.println("저장된 결과값 : "+resultReceive+" 입니다.");

                while(true){
                    System.out.println("가장 먼저 저장된 결과값을 삭제 하시겠습니까? (Y/y or N/n)");
                    String answer = sc.nextLine();
                    if (answer.equals("Y")) {
                        calculator.removeResult(0);
                        System.out.println("저장된 결과값 : "+resultReceive+" 입니다.");
                        break;
                    } else if (answer.equals("y")) {
                        calculator.removeResult(0);
                        System.out.println("저장된 결과값 : "+resultReceive+" 입니다.");
                        break;
                    } else if (answer.equals("N")) {
                        break;
                    } else if (answer.equals("n")) {
                        break;
                    } else {
                        System.out.println("잘못 입력 하셨습니다. (Y/y) 또는 (N/n) 만 입력해주세요");
                    }

                }


                while (true) {
                    System.out.println("계속 계산하시겠습니까? (Y/y)또는(exit 입력 시 종료)");
                    String answer = sc.nextLine();
                    if (answer.equals("Y")) {
                        break;
                    } else if (answer.equals("y")) {
                        break;
                    } else if (answer.equals("exit")) {
                        System.exit(0);
                    } else {
                        System.out.println("잘못 입력 하셨습니다. (Y/y) 또는 (대소분자를 구분한 exit 입력 시 종료)");
                    }
                }

            }
        }
    }


