package kz.akzam.currencyRateBot.telegram.handler.update;

import com.pengrad.telegrambot.model.Update;
import kz.akzam.currencyRateBot.telegram.dispatcher.TelegramUpdateDispatcher;
import org.springframework.beans.factory.annotation.Autowired;

public interface TelegramUpdateHandler {

    @Autowired
    default void registerMe(TelegramUpdateDispatcher telegramUpdateDispatcher) {
        telegramUpdateDispatcher.register(this);
    }

    boolean canHandle(Update update);

    void handle(Update update);
}
