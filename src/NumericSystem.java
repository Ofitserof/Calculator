class NumericSystem {
    private boolean isArab;
    private boolean isRome;
    private char[] romeDigits = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    /**
     * Проверяем строку на наличие арабских цифр
     *
     * @param s
     * @return
     */
    public boolean checkArabNum(String s) {
        boolean isArab = false;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (isArabDigit(charArr[i])) {
                isArab = true;
            } else {
                isArab = false;
            }
        }
        return isArab;
    }

    ;

    /**
     * Проверяем строку на наличие римских цифр
     *
     * @param s
     * @return
     */
    public boolean checkRomeNum(String s) {
        boolean isRome = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isRomeDigit(chars[i])) {
                isRome = true;
            } else {
                isRome = false;
            }
        }
        return isRome;
    }

    /**
     * Проверяем наличие римских цифр
     *
     * @param c
     * @return
     */
    public boolean isRomeDigit(char c) {
        boolean b = false;
        for (int i = 0; i < romeDigits.length; i++) {
            if (c == romeDigits[i]) {
                b = true;
            }
        }
        return b;
    }

    /**
     * Проверяем наличие арабских цифр
     *
     * @param c
     * @return
     */
    public boolean isArabDigit(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * Определяем знак
     *
     * @param s
     * @return
     * @throws Exception
     */
    public String checkSign(String s) throws Exception {
        char c = s.charAt(0);
        String res = "";
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            res = s;
        } else {
            throw new Exception("Отсутствует знак арифметической операции");
        }
        return res;
    }
}
