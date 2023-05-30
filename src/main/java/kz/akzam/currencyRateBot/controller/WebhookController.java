package kz.akzam.currencyRateBot.controller;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import kz.akzam.currencyRateBot.telegram.dispatcher.TelegramUpdateDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final TelegramUpdateDispatcher telegramUpdateDispatcher;

    @Autowired
    public WebhookController(TelegramUpdateDispatcher telegramUpdateDispatcher) {
        this.telegramUpdateDispatcher = telegramUpdateDispatcher;
    }

    @PostMapping("/telegram-bot")
    public ResponseEntity<?> onUpdateReceived(@RequestBody String request) {
        Update update = BotUtils.parseUpdate(request);
        telegramUpdateDispatcher.dispatch(update);
        return ResponseEntity.ok().build();
    }
}
