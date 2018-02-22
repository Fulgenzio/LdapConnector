package helpers;

import contracts.Credentials;

import javax.naming.ldap.LdapContext;
import javax.swing.*;

public class GuiHelper {


    public void login(String username, String password, String domain, String controller) throws Exception {
        Credentials c = new Credentials();
        c.setUsername(username);
        c.setPassword(password);
        c.setDomain(domain);
        c.setController(controller);

        LdapContext context = ADConnector.connect(c);
    }

}
