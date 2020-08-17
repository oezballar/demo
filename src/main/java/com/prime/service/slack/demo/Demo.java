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
      response.setResponseType("in_channel");

      if (slackRequest.getText() != null) {
         if(slackRequest.getText().equals("Trump | white house | EY")){
            response.setText("Found following disambiguation");
            Attachment attachment = new Attachment();
            attachment.setText("*Donald Trump* https://en.wikipedia.org/wiki/Donald_Trump");
            attachment.setColor("#01837E");
            response.getAttachments().add(attachment);
            Attachment attachment2 = new Attachment();
            attachment2.setText("*White House* https://en.wikipedia.org/wiki/White_House");
            attachment2.setColor("#01837E");
            response.getAttachments().add(attachment2);
            Attachment attachment3 = new Attachment();
            attachment3.setText("*Ernest & Young* https://en.wikipedia.org/wiki/Ernst_%26_Young");
            attachment3.setColor("#01837E");
            response.getAttachments().add(attachment3);
            return Mono.just(response);
         } else if (slackRequest.getText().equals("Trump | Hearthstone | Blizzard")) {
            response.setText("Found following disambiguation");
            Attachment attachment = new Attachment();
            attachment.setText("*Trump (gamer)* https://en.wikipedia.org/wiki/Trump_(gamer)");
            attachment.setColor("#01837E");
            response.getAttachments().add(attachment);
            Attachment attachment2 = new Attachment();
            attachment2.setText("*Hearthstone* https://en.wikipedia.org/wiki/Hearthstone");
            attachment2.setColor("#01837E");
            response.getAttachments().add(attachment2);
            Attachment attachment3 = new Attachment();
            attachment3.setText("*Blizzard Entertainment* https://en.wikipedia.org/wiki/Blizzard_Entertainment");
            attachment3.setColor("#01837E");
            response.getAttachments().add(attachment3);
            return Mono.just(response);
         }
      }

      response.setText("disambiguation not possible");
      return Mono.just(response);
   }
}
