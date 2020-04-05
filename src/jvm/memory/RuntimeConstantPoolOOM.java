package jvm.memory;

import java.util.HashSet;
import java.util.Set;

/**
 * JDK8以上，运行时常量池在方法区的元空间，而不在永久代
 * <p>
 * 1. VM Args: -XX:MaxMetaspaceSize=12M
 * 字符串常量在堆中，intern保存引用到常量池，所以不会出现溢出(常量池本身也可能在堆中)
 * <br>
 * 2. VM Args: -XX:MaxMetaspaceSize=12M -Xmx6M
 * </p>
 *
 * @author qiubaisen
 * @date 2020-04-05
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        boolean always = true;
        // 避免Full GC回收
        Set<String> set = new HashSet<>();
        int i = 0;
        while (always) {
            set.add(String.valueOf(i++).intern());
        }
        System.out.println(set.size());
    }
}
