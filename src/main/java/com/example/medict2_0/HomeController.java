package com.example.medict2_0;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;

    @FXML
    private AnchorPane main_form;

    public void slider(){
        new Thread(){

            public  void run(){
                int count=0;
                try{
                    while(true){
                        switch(count){

                            case 0:

                                Thread.sleep(3000);


                                TranslateTransition slider1=new TranslateTransition();
                                slider1.setNode(img1);
                                slider1.setDuration(Duration.seconds(3));
                                slider1.setToX(0);
                                slider1.play();

                                TranslateTransition slider2=new TranslateTransition();
                                slider2.setNode(img2);
                                slider2.setDuration(Duration.seconds(3));
                                slider2.setToX(0);
                                slider2.play();

                                TranslateTransition slider3=new TranslateTransition();
                                slider3.setNode(img3);
                                slider3.setDuration(Duration.seconds(3));
                                slider3.setToX(-600);
                                slider3.play();

                                TranslateTransition slider4=new TranslateTransition();
                                slider4.setNode(img4);
                                slider4.setDuration(Duration.seconds(3));
                                slider4.setToX(-1200);
                                slider4.play();

                                count=1;
                                break;

                            case 1:
                                Thread.sleep(3000);
                                TranslateTransition slider5=new TranslateTransition();
                                slider5.setNode(img1);
                                slider5.setDuration(Duration.seconds(3));
                                slider5.setToX(600);
                                slider5.play();

                                TranslateTransition slider6=new TranslateTransition();
                                slider6.setNode(img2);
                                slider6.setDuration(Duration.seconds(3));
                                slider6.setToX(600);
                                slider6.play();

                                TranslateTransition slider7=new TranslateTransition();
                                slider7.setNode(img3);
                                slider7.setDuration(Duration.seconds(3));
                                slider7.setToX(0);
                                slider7.play();

                                TranslateTransition slider8=new TranslateTransition();
                                slider8.setNode(img4);
                                slider8.setDuration(Duration.seconds(3));
                                slider8.setToX(-600);
                                slider8.play();

                                count=2;
                                break;
                        }
                    }
                } catch(Exception e){e.printStackTrace();}

            }
        }.start();
    }

    public void initialize(URL url, ResourceBundle rb){
        slider();
    }

}
