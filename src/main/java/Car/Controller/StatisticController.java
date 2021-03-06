package Car.Controller;

import Car.entity.Test;
import Car.entity.User;
import Car.entity.UserAnswer;
import Car.service.TestService;
import Car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StatisticController {

    @Autowired
    UserService userService;
    @Autowired
    TestService testService;

    @RequestMapping(value = "/ticketStatistic", method = RequestMethod.GET)
    public String ticketStatistic(Model model) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.getUserByLogin(userName);

        List<Test> userTests = testService.getUserTickets(user.getUser_id());
        List<UserAnswer> allAnswers = testService.getUserTestAnswers(user.getUser_id());

        for (Test test : userTests) {
            test.resetUserAnswers();

            for (UserAnswer userAnswer : allAnswers) {
                if (userAnswer.getTest_id() == test.getTest_id()) {
                    test.addUserAnswer(userAnswer);
                }

            }

        }

        model.addAttribute("userTests", userTests);

        return "ticketStatistic";
    }

    @RequestMapping(value = "/topicStatistic", method = RequestMethod.GET)
    public String topicStatistic(Model model) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.getUserByLogin(userName);

        List<Test> userTests = testService.getUserTopics(user.getUser_id());
        List<UserAnswer> allAnswers = testService.getUserTestAnswers(user.getUser_id());

        for (Test test : userTests) {
            test.resetUserAnswers();

            for (UserAnswer userAnswer : allAnswers) {
                if (userAnswer.getTest_id() == test.getTest_id()) {
                    test.addUserAnswer(userAnswer);
                }

            }

        }

        model.addAttribute("userTests", userTests);

        return "topicStatistic";
    }
}
