package pe.edu.upc.aaw.smartsupplybackendprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.smartsupplybackendprod.entities.Faq;

@Repository
public interface IFaqRepository extends JpaRepository<Faq,Long> {
}
