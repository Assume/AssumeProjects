/*
 * Decompiled with CFR 0_118.



 * 
 * Could not load the following classes:
 *  javafx.application.Application
 *  javafx.collections.ObservableList
 *  javafx.event.Event
 *  javafx.event.EventHandler
 *  javafx.fxml.FXMLLoader
 *  javafx.scene.Parent
 *  javafx.scene.Scene
 *  javafx.scene.image.Image
 *  javafx.stage.Stage
 *  javafx.stage.WindowEvent
 */

package org.assume.test.Calc_source_from_cfr;


import org.assume.test.Calc_source_from_cfr.ui.StakingCalcController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StakingCalc
extends Application {
    public static void main(String[] args) {
        Application.launch(StakingCalc.class, (String[])args);
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        StakingCalcController cont = new StakingCalcController();
        loader.setController((Object)cont);
        Parent root = (Parent)loader.load(this.getClass().getResourceAsStream("/ui/staking_calc_layout.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add((Object)new Image("ui/attack_icon.png"));
        stage.setTitle("Staking Calculator");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            cont.kill();
        }
        );
    }
}

