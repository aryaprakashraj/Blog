package Blog.controller;


import Blog.models.Newsletter;
import Blog.models.Subscriber;
import Blog.repository.SubscribersRepository;
import Blog.service.MailService;
import Blog.service.NewsletterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
@RequiredArgsConstructor

public class NewsletterController {

    private final NewsletterService newsletterService ;
    private final MailService mailService ;
    private final SubscribersRepository subscribersRepository ;
    @GetMapping()
    public ResponseEntity<List<Newsletter>> getSentNewsletters(){
        return ResponseEntity.ok(newsletterService.getNewsletters());
    }


    @PostMapping("/send")
    public String sendMail(@RequestBody Newsletter newsletter){
        List<Subscriber> subscribers = subscribersRepository.findByStatus("Subscribed") ;
        for (Subscriber s : subscribers) {
            mailService.sendEmail(s.getMail(), newsletter.getSubject(), newsletter.getBody());
        }
        return "Send" ;
    }


}
