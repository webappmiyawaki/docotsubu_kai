package model;

import java.util.List;

public class AddUserListLogic {
  public void execute(User user, List<User> userList) {
    userList.add(0, user); // 先頭に追加 解説①
  }
}