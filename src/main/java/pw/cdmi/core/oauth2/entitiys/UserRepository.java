package pw.cdmi.core.oauth2.entitiys;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
