package step1;

import java.util.Scanner;

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

//        - [ ]  **양의 정수(0 포함)를 입력받기**
//        - [ ]  Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
//                - [ ]  양의 정수는 각각 하나씩 전달 받습니다.
//        - [ ]  양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.

        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
            num1 = sc.nextLine();//첫번재 양의 정수를 입력받는다.

            boolean condition = true;//입력값 검증상태를 저장하기 위해서
            int dotCount = 0;//'.'이 2개이상 입력될수 없는 검증을 위해서

            if(num1.equals("-") || num1.equals(".")){
                condition = false;//첫번째 자리에 -나 . 이 입력되는 경우 잘못된 입력으로 처리
            }else{
                for(int i = 0; i < num1.length(); i++){
                    char a = num1.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                    if(a >= '0' && a <= '9'){
                        continue;//입력값이 0부터 9사이 숫자면 통과
                    }else if(a == '.'){
                        dotCount++;//'.'갯수 체크
                        if(dotCount > 1){//소수점이 2개 이상이면 오류 출력
                            condition = false;
                            break;//오류문구 출력하러 가기!
                        }
                    }else if(a == '-'){//맨앞에 '-'를 입력할수없다->음수 입력불가
                        if(i != 0){
                            condition = false;
                            break;
                        }
                    }else{
                        condition = false; //숫자,'.','-' 외 문자 입력시 오류 출력
                        break;
                    }
                }
            }
            if(condition == true){
                number1 = Integer.parseInt(num1);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                break;
            }else{
                System.out.println("0을 포함한 정수만 입력하세요!!!");
                System.out.println(".은 한개만 입력가능하며 - 단독입력 불가합니다.");
            }
        }

        //        - [ ]  **사칙연산 기호(➕,➖,✖️,➗)를 입력받기**
//        - [ ]  Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
//        - [ ]  사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다. (`charAt(0)`)


        while(true){
            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            intype =  sc.nextLine();

            if(intype.equals("+") || intype.equals("-") || intype.equals("*") || intype.equals("/")){
                calculationType = intype;
                break;//올바른 연산자 입력시 while 탈출
            }else{
                System.out.println("(+, -, *, /)중에서 연산자를 입력해주세요.");
            }
        }


        while(true){
            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            //어떤 값이 입력될지 모르기때문에 String 타입으로 입력 받기
            num2 = sc.nextLine();//첫번재 양의 정수를 입력받는다.

            boolean condition = true;//입력값 검증상태를 저장하기 위해서
            int dotCount = 0;//'.'이 2개이상 입력될수 없는 검증을 위해서

            if(num2.equals("-") || num2.equals(".")){
                condition = false;//첫번째 자리에 -나 . 이 입력되는 경우 잘못된 입력으로 처리
            }else{
                for(int i = 0; i < num2.length(); i++){
                    char a = num2.charAt(i);//입력값 0번째부터 담아서 입력값을 1자리씩 검증하기 위한단계

                    if(a >= '0' && a <= '9'){
                        continue;//입력값이 0부터 9사이 숫자면 통과
                    }else if(a == '.'){
                        dotCount++;//'.'갯수 체크
                        if(dotCount > 1){//소수점이 2개 이상이면 오류 출력
                            condition = false;
                            break;//오류문구 출력하러 가기!
                        }
                    }else if(a == '-'){//맨앞에 '-'를 입력할수없다->음수 입력불가
                        if(i != 0){
                            condition = false;
                            break;
                        }
                    }else{
                        condition = false; //숫자,'.','-' 외 문자 입력시 오류 출력
                        break;
                    }
                }
            }
            if(condition == true){
                number2 = Integer.parseInt(num2);//검증이 끝난 문자열을 정수로 변환하여 변수에 저장
                break;
            }else{
                System.out.println("0을 포함한 정수만 입력하세요!!!");
                System.out.println(".은 한개만 입력가능하며 - 단독입력 불가합니다.");
            }
        }

//        - [ ]  **위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기**
//                - [ ]  키워드 : `if` `switch`
//        - [ ]  사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
//                - [ ]  입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (예를 들면 if, switch)
//        - [ ]  연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
//        - [ ]  ex) “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.“

        switch(calculationType){
            case "+":
                result = number1 + number2;
                System.out.println("결과 : "+"number1 "+calculationType+" number2"+" = "+result);
                System.out.println("");
                break;
            case "-":
                result = number1 - number2;
                System.out.println("결과 : "+"number1 "+calculationType+" number2"+" = "+result);
                System.out.println("");
                break;
            case "*":
                result = number1 * number2;
                System.out.println("결과 : "+"number1 "+calculationType+" number2"+" = "+result);
                System.out.println("");
                break;
            case "/":
                if(number2 == 0){
                    System.out.println("'/'연산시 0으로 나눌수 없습니다.");
                    break;
                }else if(true){
                    result = number1 / number2;
                    System.out.println("결과 : "+"number1 "+calculationType+" number2"+" = "+result);
                    System.out.println("");
                    break;
                }

            default:
                System.out.println("예상치 못한 오류가 발생하였습니다. 처음부터 다시 진행해주세요.");
                break;
        }

        //---------------------------------------------아래는 기능 구현전 --------------------------------------------


//        - [ ]  **반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기**
//                - [ ]  키워드 : 무한으로 반복, 수정하기 (처음부터 무한 반복하는 것이 아니라, 위 스텝별로 진행하며 수정)
//        - [ ]  반복문을 사용합니다. (예를 들어, for, while…)


                Scanner sc = new Scanner(System.in);
                /* 반복문 사용 해서 연산을 반복 */

                System.out.println("결과: " + result);

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                /* exit을 입력 받으면 반복 종료 */













    }
}
