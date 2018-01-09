import java.io.Console;
import java.security.NoSuchAlgorithmException;

public class ConsoleClient {

    private Console C;
    private UserService userService;


    public ConsoleClient(Console c, UserService u){
        this.C=c;
        this.userService=u;
    }

    public void run() throws NoSuchAlgorithmException {
        boolean check = true;
        while(check){

            C.printf("Dzien dobry!\n");
            C.printf("Co chcesz zrobic?!\n");
            C.printf("1. DODAJ UZYTKOWNIKA!!!\n");
            C.printf("2. WERYFIKUJ UZYTKOWNIKA!!!\n");
            C.printf("3. ZAKONCZ PROGRAM!!!\n");

            String getNumber=C.readLine();

            if(getNumber.equals("1")){
                C.printf("Podaj nazwe uzytkownika!");
                String answerName=  C.readLine();

                C.printf("Podaj haslo!");
                String answerPassword= C.readLine();

                addUser(answerName,answerPassword);
            }
            else if(getNumber.equals("2")){
                C.printf("Podaj nazwe uzytkownika!");
                String answerName=  C.readLine();

                C.printf("Podaj haslo!");
                String answerPassword= C.readLine();

                verifyUser( answerName,  answerPassword);
            }

            else if(getNumber=="3"){
                check = false;
            }
        }

    }

    private void addUser(String name, String password) throws NoSuchAlgorithmException {
        User u=new User();
        u.setUsername(1name);
        HashServiceImpl hsimpl = new HashServiceImpl();
       String newhashpw= hsimpl.getHash(password);
        u.setPassword(newhashpw);
        userService.addUser(u);

        //UserService US2 = new UserService();
        //UserRepository UR2 = new UserRepository();
    }

    private void verifyUser(String name, String password) throws NoSuchAlgorithmException {
        HashServiceImpl hsimpl = new HashServiceImpl();
        String newhashpw= hsimpl.getHash(password);
        if(userService.verifyUser(name,newhashpw)){
            C.printf("Uzytkownik został pozytywnie zweryfikowany!!!!");
        }
        else {
            C.printf("BLAD UWAGA BLAD UWAGA uzytkownik nie został zweryfikowany!!!!");

        }

    }
}
