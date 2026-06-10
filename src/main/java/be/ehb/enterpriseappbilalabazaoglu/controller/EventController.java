package be.ehb.enterpriseappbilalabazaoglu.controller;

import be.ehb.enterpriseappbilalabazaoglu.model.Event;
import be.ehb.enterpriseappbilalabazaoglu.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller

public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping({"/", "/events"})
    public String index(Model model) {
        model.addAttribute("events", eventRepository.findTop10ByOrderByDateDesc());
        return "index";
    }

    @GetMapping("/events/new")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        return "events/new";
    }

    @PostMapping("/new")
    public String saveEvent(
            @Valid @ModelAttribute("event") Event event,
            BindingResult result) {

        if (result.hasErrors()) {
            return "new";
        }

        eventRepository.save(event);

        return "redirect:/events";
    }

    @GetMapping("/id")
    public String details(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);

        if (event == null) {
            return "redirect:/events";
        }
        model.addAttribute("event", event);

        return "events/details";
    }

}
