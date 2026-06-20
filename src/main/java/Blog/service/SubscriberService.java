package Blog.service;


import Blog.models.Subscriber;
import Blog.repository.SubscribersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriberService {

    private final SubscribersRepository subscribersRepository ;

    public Subscriber addSubscriber(Subscriber subscriber){
        return  subscribersRepository.save(subscriber) ;
    }

    public List<Subscriber> getAllSubscribers(){
        return subscribersRepository.findByStatus("Subscribed");
    }

}
