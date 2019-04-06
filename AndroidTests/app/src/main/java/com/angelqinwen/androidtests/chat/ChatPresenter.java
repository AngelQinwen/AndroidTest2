package com.angelqinwen.androidtests.chat;

public class ChatPresenter implements ChatContract.Presenter
{
    private ChatContract.View chatview;

    //Constructor
    public ChatPresenter(ChatContract.View chatview){
        this.chatview = chatview;
    }


    public void sendMessage(String message) {
        if(message != null && !message.isEmpty()){
            chatview.addMessage(message);
        }

    }

    @Override
    public void messageInputChanged(String messageInput)
    {
        if(messageInput == null || messageInput.isEmpty()){
            chatview.disableSendButton();
        }else
        {
            chatview.enableSendButton();
        }

    }
}
