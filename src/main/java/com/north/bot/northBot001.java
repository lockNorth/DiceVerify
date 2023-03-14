package com.north.bot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class northBot001 extends TelegramLongPollingBot {
    private String token="6292309299:AAEvJMUtOZEBOCm-bkraBqQu6ox7prVOqbk";
    private String userName = "northBot001";

    public northBot001() {
        this(new DefaultBotOptions());
    }

    public northBot001(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public String getBotUsername() {
        return this.userName;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }
    public void sentExcel(InputFile inputFile, Long chatId)  {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(String.valueOf(chatId));
        sendDocument.setDocument(inputFile);
        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
