package jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/
 * 最大最小堆内存均为20m, 最小(-Xms)等于最大(-Xmx)可避免堆内存自动扩展
 * -XX:+HeapDumpOnOutOfMemoryError 堆转储快照
 * @author qiubaisen
 * @date 2020-04-05
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
