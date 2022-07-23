class ReadInput {
    private String num1, num2, sign;

    public void textSplit(String s) throws Exception {
        String[] elements = s.split("\\s");
        if (elements.length == 3) {
            num1 = elements[0];
            num2 = elements[2];
            sign = elements[1];
        } else {
            throw new Exception();
        }
    }

    public String getNum1() {
        return num1;
    }

    public String getNum2() {
        return num2;
    }

    public String getSign() {
        return sign;
    }
}
