package com.angelqinwen.androidtests.chat;

public interface ChatContract
{
    interface View{
        void addMessage(String message);
        void clearMessageInput();
        void enableSendButton();
        void disableSendButton();
    }

    interface Presenter{
        void sendMessage(String message);

        void messageInputChanged(String messageInput);
    }
}
