package org.example;
import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;

public class Commands extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@infoCurrency1bot";
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
                if(text.equals("/language")||text.equals("<-Orqaga")||text.equals("<-Назад")){
                    System.out.println("process of choosing language");
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(chatId);
                    sendMessage.setText("Berilgan tillardan birini tanlang!");


                    ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                    keyboardMarkup.setResizeKeyboard(true);
                    List<KeyboardRow> list=new ArrayList<>();
                    KeyboardRow row=new KeyboardRow();
                    row.add(new KeyboardButton("O'zbek tili \uD83C\uDDFA\uD83C\uDDFF"));
                    row.add(new KeyboardButton("Русский язык \uD83C\uDDF7\uD83C\uDDFA"));
                    list.add(row);
                    keyboardMarkup.setKeyboard(list);
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