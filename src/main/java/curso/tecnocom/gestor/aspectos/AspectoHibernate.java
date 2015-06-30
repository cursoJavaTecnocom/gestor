package curso.tecnocom.gestor.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import curso.tecnocom.gestor.daos.GestorDao;

@Aspect
public class AspectoHibernate {

	@Pointcut("@annotation(curso.tecnocom.gestor.anotaciones.SessionManager )")
	public void ejecutarSesion() {

	}

	@Pointcut("@annotation(curso.tecnocom.gestor.anotaciones.TransactionManager)")
	public void ejecutarTransaccion() {

	}

	@Around("ejecutarSesion()")
	public void sesion(ProceedingJoinPoint joinPoint) {
		GestorDao gestorDao = (GestorDao) joinPoint.getTarget();
		if (gestorDao.getSesion() == null || !gestorDao.getSesion().isOpen())
			gestorDao.setSesion(gestorDao.getFactoria().openSession());
		try {
			joinPoint.proceed();
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Around("ejecutarTransaccion()")
	public void transaccion(ProceedingJoinPoint joinPoint) {

		GestorDao gestorDao = (GestorDao) joinPoint.getTarget();
		if (gestorDao.getSesion() == null || !gestorDao.getSesion().isOpen())
			gestorDao.setSesion(gestorDao.getFactoria().openSession());
		gestorDao.getSesion().beginTransaction();
		
		try {
			joinPoint.proceed();
			gestorDao.getSesion().getTransaction().commit();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			gestorDao.getSesion().getTransaction().rollback();
		}

	}

}
