/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  javafx.application.Platform
 *  javafx.beans.property.ReadOnlyBooleanProperty
 *  javafx.beans.property.ReadOnlyObjectProperty
 *  javafx.beans.property.StringProperty
 *  javafx.beans.value.ChangeListener
 *  javafx.beans.value.ObservableValue
 *  javafx.collections.ObservableList
 *  javafx.event.ActionEvent
 *  javafx.event.Event
 *  javafx.event.EventHandler
 *  javafx.fxml.FXML
 *  javafx.fxml.Initializable
 *  javafx.scene.control.Alert
 *  javafx.scene.control.Alert$AlertType
 *  javafx.scene.control.ButtonType
 *  javafx.scene.control.ComboBox
 *  javafx.scene.control.Label
 *  javafx.scene.control.SingleSelectionModel
 *  javafx.scene.control.TextField
 *  javafx.scene.input.KeyCode
 *  javafx.scene.input.KeyEvent
 */
package org.assume.test.Calc_source_from_cfr.ui;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.assume.test.Calc_source_from_cfr.data.Battle;
import org.assume.test.Calc_source_from_cfr.data.Player;
import org.assume.test.Calc_source_from_cfr.data.equipment.NormalWeapon;
import org.assume.test.Calc_source_from_cfr.data.equipment.SpecialWeapon;
import org.assume.test.Calc_source_from_cfr.util.Strings;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;


public class StakingCalcController
implements Initializable {
    @FXML
    private Label player2_specWin;
    @FXML
    private ComboBox<Player.Style> player1_style;
    @FXML
    private Label player1_5050X;
    @FXML
    private Label player1_profitSpec;
    @FXML
    private TextField player2_defLvl;
    @FXML
    private TextField player1_atkBonus;
    @FXML
    private TextField player2_defBonus;
    @FXML
    private TextField player1_defLvl;
    @FXML
    private TextField stake_odds;
    @FXML
    private Label player1_specOddsX;
    @FXML
    private TextField player2_strBonus;
    @FXML
    private Label player2_oddsX;
    @FXML
    private TextField xing_x;
    @FXML
    private Label player2_5050X;
    @FXML
    private Label player2_stake;
    @FXML
    private Label player1_win;
    @FXML
    private Label player1_stakeSpec;
    @FXML
    private TextField player1_name;
    @FXML
    private ComboBox<Player.Style> player2_specStyle;
    @FXML
    private TextField xing_amount;
    @FXML
    private Label player2_profitSpec;
    @FXML
    private Label player2_win;
    @FXML
    private Label player1_oddsX;
    @FXML
    private Label player2_profitStake;
    @FXML
    private TextField player2_hpLvl;
    @FXML
    private ComboBox<NormalWeapon> player2_weapon;
    @FXML
    private ComboBox<SpecialWeapon> player2_spec;
    @FXML
    private ComboBox<NormalWeapon> player1_weapon;
    @FXML
    private Label player1_cmb;
    @FXML
    private Label player1_stake;
    @FXML
    private TextField player1_strBonus;
    @FXML
    private Label player1_profitStake;
    @FXML
    private ComboBox<Player.Style> player1_specStyle;
    @FXML
    private TextField player2_strLvl;
    @FXML
    private TextField player1_atkLvl;
    @FXML
    private TextField player2_atkLvl;
    @FXML
    private Label player2_cmb;
    @FXML
    private Label player2_stakeSpec;
    @FXML
    private Label player1_specWin;
    @FXML
    private TextField stake_amount;
    @FXML
    private ComboBox<SpecialWeapon> player1_spec;
    @FXML
    private TextField player2_atkBonus;
    @FXML
    private TextField player1_defBonus;
    @FXML
    private TextField player2_name;
    @FXML
    private ComboBox<Player.Style> player2_style;
    @FXML
    private TextField player1_strLvl;
    @FXML
    private TextField player1_hpLvl;
    @FXML
    private Label player2_xingCalc;
    @FXML
    private Label player2_specOddsX;
    @FXML
    private Label player1_xingCalc;
    private Player player1 = new Player("", 1, 1, 1, 1, 1, 1, 1);
    private Player player2 = new Player("", 1, 1, 1, 1, 1, 1, 1);
    private DecimalFormat twoSF = new DecimalFormat("00.00");
    private DecimalFormat threeSF = new DecimalFormat("00.000");
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    ChangeListener<String> calcProfitStakes = (obs, newV, oldV) -> {
        double my5050 = Strings.parseDouble(this.player1_5050X.getText());
        double myStake = Strings.parseDouble(this.player1_stake.getText());
        double amount = Strings.parseDouble(this.stake_amount.getText());
        double his5050 = Strings.parseDouble(this.player2_5050X.getText());
        double hisStake = Strings.parseDouble(this.player2_stake.getText());
        double myWin = Strings.parseDouble(this.player1_win.getText().replace("%", ""));
        double hisWin = Strings.parseDouble(this.player2_win.getText().replace("%", ""));
        this.player1_profitStake.setText(this.twoSF.format((my5050 - myStake / amount) * amount * (hisWin / 100.0)));
        this.player2_profitStake.setText(this.twoSF.format((hisStake / amount - his5050) * amount * (myWin / 100.0)));
    };
    ChangeListener<String> calcSpecProfitStakes = (obs, newV, oldV) -> {
        double my5050 = Strings.parseDouble(this.player1_5050X.getText());
        double myStake = Strings.parseDouble(this.player1_stakeSpec.getText());
        double amount = Strings.parseDouble(this.stake_amount.getText());
        double his5050 = Strings.parseDouble(this.player2_5050X.getText());
        double hisStake = Strings.parseDouble(this.player2_stakeSpec.getText());
        double myWin = Strings.parseDouble(this.player1_specWin.getText().replace("%", ""));
        double hisWin = Strings.parseDouble(this.player2_specWin.getText().replace("%", ""));
        this.player1_profitSpec.setText(this.twoSF.format((my5050 - myStake / amount) * amount * (hisWin / 100.0)));
        this.player2_profitSpec.setText(this.twoSF.format((hisStake / amount - his5050) * amount * (myWin / 100.0)));
    };

    public void initialize(URL location, ResourceBundle resources) {
        this.twoSF.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        this.populateComboBoxes();
        this.setupPlayer1Events();
        this.setupPlayer2Events();
        this.setDefaults();
        this.setPlayer1(this.player1);
        this.setPlayer2(this.player2);
        this.setupXingCalc();
        this.setupStakeCalc();
        this.player2_name.setOnKeyPressed(event -> {
            if (event.getCode().equals((Object)KeyCode.TAB)) {
                Platform.runLater(() -> {
                    this.stake_amount.requestFocus();
                }
                );
            }
        }
        );
        this.player1_name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if (this.player1_name.isFocused() && !this.player1_name.getText().isEmpty()) {
                    this.player1_name.selectAll();
                }
            }
            );
        }
        );
        this.player2_name.focusedProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if (this.player2_name.isFocused() && !this.player2_name.getText().isEmpty()) {
                    this.player2_name.selectAll();
                }
            }
            );
        }
        );
        this.stake_amount.focusedProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if (this.stake_amount.isFocused() && !this.stake_amount.getText().isEmpty()) {
                    this.stake_amount.selectAll();
                }
            }
            );
        }
        );
        this.xing_amount.focusedProperty().addListener((observable, oldValue, newValue) -> {
            Platform.runLater(() -> {
                if (this.xing_amount.isFocused() && !this.xing_amount.getText().isEmpty()) {
                    this.xing_amount.selectAll();
                }
            }
            );
        }
        );
    }

    public void kill() {
        this.executorService.shutdownNow();
        Platform.exit();
        System.exit(0);
    }

    private void simulate() {
        this.executorService.submit(() -> {
            Battle battle = new Battle(this.player1, this.player2, 200000);
            battle.simulate();
            Platform.runLater(() -> {
                this.player1_win.setText(this.twoSF.format(battle.getP1WinRate()) + "%");
                this.player2_win.setText(this.twoSF.format(battle.getP2WinRate()) + "%");
                this.player1_specWin.setText(this.twoSF.format(battle.getP1SpecWinRate()) + "%");
                this.player2_specWin.setText(this.twoSF.format(battle.getP2SpecWinRate()) + "%");
            }
            );
        }
        );
    }

    private void populateComboBoxes() {
        this.player1_style.getItems().setAll((Object[])Player.Style.values());
        this.player2_style.getItems().setAll((Object[])Player.Style.values());
        this.player1_specStyle.getItems().setAll((Object[])Player.Style.values());
        this.player2_specStyle.getItems().setAll((Object[])Player.Style.values());
        this.player1_weapon.getItems().setAll((Object[])NormalWeapon.values());
        this.player2_weapon.getItems().setAll((Object[])NormalWeapon.values());
        this.player1_spec.getItems().setAll((Object[])SpecialWeapon.values());
        this.player2_spec.getItems().setAll((Object[])SpecialWeapon.values());
        this.player1_style.getSelectionModel().selectFirst();
        this.player2_style.getSelectionModel().selectFirst();
        this.player1_specStyle.getSelectionModel().selectFirst();
        this.player2_specStyle.getSelectionModel().selectFirst();
        this.player1_weapon.getSelectionModel().selectFirst();
        this.player2_weapon.getSelectionModel().selectFirst();
        this.player1_spec.getSelectionModel().selectFirst();
        this.player2_spec.getSelectionModel().selectFirst();
    }

    private void setupPlayer1Events() {
        this.player1_name.setOnAction(event -> {
            this.setPlayer1(Player.lookup(this.player1_name.getText()));
        }
        );
        this.player1_style.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setNormalStyle(newValue);
            this.updatePlayer1();
        }
        );
        this.player1_specStyle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setSpecStyle(newValue);
            this.updatePlayer1();
        }
        );
        this.player1_hpLvl.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setHpLvl(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_atkLvl.textProperty().addListener((observableValue, oldValue, newValue) -> {
            this.player1.setAtkLvl(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_strLvl.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setStrLvl(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_defLvl.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setDefLvl(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_atkBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setAtkBonus(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_strBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setStrBonus(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_defBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setDefBonus(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player1_weapon.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setNormalWeapon(newValue);
            this.updatePlayer1();
        }
        );
        this.player1_spec.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player1.setSpecWeapon(newValue);
            this.updatePlayer1();
        }
        );
    }

    private void setupPlayer2Events() {
        this.player2_name.setOnAction(event -> {
            this.setPlayer2(Player.lookup(this.player2_name.getText()));
        }
        );
        this.player2_hpLvl.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setHpLvl(Strings.parseInt(newValue));
            this.updatePlayer2();
        }
        );
        this.player2_style.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setNormalStyle(newValue);
            this.updatePlayer2();
        }
        );
        this.player2_specStyle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setSpecStyle(newValue);
            this.updatePlayer2();
        }
        );
        this.player2_atkLvl.textProperty().addListener((observableValue, oldValue, newValue) -> {
            this.player2.setAtkLvl(Strings.parseInt(newValue));
            this.updatePlayer2();
        }
        );
        this.player2_strLvl.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setStrLvl(Strings.parseInt(newValue));
            this.updatePlayer2();
        }
        );
        this.player2_defLvl.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setDefLvl(Strings.parseInt(newValue));
            this.updatePlayer2();
        }
        );
        this.player2_atkBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setAtkBonus(Strings.parseInt(newValue));
            this.updatePlayer2();
        }
        );
        this.player2_strBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setStrBonus(Strings.parseInt(newValue));
            this.updatePlayer2();
        }
        );
        this.player2_defBonus.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setDefBonus(Strings.parseInt(newValue));
            this.updatePlayer1();
        }
        );
        this.player2_weapon.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setNormalWeapon(newValue);
            this.updatePlayer2();
        }
        );
        this.player2_spec.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.player2.setSpecWeapon(newValue);
            this.updatePlayer2();
        }
        );
    }

    private void setDefaults() {
        this.player1_weapon.getSelectionModel().select((Object)NormalWeapon.TENTACLE_WHIP);
        this.player1_style.getSelectionModel().select((Object)Player.Style.CONTROLLED);
        this.player1_spec.getSelectionModel().select((Object)SpecialWeapon.DRAGON_DAGGER);
        this.player1_specStyle.getSelectionModel().select((Object)Player.Style.AGGRESIVE);
        this.player2_weapon.getSelectionModel().select((Object)NormalWeapon.TENTACLE_WHIP);
        this.player2_style.getSelectionModel().select((Object)Player.Style.CONTROLLED);
        this.player2_spec.getSelectionModel().select((Object)SpecialWeapon.DRAGON_DAGGER);
        this.player2_specStyle.getSelectionModel().select((Object)Player.Style.AGGRESIVE);
        this.stake_odds.setText(Double.toString(55.555));
    }

    private void setupXingCalc() {
        this.xing_amount.textProperty().addListener((observable, oldValue, newValue) -> {
            double amt = Strings.parseDouble(this.xing_amount.getText());
            double x = Strings.parseDouble(this.xing_x.getText());
            if (x > 0.0) {
                this.player1_xingCalc.setText(String.valueOf(amt * x));
                this.player2_xingCalc.setText(String.valueOf(amt / x));
            } else {
                this.player1_xingCalc.setText("Error");
                this.player2_xingCalc.setText("Error");
            }
        }
        );
        this.xing_x.textProperty().addListener((observable, oldValue, newValue) -> {
            double amt = Strings.parseDouble(this.xing_amount.getText());
            double x = Strings.parseDouble(this.xing_x.getText());
            if (x > 0.0) {
                this.player1_xingCalc.setText(String.valueOf(amt * x));
                this.player2_xingCalc.setText(String.valueOf(amt / x));
            } else {
                this.player1_xingCalc.setText("Error");
                this.player2_xingCalc.setText("Error");
            }
        }
        );
    }

    private void setupStakeCalc() {
        ChangeListener calc5050 = (obs, newV, oldV) -> {
            double p1Win = Strings.parseDouble(this.player1_win.getText().replace("%", ""));
            double p2Win = Strings.parseDouble(this.player2_win.getText().replace("%", ""));
            this.player1_5050X.setText(this.twoSF.format(p1Win / p2Win));
            this.player2_5050X.setText(this.twoSF.format(p2Win / p1Win));
        };
        this.player1_win.textProperty().addListener(calc5050);
        this.player2_win.textProperty().addListener(calc5050);
        this.player1_5050X.textProperty().addListener(this.calcProfitStakes);
        this.player1_stake.textProperty().addListener(this.calcProfitStakes);
        this.stake_amount.textProperty().addListener(this.calcProfitStakes);
        this.player2_win.textProperty().addListener(this.calcProfitStakes);
        this.player2_5050X.textProperty().addListener(this.calcProfitStakes);
        this.player2_stake.textProperty().addListener(this.calcProfitStakes);
        this.player1_win.textProperty().addListener(this.calcProfitStakes);
        this.player1_5050X.textProperty().addListener(this.calcSpecProfitStakes);
        this.player1_stakeSpec.textProperty().addListener(this.calcSpecProfitStakes);
        this.stake_amount.textProperty().addListener(this.calcSpecProfitStakes);
        this.player2_specWin.textProperty().addListener(this.calcSpecProfitStakes);
        this.player2_5050X.textProperty().addListener(this.calcSpecProfitStakes);
        this.player2_stakeSpec.textProperty().addListener(this.calcSpecProfitStakes);
        this.player1_specWin.textProperty().addListener(this.calcSpecProfitStakes);
        this.player1_win.textProperty().addListener((observable1, oldValue1, newValue) -> {
            double p1 = Strings.parseDouble(this.player1_win.getText().replace("%", "")) - Strings.parseDouble(this.stake_odds.getText()) + 50.0;
            double p2 = Strings.parseDouble(this.player2_win.getText().replace("%", "")) + Strings.parseDouble(this.stake_odds.getText()) - 50.0;
            this.player1_oddsX.setText(this.twoSF.format(p1 / p2));
            this.player2_oddsX.setText(this.twoSF.format(p2 / p1));
        }
        );
        this.player2_win.textProperty().addListener((observable1, oldValue1, newValue) -> {
            double p1 = Strings.parseDouble(this.player1_win.getText().replace("%", "")) - Strings.parseDouble(this.stake_odds.getText()) + 50.0;
            double p2 = Strings.parseDouble(this.player2_win.getText().replace("%", "")) + Strings.parseDouble(this.stake_odds.getText()) - 50.0;
            this.player1_oddsX.setText(this.twoSF.format(p1 / p2));
            this.player2_oddsX.setText(this.twoSF.format(p2 / p1));
        }
        );
        this.player1_specWin.textProperty().addListener((observable1, oldValue1, newValue) -> {
            double p1 = Strings.parseDouble(this.player1_specWin.getText().replace("%", "")) - Strings.parseDouble(this.stake_odds.getText()) + 50.0;
            double p2 = Strings.parseDouble(this.player2_specWin.getText().replace("%", "")) + Strings.parseDouble(this.stake_odds.getText()) - 50.0;
            this.player1_specOddsX.setText(this.twoSF.format(p1 / p2));
            this.player2_specOddsX.setText(this.twoSF.format(p2 / p1));
        }
        );
        this.player1_specWin.textProperty().addListener((observable1, oldValue1, newValue) -> {
            double p1 = Strings.parseDouble(this.player1_specWin.getText().replace("%", "")) - Strings.parseDouble(this.stake_odds.getText()) + 50.0;
            double p2 = Strings.parseDouble(this.player2_specWin.getText().replace("%", "")) + Strings.parseDouble(this.stake_odds.getText()) - 50.0;
            this.player1_specOddsX.setText(this.twoSF.format(p1 / p2));
            this.player2_specOddsX.setText(this.twoSF.format(p2 / p1));
        }
        );
        this.stake_odds.textProperty().addListener((observable, oldValue, newValue) -> {
            double p1 = Strings.parseDouble(this.player1_win.getText().replace("%", "")) - Strings.parseDouble(this.stake_odds.getText()) + 50.0;
            double p2 = Strings.parseDouble(this.player2_win.getText().replace("%", "")) + Strings.parseDouble(this.stake_odds.getText()) - 50.0;
            this.player1_oddsX.setText(this.twoSF.format(p1 / p2));
            this.player2_oddsX.setText(this.twoSF.format(p2 / p1));
            double p1s = Strings.parseDouble(this.player1_specWin.getText().replace("%", "")) - Strings.parseDouble(this.stake_odds.getText()) + 50.0;
            double p2s = Strings.parseDouble(this.player2_specWin.getText().replace("%", "")) + Strings.parseDouble(this.stake_odds.getText()) - 50.0;
            this.player1_specOddsX.setText(this.twoSF.format(p1s / p2s));
            this.player2_specOddsX.setText(this.twoSF.format(p2s / p1s));
        }
        );
        this.stake_amount.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1_stake.setText(this.twoSF.format(Strings.parseDouble(this.player1_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stake.setText(this.twoSF.format(Strings.parseDouble(this.player2_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player1_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player1_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player2_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
        }
        );
        this.player1_oddsX.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1_stake.setText(this.twoSF.format(Strings.parseDouble(this.player1_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stake.setText(this.twoSF.format(Strings.parseDouble(this.player2_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player1_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player1_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player2_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
        }
        );
        this.player2_oddsX.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1_stake.setText(this.twoSF.format(Strings.parseDouble(this.player1_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stake.setText(this.twoSF.format(Strings.parseDouble(this.player2_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player1_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player1_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player2_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
        }
        );
        this.player1_specOddsX.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1_stake.setText(this.twoSF.format(Strings.parseDouble(this.player1_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stake.setText(this.twoSF.format(Strings.parseDouble(this.player2_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player1_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player1_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player2_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
        }
        );
        this.player2_specOddsX.textProperty().addListener((observable, oldValue, newValue) -> {
            this.player1_stake.setText(this.twoSF.format(Strings.parseDouble(this.player1_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stake.setText(this.twoSF.format(Strings.parseDouble(this.player2_oddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player1_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player1_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
            this.player2_stakeSpec.setText(this.twoSF.format(Strings.parseDouble(this.player2_specOddsX.getText()) * Strings.parseDouble(this.stake_amount.getText())));
        }
        );
    }

    private void setPlayer1(Player player) {
        if (player == null) {
            new Alert(Alert.AlertType.ERROR, "Not a valid player", new ButtonType[]{ButtonType.OK}).show();
        } else {
            player.copyBonuses(this.player1);
            player.copyMods(this.player1);
            player.copyWeaponsAndStyles(this.player1);
            this.player1 = player;
            this.updatePlayer1();
        }
    }

    void updatePlayer1() {
        this.player1_name.setText(this.player1.getName());
        this.player1_hpLvl.setText(String.valueOf(this.player1.getHpLvl()));
        this.player1_atkLvl.setText(String.valueOf(this.player1.getAtkLvl()));
        this.player1_strLvl.setText(String.valueOf(this.player1.getStrLvl()));
        this.player1_defLvl.setText(String.valueOf(this.player1.getDefLvl()));
        this.player1_atkBonus.setText(String.valueOf(this.player1.getAtkBonus()));
        this.player1_strBonus.setText(String.valueOf(this.player1.getStrBonus()));
        this.player1_cmb.setText("" + this.player1.getCombatLevel() + " (" + this.player1.getMaxHit() + ")");
        this.simulate();
    }

    private void setPlayer2(Player player) {
        if (player == null) {
            new Alert(Alert.AlertType.ERROR, "Not a valid player", new ButtonType[]{ButtonType.OK}).show();
        } else {
            player.copyBonuses(this.player2);
            player.copyMods(this.player2);
            player.copyWeaponsAndStyles(this.player2);
            this.player2 = player;
            this.updatePlayer2();
        }
    }

    void updatePlayer2() {
        this.player2_name.setText(this.player2.getName());
        this.player2_hpLvl.setText(String.valueOf(this.player2.getHpLvl()));
        this.player2_atkLvl.setText(String.valueOf(this.player2.getAtkLvl()));
        this.player2_strLvl.setText(String.valueOf(this.player2.getStrLvl()));
        this.player2_defLvl.setText(String.valueOf(this.player2.getDefLvl()));
        this.player2_atkBonus.setText(String.valueOf(this.player2.getAtkBonus()));
        this.player2_strBonus.setText(String.valueOf(this.player2.getStrBonus()));
        this.player2_cmb.setText("" + this.player2.getCombatLevel() + " (" + this.player2.getMaxHit() + ")");
        this.simulate();
    }
}

