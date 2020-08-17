package com.prime.service.slack.demo;

import com.prime.service.slack.demo.service.Attachment;
import com.prime.service.slack.demo.service.SlackResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/slack/slash")
public class Demo {

   @PostMapping
   public Mono<SlackResponse> processor(){


      SlackResponse response = new SlackResponse();
      response.setText("This is the response text");
      response.setResponseType("in_channel");

      Attachment attachment = new Attachment();
      attachment.setText("This is the attachment text");
      attachment.setColor("#0000ff");

      response.getAttachments().add(attachment);

      return Mono.just(response);
   }
}
