package Utils;

public class GenerateUser {

    public static JUser randomUser(){
        return new JUser()
                .withEmail(Utils.randomEmail(6))
                .withPassword(Utils.randomString(8))
                .withName(Utils.randomString(10));
    }

    public static JUser randomUserBadPassword(){
        return new JUser()
                .withEmail(Utils.randomEmail(6))
                .withPassword(Utils.randomString(5))
                .withName(Utils.randomString(10));
    }


}
