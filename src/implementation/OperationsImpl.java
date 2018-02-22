package implementation;

import contracts.Credentials;
import helpers.ActiveDirectory;
import interfaces.Operations;

import javax.naming.ldap.LdapContext;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static helpers.ADConnector.context;

public class OperationsImpl implements Operations {

    public void getMailsToFile(LdapContext c, String filePath, String fileName) throws Exception {
        ActiveDirectory.User[] users = ActiveDirectory.getUsers(c);
        try {
            String f ="";
            if (filePath != null && fileName != null) {
                f = filePath + fileName;
            } else if (filePath == null && fileName != null){
                f = fileName;
            } else if (fileName == null) {
                throw new Exception("Please insert file name");
            }
            for (int i = 0; i < users.length; i++) {
                FileWriter fw = new FileWriter(f, true);
                String mail = users[i].getMail()+",";
                BufferedWriter bw = new BufferedWriter(fw);
                if(!users[i].getMail().equals("void@void.com")) {
                    bw.write(mail);
                    bw.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(LdapContext c, String username, String oldPass, String newPass) throws Exception{
        ActiveDirectory.User user = ActiveDirectory.getUser(username, c);
        if (user != null) {
            user.changePassword(oldPass, newPass, true, c);
        } else {
            throw new Exception("Invalid user");
        }
    }


    public ActiveDirectory.User[] getUsers(LdapContext c) throws Exception {
        return ActiveDirectory.getUsers(c);

    }
}
