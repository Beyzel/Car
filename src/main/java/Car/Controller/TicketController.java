package Car.Controller;

import Car.entity.Answer;
import Car.entity.Question;
import Car.service.QuestionService;
import Car.service.TicketService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@Controller
public class TicketController {

    @Autowired
    TicketService ticketService;
    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
    public String test(Model model, @PathVariable(value = "ticketId") int ticketId) throws Exception {

        model.addAttribute("ticketId", ticketId);
        model.addAttribute("testType", TestType.TICKET);

        List<Question> questions = ticketService.getTicketQuestions(ticketId);
        List<Answer> answers = ticketService.getAnswersToTicketQuestions(ticketId);
        for (Question question : questions) {
            question.checkAndSetAnswers(answers);
        }
        Collections.shuffle(questions);

        model.addAttribute("questionLength", questions.size() - 1);
        model.addAttribute("questions", questions);

        return "ticket";
    }

    @RequestMapping(value = "/image/{questionId}")
    public void getUserImage(HttpServletResponse response, @PathVariable("questionId") int questionId) throws Exception {

        response.setContentType("image/jpeg");
        final Question question = questionService.getQuestion(questionId);
        IOUtils.copy(question.getImage().getBinaryStream(), response.getOutputStream());
    }

}
