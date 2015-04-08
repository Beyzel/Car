package Car.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rule")
public class RulesController {

    @RequestMapping(value = "")
    public String rules(Model model) {
        return "rules";
    }

    @RequestMapping(value = "/general")
    public String general(Model model) {
        return "/rules/generalRules";
    }

    @RequestMapping(value = "/driverRights")
    public String driverRights(Model model) {
        return "/rules/driverRights";
    }

    @RequestMapping(value = "/vehiclesWithSpecialSignal")
    public String vehiclesWithSpecialSignal(Model model) {
        return "/rules/vehiclesWithSpecialSignal";
    }

    @RequestMapping(value = "/pedestriansRight")
    public String pedestriansRight(Model model) {
        return "/rules/pedestriansRight";
    }

    @RequestMapping(value = "/passengerRights")
    public String passengerRights(Model model) {
        return "/rules/passengerRights";
    }

    @RequestMapping(value = "/requirementsForCyclists")
    public String requirementsForCyclists(Model model) {
        return "/rules/requirementsForCyclists";
    }

    @RequestMapping(value = "/requirementsForAnimalsMushers")
    public String requirementsForAnimalsMushers(Model model) {
        return "/rules/requirementsForAnimalsMushers";
    }

    @RequestMapping(value = "/trafficRegulation")
    public String trafficRegulation(Model model) {
        return "/rules/trafficRegulation";
    }

    @RequestMapping(value = "/warningSignals")
    public String warningSignals(Model model) {
        return "/rules/warningSignals";
    }

    @RequestMapping(value = "/startMovement")
    public String startMovement(Model model) {
        return "/rules/startMovement";
    }

    @RequestMapping(value = "/locationOnTheRoad")
    public String locationOnTheRoad(Model model) {
        return "/rules/locationOnTheRoad";
    }
}
