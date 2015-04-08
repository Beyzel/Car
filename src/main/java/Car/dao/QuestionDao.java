package Car.dao;

import Car.entity.Question;

public interface QuestionDao {
    public Question getQuestion(Integer questionId) throws Exception;
}
