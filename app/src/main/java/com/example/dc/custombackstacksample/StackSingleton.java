package com.example.dc.custombackstacksample;

import java.util.Stack;

class StackSingleton {
    private static StackSingleton mInstance;
    private static Stack<Class<?>> stack = new Stack<>();

    static StackSingleton getInstance(){
        if (mInstance == null) {
            mInstance = new StackSingleton();
        }
        return mInstance;
    }

    void setCurrentClass(Class<?> currentClass) {
        if (StackSingleton.getInstance().isStackEmpty() || StackSingleton.getInstance().getTopClass() != currentClass) {
            stack.push(currentClass);
        }
    }

    Class<?> getTopClass() {
        return stack.peek();
    }

    void removeTopClass() {
        stack.pop();
    }

    boolean isStackEmpty(){
        return stack.empty();
    }

}
