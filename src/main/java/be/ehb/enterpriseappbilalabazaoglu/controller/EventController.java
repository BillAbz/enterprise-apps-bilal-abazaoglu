package be.ehb.enterpriseappbilalabazaoglu.controller;

import be.ehb.enterpriseappbilalabazaoglu.model.Event;
import be.ehb.enterpriseappbilalabazaoglu.model.Location;
import be.ehb.enterpriseappbilalabazaoglu.repository.EventRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("events", eventRepository.findTop10ByOrderByDateDesc());
        return "index";
    }

    @GetMapping("/new")
    public String newEvent(Model model) {
        Event event = new Event();
        event.setLocation(new Location());

        model.addAttribute("event", event);
        return "new";
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

    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        Event event = eventRepository.findById(id).orElse(null);

        if (event == null) {
            return "redirect:/events";
        }
        model.addAttribute("event", event);

        return "details";
    }

}
