package Car.Controller;

import Car.entity.Question;
import Car.entity.Test;
import Car.entity.User;
import Car.service.QuestionService;
import Car.service.TestService;
import Car.service.TicketService;
import Car.service.UserService;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
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
        model.addAttribute("testType", 1);//1 - ticket; 0 - topic

        List questions = ticketService.getTicketQuestions(ticketId);
        List answers = ticketService.getAnswersToTicketQuestions(ticketId);
        for(Iterator<Question> i = questions.iterator(); i.hasNext(); ) {
            i.next().checkAndSetAnswers(answers);
        }
        Collections.shuffle(questions);

        model.addAttribute("questionLength", questions.size() - 1);
        model.addAttribute("questions", questions);

        return "ticket";
    }

    @RequestMapping(value="/image/{questionId}")
     public void getUserImage(HttpServletResponse response , @PathVariable("questionId") int questionId) throws Exception {

        response.setContentType("image/jpeg");
        final Question question = questionService.getQuestion(questionId);
        IOUtils.copy(question.getImage().getBinaryStream(), response.getOutputStream());
    }

}
