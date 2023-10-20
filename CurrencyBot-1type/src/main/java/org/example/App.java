package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Start start = new Start();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(start);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        Commands commands=new Commands();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(commands);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        UzbButton uzbButton = new UzbButton();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(uzbButton);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);

        }
        RusButt rusButton = new RusButt();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(rusButton);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);}
        Valyuta valyuta = new Valyuta();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(valyuta);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        Valyuta2 valyuta2=new Valyuta2();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(valyuta2);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        Calculation calculation=new Calculation();
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(calculation);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}