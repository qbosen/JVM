package jvm.memory;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * 通过nio buffer 分配的直接内存，会在check分配大小的时候就直接抛出错误，而非真实分配内存
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * @author qiubaisen
 * @date 2020-04-05
 */
public class DirectMemoryOOMByBuffer {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(ByteBuffer.allocateDirect(_1MB));
        }
    }
}
