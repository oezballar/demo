package com.prime.service.slack.demo;

import com.prime.service.slack.demo.service.Attachment;
import com.prime.service.slack.demo.service.SlackRequest;
import com.prime.service.slack.demo.service.SlackResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/slack/slash")
public class Demo {

   @PostMapping(consumes = "application/x-www-form-urlencoded")
   public Mono<SlackResponse> processor(@ModelAttribute SlackRequest slackRequest){
      SlackResponse response = new SlackResponse();

      if (slackRequest.getText() != null) {
         if(slackRequest.getText().equals("Trump | white house | EY")){
            response.setText("Found following disambiguation");
            Attachment attachment = new Attachment();
            attachment.setText("*Donald Trump* https://en.wikipedia.org/wiki/Donald_Trump");
            attachment.setColor("#0000ff");
            response.getAttachments().add(attachment);
         }
      }
      else {
         response.setText("disambiguation not possible");
      }


      response.setResponseType("in_channel");
      return Mono.just(response);
   }
}
