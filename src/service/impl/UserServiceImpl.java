package service.impl;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.Students;
import pojo.User;
import pojo.kaohe;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    public User Login(String userName,String pwd){
        return userDao.findUserByNameAndPwd(userName,pwd);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User u) {
        userDao.updateUser(u);
    }

    @Override
    public List<User> findUserByCondition(int currentPage ,int rows ,Map<String, String[]> map) {
        return userDao.findUserByCondition(currentPage ,rows ,map);
    }

    @Override
    public int findUserByConditionCount(Map<String, String[]> map) {
        return userDao.findUserByConditionCount(map);
    }

    @Override
    public void delUser(int uid) {
        userDao.delUser(uid);
    }
    @Override
    public void delSelectedUser(String[] ids) {
        for (String id : ids) {
            int uid = Integer.parseInt(id);
            delUser(uid);
        }
    }

    @Override
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    public void addStudent(Students s) throws IOException, SQLException {
        userDao.addStudent(s);
    }

    @Override
    public void delStudentSelectedUser(String[] ids) {
        for (String id : ids) {
            int uid = Integer.parseInt(id);
            delStudentUser(uid);
        }
    }

    @Override
    public List<Students> findStudentByCondition(int currentPage, int rows, Map<String, String[]> map) {
        return userDao.findStudentByConditionCount(currentPage ,rows ,map);
    }

    @Override
    public int findStudentByConditionCount(Map<String, String[]> map) {
        return userDao.findStudentByConditionCount(map);
    }
    @Override
    public void delStudentUser(int uid) {
        userDao.delStudentUser(uid);
    }

    @Override
    public List<kaohe> findAllkaohe() {
        return userDao.findAllkaohe();
    }

    @Override
    public int findkaohe(Map<String, String[]> map) {
        return userDao.findkaohe(map);
    }

    @Override
    public List<kaohe> findkaohe(int currentPage, int rows, Map<String, String[]> map) {
        return userDao.findkaohe(currentPage ,rows ,map);
    }

    @Override
    public void delListSelectedUser(String[] ids) {
        for (String id : ids) {
            int uid = Integer.parseInt(id);
            delList(uid);
        }
    }
    @Override
    public void delList(int uid) {
        userDao.delList(uid);
    }

    @Override
    public void addKaohe(kaohe s) {
        userDao.addKaohe(s);
    }

    @Override
    public void updateKaohe(kaohe s) {
        userDao.updateList(s);
    }

    @Override
    public void updateStudent(Students s) {
        userDao.updateStudent(s);
    }

    @Override
    public kaohe findk(String uid) {
        return userDao.findK(uid);
    }

    @Override
    public List<Students> findStudentByCondition(int currentPage, int rows, Map<String, String[]> map, String kaohename) {
        return userDao.findkaohe(currentPage ,rows ,map,kaohename);
    }


}
