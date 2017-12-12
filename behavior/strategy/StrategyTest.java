package com.vsu.behavior.strategy;

/**
 * Created by vsu on 2017/12/12.
 */

/**
 * 策略模式
 */


/**
 *  统一接口
 */
interface ICalculator{
    int calculate(String str);
}

/**
 * 辅助类
 */
abstract class AbstractCalculator{
    public int[] split(String exp, String opt) {
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }
}


/**
 *  三个实现类
 */
class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}


class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\-");
        return arrayInt[0] - arrayInt[1];
    }

}


class Multiply extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"\\*");
        return arrayInt[0]*arrayInt[1];
    }
}





public class StrategyTest {
    public static void main(String[] args) {
        String exp = "8-2";
        ICalculator cal = new Minus();
        int result = cal.calculate(exp);
        System.out.println(exp + "=" + result);
    }
}
