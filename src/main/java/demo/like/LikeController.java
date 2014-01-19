package demo.like;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class LikeController {
    AtomicLong likes = new AtomicLong(0);

    @MessageMapping("/like")
    @SendTo("/topic/like")
    public Like like() {
        return new Like(likes.incrementAndGet(), new Date());
    }

    @lombok.Data
    @lombok.AllArgsConstructor
    static class Like {
        private long total;
        private Date lastModifiedAt;
    }
}
