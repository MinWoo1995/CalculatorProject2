프로젝트명 : 계산기 과제
프로젝트 소개 : Java를 활용하여 사칙연산을 수행하는 콘솔 기반 계산기 구현 프로젝트입니다.
주요기능 : 덧셈,뺄셈,곱셈,나눗셈,가장먼저 저장된 결과값 삭제,저장된 결과값중에서 입력기준값 보다 큰값찾기,
         계속 계산을 진행할지 선택,프로그램을 종료할지 선택
구현목표 :    1. 양의정수(0포함) 2개 입력받기
            2.사칙연산 기호(+,-,*,/) 1개 입력받기
            3.입력받은 정수2개와 기호를 통한 연산 진행후 결과값 출력하기
            4.반복문을 사용하되 exit 문자열 입력 전까지 무한으로 계산하기
            5.연산을 진행후 결과값을 저장하여 관리하기
            6.연산을 진행하는 기능을 클래스로 분리하기
            7.연산 기능을 담당하는 클래스를 캡슐화 진행하기
            8.순차적으로 저장된 연산결과를 가장 먼저 삭제하는 기능 구현
            9.Enum 을 활용하여 연산자 타입을 안정적으로 관리 하기
            10.더블타입으로도 입력받아도 연산이 가능하게 제네릭 활용하기
            11.저장된 연산 결과값중에서 입력받은 기준값보다 큰값 찾기 구현하기
기술스택 : Java 17
실행방법 : 로컬에서 구동


classDiagram
class Main {
+ main()
}
class Calculator {
+ calculate(num1, num2, type): result
}
class OperatorType {
<<Enum>>
+ symbol: String
+ ADD: OperatorType
+ SUBTRACT: OperatorType
+ MULTIPLY: OperatorType
+ DIVIDE: OperatorType
+ getOperator(symbol): OperatorType
}

    Main --> Calculator : uses
    Calculator --> OperatorType : depends on