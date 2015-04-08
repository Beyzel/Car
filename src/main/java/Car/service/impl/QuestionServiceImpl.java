package Car.service.impl;

import Car.dao.QuestionDao;
import Car.entity.Question;
import Car.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public Question getQuestion(Integer questionId) throws Exception {
        return questionDao.getQuestion(questionId);
    }
}
