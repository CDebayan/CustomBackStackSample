package com.example.dc.custombackstacksample;

import android.app.Activity;

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

    void addCurrentClass(Activity activity) {
        if (StackSingleton.getInstance().isStackEmpty() || StackSingleton.getInstance().getTopClass() != activity.getClass()) {
            stack.push(activity.getClass());
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
