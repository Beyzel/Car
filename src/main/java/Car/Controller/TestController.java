package Car.Controller;

import Car.entity.Test;
import Car.entity.User;
import Car.service.TestService;
import Car.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;
    @Autowired
    Gson serializer;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) throws Exception {

        model.addAttribute("tickets", testService.getAllTickets());
        model.addAttribute("topics", testService.getAllTopics());

        return "test";
    }

    @RequestMapping(value="/setUserAnswers", method = RequestMethod.POST)
    public @ResponseBody
    String setUserAnswers(HttpSession session, HttpServletResponse response, @RequestParam String userAnswers,
                          @RequestParam Integer testType, @RequestParam Integer testId) throws Exception {

        List<Integer> answers = Arrays.asList(serializer.fromJson(userAnswers, Integer[].class));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            String userName = authentication.getName();
            User user = userService.getUserByLogin(userName);


            Date date = new Date(new java.util.Date().getTime());
            if(testType == 1) {
                Test test = testService.checkIfTicketWasPassedBefore(user.getUser_id(), testId);
                if(test.getTest_id() != null) {
                    testService.deleteTest(test.getTest_id());
                }

                testService.addNewTest(user.getUser_id(), date);
                Integer generatedTestId = testService.getTestId(user.getUser_id(), date);

                testService.insertUserAnswers(answers, user.getUser_id(), generatedTestId);

            }else{
                Test test = testService.checkIfTopicWasPassedBefore(user.getUser_id(), testId);
                if(test.getTest_id() != null) {
                    testService.deleteTest(test.getTest_id());
                }
                testService.addNewTest(user.getUser_id(), date);
                Integer generatedTestId = testService.getTestId(user.getUser_id(), date);

                testService.insertUserAnswers(answers, user.getUser_id(), generatedTestId);
            }

            return "success";
        }
        return "Not authenticated";
    }
}
