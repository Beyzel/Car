package Car.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/rule")
public class RulesController {

    @RequestMapping(value = "")
    public String rules(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "rules";
    }

    @RequestMapping(value = "/general")
    public String general(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/generalRules";
    }

    @RequestMapping(value = "/driverRights")
    public String driverRights(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/driverRights";
    }

    @RequestMapping(value = "/vehiclesWithSpecialSignal")
    public String vehiclesWithSpecialSignal(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/vehiclesWithSpecialSignal";
    }

    @RequestMapping(value = "/pedestriansRight")
    public String pedestriansRight(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/pedestriansRight";
    }

    @RequestMapping(value = "/passengerRights")
    public String passengerRights(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/passengerRights";
    }

    @RequestMapping(value = "/requirementsForCyclists")
    public String requirementsForCyclists(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/requirementsForCyclists";
    }

    @RequestMapping(value = "/requirementsForAnimalsMushers")
    public String requirementsForAnimalsMushers(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/requirementsForAnimalsMushers";
    }

    @RequestMapping(value = "/trafficRegulation")
    public String trafficRegulation(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/trafficRegulation";
    }

    @RequestMapping(value = "/warningSignals")
    public String warningSignals(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/warningSignals";
    }

    @RequestMapping(value = "/startMovement")
    public String startMovement(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/startMovement";
    }

    @RequestMapping(value = "/locationOnTheRoad")
    public String locationOnTheRoad(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        return "/rules/locationOnTheRoad";
    }
}
