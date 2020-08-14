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

   @GetMapping
   public Mono<SlackResponse> processor(@RequestParam("team_id") String teamId,
                                 @RequestParam("team_domain") String teamDomain,
                                 @RequestParam("channel_id") String channelId,
                                 @RequestParam("channel_name") String channelName,
                                 @RequestParam("user_id") String userId,
                                 @RequestParam("user_name") String userName,
                                 @RequestParam("command") String command,
                                 @RequestParam("text") String text,
                                 @RequestParam("response_url") String responseUrl){


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
