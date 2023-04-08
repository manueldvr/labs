package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Newauthoruuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorUUIDRepository extends JpaRepository<Newauthoruuid, UUID> {
}
