package org.example;

import com.google.j2objc.annotations.ObjectiveCName;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.awt.*;

public class EchoBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(final Update update) {

        final String messageTextReceived = update.getMessage().getText();

        final long chatId = update.getMessage().getChatId();

        SendMessage message = procesarMensaje(String.valueOf(chatId), messageTextReceived);

        try{
            execute(message);
        }catch(TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "aulaNosaHugo_bot";
    }

    @Override
    public String getBotToken() {
        return "12321321321:asfsasfasdf";
    }


    private SendMessage procesarMensaje(String chatId, String texto) {

        SendMessage message = new SendMessage();
        message.setText("Me has dicho: " + texto);
        message.setChatId(String.valueOf(chatId));

        return message;
    }


    public static void main(String[] args){
        registrarBot();
    }

    private static void registrarBot(){
        try{
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new EchoBot());
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
