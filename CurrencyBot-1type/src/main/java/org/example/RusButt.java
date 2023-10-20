package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class RusButt extends TelegramLongPollingBot {
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
            if(message.hasText()){
                String text=message.getText();

                if(text.equals("Русский язык \uD83C\uDDF7\uD83C\uDDFA")){
                    System.out.println("Выбран Русский язык ");
                    SendMessage sendMessage=new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Успешно выбран Русский язык\uD83C\uDDF7\uD83C\uDDFA.\nВыберите валюту!");
                    ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                    keyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow> keyList=new ArrayList<>();
                    KeyboardRow row1=new KeyboardRow();
                    row1.add(new KeyboardButton("USD"));
                    row1.add(new KeyboardButton("SUM"));
                    KeyboardRow row2=new KeyboardRow();
                    row2.add("EUR");
                    row2.add("RUB");
                    KeyboardRow row3=new KeyboardRow();
                    row3.add("GBP");
                    row3.add("CHF");
                    KeyboardRow row4=new KeyboardRow();
                    row4.add("JPY");
                    row4.add("AUD");
                    KeyboardRow backRow=new KeyboardRow();
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
                }
            }
        }
    }
}