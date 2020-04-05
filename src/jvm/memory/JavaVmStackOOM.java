package jvm.memory;

/**
 * 32位windows单个进程最大内存2G, 设置好堆内存、方法区内存。剩下的用用于线程分配。即程序计数器、虚拟机栈、本地方法栈。
 * 每次创建线程都会分配栈空间，所以 创建多个线程也可能导致OOM
 *  VM Args: -Xss2M
 * @author qiubaisen
 * @date 2020-04-05
 */
public class JavaVmStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }
}
