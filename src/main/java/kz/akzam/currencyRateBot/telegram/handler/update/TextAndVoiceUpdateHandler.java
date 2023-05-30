package kz.akzam.currencyRateBot.telegram.handler.update;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;

@Component
public class TextAndVoiceUpdateHandler implements TelegramUpdateHandler {

    @Override
    public boolean canHandle(Update update) {
        Message message = update.message();
        return message.text() != null || message.voice() != null;
    }

    @Override
    public void handle(Update update) {

    }
}
