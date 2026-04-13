package pe.edu.upc.aaw.smartsupplybackendprod.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.smartsupplybackendprod.entities.TypeUser;

@Repository
public interface ITypeUserRepository extends JpaRepository<TypeUser,Long> {
}
