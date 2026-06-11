package be.ehb.enterpriseappbilalabazaoglu;

import be.ehb.enterpriseappbilalabazaoglu.model.Event;
import be.ehb.enterpriseappbilalabazaoglu.model.Location;
import be.ehb.enterpriseappbilalabazaoglu.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;

    public DataLoader(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) {
        if (eventRepository.count() == 0) {
            Event event1 = new Event();
            event1.setTitle("Community Dinner");
            event1.setDescription("Een gratis warme maaltijd voor buurtbewoners.");
            event1.setOrganisation("Anderlecht Community NGO");
            event1.setContactEmail("info@anderlechtngo.be");
            event1.setDate(LocalDateTime.now().plusDays(3));

            Location location1 = new Location();
            location1.setName("Campus Kaai");
            location1.setAddress("Nijverheidskaai 170, 1070 Anderlecht");
            location1.setCapacity(80);

            event1.setLocation(location1);

            Event event2 = new Event();
            event2.setTitle("Clothing Donation Day");
            event2.setDescription("Inzameling en verdeling van kleding voor gezinnen in nood.");
            event2.setOrganisation("Partnerorganisatie Solidariteit Brussel");
            event2.setContactEmail("donaties@solidariteit.be");
            event2.setDate(LocalDateTime.now().plusDays(7));

            Location location2 = new Location();
            location2.setName("Community Hall Anderlecht");
            location2.setAddress("Raadsplein 1, 1070 Anderlecht");
            location2.setCapacity(120);

            event2.setLocation(location2);

            Event event3 = new Event();
            event3.setTitle("Homework Support");
            event3.setDescription("Vrijwilligers helpen kinderen uit de buurt met huiswerk.");
            event3.setOrganisation("Anderlecht Community NGO");
            event3.setContactEmail("education@anderlechtngo.be");
            event3.setDate(LocalDateTime.now().plusDays(10));

            Location location3 = new Location();
            location3.setName("Youth Centre");
            location3.setAddress("Bergensesteenweg 145, 1070 Anderlecht");
            location3.setCapacity(40);

            event3.setLocation(location3);

            eventRepository.save(event1);
            eventRepository.save(event2);
            eventRepository.save(event3);
        }
    }
}