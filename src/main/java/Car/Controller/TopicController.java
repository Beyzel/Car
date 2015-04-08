package Car.Controller;

import Car.entity.Question;
import Car.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
public class TopicController {

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.GET)
    public String topic(Model model, @PathVariable(value = "topicId") Integer topicId) throws Exception {

        model.addAttribute("topic", topicService.getTopic(topicId));
        model.addAttribute("testType", 0);//1 - ticket; 0 - topic

        List questions = topicService.getTopicQuestions(topicId);
        List answers = topicService.getAnswersToTopicQuestions(topicId);
        for(Iterator<Question> i = questions.iterator(); i.hasNext(); ) {
            i.next().checkAndSetAnswers(answers);
        }
        Collections.shuffle(questions);

        if(questions.size() > 20) {
            List first20Questions = new ArrayList();
            for(int i = 0; i < 20; i++) {
                first20Questions.add(questions.get(i));
            }

            model.addAttribute("questionLength", first20Questions.size() - 1);
            model.addAttribute("questions", first20Questions);
        }else{
            model.addAttribute("questionLength", questions.size() - 1);
            model.addAttribute("questions", questions);
        }

        return "topic";
    }
}
