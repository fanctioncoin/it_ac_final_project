package by.staravoyt.app.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import by.staravoyt.app.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j
public class ServiceExceptionLoggingAspect
{

    @AfterThrowing(
            pointcut = "execution(* by.staravoyt.app.services.CoachService.findAll())",
            throwing = "ex"
    )
    public void loggingExceptionCoachService(Exception ex) {
        log.error("!!!Exception {}", ex.getMessage());
        throw new ApplicationException(ex);
    }

    @AfterThrowing(
            pointcut = "execution(* by.staravoyt.app.services.StudentService.findAll())",
            throwing = "ex"
    )
    public void loggingExceptionStudentService(Exception ex) {
        log.error("!!!Exception {}", ex.getMessage());
        throw new ApplicationException(ex);
    }
    @AfterThrowing(
            pointcut = "execution(* by.staravoyt.app.services.BandService.findAll())",
            throwing = "ex"
    )
    public void loggingExceptionBandService(Exception ex) {
        log.error("!!!Exception {}", ex.getMessage());
        throw new ApplicationException(ex);
    }
}
