package be.ehb.enterpriseappbilalabazaoglu.controller;

import be.ehb.enterpriseappbilalabazaoglu.model.ContactMessage;
import jakarta.validation.Valid;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    private final JavaMailSender mailSender;

    public ContactController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("contactMessage", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String sendMessage(@Valid @ModelAttribute("contactMessage") ContactMessage contactMessage,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            return "contact";
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("admin@anderlechtngo.be");
        mailMessage.setSubject("Nieuw bericht van " + contactMessage.getName());
        mailMessage.setText(
                "Naam: " + contactMessage.getName() + "\n" +
                        "Email: " + contactMessage.getEmail() + "\n\n" +
                        "Bericht:\n" + contactMessage.getMessage()
        );

        mailSender.send(mailMessage);

        model.addAttribute("successMessage", "Je bericht is succesvol verzonden.");
        model.addAttribute("contactMessage", new ContactMessage());

        return "contact";
    }
}