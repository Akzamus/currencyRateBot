package kz.akzam.currencyRateBot.config;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SetWebhook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramBotConfig {

    @Value("${telegram.bot.token}")
    private String token;

    @Value("${telegram.bot.webhookUrl}")
    private String webhookUrl;

    @Bean
    public SetWebhook setWebhook() {
        return new SetWebhook().url(webhookUrl);
    }

    @Bean
    public TelegramBot webhookBot(SetWebhook setWebhook) {
        TelegramBot telegramBot = new TelegramBot(token);
        telegramBot.execute(setWebhook);
        return telegramBot;
    }
}
