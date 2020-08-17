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

   @PostMapping(consumes = "application/x-www-form-urlencoded")
   public Mono<SlackResponse> processor(@RequestParam(value = "team_id", required = false) String teamId,
                                 @RequestParam(value = "team_domain", required = false) String teamDomain,
                                 @RequestParam(value = "channel_id", required = false) String channelId,
                                 @RequestParam(value = "channel_name",required = false) String channelName,
                                 @RequestParam(value = "user_id", required = false) String userId,
                                 @RequestParam(value = "user_name", required = false) String userName,
                                 @RequestParam(value = "command", required = false) String command,
                                 @RequestParam(value = "text", required = false) String text,
                                 @RequestParam(value = "response_url", required = false) String responseUrl){

      String  responseText = "no text available";

      if (text != null) {
         responseText = text;
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
