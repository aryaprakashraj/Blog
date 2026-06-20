package Blog.controller;


import Blog.models.Subscriber;
import Blog.service.SubscriberService;
import com.oracle.svm.core.annotate.Delete;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriber")
@RequiredArgsConstructor
public class SubscriberController {

    private final SubscriberService subscriberService ;

    @PostMapping("/add")
    public ResponseEntity<Subscriber> addSubscriber(@RequestBody Subscriber subscriber){
        return ResponseEntity.ok(subscriberService.addSubscriber(subscriber));
    }

    @GetMapping("/get-subscribers")
    public ResponseEntity<List<Subscriber>> getAllSubscribers(){
        return ResponseEntity.ok(subscriberService.getAllSubscribers());
    }

}
