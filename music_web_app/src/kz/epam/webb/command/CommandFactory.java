package kz.epam.webb.command;

import kz.epam.webb.command.impl.EmptyCommand;

public class CommandFactory {
  public static Command defineCommand(String action) {
     Command current = null;

     if(action == null || action.isEmpty()) {
         return new EmptyCommand();
     }

     try {
         CommandType currentType = CommandType.valueOf(action.toUpperCase());
         current = currentType.getCommand();
     } catch (IllegalArgumentException e) {
         //
     }
     return current;
  }
}
