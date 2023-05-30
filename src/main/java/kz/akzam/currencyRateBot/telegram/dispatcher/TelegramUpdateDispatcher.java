package kz.akzam.currencyRateBot.telegram.dispatcher;

import com.pengrad.telegrambot.model.Update;
import kz.akzam.currencyRateBot.telegram.handler.update.TelegramUpdateHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelegramUpdateDispatcher {

    private final List<TelegramUpdateHandler> telegramUpdateHandlers;

    public TelegramUpdateDispatcher() {
        this.telegramUpdateHandlers = new ArrayList<>();
    }

    public void dispatch(Update update) {
        telegramUpdateHandlers.stream()
                .filter(handler -> handler.canHandle(update))
                .findFirst()
                .ifPresent(foundHandler -> foundHandler.handle(update));
    }

    public void register(TelegramUpdateHandler telegramUpdateHandler) {
        telegramUpdateHandlers.add(telegramUpdateHandler);
    }
}
