package service;

import pojo.Students;
import pojo.Students;
import pojo.User;
import pojo.kaohe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    User Login(String userName, String pwd);
    List<User> findAllUser();
    User findUserById(int id);
    void updateUser(User u);
    List<User>findUserByCondition(int currentPage, int rows, Map<String, String[]> map);
    int findUserByConditionCount(Map<String, String[]> map);
    void delUser(int uid);

    void delSelectedUser(String[] ids);

    void addUser(User u);

    void addStudent(Students s) throws IOException, SQLException;

    void delStudentSelectedUser(String[] ids);

    List<Students> findStudentByCondition(int currentPage, int rows, Map<String, String[]> map);

    int findStudentByConditionCount(Map<String, String[]> map);

    void delStudentUser(int uid);

    List<kaohe> findAllkaohe();

    int findkaohe(Map<String, String[]> map);

    List<kaohe> findkaohe(int parseInt, int parseInt1, Map<String, String[]> map);

    void delListSelectedUser(String[] ids);

    void delList(int uid);

    void addKaohe(kaohe s);

    void updateKaohe(kaohe s);

    void updateStudent(Students s);

    kaohe findk(String uid);

    List<Students> findStudentByCondition(int currentPage, int rows, Map<String, String[]> map, String kaohename);
}
