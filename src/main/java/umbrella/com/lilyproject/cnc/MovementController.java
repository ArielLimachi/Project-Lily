package umbrella.com.lilyproject.cnc;

public interface MovementController <T,N>{
    void move(T parameter);
    void setParameter (N parameterName, T parameter);
}
