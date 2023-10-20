package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Calculation extends TelegramLongPollingBot {
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
        Valyuta valyuta1=new Valyuta();
        Valyuta2 valyuta2=new Valyuta2();
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = String.valueOf(message.getChatId());
            SendMessage sendMessage=new SendMessage();
            sendMessage.setChatId(chatId);
            if(message.hasText()){
                String text=message.getText();
                double amount=Double.parseDouble(text);
                if(0<amount&&amount<999999999){
                    System.out.println("Procces of counting");
                    try {
                        String apiUrl = "https://api.exchangerate-api.com/v4/latest/";
                        URL url = new URL(apiUrl+valyuta1.firstCurrency);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        int responseCode = connection.getResponseCode();

                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            String line;
                            StringBuilder responseJson = new StringBuilder();
                            while ((line = reader.readLine()) != null) {
                                responseJson.append(line);
                            }

                            reader.close();


                            Gson gson = new Gson();
                            JsonObject jsonObject = gson.fromJson(responseJson.toString(), JsonObject.class);
                            JsonObject rates1 = jsonObject.getAsJsonObject("rates");
                            JsonObject rates2 = jsonObject.getAsJsonObject("rates");
                            JsonObject rates3 = jsonObject.getAsJsonObject("rates");
                            JsonObject rates4 = jsonObject.getAsJsonObject("rates");
                            JsonObject rates5 = jsonObject.getAsJsonObject("rates");
                            JsonObject rates6 = jsonObject.getAsJsonObject("rates");
                            JsonObject rates7 = jsonObject.getAsJsonObject("rates");
                            double UZS = rates1.get("UZS").getAsDouble();
                            double EUR = rates2.get("EUR").getAsDouble();
                            double RUB = rates3.get("RUB").getAsDouble();
                            double GBP = rates4.get("GBP").getAsDouble();
                            double CHF = rates5.get("CHF").getAsDouble();
                            double JPY = rates6.get("JPY").getAsDouble();
                            double AUD = rates7.get("AUD").getAsDouble();
                            switch (valyuta2.secondCurrency) {
                                case "->UZS" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + 14410 * amount);
                                    System.out.println(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + 14410 * amount);
                                }
                                case "->RUB" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + RUB * amount);
                                }
                                case "->EUR" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + EUR * amount);
                                }
                                case "->GBP" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + GBP * amount);
                                }
                                case "->CHF" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + CHF * amount);
                                }
                                case "->JPY" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + JPY * amount);
                                }
                                case "->AUD" -> {
                                    sendMessage.setChatId(chatId);
                                    sendMessage.setText(valyuta1.firstCurrency + ":" + amount + "==" + valyuta2.secondCurrency + ":" + AUD * amount);
                                }
                            }

                        } else {
                            sendMessage.setChatId(chatId);
                            sendMessage.setText("HTTP Error cannot find number: " + valyuta1.firstCurrency+valyuta2.secondCurrency);
                        }

                        connection.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}