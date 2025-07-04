package br.com.fiap.acolher.infra.config;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncrypt {
    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public boolean checkPass(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
