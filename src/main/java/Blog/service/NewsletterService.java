package Blog.service;
import Blog.models.Newsletter;
import Blog.repository.NewsletterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsletterService {

    private final NewsletterRepository newsletterRepository ;

    public Newsletter createNewsletter(Newsletter newsletter){
        return newsletterRepository.save(newsletter) ;
    }

    public List<Newsletter> getNewsletters(){return newsletterRepository.findAll();}

    public List<Newsletter> getSentNewsletters(){
        return newsletterRepository.findByStatusOrderByCreatedAtDesc("SENT") ;
    }

}
