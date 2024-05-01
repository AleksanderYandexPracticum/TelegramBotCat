package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.javarush.telegrambot.TelegramBotContent.FINAL_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_1_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_2_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_3_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_4_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_5_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_6_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_7_TEXT;
import static com.javarush.telegrambot.TelegramBotContent.STEP_8_TEXT;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "cat_demo_01_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "7179851458:AAFWsf5NQ1js_NdjqKONL8K1QMs97l18sgU"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
        //Взлом холодильника

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_1_TEXT);
           // sendAnswerCallbackQuery();
//            for (Message allSentMessage : getAllSentMessages()) {
//                if(allSentMessage.)
//            }
            addUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Скинуть банку с огурцами! +20 славы", "step_2_btn"));
            sendTextMessageAsync("\uD83D\uDC7B");  // Эмоджи призрака
        }
        //Взлом робота-пылесоса
        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            List<Message> messageList=getAllSentMessages();
            editTextMessageAsync(messageList.get(messageList.size()-2).getMessageId(), STEP_2_TEXT);
            addUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of("Взлом робота-пылесоса", "step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_3_TEXT);
            addUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот-пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на роботе-пылесосе! +30 славы", "step_4_btn",
                            "Убежать от робота-пылесоса! +30 славы", "step_4_btn"));
        }
        //Взломываем камеру Go-Pro
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_4_TEXT);
            addUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Взлом камеры Go-Pro", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_5_TEXT);
            addUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Поиграть с камерой Go-Pro! +40 славы", "step_6_btn",
                            "Сделать селфи с помощью Go-Pro! +40 славы", "step_6_btn",
                            "Понырять в аквариум и поснимать рыбок! +40 славы", "step_6_btn"));
        }
        //Взламываем компьютер
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_6_TEXT);
            addUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of("Взлом компьютера!", "step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_7_TEXT);
            addUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Пошёл гулять на улицу!", "step_8_btn"));
        }
        //Хвастаемя дворовым котам
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            editTextMessageAsync(getLastSentMessage().getMessageId(), STEP_8_TEXT);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT);
            sendTextMessageAsync("💀");// Эмоджи череп
        }
        if (getMessageText().equals("/glory")) {
            sendTextMessageAsync("У тебя славы:  "+String.valueOf(getUserGlory()));
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());

    }
}

//if (getMessageText().equals("/start")) sendTextMessageAsync("Привет!");
//        if (getMessageText().equals("/bye")) sendTextMessageAsync("Asta la vista, baby!");
//        if (getMessageText().equals("Как здоровье?")) {
//        sendTextMessageAsync("Всё хорошо! %s ".formatted(updateEvent.getMessage().getFrom().getUserName()));
//        }
//        if (getMessageText().contains("пирог")) {
//        sendTextMessageAsync("Опасность!");
//        }
//        if (getMessageText().contains("картинка")) {
//        sendPhotoMessageAsync("step_%d_pic"
//        .formatted(IntStream.generate(() -> (int) (Math.random() * 10))
//        .filter(x -> x > 0 && x < 9)
//        .limit(8)
//        .findFirst()
//        .getAsInt()));
//        }
//        if (getMessageText().equals("animals")) {
//        sendTextMessageAsync("_Ваше любимое животное?_ *%s* "
//        .formatted(updateEvent
//        .getMessage()
//        .getFrom()
//        .getUserName()),
//        Map.of("Кот", "cat", "Собака", "dog"));
//        }
//        if (getCallbackQueryButtonKey().equals("cat")) sendPhotoMessageAsync("step_4_pic");
//        if (getCallbackQueryButtonKey().equals("dog")) sendPhotoMessageAsync("step_6_pic");
//
//        if (getMessageText().contains("smile")) {
//        Message message = getLastSentMessage();
//        editTextMessageAsync(message.getMessageId(), message.getText() + " :) ");
//        }