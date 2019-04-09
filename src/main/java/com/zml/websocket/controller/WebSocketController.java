package com.zml.websocket.controller;

import com.zml.websocket.constant.Constants;
import com.zml.websocket.dto.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

/**
 * @author zhangminglei
 */
@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping(Constants.HELLO_MAPPING)
    @SendTo(Constants.TOPIC)
    public RequestMessage greeting(RequestMessage message) throws Exception {
        // 模拟业务操作
        Thread.sleep(1000);
        return new RequestMessage("Hello, " + HtmlUtils.htmlEscape(message.getContent()) + "!");
    }

    @PostMapping("/post")
    @ResponseBody
    public void send(@RequestBody RequestMessage object) {
        template.convertAndSend(Constants.TOPIC, object);
    }
}
