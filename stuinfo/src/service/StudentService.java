package service;

import dao.StudentDao;
import domain.Student;

import java.util.List;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    //查看所有学生
    public List<Student> QueryAllStu() {
        return studentDao.QueryAll();
    }

    //指定学号查询信息
    public Student QueryOne(String id) {
        return studentDao.QueryOne(id, name);
    }

    //添加学生信息
    public int AddOne(Student student) {
        return studentDao.AddOne(student);
    }

    //指定学号删除信息
    public int deleteOne(String ID) {
        return studentDao.deleteOne(ID);
    }


}
