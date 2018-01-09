import java.security.NoSuchAlgorithmException;

public interface HashService {
    public String getHash(String message) throws NoSuchAlgorithmException;
}
