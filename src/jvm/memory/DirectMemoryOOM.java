package jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * 默认直接内存等于堆内存
 * @author qiubaisen
 * @date 2020-04-05
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        // Unsafe.getUnsafe() 增加了限制，所以通过反射获取
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        // 获取静态成员变量
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
