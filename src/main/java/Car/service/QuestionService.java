package Car.service;

import Car.entity.Question;

public interface QuestionService {
    public Question getQuestion(Integer questionId) throws Exception;
}
