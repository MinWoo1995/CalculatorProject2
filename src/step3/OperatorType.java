package step3;


    public enum OperatorType {
        //enum이 무엇이고 어떻게 활용하는지, 자료를 찾아보고 활용하였습니다.
        //실제 연산 기호(String)를 정의
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        // 연관된 기호를 저장합니다.
        private final String symbol;

        // 생성자: Enum은 private 생성자만 가집니다.
        //생성자이자 세터의 역할
        OperatorType(String symbol) {
            this.symbol = symbol;
        }

        // Getter: 기호 값을 외부에 전달
        public String getSymbol() {
            return symbol;
        }
        public static OperatorType getOperator(String symbol) {
            // 모든 Enum 상수를 순회합니다. (Enum의 values() 메서드 활용)
            for (OperatorType op : values()) {
                // 입력된 symbol과 Enum 상수가 가진 symbol을 비교합니다.
                if (op.getSymbol().equals(symbol)) {
                    return op; // 일치하면 해당 Enum 상수 객체를 반환
                }
            }
            // 일치하는 상수가 없으면 예외를 발생시켜 Main에서 catch하도록 유도
            throw new IllegalArgumentException("지원하지 않는 연산 기호입니다: " + symbol);
        }


    }

