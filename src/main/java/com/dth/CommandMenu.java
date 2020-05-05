package com.dth;

import com.dth.command.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandMenu {
    Map<Integer, Command> menuList = new HashMap<>();

    public void setMenuOption(int menuOption, Command command) {
        menuList.put(menuOption, command);
    }

    public void runMenuOption(int menuOption) {
        menuList.get(menuOption).execute();
    }
}
