package henrique.igor.barbershopapi.exceptions;

public class ScheduleAlreadyUsedException extends RuntimeException {

    public ScheduleAlreadyUsedException(String message) {
        super(message);
    }
}
