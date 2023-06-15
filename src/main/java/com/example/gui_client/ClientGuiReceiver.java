package com.example.gui_client;

import javafx.application.Platform;

import java.util.Arrays;

public class ClientGuiReceiver implements ClientReceiver {
    HelloController controller = null;

    public void setController(HelloController controller){
        this.controller = controller;
    }
    @Override
    public void receiveBroadcast(String sender, String message) {
        controller.showBroadcast(sender, message);
    }

    @Override
    public void receiveWhisper(String sender, String message) {

    }

    @Override
    public void receiveFile(String sender, long fileSize, String fileName) {
    }

    @Override
    public void receiveLoginBroadcast(String sender) {
        Platform.runLater( () -> controller.clientList.getItems().add(sender));
    }

    @Override
    public void receiveLogoutBroadcast(String sender) {
        Platform.runLater( () -> controller.clientList.getItems().remove(sender));
    }

    @Override
    public void receiveOnline(String[] clientNames) {
        Platform.runLater( () -> controller.populateOnLineList(Arrays.stream(clientNames).toList()));
    }

    @Override
    public void receiveFileProgress(int progress) {

    }
}
