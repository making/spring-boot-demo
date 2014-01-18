package demo.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class LikeController {
    private static Logger logger = LoggerFactory.getLogger(LikeController.class);
    AtomicLong likes = new AtomicLong(0);

    @MessageMapping("/like")
    @SendTo("/topic/like")
    public Like like() {
        return new Like(likes.incrementAndGet(), new Date());
    }

    @Data
    @AllArgsConstructor
    static class Like {
        private long total;
        private Date lastModifiedAt;
    }
}
