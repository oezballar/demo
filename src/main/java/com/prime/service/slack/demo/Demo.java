package com.prime.service.slack.demo;

import com.prime.service.slack.demo.service.Attachment;
import com.prime.service.slack.demo.service.SlackRequest;
import com.prime.service.slack.demo.service.SlackResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/slack/slash")
public class Demo {

   @PostMapping(consumes = "application/x-www-form-urlencoded")
   public Mono<SlackResponse> processor(@RequestParam(required = false) Map<String, String> params){

      String  responseText = "no text available";

      if (params.get("text") != null) {
         responseText = params.get("text");
      }

      SlackResponse response = new SlackResponse();
      response.setText( responseText );
      response.setResponseType("in_channel");

      Attachment attachment = new Attachment();
      attachment.setText("This is the attachment text");
      attachment.setColor("#0000ff");

      response.getAttachments().add(attachment);

      return Mono.just(response);
   }
}
