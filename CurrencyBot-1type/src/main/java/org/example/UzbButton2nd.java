package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class UzbButton2nd extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "infoCurrency1bot";
    }

    @Override
    public String getBotToken() {
        return "6091576553:AAHPn7EpqsJGQYezfObg5ApVRA3w8DO28EA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("O'zbek tili \uD83C\uDDFA\uD83C\uDDFF")) {
                    System.out.println("O'zbek tili tanlandi");
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    keyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow> keyList = new ArrayList<>();
                    KeyboardRow row1 = new KeyboardRow();
                    row1.add(new KeyboardButton("->USD"));
                    row1.add(new KeyboardButton("->SUM"));
                    KeyboardRow row2 = new KeyboardRow();
                    row2.add(new KeyboardButton("->EUR"));
                    row2.add(new KeyboardButton("->RUB"));
                    KeyboardRow row3 = new KeyboardRow();
                    row3.add(new KeyboardButton("->GBP"));
                    row3.add(new KeyboardButton("->CHF"));
                    KeyboardRow row4 = new KeyboardRow();
                    row4.add(new KeyboardButton("->JPY"));
                    row4.add(new KeyboardButton("->AUD"));
                    KeyboardRow backRow = new KeyboardRow();
                    backRow.add("<-Orqaga");
                    keyList.add(row1);
                    keyList.add(row2);
                    keyList.add(row3);
                    keyList.add(row4);
                    keyList.add(backRow);
                    keyboardMarkup.setKeyboard(keyList);
                    sendMessage.setReplyMarkup(keyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (text.equals("Русский язык \uD83C\uDDF7\uD83C\uDDFA")) {
                    System.out.println("Russkiy");
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                    keyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow> keyList = new ArrayList<>();
                    KeyboardRow row1 = new KeyboardRow();
                    row1.add(new KeyboardButton("->USD"));
                    row1.add(new KeyboardButton("->SUM"));
                    KeyboardRow row2 = new KeyboardRow();
                    row2.add(new KeyboardButton("->EUR"));
                    row2.add(new KeyboardButton("->RUB"));
                    KeyboardRow row3 = new KeyboardRow();
                    row3.add(new KeyboardButton("->GBP"));
                    row3.add(new KeyboardButton("->CHF"));
                    KeyboardRow row4 = new KeyboardRow();
                    row4.add(new KeyboardButton("->JPY"));
                    row4.add(new KeyboardButton("->AUD"));
                    KeyboardRow backRow = new KeyboardRow();
                    backRow.add("<-Назад");
                    keyList.add(row1);
                    keyList.add(row2);
                    keyList.add(row3);
                    keyList.add(row4);
                    keyList.add(backRow);
                    keyboardMarkup.setKeyboard(keyList);
                    sendMessage.setReplyMarkup(keyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (message.getText().equals("<-Orqaga")) {
                    System.out.println("Orqaga");
                } else if (message.getText().equals("<-Назад")) {
                    System.out.println("<-Назад");
                }
            }
        }
    }
}

