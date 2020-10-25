package com.company.Lab13;

public class SmthThatThrowException {
    private int a = 0;
    private int b = 0;
    private int c = 0;

    public void addA(int a) throws Exception {
        if (a < 0)
            throw new Exception();
        this.a += a;
    }

    public void checkMyexception(int a) throws MineException {
        if (a < 0)
            throw new MineException();
        this.b += a;
    }

    public void checkMyRuntime(int a) throws MyRunTimeException {
        if (a < 0)
            throw new MyRunTimeException();
        this.c += a;
    }

    @Override
    public String toString() {
        return "SmthThatThrowException{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
