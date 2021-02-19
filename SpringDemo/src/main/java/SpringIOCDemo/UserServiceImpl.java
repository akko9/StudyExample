package SpringIOCDemo;

public class UserServiceImpl implements UserService {
    //普通注入
    //UserDao userDao=new UserDaoImpl();
    //Spring注入
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser() {
        userDao.addUser();
    }

}
