package com.beta.replyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ReplyController {
    public static final String SEPARATOR = "-";
    @Autowired
    private final ReplyService replyService;

    public ReplyController(ReplyService service) {
        this.replyService = service;
    }

    @GetMapping("/reply")
    public ReplyMessage replying() {
        return new ReplyMessage("Message is empty");
    }

    @GetMapping("/reply/{message}")
    public ReplyMessage replying(@PathVariable String message) {
        String[] data = message.split(SEPARATOR);
        return replyService.processMessage(data[1], data[0]);
    }
}