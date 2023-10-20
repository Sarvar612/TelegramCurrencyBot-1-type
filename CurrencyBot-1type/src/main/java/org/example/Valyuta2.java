package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Valyuta2 extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "infoCurrency1bot";
    }

    @Override
    public String getBotToken() {
        return "6091576553:AAHPn7EpqsJGQYezfObg5ApVRA3w8DO28EA";
    }
    public static String secondCurrency;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            SendMessage sendMessage=new SendMessage();
            if(message.hasText()){
                String text=message.getText();
                switch (text) {
                    case "->USD" -> {
                        this.secondCurrency = "USD";
                        System.out.println("dollar haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->SUM" -> {
                        secondCurrency = "UZS";
                        System.out.println("sum haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->EUR" -> {
                        secondCurrency = "EUR";
                        System.out.println("eur haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->RUB" -> {
                        secondCurrency = "RUB";
                        System.out.println("rub haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->GBP" -> {
                        secondCurrency = "GBP";
                        System.out.println("gbp haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->CHF" -> {
                        secondCurrency = "CHF";
                        System.out.println("frank haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");

                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->JPY" -> {
                        secondCurrency = "JPY";
                        System.out.println("jpy haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");

                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                    case "->AUD" -> {
                        secondCurrency = "AUD";
                        System.out.println("aud haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Pul miqdorini kiriting!\n Вводите количество!");

                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
