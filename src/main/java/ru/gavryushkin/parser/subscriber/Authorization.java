package ru.gavryushkin.parser.subscriber;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Authorization {
    public boolean isLogIn(String uuid) {
        Connection con = null;
        Statement statement = null;
        final String CHECK_QUERY;
        try {
            CHECK_QUERY = "select BLOCKED,DEACTIVATE_DATE from AUTH " +
                    "where UUID=" + "'" + uuid + "'";

            con = new SSHConnection().openSSH();
            statement = con.createStatement();
            ResultSet result = statement.executeQuery(CHECK_QUERY);
            if (result.next()) {
                int param = result.getInt("BLOCKED");
                Date paramDate = (Date) result.getObject("DEACTIVATE_DATE");
                if (param != 1 || new Date().getTime() > paramDate.getTime()) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Ваша подписка закончилась");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(new Frame(), "Ваша подписка не активирована");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new Frame(), "Проблемы с доступом к БД");
        } finally {
            try {
                con.close();
                statement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new Frame(), "Соединение не закрывается");
            }
        }
        return false;
    }
}
