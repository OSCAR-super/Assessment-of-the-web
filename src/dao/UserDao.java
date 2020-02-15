package dao;

import pojo.Students;
import pojo.Students;
import pojo.User;
import pojo.kaohe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
    User findUserByNameAndPwd(String userName, String pwd);
    List<User> findAllUser();
    User findUserById(int id);
    void updateUser(User u);
    List<User>findUserByCondition(int currentPage, int rows, Map<String, String[]> map);
    int findUserByConditionCount(Map<String, String[]> map);
    void delUser(int uid);

    void addUser(User u);

    void addStudent(Students s) throws IOException, SQLException;
    void  delStudentUser(int uid);

    List<Students> findStudentByConditionCount(int currentPage , int rows , Map<String, String[]> map);
    int findStudentByConditionCount(Map<String, String[]> map);

    List<kaohe> findAllkaohe();

    int findkaohe(Map<String, String[]> map);
    List<kaohe> findkaohe(int currentPage , int rows , Map<String, String[]> map);

    void delList(int uid);

    void addKaohe(kaohe s);

    void updateList(kaohe s);

    void updateStudent(Students s);

    kaohe findK(String uid);

    List<Students> findkaohe(int currentPage, int rows, Map<String, String[]> map, String kaohename);
}
