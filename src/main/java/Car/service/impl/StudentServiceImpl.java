package Car.service.impl;


import Car.dao.StudentDao;
import Car.entity.Student;
import Car.entity.User;
import Car.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;

    @Override
    public void addStudent() throws Exception {
        studentDao.addStudent();
    }
}
