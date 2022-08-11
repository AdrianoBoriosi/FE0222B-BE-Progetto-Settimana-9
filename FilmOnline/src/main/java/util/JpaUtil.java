package util;

public class JpaUtil {

	private static final EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("FilmOnline"); 
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;

	}
}