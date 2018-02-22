package helpers;

import contracts.Credentials;
import contracts.exceptions.CredentialsException;

import javax.naming.ldap.LdapContext;

public class ADConnector {

    public static LdapContext context;

    private static ADConnector connector = new ADConnector();

    public static ADConnector getConnector()
    {
        if (connector == null)
            connector = new ADConnector();
        return connector;
    }

    public static LdapContext getConnection(Credentials c) throws Exception
    {
        if (context == null)
            context = connect(c);

        return context;
    }



    public static LdapContext connect(Credentials credentials) throws Exception{

        if (credentials.getUsername() == null ||
                credentials.getPassword() == null ||
                credentials.getDomain() == null ||
                credentials.getController() == null) {
            throw new CredentialsException("ic");
        }

        return ActiveDirectory.getConnection(
                credentials.getUsername(),
                credentials.getPassword(),
                credentials.getDomain(),
                credentials.getController()
        );
    }
}
