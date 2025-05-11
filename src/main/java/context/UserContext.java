package context;

import com.wind.perfmonitor.entity.User;

//上下文配置，前期作为测试使用设置用户

public class UserContext {
    private static final ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static void setUser(User user) {
        currentUser.set(user);
    }

    public static User getUser() {
        return currentUser.get();
    }

    public static void clear() {
        currentUser.remove();
    }
}
