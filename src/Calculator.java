class Calculator {
    private String a, b, sign;
    private SystemNum systemNum;
    private ReadInput readInput = new ReadInput();
    private NumericSystem numericSystem = new NumericSystem();
    private Converter converter = new Converter();

    public String setExpression(String s) throws Exception{
        readInput.textSplit(s);
        a = readInput.getNum1();
        b = readInput.getNum2();
        findNumFromRome(a);
        sign = numericSystem.checkSign(readInput.getSign());
        checkSystemNum();
        return expression(systemNum);
    }

    private void checkSystemNum() throws Exception {
        boolean isArab = numericSystem.checkArabNum(a) && numericSystem.checkArabNum(b);
        boolean isRome = numericSystem.checkRomeNum(a) && numericSystem.checkRomeNum(b);
        if (isArab || isRome) {
            if (numericSystem.checkArabNum(a)) {
                systemNum = SystemNum.ARAB;
            } else {
                systemNum = SystemNum.ROME;
            }
        } else {
            throw new Exception("Разные системы счисления");
        }
    }

    /**
     * Арифметическое выражение
     *
     * @param sysNum
     */
    private String expression(SystemNum sysNum) throws Exception {
        int a = 0;
        int b = 0;
        int result = 0;
        String sResult = "";
        if (sysNum.equals(SystemNum.ROME)) {
            a = findNumFromRome(this.a);
            b = findNumFromRome(this.b);
        }
        if (sysNum.equals((SystemNum.ARAB))) {
            a = Integer.parseInt(this.a);
            b = Integer.parseInt(this.b);

        }
        checkNumRange(a);
        checkNumRange(b);
        if (sign.equals("+")) {
            result = a + b;
        }
        if (sign.equals("-")) {
            result = a - b;
        }
        if (sign.equals("*")) {
            result = a * b;
        }
        if (sign.equals("/")) {
            result = (a / b);
        }

        if (sysNum.equals(SystemNum.ROME)) {
            if (result == 0) {
                throw new Exception("в римской системе отсутствует ноль");
            }
            if (result < 0) {
                throw new Exception("в римской системе нет отрицательных чисел");
            } else {
                sResult = converter.checkOfNumber(result);
            }
        } else {
            sResult = Integer.toString(result);
        }
        return sResult;
    }

    /**
     * Проверяем диапазон
     */
    private void checkNumRange(int num) throws Exception {
        if (num < 1 || num > 10) {
            throw new Exception("Число за диапазоном 1 - 10");
        }
    }

    private int findNumFromRome(String s) {
        int num = 0;
        for (int i = 0; i < 201; i++) {
            if (s.equals(converter.checkOfNumber(i))) {
                num = -i * -1;
            }
        }
        return num;
    }
}
