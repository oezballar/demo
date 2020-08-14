package com.prime.service.slack.demo;

import com.prime.service.slack.demo.service.Attachment;
import com.prime.service.slack.demo.service.SlackResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/processor")
public class Demo {

   public Mono<SlackResponse> procesoor(@RequestParam("team_id") String teamId,
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
