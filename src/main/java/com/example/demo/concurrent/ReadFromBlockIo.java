package com.example.demo.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class ReadFromBlockIo {

    public final static ScopedValue<String> SCOPED_CONTEXT = ScopedValue.newInstance();

    public static void main(String[] args) {
        Integer foobar = ScopedValue.getWhere(SCOPED_CONTEXT, "foobar", ReadFromBlockIo::getInteger);
        System.out.println(foobar);
    }

    private static Integer getInteger() {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<Integer>()) {
            StructuredTaskScope.Subtask<Integer> int1 = scope.fork(ReadFromBlockIo::readFromA);
            StructuredTaskScope.Subtask<Integer> int2 = scope.fork(ReadFromBlockIo::readFromB);

            scope.join();
//            scope.throwIfFailed();

            return scope.result();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Integer readFromA() throws InterruptedException {
        System.out.println(Thread.currentThread());
        Thread.sleep(1000);
        System.out.println(Thread.currentThread());

        System.out.println(SCOPED_CONTEXT.get());

        return 1;
    }

    private static Integer readFromB() throws InterruptedException {
        System.out.println(Thread.currentThread());
        Thread.sleep(3000);

        throw new RuntimeException("error!!!");
//        return 2;
    }
}
