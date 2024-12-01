package sc.senai.controle_de_estoque.controllers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sc.senai.controle_de_estoque.services.LogService;

@Aspect
@Component
public class LogLoggingAspect {
    private final LogService logService;
    public LogLoggingAspect(LogService logService) {
        this.logService = logService;
    }

    @Before("@annotation(getMapping)")
    public void logGet(JoinPoint joinPoint, GetMapping getMapping) {
        logHttpRequest(joinPoint, "GET");
    }

    @Before("@annotation(postMapping)")
    public void logPost(JoinPoint joinPoint, PostMapping postMapping) {
        logHttpRequest(joinPoint, "POST");
    }

    @Before("@annotation(putMapping)")
    public void logPut(JoinPoint joinPoint, PutMapping putMapping) {
        logHttpRequest(joinPoint, "PUT");
    }

    @Before("@annotation(deleteMapping)")
    public void logDelete(JoinPoint joinPoint, DeleteMapping deleteMapping) {
        logHttpRequest(joinPoint, "DELETE");
    }

    @Before("@annotation(patchMapping)")
    public void logPatch(JoinPoint joinPoint, PatchMapping patchMapping) {
        logHttpRequest(joinPoint, "PATCH");
    }

    private void logHttpRequest(JoinPoint joinPoint, String httpMetodo) {
        String classe = joinPoint.getTarget().getClass().getSimpleName();
        String nomeMetodo = joinPoint.getSignature().getName();
        logService.salvarLog(httpMetodo, classe, nomeMetodo);
    }



}
