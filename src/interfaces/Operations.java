package interfaces;

import helpers.ActiveDirectory;

import javax.naming.ldap.LdapContext;

public interface Operations {
    void getMailsToFile(LdapContext c, String filePath, String filename) throws Exception;

    void changePassword(LdapContext c, String username, String oldPass, String newPass) throws Exception;

    ActiveDirectory.User[] getUsers(LdapContext c) throws Exception;
}
