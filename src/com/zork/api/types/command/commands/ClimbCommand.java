package com.zork.api.types.command.commands;

import com.zork.api.types.bottomlevel.game.Game;
import com.zork.api.types.command.Command;

public class ClimbCommand extends Command {
        String ladder;

        public static Command createInstance(String ladder) {
                return new ClimbCommand(ladder);
        }

        private ClimbCommand(String ladder) {
                this.ladder = ladder;
        }

        @Override
        public boolean canRun() {
                if (Game.getGame().getPlayer().getLocation().hasDoor(ladder)) {
                        return true;
                }
                return false;
        }

        @Override
        public void execute() {
                Game.getGame()
                                .getPlayer()
                                .setCurrentRoom(
                                                Game.getGame().getPlayer().getLocation()
                                                                .getDoor(ladder).getNextRoom());
                System.out.println(Game.getGame().getPlayer().getLocation());
        }
}