package dao;

import Tools.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.Students;

import pojo.User;
import pojo.kaohe;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserDaoImpl implements UserDao {
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByNameAndPwd(String userName, String pwd) {
        String sql="SELECT *FROM user WHERE username=? AND password=?";
        User u=null;
        try {
            u=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),userName,pwd);
        }catch (Exception ex){
            u=null;
        }

        return u;

    }

    @Override
    public List<User> findAllUser() {
        String sql="SELECT * FROM user";
        List<User>lst=template.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return lst;
    }

    @Override
    public User findUserById(int id) {
        return template.queryForObject("SELECT * FROM user WHERE id=?",new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void updateUser(User u) {

        String sql="UPDATE user SET name=?,username=? WHERE id=?";
        template.update(sql,u.getName(),u.getUsername(),u.getId());
    }

    @Override
    public List<User> findUserByCondition(int currentPage ,int rows ,Map<String, String[]> map) {
        StringBuffer sb=new StringBuffer("SELECT * FROM user WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }
        sb.append("LIMIT ?,?");
        int start=(currentPage-1)*rows;
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }

    @Override
    public int findUserByConditionCount(Map<String, String[]> map) {
        StringBuffer sb=new StringBuffer("SELECT count(*) FROM user WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public void delUser(int uid) {
        template.update("DELETE FROM user WHERE id=?",uid);
    }

    @Override
    public void addUser(User u) {
        String sql="INSERT INTO user(id,name,username,password)value (null ,?,?,? )";
        template.update(sql,u.getName(),u.getUsername(),u.getPassword());
    }

    @Override
    public void addStudent(Students s) throws IOException, SQLException {
        String sql1="SELECT id FROM user ORDER BY rand() LIMIT 1";
        int id=template.queryForObject(sql1,Integer.class);
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        s.setStime(sdf.format(date));
        String sql="INSERT INTO student(sid,sname,teacher,gai,stime,kaohename,file)value (? ,?,?,?,?,?,?)";
        template.update(sql,s.getSid(),s.getSname(),id,"审核中",s.getStime(),s.getKaohename(),s.getFile());
    }

    @Override
    public void delStudentUser(int uid) {
        template.update("DELETE FROM student WHERE sid=?",uid);
    }

    @Override
    public List<Students> findStudentByConditionCount(int currentPage , int rows , Map<String, String[]> map) {
        StringBuffer sb=new StringBuffer("SELECT * FROM student WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }
        sb.append("LIMIT ?,?");
        int start=(currentPage-1)*rows;
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<Students>(Students.class),params.toArray());
    }

    @Override
    public int findStudentByConditionCount(Map<String, String[]> map) {
        StringBuffer sb=new StringBuffer("SELECT count(*) FROM student WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<kaohe> findAllkaohe() {
        String sql="SELECT * FROM kaohe";
        List<kaohe>lst=template.query(sql,new BeanPropertyRowMapper<kaohe>(kaohe.class));
        return lst;
    }

    @Override
    public int findkaohe(Map<String, String[]> map) {
        StringBuffer sb=new StringBuffer("SELECT count(*) FROM kaohe WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<kaohe> findkaohe(int currentPage, int rows, Map<String, String[]> map) {
        StringBuffer sb=new StringBuffer("SELECT * FROM kaohe WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }
        sb.append("LIMIT ?,?");
        int start=(currentPage-1)*rows;
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<kaohe>(kaohe.class),params.toArray());
    }

    @Override
    public void delList(int uid) {
        template.update("DELETE FROM kaohe WHERE id=?",uid);
    }

    @Override
    public void addKaohe(kaohe s) {
        String sql="INSERT INTO kaohe(id,name,time,neiron)value (null ,?,?,? )";
        template.update(sql,s.getName(),s.getTime(),s.getNeiron());
    }

    @Override
    public void updateList(kaohe s) {
        String sql="UPDATE kaohe SET name=?,time=?,neiron=? WHERE id=?";
        template.update(sql,s.getName(),s.getTime(),s.getNeiron(),s.getId());
    }

    @Override
    public void updateStudent(Students s) {
        String sql="UPDATE student SET gai=? WHERE sid=?";
        template.update(sql,s.getGai(),s.getSid());
    }

    @Override
    public kaohe findK(String uid) {

        return template.queryForObject("SELECT * FROM kaohe WHERE name=?",new BeanPropertyRowMapper<kaohe>(kaohe.class),uid);

    }

    @Override
    public List<Students> findkaohe(int currentPage, int rows, Map<String, String[]> map, String kaohename) {
        StringBuffer sb=new StringBuffer("SELECT * FROM student WHERE 1=1 ");
        Set<String>keys=map.keySet();
        List<Object>params=new ArrayList<Object>();
        for (String key:keys){
            if (key.equals("currentPage")||key.equals("rows")){
                continue;
            }
            String value=map.get(key)[0];
            if (value!=null&&!value.equals("")){
                sb.append("AND "+key+" LIKE ?");
                params.add("%"+value+"%");
            }
        }
        sb.append("LIMIT ?,?");
        int start=(currentPage-1)*rows;
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(),new BeanPropertyRowMapper<Students>(Students.class),params.toArray());
    }

}
