//package org.example;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
//import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Valyuta extends TelegramLongPollingBot {
//    @Override
//    public String getBotUsername() {
//        return "infoCurrency1bot";
//    }
//
//    @Override
//    public String getBotToken() {
//        return "6091576553:AAHPn7EpqsJGQYezfObg5ApVRA3w8DO28EA";
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//    if (update.hasMessage()) {
//        Message message = update.getMessage();
//        String chatId = message.getChatId().toString();
//        SendMessage sendMessage=new SendMessage();
//        if(message.hasText()){
//            String text=message.getText();
//            if(text.equals("USD")){
//                System.out.println("dollar haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"USD");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "USD" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "USD" + " = " + eurRate + " EUR"+
//                                "\n1 " + "USD" + " = " + rubRate + " RUB"+
//                                "\n1 " + "USD" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "USD" + " = " + chfRate + " CHF"+
//                                "\n1 " + "USD" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "USD" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                }
//            } else if(text.equals("SUM")){
//                System.out.println("Sum haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"UZS");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double usdRate = rates1.get("USD").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "UZS" + " = " + usdRate + " USD"+
//                                "\n1 " + "UZS" + " = " + eurRate + " EUR"+
//                                "\n1 " + "UZS" + " = " + rubRate + " RUB"+
//                                "\n1 " + "UZS" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "UZS" + " = " + chfRate + " CHF"+
//                                "\n1 " + "UZS" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "UZS" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                    }
//                }
//            else if(text.equals("RUB")){
//                System.out.println("dollar haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"RUB");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double usdRate = rates3.get("USD").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "RUB" + " = " + usdRate + " USD"+
//                                "\n1 " + "RUB" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "RUB" + " = " + eurRate + " EUR"+
//                                "\n1 " + "RUB" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "RUB" + " = " + chfRate + " CHF"+
//                                "\n1 " + "RUB" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "RUB" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                }
//            }else if(text.equals("GBP")){
//                System.out.println("gbp haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"GBP");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double usdRate = rates4.get("USD").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "GBP" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "GBP" + " = " + eurRate + " EUR"+
//                                "\n1 " + "GBP" + " = " + rubRate + " RUB"+
//                                "\n1 " + "GBP" + " = " + usdRate + " USD"+
//                                "\n1 " + "GBP" + " = " + chfRate + " CHF"+
//                                "\n1 " + "GBP" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "GBP" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                    }
//                }else if(text.equals("CHF")){
//                System.out.println("Franc haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"CHF");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double usdRate = rates5.get("USD").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "CHF" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "CHF" + " = " + eurRate + " EUR"+
//                                "\n1 " + "CHF" + " = " + rubRate + " RUB"+
//                                "\n1 " + "CHF" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "CHF" + " = " + usdRate + " USD"+
//                                "\n1 " + "CHF" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "CHF" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                }
//            }else if(text.equals("JPY")){
//                System.out.println("dollar haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"JPY");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double usdRate = rates6.get("USD").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "JPY" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "JPY" + " = " + eurRate + " EUR"+
//                                "\n1 " + "JPY" + " = " + rubRate + " RUB"+
//                                "\n1 " + "JPY" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "JPY" + " = " + chfRate + " CHF"+
//                                "\n1 " + "JPY" + " = " + usdRate + " USD"+
//                                "\n1 " + "JPY" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                    }
//                }else if(text.equals("AUD")){
//                System.out.println("Avstraliya dollari haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"AUD");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double eurRate = rates2.get("EUR").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double usdRate = rates7.get("USD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "AUD" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "AUD" + " = " + eurRate + " EUR"+
//                                "\n1 " + "AUD" + " = " + rubRate + " RUB"+
//                                "\n1 " + "AUD" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "AUD" + " = " + chfRate + " CHF"+
//                                "\n1 " + "AUD" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "AUD" + " = " + usdRate + " USD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                }
//            }else if(text.equals("EUR")){
//                System.out.println("gbp haqida malumot");
//                try {
//                    String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
//
//                    URL url = new URL(apiUrl+"EUR");
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//                    connection.setRequestMethod("GET");
//
//                    int responseCode = connection.getResponseCode();
//
//                    if (responseCode == HttpURLConnection.HTTP_OK) {
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//
//
//                        String line;
//                        StringBuilder responseJson = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            responseJson.append(line);
//                        }
//
//                        reader.close();
//
//
//                        Gson gson = new Gson();
//                        JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
//                        JsonObject rates1 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates2 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates3 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates4 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates5 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates6 = jsonObject.getAsJsonObject("rates");
//                        JsonObject rates7 = jsonObject.getAsJsonObject("rates");
//                        double uzsRate = rates1.get("UZS").getAsDouble();
//                        double usdRate = rates2.get("USD").getAsDouble();
//                        double rubRate = rates3.get("RUB").getAsDouble();
//                        double gbpRate = rates4.get("GBP").getAsDouble();
//                        double chfRate = rates5.get("CHF").getAsDouble();
//                        double jpyRate = rates6.get("JPY").getAsDouble();
//                        double audRate = rates7.get("AUD").getAsDouble();
//
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("1 " + "EUR" + " = " + uzsRate + " UZS"+
//                                "\n1 " + "EUR" + " = " + usdRate + " EUR"+
//                                "\n1 " + "EUR" + " = " + rubRate + " RUB"+
//                                "\n1 " + "EUR" + " = " + gbpRate + " GBP"+
//                                "\n1 " + "EUR" + " = " + chfRate + " CHF"+
//                                "\n1 " + "EUR" + " = " + jpyRate + " JPY"+
//                                "\n1 " + "EUR" + " = " + audRate + " AUD");
//                    } else {
//                        sendMessage.setChatId(chatId);
//                        sendMessage.setText("HTTP Error: " + responseCode);
//                    }
//
//                    connection.disconnect();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}}



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
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Valyuta extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "infoCurrency1bot";
    }

    @Override
    public String getBotToken() {
        return "6091576553:AAHPn7EpqsJGQYezfObg5ApVRA3w8DO28EA";
    }
    public static String firstCurrency;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            SendMessage sendMessage=new SendMessage();
            if(message.hasText()){
                String text=message.getText();
                switch (text) {
                    case "USD" -> {
                        firstCurrency = "USD";
                        System.out.println("dollar haqida malumot");
                        sendMessage.setChatId(chatId);
                        sendMessage.setText("Qaysi valyuta turida berilgan valyuta narxini bilmoqchisiz!");

                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                    }
                    case "UZS" -> {
                        firstCurrency = "UZS";
                        System.out.println("sum haqida malumot");
                        sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                            e.printStackTrace();
                        }
                    }
                    case "EUR" -> {
                        firstCurrency = "EUR";
                        System.out.println("eur haqida malumot");
                        sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                    }
                    case "RUB" -> {
                        firstCurrency = "RUB";
                        System.out.println("rub haqida malumot");
                        sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                            e.printStackTrace();
                        }
                    }
                    case "GBP" -> {
                        firstCurrency = "GBP";
                        System.out.println("gbp haqida malumot");
                        sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                            e.printStackTrace();
                        }
                    }
                    case "CHF" -> {
                        firstCurrency = "CHF";
                        System.out.println("frank haqida malumot");
                        sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                            e.printStackTrace();
                        }
                    }
                    case "JPY" -> {
                        firstCurrency = "JPY";
                        System.out.println("jpy haqida malumot");
                        sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                            e.printStackTrace();
                        }
                    }
                    case "AUD" -> {
                        firstCurrency = "AUD";
                        System.out.println("aud haqida malumot");sendMessage.setChatId(chatId);
                        ReplyKeyboardMarkup keyboardMarkup=new ReplyKeyboardMarkup();
                        keyboardMarkup.setResizeKeyboard(true);
                        List<KeyboardRow> keyList=new ArrayList<>();
                        KeyboardRow row1=new KeyboardRow();
                        row1.add(new KeyboardButton("->USD"));
                        row1.add(new KeyboardButton("->SUM"));
                        KeyboardRow row2=new KeyboardRow();
                        row2.add(new KeyboardButton("->EUR"));
                        row2.add(new KeyboardButton("->RUB"));
                        KeyboardRow row3=new KeyboardRow();
                        row3.add(new KeyboardButton("->GBP"));
                        row3.add(new KeyboardButton("->CHF"));
                        KeyboardRow row4=new KeyboardRow();
                        row4.add(new KeyboardButton("->JPY"));
                        row4.add(new KeyboardButton("->AUD"));
                        KeyboardRow backRow=new KeyboardRow();
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
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
