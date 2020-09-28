package com.wwh.boke.util;

public class UserUtil {
    private static ThreadLocal<Integer> currentUidContainer = new ThreadLocal<>();

    // 用于存放当前用户的 uid，可供在项目中使用。
    public static void setCurrentUid(int uid) {
        currentUidContainer.set(uid);
    }

    public static int getCurrentUid() {
        return currentUidContainer.get();
    }
}
