package Utils;

public class JUser {

    private String email;
    private String password;
    private String name;


    public JUser(){

    }

    public JUser(String email, String password){
        this.email = email;
        this.password = password;
    }



    public JUser withEmail(String email){
        this.email = email;
        return this;
    }

    public JUser withPassword(String password){
        this.password = password;
        return this;
    }

    public JUser withName(String name){
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getName() {
        return name;
    }


}
