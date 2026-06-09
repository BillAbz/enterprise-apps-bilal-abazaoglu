package be.ehb.enterpriseappbilalabazaoglu.controller;

import be.ehb.enterpriseappbilalabazaoglu.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping({"/", "/events"})
    public String index(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }


}
