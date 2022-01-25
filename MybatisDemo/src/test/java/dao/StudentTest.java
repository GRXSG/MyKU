package test.java.dao;

import Dao.StudentDao;
import Demo.Student;
import Utils.Mybatis_Utills;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @Author
 * @Date 2022/1/20 22:38
 * @Version 1.0
 */
public class StudentTest {

    @Test
    public void test(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession = Mybatis_Utills.getSqlSession();
        //执行SQL
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = mapper.getStudentList();

        for (Student student : studentList){
            System.out.println(student);
        }
        //关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getStudent(){
        SqlSession sqlSession = Mybatis_Utills.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.getStudent("123");
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void addStudent(){
        SqlSession sqlSession = Mybatis_Utills.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        int i = mapper.addStudent(new Student("111", "111"));
        System.out.println(i>0? "插入成功":"插入失败");
        //提交事务，否则无法真正提交
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateStudent(){
        SqlSession sqlSession = Mybatis_Utills.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        int i = mapper.updateStudent(new Student("111","6666"));
        System.out.println(i>0? "修改成功":"修改失败");
        //提交事务，否则无法真正提交
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateStudent2(){
        SqlSession sqlSession = Mybatis_Utills.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);


        HashMap<String, Object> map = new HashMap<>();

        map.put("1","123");
        map.put("2","2222");

        int i = mapper.updateStudent2(map);

        System.out.println(i>0?"更改成功":"更改失败");
        //提交事务，否则无法真正提交
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteStudent(){
        SqlSession sqlSession = Mybatis_Utills.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        int i = mapper.deleteStudent("111");
        System.out.println(i>0? "删除成功":"删除失败");
        //提交事务，否则无法真正提交
        sqlSession.commit();

        sqlSession.close();
    }
}
