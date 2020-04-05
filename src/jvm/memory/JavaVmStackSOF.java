package jvm.memory;

/**
 * 限制栈内存容量，验证请求栈深度过大会抛出StackOverflowException
 * <p>
 * <pre>The Java thread stack size specified is too small. Specify at least 152k</pre>
 * VM Args:-Xss152k
 *
 * @author qiubaisen
 * @date 2020-04-05
 */
public class JavaVmStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        JavaVmStackSOF oom = new JavaVmStackSOF();
        try {
            oom.stackLeak();
            //StackOverflowError 是Error, 用Exception无法捕获
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            e.printStackTrace();
        }
    }
}
