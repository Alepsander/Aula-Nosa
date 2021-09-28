package org.example;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;


public class EchoBot extends TelegramLongPollingBot {

    String ultimoMensaje;

    @Override
    public void onUpdateReceived(final Update update) {

        final Message messageReceived = update.getMessage();


        final long chatId = update.getMessage().getChatId();

        SendMessage message = procesarMensaje(String.valueOf(chatId), messageReceived);


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
        return "2048204729:AAGdShCs2uDqsTsOCLTrp8sYi3t_QjwhqbE";
    }


    private SendMessage procesarMensaje(String chatId, Message mensaje) {

        SendMessage message = new SendMessage();

            switch (mensaje.getText()){
                case "/start" : message.setText("Bienvenido. Pulse /ayuda para ver el resto de comandos");
                    break;
                case "/ayuda" : message.setText("/start\n" + "/ayuda\n" + "/hora\n" + "/miNombre\n" + "ultimoMensaje");
                    break;
                case "/hora" :
                    LocalDateTime hora = LocalDateTime.now();
                    message.setText("La fecha actual es " + hora);
                    break;
                case "/miNombre": message.setText(mensaje.getFrom().getFirstName());
                    break;
                case "/ultimoMensaje: ": message.setText(ultimoMensaje);
                break;

                default: message.setText(mensaje.getText());


            }
        message.setChatId(String.valueOf(chatId));

        ultimoMensaje=message.getText();
        return message;



    }

}
