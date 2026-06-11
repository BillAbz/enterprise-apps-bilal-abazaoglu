package be.ehb.enterpriseappbilalabazaoglu.controller;

import be.ehb.enterpriseappbilalabazaoglu.model.ContactMessage;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact(Model model) {

        model.addAttribute(
                "contactMessage",
                new ContactMessage()
        );

        return "contact";
    }

    @PostMapping("/contact")
    public String sendMessage(
            @Valid @ModelAttribute("contactMessage")
            ContactMessage contactMessage,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "contact";
        }

        model.addAttribute(
                "successMessage",
                "Uw bericht werd succesvol verzonden"
        );

        model.addAttribute(
                "contactMessage",
                contactMessage
        );

        return "contact";

    }
}
