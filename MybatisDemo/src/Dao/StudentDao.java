package Dao;

import Demo.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author
 * @Date 2022/1/20 22:21
 * @Version 1.0
 */
public interface StudentDao {
    //查询全部用户
    List<Student> getStudentList();
    //根据ID查询用户
    Student getStudent(String username);
    //插入用户
    int addStudent(Student student);

    //更新用户
    int updateStudent(Student student);
    //利用map局部更改用户信息
    int updateStudent2(Map<String,Object> map);
    //删除用户
    int deleteStudent(String username);
}
