package com.example.gui_client;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class HelloController {
    public TextArea outputArea;
    private ServerThread serverThread;
    private ClientGuiReceiver receiver;

    public HelloController(ServerThread serverThread, ClientGuiReceiver receiver) {
        this.serverThread = serverThread;
        this.receiver = receiver;
        receiver.controller = this;
    }
    public void initialize(){
        serverThread.online();
    }
    public void showBroadcast(String sender, String message){
        outputArea.appendText("\n" +sender + ": " + message);
    }

    public void send(){
        String text = inputField.getText();
        serverThread.broadcast(text);
        inputField.clear();
    }
    public void addToClients(String clientName){
        clientList.getItems().add(clientName);
    }
    public void removeFromClient(String clientName){
        clientList.getItems().remove(clientName);
    }
    public void populateOnLineList(List<String> clientNames){
        clientList.getItems().clear();
        clientNames.stream().
                forEach(name -> clientList.getItems().add(name));

    }
    public TextField inputField;
    public Button sendButton;
    public Button sendFileButton;
    public ListView clientList;
    public ProgressBar fileProgressBar;
}