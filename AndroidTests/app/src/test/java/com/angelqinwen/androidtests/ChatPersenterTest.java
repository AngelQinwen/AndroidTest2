package com.angelqinwen.androidtests;


import com.angelqinwen.androidtests.chat.ChatContract;
import com.angelqinwen.androidtests.chat.ChatPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ChatPersenterTest
{
    public static final String Message = "This is a normal text message";
    private ChatContract.Presenter chatPresenter;
    @Mock
    private ChatContract.View chatView;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        chatPresenter = new ChatPresenter(chatView);

    }


    //Test when the message is send.

    @Test
    public void sendMessage_NullString_NoMessageSent()
    {
        chatPresenter.sendMessage(null);
        verify(chatView, never()).addMessage(anyString());

    }

    @Test
    public void sendMessage_EmptyString_NoMessageSent(){
        chatPresenter.sendMessage("");
        verify(chatView, never()).addMessage(anyString());

    }

    @Test
    public void sendMessage_NormalString_MessageSent(){
        chatPresenter.sendMessage(Message);
        verify(chatView).addMessage(Message);

    }



    @Test
    public void messageInputTextChanged_NullString_SendButtonDisabled(){
        chatPresenter.messageInputChanged(null);
        verify(chatView).disableSendButton();

    }



    @Test
    public void messageInputTextChanged_EmptyString_SendButtonDisabled(){
        chatPresenter.messageInputChanged("");
        verify(chatView).disableSendButton();

    }


    @Test
    public void messageInputTextChanged_NormalString_SendButtonEnabled(){
        chatPresenter.messageInputChanged(Message);
        verify(chatView).enableSendButton();

    }

}
